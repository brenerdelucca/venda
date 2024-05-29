# Sistema de venda
Versão do Java: 17<br>
Versão do Spring: 3.3.0

## Rotas
Rota: /vendas <br>
Método: GET<br>
Retorna todas as vendas

Rota: /vendas/2024-01-01&2024-02-28<br>
Método: GET<br>
Retorna uma lista de vendedores com nome, total de vendas e média de vendas diaria conforme o período informado no parâmetro(colocar as datas na mesma formatação do exemplo acima)

Rota: /vendas<br>
Método: POST<br>
Cria uma nova venda<br>
Exemplo de POST no formato JSON:<br>
<pre>
{
    "data": "2024-01-25",
    "valor": "50.25",
    "vendedorId": "3",
    "vendedorNome": "Pedro Souza"
}
</pre>

Rota: /h2-console
Rota para acessar o banco de dados H2
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:venda
User name: sa
Não é necessário senha