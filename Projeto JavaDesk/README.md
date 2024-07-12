# ☕ Projeto Java Desk!

Esse projeto foi desenvolvido juntamente com o professor da matéria de Programação Orientada a Objetos (POO) durante o quarto semestre de Análise e Desenvolvimento de Sistema na FATEC. 

O projeto foi todo arquitetado e construido utilizando o padrão de design MVC(Model, View, Controller) juantamente com o padrão DAO, que divide a aplicação em camadas: camada de interação do usuário (view), a camada de manipulação dos dados (model), a camada de controle (controller), camada da lógica de negócios (DAO) e a camada de conexão com o banco de dados (Utils).
Juntas essas camadas são responsáveis por tornar o código mais estruturado, organizado e mais fácil de concertar possíveis erros que possam ocorrer ao longo de seu processo de desenvolvimento e teste. 

Resumo dos pastas e arquivos que compõem o projeto:

### Pasta com.br.fatecswing.dao

cidadeDAO - clienteDAO - estadoDAO

É onde ocorre a conexão com o banco de dados, cada public void representa um método que o sistema é capaz de executar, sendo eles: inserir, alterar e excluir.
O try / catch é utilizado para tratar possíveis exceções que possam ocorrer durante a tentativa de conexão, tais como valores do tipo errado, ausencia de algum dado ou problemas de conexão.

### Pasta com.br.fatecswing.imagens

Onde estão armazenados os icones utilizados na construção da interface gráfica do projeto.

### Pasta com.br.fatecswing.model

ModeloCidade - ModeloCliente - ModeloEstado

Dentro de cada Modelo são tratadas as regras de negócio que envolve a aplicação. É criada uma classe para cada Modelo: Cidade, cliente e estado.

Cada classe contém atributos próprios que recebem os dados que serão enviados para o banco.

Getters e Setter são usados para a manipulação dos valores, get "retorna" e set "recebe".

### Pasta com.br.fatecswing.util

ModeloTabela - SingleConnection - banco

O ModeloTabela é uma classe que extende os recursos gráficos para gerar as Tabelas responsáveis por listar os dados na interface.

SingleConnection responsável pela conexão com o banco de dados, o banco utilizado para esse projeto foi o PostgresSQL e por meio o PgAdmin 4.

banco é um arquivo do tipo SQL, é onde está localizado as alterações feitas no banco de dados.

### Pasta com.br.fatecswing.view

FormCidade - FormCliente - FormPrincipal - FrmEstado

Cada um desses Form representa uma tela ou Frame da aplicação e seus respectivos widgets e ações.

## Capturas de Tela

### Tela Inicial
![Tela Inicial](Imagens/Tela%20Inicial.png)

### Tela Cadastro de Cidades
![Tela Cadastro de Cidades](Imagens/Cadastro%20Cidade.png)

### Tela Cadastro de Estados
![Tela Cadastro de Estados](Imagens/Cadastro%20Estados.png)

### Tela Cadastro de Clientes
![Tela Cadastro de Cliente](Imagens/Cadastro%20Clientes.png)

### Tela Cadastro de Clientes - ComboBox Cidade
![Tela Cadastro de Cliente](Imagens/Combo%20Box%20Cidade.png)

### Tela Cadastro de Cidades - ComboBox Situação
![Tela Cadastro de Cliente](Imagens/Combo%20Box%20Situação.png)
