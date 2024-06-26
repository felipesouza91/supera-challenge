

# Desafio Supera 

## BackEnd

### Descrição 

- Este teste consiste em construir uma camada de serviço, para uma operação muito realizada em bancos, para emissão de extrato bancário.


### Como executar a aplicação 

- Você pode executar a aplicação da maneira que quiser e utilizando a IDE de sua preferência. 
- Caso queira executar a aplicação via linha de comando, execute primeiramente o comando:

                   ./mvnw clean package  para linux.

                   .\mvnw clean package  para windows.
- Após isso execute o comando: 

                             java -jar <...caminhoParaSeuJar>

### Requisitos de sistema

- Possuir a JDK 11 
- Uma IDE ou editor de sua preferência

### Requisitos do Projeto

- [x] A sua api deve fornecer os dados de transferência de acordo com o número da conta bacária.
- [x] Caso não seja informado nenhum filtro, retornar  todos os dados de transferência.
- [x] Caso seja informado um período de tempo, retornar todas as transferências relacionadas à aquele período de tempo.
- [x] Caso seja informado o nome do operador da transação, retornar todas as transferências relacionados à aquele operador.
- [x] Caso todos os filtros sejam informados, retornar todas as transferências com base no período de tempo informado e o nome do operador.
- [x] Operador de transação nada mais é que, o nome do responsável de destino da transação caso seja uma operação de transferência de saida ou o nome do responsável de onde se originou a transação caso seja uma operação de transferência de entrada.
- [x] Os valores devem ser de ponto flutuante, e deve-se considerar apenas duas casas decimais.
- [x] O frontend deve seguir como exemplo o protótipo informado no documento do processo seletivo.
- [x] No frontend o usuário deve ser capaz de informar um período de tem e/ou nome do operador da transasção como filtros para buscar as transações.
- [x] As transações devem ser exibidas junto com o saldo total e o saldo total no período de acordo com o protótipo do documento.

### O que iremos avaliar
- Cumprimento dos requisitos
- Qualidade do projeto de API e fluidez da DX
- Organização do código e boas práticas
- Domínio das linguagens, bibliotecas e ferramentas utilizadas
- Organização dos commits
- Escrita e cobertura de testes

### Sobre a entrega
- Utilizar o padrão RESTFul para a construção da sua API.
- Existe um script sql no pacote resources que cotém a modelagem do banco que pode ser seguida, e valores iniciais.
- Caso julge necessário você poderá criar mais tablas, porém a estrutura inicial não deve ser alterada.

---
---
---

## FrontEnd

Desafio do processo seletivo FullStack Java-React

### Tecnologias utilizadas

- React
- React Hook Forms
- Axios
- Tailwind CSS

### Installation and Setup Instructions

#### Example:  

Clone o repositório. Você vai precisar do `node` e `npm` instalado na sua maquina.

Instalação:

`npm install`  


Para iniciar Servidor:

`npm run dev`  

Para acessar o aplicativo:

`localhost:3000`  