package br.edu.fatecpg.cadastro_produtos;

import java.util.List;

import br.edu.fatecpg.cadastro_produtos.controller.ProdutoController;
import br.edu.fatecpg.cadastro_produtos.model.Produto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class CadastroProdutosApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	@AfterEach
	void clearProducts() {
		((List<?>) ReflectionTestUtils.getField(ProdutoController.class, "produtos")).clear();
	}

	@Test
	void homeRouteRedirectsToRegistration() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/cadastrar"))
				.andExpect(redirectedUrl("/cadastrar"));
	}

	@Test
	void registrationFormBindsProductFields() throws Exception {
		mockMvc.perform(get("/cadastrar"))
				.andExpect(status().isOk())
				.andExpect(view().name("cadastrar"))
				.andExpect(model().attribute("produto", instanceOf(Produto.class)))
				.andExpect(content().string(containsString("<form action=\"/cadastrar\" method=\"post\">")))
				.andExpect(content().string(containsString("id=\"nome\" name=\"nome\"")))
				.andExpect(content().string(containsString("id=\"preco\" name=\"preco\"")))
				.andExpect(content().string(containsString("step=\"0.01\" min=\"0\"")))
				.andExpect(content().string(containsString("id=\"categoria\" name=\"categoria\"")))
				.andExpect(content().string(containsString("href=\"/lista\"")));
	}

	@Test
	void emptyListShowsMessageInsteadOfTable() throws Exception {
		mockMvc.perform(get("/lista"))
				.andExpect(status().isOk())
				.andExpect(view().name("lista"))
				.andExpect(model().attribute("produtos", hasSize(0)))
				.andExpect(content().string(containsString("Nenhum produto cadastrado ainda.")))
				.andExpect(content().string(not(containsString("<table"))))
				.andExpect(content().string(containsString("href=\"/cadastrar\"")));
	}

	@Test
	void registrationFlowListsTwoProductsWithoutResubmittingOnRefresh() throws Exception {
		mockMvc.perform(post("/cadastrar")
					.param("nome", "Camiseta")
					.param("preco", "49.90")
					.param("categoria", "Vestuário"))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/lista"));

		mockMvc.perform(get("/lista"))
				.andExpect(status().isOk())
				.andExpect(model().attribute("produtos", hasSize(1)))
				.andExpect(content().string(containsString("<td>Camiseta</td>")))
				.andExpect(content().string(containsString("<td>R$ 49,90</td>")))
				.andExpect(content().string(containsString("<td>Vestuário</td>")));

		mockMvc.perform(post("/cadastrar")
					.param("nome", "Notebook <Pro>")
					.param("preco", "3500.50")
					.param("categoria", "Eletrônico"))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/lista"));

		for (int refresh = 0; refresh < 2; refresh++) {
			mockMvc.perform(get("/lista"))
					.andExpect(status().isOk())
					.andExpect(model().attribute("produtos", hasSize(2)))
					.andExpect(content().string(containsString("<td>1</td>")))
					.andExpect(content().string(containsString("<td>Camiseta</td>")))
					.andExpect(content().string(containsString("<td>2</td>")))
					.andExpect(content().string(containsString("<td>Notebook &lt;Pro&gt;</td>")))
					.andExpect(content().string(containsString("<td>R$ 3.500,50</td>")))
					.andExpect(content().string(containsString("<td>Eletrônico</td>")))
					.andExpect(content().string(containsString("2 produto(s) cadastrado(s)")))
					.andExpect(content().string(not(containsString("Nenhum produto cadastrado ainda."))));
		}
	}

}
