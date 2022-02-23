</div>
<a name="back-to-top">

<p align="center">
  <a href="">
    <img width="300px" src="" alt="">
   </a>
</p>

<p>
    <h2 align="center"> Projeto Aplicado </h2>
</p> 
  </br>
<br>
<div align="center">
  <a href="https://serratec.org/"><img width="500px" src="https://i.imgur.com/H5Pd8Ah.png" ></a>
  <br>  </br>
</div>
<br>
<br>
<div align="center">
  <a href="https://jaya.tech/"><img width="500px" src="https://jaya.tech/images/logo-black.png" ></a>
  <br>  </br>
</div>
<br>

## ✔️ API Currency Converter SERRATEC/Jaya Tech [API]
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="https://github.com/ProjetoJayaTech/ProjectWithAuth">**Requisitos [JAYATECH]**  </a>
 <br>  </br>
<details>
  <summary>✔️ Requisitos:</summary><br>
      <p align="justify">
👉 Conversor de moedas: <br></br>
<p>Você deverá implementar uma API Rest que seja capaz de realizar a conversão entre duas moedas utilizando taxas de conversões atualizadas de um serviço externo.</p>

<p>Para realização da conversão é necessário o ID do usuário que deseja realizar a conversão.</p>

<p>A API deverá registrar cada transação de conversão com todas as informações relacionadas e também disponibilizar um endpoint para consulta das transações realizadas por um usuário.</p>

1 - Deve ser possível realizar a conversão entre 4 moedas no mínimo (BRL, USD, EUR, JPY);</br>
2 - As taxas de conversão devem ser obtidas de http://api.exchangeratesapi.io/latest?base=EUR (Usar a API Free - Tem limitação de requisições, e apenas conversão com base na moeda EUR)</br></br>
3 - As transações de conversão devem ser persistidas no banco de dados (embedded) contendo:</br></br>
● ID do usuário;</br>
● Moeda origem;</br>
● Valor origem;</br>
● Moeda destino;</br>
● Taxa de conversão utilizada;</br>
● Data/Hora UTC;</br></br>
4 - Uma transação com sucesso deve retornar:</br></br>
● ID da transação</br>
● ID do usuário;</br>
● Moeda origem;</br>
● Valor origem;</br>
● Moeda destino;</br>
● Valor destino;</br>
● Taxa de conversão utilizada;</br>
● Data/Hora UTC;</br></br>
5 - Os casos de falha devem retornar com status code pertinente e descrição no corpo;</br>
6 - Deverá existir um endpoint para listagem de todas as transações realizadas por usuário;</br>
7 - Deve haver uma cobertura satisfatória de testes;</br>
8 - Deve haver um Readme que explique como rodar a aplicação, e com uma apresentação sobre o projeto: propósito, features, motivação das principais escolhas de tecnologias, e separação das camadas.</br>
9 - Todo o código deve ser em inglês;</br>
10 - Deve ser entregue em um repositório do GitHub;</br></br>
👉 Ítens desejáveis</br></br>
● Logs</br>
● Tratamento de exceções</br>
● Documentação</br>
● Coesão de commits</br>
● Mensagens de commits claras</br>
● Configuração de lint</br>
● Testes unitários</br>
● Testes de integração</br>
● Documentação dos endpoints</br>
● Estar rodando e disponível (Ex: Heroku, ou similar)</br>
● CI/CD</br>
  </details>

<BR>

## 🔑API Currency Converter SERRATEC/Jaya Tech [API]
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="http://169.57.150.59:8016/swagger-ui/index.html#/">**Documentation [SWAGGER]**  </a>
<br>  </br>
<details>
  <summary>✔️ Functionalities:</summary><br>
      <p align="justify">
      1:  Insert User <br>
      2:  Login User <br>
      3:  Insert Transaction <br>
      4:  List all Transactions <br>
      5:  List Transactions by Id User <br>
      6:  List all Rates <br>
      7:  Custom Exceptions <br>
      8:  Unit testing <br>
      9:  Return codes in standard http <br>
      10:  Authentication Tokens <br>
      11:  Documentation with Swagger <br>
      12:  Continuous Integration and Delivery with CircleCI <br>
      13:  Using the  SonarLint extension <br>
      14:  Saving Rates for 30 minutes to decrease the amount of requests on the exchangeAPI <br>
      15:  A calculation to change the source currency to the chosen one, since the exchangeAPI only makes calculations based on EUR <br>
