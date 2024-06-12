# Usa uma imagem base com o JDK 17
FROM maven:3.8.4-openjdk-17-slim AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo de configuração do Maven
COPY ../pom.xml .

# Copia o código-fonte
COPY ../src src

# Constrói a aplicação usando o Maven
RUN mvn clean install -Dskiptests

# Usa uma imagem JRE para executar a aplicação
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho no novo estágio
WORKDIR /app

# Copia o JAR gerado do estágio anterior para o diretório de trabalho
COPY --from=build /app/target/DesafioDesignPattern-1.0.jar app.jar

EXPOSE 8080

# Define o comando para rodar a aplicação quando o container iniciar
CMD ["java", "-Xmx1024m", "-Xms512m", "-jar", "app.jar"]