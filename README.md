# Bytebank web API

Web API em Spring Boot para consumo do App em Flutter do Bytebank

## Funcionalidades

A Web API oferece as seguintes funcionalidades:

- Listagem e cadastro de transações.

## Como executar

Após clonar o projeto, dentro do diretório raiz, execute a task `bootRun` do Gradle. A primeira execução vai realizar o download de todas dependências necessárias.

> O uso do Wrapper é recomendado `gradlew` ou `gradlew.bat` para garantir a compatibilidade.

Também é possível executar o projeto via arquivo jar gerado pela task `build` que é armazenado no diretório **build/libs/file-name.jar**. Para executar basta usar o seguinte comando:

```
java -jar file-name.jar
```

> A build do projeto foi feita com base no Java 8, portanto, é recomendado usar o Java 8 para que tudo funcione como esperado.

## Modificando properties de inicialização

Por padrão o Spring Boot vai rodar a aplicação na porta `8080` e vai exigir a senha para criar transação com o valor `1000`.

Caso queria modificar ambos valores, edite os valores das propriedades:


```
server:
  port: ${port:8081}
user:
  password: ${password:2000}
```

Na amostra acima, durante a execução a aplicação vai operar na porta `8081` e a senha para as transações será `2000`.

## Modificando propridades durante a execução

Também é possível modificar as propridades via command line durante a execução.

### Via task `bootRun` do Gradle

Com o Gradle você pode alterar os valores das properties por meio do comando `-args`:

```
./gradlew bootRun --args='--server.port=8081 --user.password=2000'
```

### Via arquivo jar gerado

Caso execute pelo arquivo jar,

```
java -jar file-name.jar --server.port=8081 --user.password=2000
```

## Mapeamento de end-points

Para acessar as funcionalidades foram disponibilizados os seguintes end-points:

- `/transactions`:
  - **GET**: Listagem:
    - O resultado é ordenado pela data e hora da criação em ordem crescente.

  ```
  // response example
  [
      {
          "id": "b9663ef3-3749-400e-be8f-1280db94aac8",
          "value": 200.00,
          "contact": {
              "name": "gui",
              "accountNumber": 1000
          },
          "dateTime": "2019-11-06 12:57:23"
      },
      {
          "id": "d1bf689c-caa2-4e45-b1fc-5a90b10d6d48",
          "value": 200.00,
          "contact": {
              "name": "gui",
              "accountNumber": 1500
          },
          "dateTime": "2019-11-06 12:57:37"
      }
  ]
  ```

  - **POST**: Inserção:
    - Para salvar a transação é necessário o envio do *header* `password` conforme o valor configurado na aplicação:
      - Caso não seja enviado, é retornado `400 BAD REQUEST`;
      - Caso falhar na autenticação `401 UNAUTHORIZED`.
    - Não é possível alterar a transação, caso haja a tentativa é retornado `409 CONFLICT`.

  ```
  // request body example
  {
    	"value": 200.0,
    	"contact": {
    		"name": "gui",
    		"accountNumber": 1000
    	}
  }

  // response example
  {
        "id": "b9663ef3-3749-400e-be8f-1280db94aac8",
        "value": 200.00,
        "contact": {
            "name": "gui",
            "accountNumber": 1000
        },
        "dateTime": "2019-11-06 12:57:23"
  }
  ```