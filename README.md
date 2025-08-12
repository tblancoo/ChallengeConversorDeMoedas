Challenge Conversor de Moedas
Aplicação Java desenvolvida para o desafio Challenge ONE – JAVA – Backend, utilizando a ExchangeRate API para obter taxas de câmbio em tempo real e realizar conversões entre diferentes moedas.

📋 Funcionalidades
Menu interativo no console para seleção da conversão.

Conversões disponíveis:

Dólar (USD) → Peso argentino (ARS)

Peso argentino (ARS) → Dólar (USD)

Dólar (USD) → Real brasileiro (BRL)

Real brasileiro (BRL) → Dólar (USD)

Dólar (USD) → Peso colombiano (COP)

Peso colombiano (COP) → Dólar (USD)

Consumo da API ExchangeRate API usando HttpClient.

Interpretação do retorno JSON com Gson.

Exibição do resultado formatado no console.

🛠 Tecnologias utilizadas
Java 21

Biblioteca Gson (Google)

HttpClient, HttpRequest, HttpResponse (Java)

IntelliJ IDEA

🔑 Obtenção da chave da API
Acesse: https://www.exchangerate-api.com/

Clique em Get Free Key e cadastre seu e-mail.

Verifique sua caixa de entrada e copie a API Key enviada.

No código, insira sua chave na variável apiKey da classe Principal.

Exemplo:

java
Copiar
Editar
String apiKey = "SUA_CHAVE_AQUI";
▶️ Como executar o projeto
Clone este repositório ou baixe os arquivos.

Abra o projeto no IntelliJ IDEA.

Adicione o Gson ao projeto:

Baixe o JAR em: https://github.com/google/gson

No IntelliJ: File → Project Structure → Libraries → Add → JAR.

Compile e execute a classe Principal.

📌 Observações importantes
É necessário ter Java 17 ou superior instalado.

A API é gratuita, mas possui limite de requisições diárias no plano free.

A base e o destino são escolhidos automaticamente pelo menu.
