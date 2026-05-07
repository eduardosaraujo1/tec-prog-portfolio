# Respostas - por Eduardo Soares e Araujo

Segue abaixo as respostas das perguntas feitas nas questões:

### 1. Explique como a sobrescrita de métodos permite comportamentos diferentes para objetos da mesma hierarquia.

**Resposta:** Através da herança, a estrutura de uma classe pai é aplicada na classe filha, mas essa pode declarar seu próprio método em sua implementação, sobrescrevendo a implementação da classe pai. Em java, é recomendado acompanhar essa herança com a annotation @Override. Isso é útil pois mesmo após um _upcasting_ para a classe pai o comportamento continua sendo da classe filha.

### 2. Descreva o mecanismo de sobrecarga de métodos e como ele difere da sobrescrita em termos de polimorfismo.

**Resposta:** A sobrecarga de métodos é uma funcionalidade de linguagens orientadas a objeto que permitem funções com o mesmo nome serem distinguidas pela sua assinatura, isto é, pelos parâmetros e/ou tipo de retorno. Isso difere do _override_ no polimorfismo, que substitui um método por outro com a mesma assinatura, e tem como um de seus usos possibilitar que uma mesma função possa executar fluxos diferentes por meio de _upcasting_ e injeção de dependência.

### 3. Discuta como a sobrecarga de construtores facilita a criação de objetos com diferentes conjuntos de informações, permitindo flexibilidade na instânciação de objetos.

**Resposta:** A sobrecarga de construtores permite que um objeto seja instanciado com diferentes atributos em seu construtor, permitindo, de forma geral, diferentes comportamentos a depender dos parametros passados no método. Por exemplo, a sobrecarga de construtores permite que parametros opcionais sejam omitidos na construção.

### 4. Como o polimorfismo por sobrescrita facilita a implementação de diferentes formas de pagamento dentro de um sistema sem alterar o código da classe base?

**Resposta:** A sobrescrita não necessariamente facilita a implementação de diferentes formas de pagamento no sentido de escrita de código, mas facilita seu uso futuro em futuras implementações de dependências desse sistema. Sem o uso de polimorfismo, não haveria uma garantia de que o método 'processarPagamento' existe para um pagamento, causando maiores refactorações quando um novo meio de pagamento não possuir esse método.

Aplicando o esforço de escrever uma classe genérica para pagamento, a troca entre as implementações "Boleto" e "Cartão" se tornam triviais, e caso um novo método de pagamento seja criado, ele herdará o comportamento genérico sem erros (o que é indesejável nessa situação, uma interface seria melhor pois um erro de compilação avisaria o desenvolvedor que o método de pagamento precisa de uma implementação própria).

### 5. Explique como a sobrecarga de métodos permite implementar várias versões do método converter(), mesmo com diferentes tipos de dados e funcionalidades.

**Resposta:** Justamente por terem diferentes tipos de dados, é possível implementar diferentes funcionalidades sobre o nome do mesmo método (converter). A sobrecarga funciona através da identificação da assinatura apropriada da função no momento em que é chamada. Não é recomendado criar sobrecargas para funções que possuem o mesmo tipo de dado na entrada, como é o caso de 'temperatura' e 'distância' (ambos decimal), embora isso seja possível através da diferenciação de assinaturas 'float' e 'double'. O ideal é criar diferentes nomes para as funções.
