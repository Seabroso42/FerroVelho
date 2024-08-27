# IRON-OLD
## Descrição geral do projeto:

-- projeto desenvolvido para a cadeira de IP2 na UFRPE.
O projeto é, em resumo, um sistema para um ferro-velho, com repositório de produtos, repositório de clientes, carrinho de compras e medidor de qualidade de produto.
O programa contará com controladores que podem adicionar, remover, reorganizar e ler usuários e produtos no tal ferro velho, além de permitir a compra, por meio do carrinho de compras. O sistema também contará com métodos para verificar a qualidade do produto analisado, que decai ao longo do tempo.

### Ideia do programa:

* O programa se iniciará com uma tela de login e senha / criar conta.
* Após a tela de login, o usuário será redirecionado a página inicial da aplicação, onde pode acessar o seu carrinho ou buscar por determinados itens, podendo buscá-los por: Tipo do automóvel, Qualidade da peça, Preço e Nome.
* Existirão diferentes tipos de usuários, como usuário Padrão e o Admin, onde o admin terá o poder de adicionar produtos, transformar outros usuários em admins e completar vendas.
* A ordem das telas seguirá o fluxograma anexado(Ainda vamos fazer).
  
## Tecnologias:

- o backend do projeto está sendo desenvolvido em Java
- o banco de dados implementado é um MySql conectado com JDBC
- a interface do projeto foi desenvolvida em JavaFx

## Requisitos do Projeto:

* Usuários devem possuir métodos para adicionar e remover itens de seu carrinho.
* Usuários devem poder buscar por itens e ordená-los a partir do atributo: Nome, Tipo, Qualidade e Preço.
* Navegação entre a página de cada item.
* Usuário Vendedor deverá poder adicionar e remover Items.
* Usuário vendedor só poderá se cadastrar caso tenha configurado sua carteira.
* Usuário Admin deverá poder transformar outros usuários em Admins e Vendedores.
* O programa poderá gerar uma Nota Fiscal de uma venda, contendo nome do cliente, nome do vendedor, produtos e quantidades.
* O programa conterá uma função para calcular o preço total do carrinho de um cliente.
* Clientes podem acessar seu carrinho e histórico de compras.
* Vendedores podem acessar seu histórico de vendas.
* O programa conterá um método que diminui a qualidade da peça de acordo com o tempo que passou no estoque.
* Um sistema de autenticação de usuário estará presente no código.
* Algumas funcionalidades de gerenciamento deverão estar disponíveis somente para a classe administrador.
