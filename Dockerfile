FROM maven:3.8.7-eclipse-temurin-17 AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos del proyecto
COPY pom.xml .
COPY src ./src

# Compila el proyecto y genera el JAR
RUN mvn clean package -DskipTests

# Etapa 2: Imagen mínima para ejecutar Spring Boot
FROM eclipse-temurin:17-jre

# Directorio de trabajo en la imagen final
WORKDIR /app

# Copia el JAR desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto en el que corre la aplicación
EXPOSE 8080

# Comando de ejecución
ENTRYPOINT ["java", "-jar", "app.jar"]