package br.edu.fatecpg.cadastro_produtos.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.fatecpg.cadastro_produtos.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdutoController {

	// A lista é compartilhada entre requisições e zerada ao reiniciar o servidor.
	private static final List<Produto> produtos = new ArrayList<>();

	@GetMapping("/")
	public String index() {
		return "redirect:/cadastrar";
	}

	@GetMapping("/cadastrar")
	public String exibirFormulario(Model model) {
		model.addAttribute("produto", new Produto());
		return "cadastrar";
	}

	@PostMapping("/cadastrar")
	public String cadastrarProduto(@ModelAttribute Produto produto, BindingResult bindingResult) {
		if (!bindingResult.hasFieldErrors("preco")
				&& (!Double.isFinite(produto.getPreco()) || produto.getPreco() < 0)) {
			bindingResult.rejectValue("preco", "preco.invalido",
					"O preço deve ser um número maior ou igual a zero.");
		}
		if (bindingResult.hasErrors()) {
			return "cadastrar";
		}
		produtos.add(produto);
		return "redirect:/lista";
	}

	@GetMapping("/lista")
	public String exibirLista(Model model) {
		model.addAttribute("produtos", produtos);
		return "lista";
	}

	@PostMapping("/remover/{id}")
	public String removerProduto(@PathVariable String id) {
		produtos.removeIf(produto -> produto.getId().equals(id));
		return "redirect:/lista";
	}
}
