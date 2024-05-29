##Sistema de venda

Versão do Java: 17
Versão do Spring: 3.3.0

#Rotas
Rota: /vendas
Método: GET
Retorna todas as vendas

Rota: /vendas/2024-01-01&2024-02-28
Método: GET
Retorna uma lista de vendedores com nome, total de vendas e média de vendas diaria conforme o período informado no parâmetro(colocar as datas na mesma formatação do exemplo acima)

Rota: /vendas
Método: POST
Cria uma nova venda
Exemplo de POST no formato JSON:
{
    "data": "2024-01-25",
    "valor": "50.25",
    "vendedorId": "3",
    "vendedorNome": "Pedro Souza"
}