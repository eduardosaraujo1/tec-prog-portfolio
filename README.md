# Atividade Associação

Desenvolva um sistema Java que seja capaz de:

## Parte 1: Associação Classe Empresa.

**Classe Cliente**: Crie uma classe Cliente que possui os atributos nome e email. Depois, modifique a classe Empresa para ter um cliente.

## Parte 2: Composição

**Classe Funcionário**:

- Modifique a classe **Empresa** para incluir um array de até 5 funcionários (Funcionario[] funcionarios).
- Modifique a classe **Empresa** para incluir um array de até 10 clientes (Cliente[] clientes).

## Parte 3: modificações

- Na classe **Empresa**, Implemente o método `adicionarFuncionario` que recebe o nome e cargo de um funcionário e o adiciona à lista.
- Na classe **Empresa**, Implemente o método `exibirFuncionarios` para exibir o nome e cargo de cada funcionário da empresa.
- Na classe **Funcionario**, adicione um atributo _salario_ e modifique o construtor para que ele receba esse valor ao criar o funcionário.
- Na classe **Empresa**, Crie um método `calcularFolhaSalarial` que calcula e exibe o total gasto em salários com os funcionários da empresa.

---

# Técnicas de Programação - Portifólio

Repositório dedicado a centralizar todas as atividades de Técnicas de Programação em um só lugar. Cada atividade possui sua própria branch, seguindo o padrão `{SIGLA_DISCIPLINA}/{BIMESTRE}/{NOME}`. Alguns exemplos são:

- `tp1/bim1/java-estrutura-repeticao`
- `tp1/bim2/atv-heranca`
- `tp2/bim1/records`

Anteriormente, cada atividade era colocada em uma pasta dentro da branch `main`. A fim de manter compatibilidade e não quebrar os links de atividade enviados anteriormente, a branch padrão tornou-se a [trunk](https://github.com/eduardosaraujo1/tec-prog-portifolio/tree/trunk).

Com essa alteração, novas atividades poderão ser enviadas por links, sem tornar a estrutura de arquivos rígida, e com verificação para correção tão simples quanto:

```sh
git clone <REPO_URL>
git switch tp1/bim2/atv-heranca
```