</details>

<br>


## ✔️ Running the API  [RUN] [API]
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br></br>
⚠️🔃**USE THE FOLLOWING CODES TO RUN THE API FROM THE PROMPT <br><br> 

👉 mvn package -Dmaven.test.skip

👉java -jar project-0.0.1-SNAPSHOT.jar<br><br>

⚠️**In case of error**<br>

👉 Open Spring tool suit 4 and follow the steps below:

<br>
  <div align="center">
  <img width="1000px" src="assets/InCaseOfError.gif">
</div>


## 🔒 Register [User] [POST]
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**Register user registration through the endpoint <a href="http://169.57.150.59:8016/api/user">/login </a>**  

  <div align="center">
  <img width="1000px" src="assets/InsertUserJaneDoe.gif">
</div>
  ⚠️🔃**USE THE FOLLOWING TEMPLATE TO INSERT A NEW USER <br><br> 

**Enter the following parameters in Body: **<br>

{<br>
    "login":"JaneDoe123",<br>
    "name":"Jane Doe",<br>
    "email":"janedoe@gmail.com",<br>
    "password":"admin"<br>
}<br>
<br>

<br>
⚠️🔃**USE THE cURL TO INSERT A NEW USER <br><br> 

curl --location --request POST 'http://169.57.150.59:8016/api/user' \<br> 
--header 'Content-Type: application/json' \<br> 
--data-raw '{<br> 
    "login":"JaneDoe123",<br> 
    "name":"Jane Doe",<br> 
    "email":"jane@doe.com",<br> 
    "password":"admin"<br> 
}'<br> 
<br> 

## 🔒 Authentication[LOGIN-TOKEN] [POST]
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**Login with endpoint <a href="http://169.57.150.59:8016/login">/login </a>, a 15 minute TOKEN will be generated**  

  <div align="center">
  <img width="1000px" src="assets/LoginJaneDoe.gif">
</div>
<br></br>
  ⚠️🔃**USE THE FOLLOWING TEMPLATE TO LOGIN <br><br> 

**Enter the following parameters in Body: **<br>
{<br>
    "login":"JaneDoe12345",<br>
    "password":"admin"<br>
}<br>

**Will return a token **<br>

<br>

<br>
⚠️🔃**USE THE cURL TO LOGIN <br><br> 

curl --location --request POST 'http://169.57.150.59:8016/login' \<br> 
--header 'Content-Type: application/json' \<br> 
--data-raw '{<br> 
    "login":"JaneDoe123",<br> 
    "password":"admin"<br> 
}'<br> 
<br> 

## ✔️ Insert Transaction  [END-POINT] [POST]
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Inserting Transaction through the endpoint <a href="http://169.57.150.59:8016/api/transactions"> /api/transactions**  </a>
 
  
  <div align="center">
  <img width="1000px" src="assets/InsertTransactionUserJaneDoe.gif">
</div>
  <br></br>
⚠️🔃**USE THE FOLLOWING TEMPLATE TO INSERT A NEW TRANSACTION <br><br> 

  **Enter the following parameters in Headers: **<br>

👉 KEY = Authorization<br>

👉 VALUE = Bearer + TOKEN<br>

**Enter the following parameters in Body: **<br>

{<br>
    "originCoin": "USD",<br>
    "destinyCoin": "BRL",<br>
    "inputValue": 128,<br>
    "idUser": 2<br>
}<br>
<br>

<br>
⚠️🔃**USE THE cURL TO INSERT A NEW TRANSACTION <br><br> 

