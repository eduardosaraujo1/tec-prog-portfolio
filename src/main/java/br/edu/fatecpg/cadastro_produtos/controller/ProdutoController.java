package br.edu.fatecpg.cadastro_produtos.controller;

import br.edu.fatecpg.cadastro_produtos.model.Produto;
import br.edu.fatecpg.cadastro_produtos.service.ProdutoStorageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProdutoController {

	private final ProdutoStorageService produtos;

	public ProdutoController(ProdutoStorageService produtos) {
		this.produtos = produtos;
	}

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
		produtos.insert(produto);
		return "redirect:/lista";
	}

	@GetMapping("/lista")
	public String exibirLista(@RequestParam(defaultValue = "") String busca, Model model) {
		model.addAttribute("busca", busca.strip());
		model.addAttribute("produtos", produtos.search(busca));
		return "lista";
	}

	@PostMapping("/remover/{id}")
	public String removerProduto(@PathVariable String id) {
		produtos.removeByUuid(id);
		return "redirect:/lista";
	}
}
