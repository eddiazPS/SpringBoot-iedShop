FROM eclipse-temurin:17-jdk

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Crear un volumen en la ruta personalizada
#VOLUME ./myVOL

# Copiar el archivo JAR del proyecto en el contenedor
COPY target/localHost3306-iedshop-0.0.1-SNAPSHOT.jar /app/localHost3306-iedshop-0.0.1-SNAPSHOT.jar

# Exponer el puerto de la aplicación (modifica según sea necesario)
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "/app/localHost3306-iedshop-0.0.1-SNAPSHOT.jar"]