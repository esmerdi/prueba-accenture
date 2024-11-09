# Imagen base de Java
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR de la aplicación a la imagen Docker
COPY target/prueba-0.0.1-SNAPSHOT.jar /app/prueba-0.0.1-SNAPSHOT.jar

# Exponer el puerto en el que la aplicación Spring Boot escucha
EXPOSE 8080

# Ejecutar la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "/app/prueba-0.0.1-SNAPSHOT.jar"]
