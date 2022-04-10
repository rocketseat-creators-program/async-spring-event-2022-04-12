<img src="https://storage.googleapis.com/golden-wind/experts-club/capa-github.svg" />

## Programação Assíncrona com Spring Event
Nesta aula vamos apresentar um ótimo recurso para separar rotinas de sua aplicação, não necessitamdo nenhuma infraestrutura externa, 
pois esses eventos ocorrem dentro da Java VM. Com isso, os eventos só serão enviados para outras rotinas dentro da mesma JVM,
não há troca de mensagens entre processos, mas podemos usar para executar blocos de código de maneira assíncrona, fazendo uso dos recursos do Java.



### Ambiente Utilizado
* Java JDK 17
* Spring 2.6.6
* Intellij Community
* Sistema Operacional Linux

### Diretório do Projeto

Abaixo iremos descrever brevemente o que cada classe tem por objetivo de realizar.

```sh
.
├── src/
│   ├── cart/
│   │   ├── Cart  # entidade com os campos de um carrinho de compras
│   │   ├── CartAndProductRequestDTO # DTO que adiciona produto ao carrinho existente
│   │   ├── CartConfirmEvent # evento para confirmação de um carrinho
│   │   ├── CartController # classe que recebe os request de api a cerca do carrinho
│   │   ├── CartCreateRequestDTO # classe que armazena os dados para criação de um carrinho
│   │   ├── CartListener # listenner que fica esperando os eventos de carrinho
│   │   ├── CartRepository # interface que realiza as operações do banco de dados
│   │   └── CartService # classe que realiza toda a lógica dos serviços do carrinho
│   ├── product/
│   │   ├── Product # entidade com os campos de produto
│   │   ├── ProductController # classe que recebe os request de api a cerca de produto
│   │   ├── ProductCreateRequestDTO # classe que armazena os dados para criação de um produto
│   │   ├── ProductListener # listenner que fica esperando os eventos de produto
│   │   ├── ProductRepository # interface que realiza as operações do banco de dados
│   │   ├── ProductService # classe que implementa o serviço de produto
│   │   ├── ProductUpdatedEvent # evento disparado quando um produto é atualizado
│   │   └── ProductUpdateRequestDTO # DTO que o campos informados no request de atualização de um produto
│   ├── EventBusConfiguration #configura o barramento para execução dos eventos
│   └── EventAplication #classe principal do projeto
├── .gitignore # informa quais arquivos  o git deve ignorar
├── License # lincesa de utilização do código (MIT)
├── pom.xml # arquivo que contém todas as dependências do projeto
├── README.md # este arquivo
└── slides.pdf # slides utilizandos durante a apresentação da aula.
```


## Expert
| [<img src="https://avatars.githubusercontent.com/u/1785791?s=400&u=cf86c9ae2216765f948ca2136eda7e632e0cd922&v=4" width="75px;"/>](https://github.com/gustavodsf) |
| :-: |
|[Gustavo Figueiredo](https://github.com/gustavodsf)|