curl --location --request POST 'http://169.57.150.59:8016/api/transactions' \<br>
--header 'Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKYW5lRG9lMTIzIiwiZXhwIjoxNjQyNTU2MTE5fQ.-TqMtoKKCXPJPDjQlVcZrSVT3ogztWvzekhTy45LslMHYp_xnjvw3ElbUmZTJiFmJ2piuMbZYK6-j4m5Zt9DgA' \<br>
--header 'Content-Type: application/json' \<br>
--data-raw '{<br>
    "originCoin": "USD",<br>
    "destinyCoin": "BRL",<br>
    "inputValue": 128,<br>
    "idUser": 2<br>
}'<br>

<br>
  
## ✔️ List all Transactions  [END-POINT] [GET]
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **List all Transactions through the endpoint <a href="http://169.57.150.59:8016/api/transactions"> /api/transactions**  </a>
 
  <div align="center">
  <img width="1000px" src="assets/GetAllTransactions.gif">
</div>
  <br></br>
  ⚠️🔃**USE THE FOLLOWING TEMPLATE TO LIST ALL TRANSACTIONS <br><br> 

  **Enter the following parameters in Headers: **<br>

👉 KEY = Authorization<br>

👉 VALUE = Bearer + TOKEN<br>

<br>
⚠️🔃**USE THE cURL TO LIST ALL TRANSACTIONS <br><br> 

curl --location --request GET 'http://169.57.150.59:8016/api/transactions' \
--header 'Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKYW5lRG9lMTIzIiwiZXhwIjoxNjQyNTU2MTE5fQ.-TqMtoKKCXPJPDjQlVcZrSVT3ogztWvzekhTy45LslMHYp_xnjvw3ElbUmZTJiFmJ2piuMbZYK6-j4m5Zt9DgA'

<br>

**Expected return: **<br>
[<br>
    {<br>
        "idTransaction": 1,<br>
        "originCoin": "USD",<br>
        "destinyCoin": "EUR",<br>
        "inputValue": 128.00,<br>
        "conversionRate": 0.87,<br>
        "finalValue": 111.71,<br>
        "dateTransaction": "2022-01-13",<br>
        "idUser": 7<br>
    },<br>
    {<br>
        "idTransaction": 2,<br>
        "originCoin": "USD",<br>
        "destinyCoin": "BRL",<br>
        "inputValue": 128.00,<br>
        "conversionRate": 5.53,<br>
        "finalValue": 707.70,<br>
        "dateTransaction": "2022-01-14",<br>
        "idUser": 2<br>
    }<br>
]<br>
<br>

## ✔️ List Transactions by Id User  [END-POINT] [GET]
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  **List all Transactions by id user through the endpoint <a href="http://169.57.150.59:8016/api/transactions/2">/api/transactions/2**  </a>
 
  
  <div align="center">
  <img width="1000px" src="assets/GetTransactionsById.gif">
</div>
  <br></br>
  ⚠️🔃**USE THE FOLLOWING TEMPLATE TO LIST ALL TRANSACTIONS BY ID USER<br><br> 

 **Enter the following parameters in the link: **<br>

👉 /api/transactions/ User ID to be queried --> /api/transactions/2

  **Enter the following parameters in Headers: **<br>

👉 KEY = Authorization<br>

👉 VALUE = Bearer + TOKEN<br>

<br>
⚠️🔃**USE THE cURL TO LIST ALL TRANSACTIONS BY ID USER <br><br> 

curl --location --request GET 'http://169.57.150.59:8016/api/transactions/2' \
--header 'Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKYW5lRG9lMTIzIiwiZXhwIjoxNjQyNTU2MTE5fQ.-TqMtoKKCXPJPDjQlVcZrSVT3ogztWvzekhTy45LslMHYp_xnjvw3ElbUmZTJiFmJ2piuMbZYK6-j4m5Zt9DgA'

<br>
**Expected return: **<br>
[<br>
    {<br>
        "idTransaction": 1,<br>
        "originCoin": "USD",<br>
        "destinyCoin": "EUR",<br>
        "inputValue": 128.00,<br>
        "conversionRate": 0.87,<br>
        "finalValue": 111.71,<br>
        "dateTransaction": "2022-01-13",<br>
        "idUser": 2<br>
    },<br>
    {<br>
        "idTransaction": 2,<br>
        "originCoin": "USD",<br>
        "destinyCoin": "BRL",<br>
        "inputValue": 128.00,<br>
        "conversionRate": 5.53,<br>
        "finalValue": 707.70,<br>
        "dateTransaction": "2022-01-14",<br>
        "idUser": 2<br>
    }<br>
]<br>
<br>

