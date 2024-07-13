# ☕ CRUD com Java Server Pages (JSP) - Projeto Redação!

Esse projeto foi desenvolvido como trabalho final da matéria de programação web no quarto semestre de Análise e Desenvolvimento de Sistemas, representa um relacionamento N para N entre os atores "Aluno" e "Escola" do meu projeto interdisciplinar que envolve a criação de uma aplicação para correção de redações disseratativas.  

Resumindo como funciona a aplicação, será apresentado um Menu para o usuário, por meio dele é possível acessar as telas de cadastro de "Escola" e de "Aluno", para efetuar o cadastro do aluno é necessário que já exista alguma escola cadastrada no sistema.

O projeto foi todo arquitetado e construido utilizando o padrão de design MVC(Model, View, Controller) juantamente com o padrão DAO, que divide a aplicação em camadas: camada de interação do usuário (view), a camada de manipulação dos dados (model), a camada de controle (controller), camada da lógica de negócios (DAO) e a camada de conexão com o banco de dados (Utils).
Juntas essas camadas são responsáveis por tornar o código mais estruturado, organizado e mais fácil de concertar possíveis erros que possam ocorrer ao longo de seu processo de desenvolvimento e teste. 

Resumo dos pastas e arquivos que compõem o projeto:

### Pasta Web Pages/ cadastros/ aluno ou escola

Em suma, dentro da pasta cadstros tem duas outras pastas: aluno e escola. E dentro de cada uma dessas pastas tem um arquivo em HTML e CSS para a tela de cadastro e outra para a tela princípal, onde fica listado os alunos e as escolas já cadastradas. 

Dentro da Web pages temos algums arquivos, são eles:

footer.jsp - header.jsp - home.jsp - index.jsp - menu.jsp

São arquivos JSP que configuram a parte visual da aplicação, códigos de HTML.

### Pasta br.com.curso.controller.aluno/escola

Dentro dessas pastas estão os servlets, um para cada método (ação) da aplicação. Eles são responsáveis por:

1. Receber e processar solicitações HTTP: Os servlets podem lidar com solicitações GET e POST. Eles extraem os parâmetros enviados pela interface gráfica (formulários, por exemplo).

2. Validar e converter dados: Os parâmetros recebidos são validados e convertidos para os tipos apropriados (por exemplo, Strings para Integers).

3. Criar e configurar objetos de modelo: Com os dados recebidos, os servlets criam e configuram objetos de modelo (como Aluno e Escola).

4. Interagir com a camada de dados (DAO): Utilizando objetos DAO (Data Access Objects), os servlets executam operações no banco de dados, como inserir, atualizar ou buscar registros.

5. Definir mensagens de resposta: Baseado no sucesso ou falha das operações de banco de dados, os servlets definem mensagens de sucesso ou erro.

6. Encaminhar a resposta ou redirecionar: Finalmente, os servlets encaminham a solicitação para outra página (usando RequestDispatcher) ou redirecionam para outra URL (usando response.sendRedirect), passando dados e mensagens necessárias.

### Pasta br.com.curso.dao

Os DAOs (Data Access Objects) são responsáveis pela interação direta com o banco de dados. No caso da AlunoDAO, suas principais funções são:

1. Conexão com o banco de dados: Inicializa a conexão com o banco de dados utilizando a classe SingleConnection.

2. Cadastrar: Verifica se o objeto Aluno deve ser inserido ou alterado, chamando os métodos inserir ou alterar conforme necessário.

3. Inserir: Insere um novo registro de aluno no banco de dados. Utiliza um comando SQL INSERT e, em caso de sucesso, faz commit na transação; caso contrário, realiza um rollback.

4. Alterar: Atualiza um registro existente de aluno no banco de dados. Utiliza um comando SQL UPDATE e, similar ao método inserir, faz commit ou rollback conforme o resultado.

5. Excluir: Remove um registro de aluno do banco de dados utilizando um comando SQL DELETE. Também realiza commit ou rollback conforme o sucesso da operação.

