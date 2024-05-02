# Sistema de Pedidos - Spring Kafka com MongoDB
<p align="left">
<a href="https://refactoring.guru/design-patterns/java" title="Go to Bash homepage"><img src="https://img.shields.io/badge/Prompt-Project-blue?logo=gnu-bash&amp;logoColor=white" alt="Made with Bash"></a></p>
-------

Este é um sistema de processamento de pedidos assíncrono dividido em módulos para receber e processar pedidos utilizando as tecnologias Java 17, Spring Boot 3, Maven 3.8, Kafka e MongoDB.

## 💻 Tecnologias utilizadas no projeto

- Java 17
- Spring Boot 3
- Maven 3.8
- Kafka
- MongoDB

### 🛠️ Infraestrutura

Para subir a infraestrutura necessária (Kafka e MongoDB), utilize o Docker Compose através do seguinte comando:

```bash
docker compose -f docker-compose.yml up -d
```

## 🧠 Instruções de Instalação
Após a infraestrutura estar em execução, siga os passos abaixo para subir a aplicação modular utilizando o Maven:

1. Clone o repositório
```bash
git clone https://github.com/seu-usuario/seu-projeto.git
```

2. Navegue até o diretório do projeto: 
```bash
cd seu-projeto
```

3. Compile e execute a aplicação utilizando o Maven:
```bash
mvn clean install
mvn spring-boot:run
```

## 🧠 Contribuição

Este projeto está aberto para contribuições. Aceitamos contribuições que sigam a implementação utilizando a arquitetura hexagonal e princípios de clean code. Para contribuir, siga os passos abaixo:

* Faça um fork do projeto.
* Crie uma nova branch com a sua feature: git checkout -b minha-feature
* Faça o commit das suas alterações: git commit -m 'Adicionando nova feature'
* Faça o push para a sua branch: git push origin minha-feature
* Crie um novo Pull Request.

Para reportar problemas ou sugestões, entre em contato pelo [e-mail](williamdkdevops@gmail.com).


## :man_technologist: Licença

Este projeto está licenciado sob a Licença MIT. Consulte o arquivo LICENSE para obter mais detalhes. :octocat:
Contato:

    [![Github Badge](https://img.shields.io/badge/-Github-000?style=flat-square&logo=Github&logoColor=white&link=https://github.com/willdkdevj)](https://github.com/willdkdevj)
[![Linkedin Badge](https://img.shields.io/badge/-LinkedIn-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/william-derek-dias/)](https://www.linkedin.com/in/william-derek-dias/)
[![Gmail Badge](https://img.shields.io/badge/-Gmail-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:williamdkdevops@gmail.com)](mailto:williamdkdevops@gmail.com)
 