# Técnicas de Programação - Portfólio

Repositório dedicado a centralizar todas as atividades de Técnicas de Programação em um só lugar. Cada atividade possui sua própria branch, seguindo o padrão `{SIGLA_DISCIPLINA}/{BIMESTRE}/{NOME}`. Alguns exemplos são:

- `tp1/bim1/java-estrutura-repeticao`
- `tp1/bim2/atv-heranca`
- `tp2/bim1/records`

Anteriormente, cada atividade era colocada em uma pasta dentro da branch `main`. A fim de manter compatibilidade e não quebrar os links de atividade enviados anteriormente, a branch padrão tornou-se a [trunk](https://github.com/eduardosaraujo1/tec-prog-portifolio/tree/trunk).

# ATIVIDADES

| ATIVIDADE         | BRANCH                    |
| ----------------- | ------------------------- |
| 09 - HERANÇA      | tp1/bim2/atv-heranca      |
| 10 - POLIMORFISMO | tp1/bim2/atv-polimorfismo |
| 11 - ASSOCIACAO   | tp1/bim2/atv-associacao   |
| 00 - REVISAO      | tp2/bim1/revisao-tp1      |

# Como ver atividade

Com essa alteração, novas atividades poderão ser enviadas por links, sem tornar a estrutura de arquivos rígida, e com verificação para correção tão simples quanto:

```sh
git clone <REPO_URL>
git switch tp1/bim2/atv-heranca
```