6. Carregar: Busca um registro de aluno específico pelo seu ID. Utiliza um comando SQL SELECT para recuperar os dados do aluno e popula um objeto Aluno com esses dados.

7. Listar: Recupera todos os registros de alunos do banco de dados, ordenados pelo ID. Utiliza um comando SQL SELECT e retorna uma lista de objetos Aluno.

O mesmo pode ser dito de EscolaDAO, ocorre apenas algumas alterações para se adequar as necessidades.

### Pasta br.com.curso.filter

O FilterAutenticacao é um filtro que intercepta todas as requisições e respostas na aplicação. Suas principais funções são:

1. Inicialização da conexão com o banco de dados: No método init, ele inicializa a conexão com o banco de dados utilizando a classe SingleConnection.

2. Interceptação de requisições e respostas: No método doFilter, ele intercepta todas as requisições e respostas. Durante esta interceptação, ele permite que a requisição e a resposta prossigam na cadeia de filtros (com o chain.doFilter(request, response)). Isso é onde você pode adicionar lógica adicional para autenticação, autorização, ou tratamento de exceções.

3. Tratamento de exceções: Se ocorrer alguma exceção durante o processamento da requisição ou resposta, ele captura e imprime o stack trace para depuração.

4. Fechamento da conexão: No método destroy, ele fecha a conexão com o banco de dados quando o filtro é destruído, garantindo a liberação dos recursos.

### Pasta br.com.curso.model

Dentro da pasta model temos os arquivos Aluno.java e Escola.java, que contêm as respectivas classes: Aluno e Escola, seus atributos e métodos. Usando a classe Aluno como exemplo:

1. Atributos:

- A classe Aluno possui os seguintes atributos: idaluno, nomealuno, serie, escola e email.
- Esses atributos representam os dados do aluno, incluindo seu ID, nome, série (utilizando um enum Serie), a escola a que pertence (um objeto Escola), e seu email.

2. Construtores:

- Construtor padrão: Inicializa os atributos com valores padrão. O ID do aluno é zero, o nome e o email são strings vazias, a série é nula, e a escola é um novo objeto 'Escola'.
- Construtor com parâmetros: Permite a inicialização dos atributos com valores específicos fornecidos como argumentos.

3. Métodos Getters e Setters:

- Getters: Métodos que retornam os valores dos atributos. Por exemplo, 'getIdaluno()' retorna o ID do aluno.
- Setters: Métodos que permitem modificar os valores dos atributos. Por exemplo, 'setNomealuno(String nomealuno)' permite definir o nome do aluno.

Resumo do funcionamento:

- A classe Aluno é uma representação dos dados de um aluno no sistema.
- Os construtores permitem a criação de objetos Aluno com valores padrão ou específicos.
- Os getters e setters facilitam o acesso e a modificação dos atributos de um aluno, mantendo o princípio de encapsulamento.

### Pasta br.com.curso.utils

Dentro da pasta 'utils' temos os arquivos 'SingleConnection.java' e 'banco.sql'. O primeiro é responsável por estabeler uma conexão com o banco de dados.

1. Abre uma conexão, utilizando uma String servidor, usuario e senha. E tenta abrir uma conexão com static.

2. Trata possíveis erros de conexão com o banco de dados, utilizando try catch.

Enquanto o segundo arquivo, 'banco.sql' possui o código de criação das tabelas do banco, e inserção de dados em SQL.

## Capturas de Tela

### Tela Inicial
![Tela Inicial](imagens/Tela%20Inicial.png)

### Tela De Escolas
![Tela De Escolas](imagens/Tela%20Escola.png)

### Tela De Aluno
![Tela De Aluno](imagens/Tela%20Aluno.png)

### Tela Cadastro de Escola
![Tela Cadastro de Escola](imagens/Cadastro%20Escola.png)

### Tela Cadastro de Aluno
![Tela Cadastro de Aluno](imagens/Cadastro%20Aluno.png)