## ✔️ List All Rates  [END-POINT] [GET]
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  **List all Rates through the endpoint <a href="http://169.57.150.59:8016/api/transactions/rates">/api/transactions/rates**  </a>
 
  
  <div align="center">
  <img width="1000px" src="assets/GetAllRates.gif">
</div>
  <br></br>
  ⚠️🔃**USE THE FOLLOWING TEMPLATE TO LIST ALL RATES<br><br> 

  **Enter the following parameters in the link: **<br>

👉 /api/transactions/ --> /api/transactions/rates<br>

  **Enter the following parameters in Headers: **<br>

👉 KEY = Authorization<br>

👉 VALUE = Bearer + TOKEN<br>


<br>
⚠️🔃**USE THE cURL TO LIST ALL RATES <br><br> 

curl --location --request GET 'http://169.57.150.59:8016/api/transactions/rates' \
--header 'Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKYW5lRG9lMTIzIiwiZXhwIjoxNjQyNTU2MTE5fQ.-TqMtoKKCXPJPDjQlVcZrSVT3ogztWvzekhTy45LslMHYp_xnjvw3ElbUmZTJiFmJ2piuMbZYK6-j4m5Zt9DgA'

<br>

**Expected return: **<br>
{<br>
    "success": "true",<br>
    "timestamp": "1642172943",<br>
    "base": "EUR",<br>
    "date": "2022-01-14",<br>
    "rates": {<br>
        "JPY": 130.109121,<br>
        "EUR": 1,<br>
        "USD": 1.143465,<br>
        "BRL": 6.325073<br>
    },<br>
    "dateForTest": "2022-01-14T12:10:35.4989988"<br>
}
<br>

## <img  height="45px" align="center" src="https://github.com/luqui2/Sistema-para-Viagens-/blob/main/src/imagens/foguete.gif"> Built with the following technology

- [**Java**](https://www.oracle.com/java/technologies/)    [(*Documentation*)](https://docs.oracle.com/en/java/)    [(*Documentation MDN*)](https://developer.mozilla.org/en-US/docs/Glossary/Java)
- [**PostgreSQL**](https://www.postgresql.org/)    [(*Documentation*)](http://pgdocptbr.sourceforge.net/pg80/index.html)
- [**Postman**](https://www.postman.com/downloads/)    [(*Documentation*)](https://learning.postman.com/docs/getting-started/introduction/)
- [**Spring Boot**](https://spring.io/)    [(*Documentation*)](https://spring.io/projects/spring-boot)
- [**Spring Tools 4**](https://spring.io/tools)    [(*Documentation*)](https://github.com/spring-projects/sts4/wiki)
- [**Swagger**](https://swagger.io/)    [(*Documentation*)](https://swagger.io/solutions/api-documentation/) 
- [**SonarLint**](https://www.sonarlint.org/eclipse/)    [(*Documentation*)](https://www.sonarsource.com/products/sonarlint/) 
     

<br>
 
## <img height="45px" align="center" src="https://github.com/luqui2/Sistema-para-Viagens-/blob/main/src/imagens/set.gif">   Developers:
 <br>

- [**Diego Dias Faria da Silveira**](https://github.com/diegofaria13)    [(*LinkedIn*)](https://www.linkedin.com/in/diegofaria13/)
- [**Leticia de Souza Lannes**](https://github.com/letilannes)    [(*LinkedIn*)](https://www.linkedin.com/in/let%C3%ADcia-de-souza-lannes/)
- [**Lucas Coelho Paulino**](https://github.com/Lucascoelhop)    [(*LinkedIn*)](https://www.linkedin.com/in/lucacoelhop/)
- [**Raphaela Bernardes Medeiros Martins**](https://github.com/raaphaa)    [(*LinkedIn*)](https://www.linkedin.com/in/raphaela-martins-3596a5133/)
 <br>
<div align="center">      
 </div>
</p>

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;⬆️[**Back to the top**](#back-to-top)⬆️
