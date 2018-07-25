# AppExampleJava
Exemplo base de aplicação com Angular, Spring, Hibernate e Oracle

Stack:

- Front-end
Angular Utilizado template front-end Blur Admin
Documentaçõa do Blur Admin: https://akveo.github.io/blur-admin/articles/001-getting-started/
Demo do template: https://akveo.github.io/blur-admin/

- Back-end
Java utilizando Spring boot

Projeto inicializado pelo Spring Initializr contendo:
DevTools (Spring Boot Development Tools)
Web (Full-stack web development with Tomcat and Spring MVC)
JPA (Java Persistence API including spring-data-jpa, spring-orm and Hibernate)

- Data Base
Oracle 12c (utilizando docker container para testes)


-  Levantar o ambiente:

1 - Banco oracle: 

Caso já possua o oracle instalado, pular para passo 2.

1.1 - instalar o docker

1.2- Com o docker instalado...

Baixar e rodar a imagem mritschel/oraclebase seguindo essas instruções: https://hub.docker.com/r/mritschel/oraclebase/

Comando informado no guia: docker run -d -p 8080:8080 -p 5500:5500 -p 1521:1521 -v [<host mount point>:]/u01/oracle/oradata  --name oracle-base mritschel/oraclebase

Comando utilizado por mim para rodar a imagem: docker run -d -p 8080:8080 -p 5500:5500 -p 8090:1521 -v /c/oracle_db:/u01/oracle/oradata --name oracle-base mritschel/oraclebase

Obs: Escolhi rodar o banco na porta 8090 e mapeei o diretório oracledata (do container) com um diretório na minha máquina (C:\oracle_db) onde serão guardados os dados do banco, assim não perco os dados caso derrube e levante o container.

Obs 2: Ao levantar o container a primeira vez, será informado a senha de administrador do banco(guarde essa senha).

2 - Projeto Java:

2.1 - Importar o projeto maven no eclipse

2.2 - Atualizar as dependências do maven, clicando com o botão direito no projeto >> Maven >> Update Project...

2.3 - Abrir o arquivo application.properties, escolher a porta que a aplicação ficará disponível e setar os dados de acesso ao banco.

Ex:
server.port = 8081
spring.datasource.url=jdbc:oracle:thin:@localhost:8090:ORCLCDB
spring.datasource.username= seu_user_name
spring.datasource.password= sua_senha

3 - Start da aplicação

3.1 - Rodar a classe principal MyappexampleApplication e o serviço será levantado

3.2 - acessar a aplicação na porta escolhida ex: http://localhost:8081


4 - Testes

4.1 - Os exemplos de teste estão localizados no diretório src/test/java e podem ser executados clicando com o botão direito sobre a classe >> Run As... >> Junit Test

4.2 - Os exemplos de teste cobrem a persistência com JPA e teste da lógica contida no service.
