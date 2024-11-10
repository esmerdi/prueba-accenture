# prueba-accenture
API para manejar un listado de franquicias. 

# Desplegar Aplicación en un Ambiente Local

### Requisitos
1. **JDK 17**: Asegúrate de tener instalado JDK 17, ya que es la versión compatible con Spring Boot 3.

### Instrucciones

1. **Clonar el Repositorio**  
   Clona el repositorio con el siguiente enlace:  
   `https://github.com/esmerdi/prueba-accenture.git`

2. **Ubicar el JAR de la Aplicación**  
   Dentro de la raíz del proyecto, busca el archivo `prueba-0.0.1-SNAPSHOT.jar` en la carpeta `target`.

3. **Ejecutar el JAR**  
   En el directorio `target`, ejecuta el comando:  
   ```bash
   java -jar prueba-0.0.1-SNAPSHOT.jar

# Instrucciones para Verificar la Aplicación

## Pasos para Verificar el Funcionamiento

1. Accede a la siguiente URL para corroborar que todo está funcionando correctamente:  
   **[http://localhost:8080/api/v1/saludo](http://localhost:8080/api/v1/saludo)**

2. Utiliza la colección de Postman proporcionada, que contiene las definiciones de prueba para los endpoints.

## Información Adicional

- El endpoint base de la API es:  
  **http://localhost:8080/api/v1**

- Para acceder a la base de datos en AWS desde MySQL Workbench u otro IDE de tu preferencia:
  - Conéctate a la instancia de base de datos en AWS.
  - Utiliza el **usuario** y **contraseña** especificados en el archivo de propiedades de la aplicación para una conexión más conveniente.

# Desplegar aplicación en Docker

### Pasos para el despliegue

1. Asegúrate de que la aplicación desplegada localmente **no esté ejecutándose** para evitar conflictos con los puertos. Alternativamente, puedes cambiar el puerto en el archivo `docker-compose.yml` de la izquierda a `8081`.

2. Tener **Docker instalado**, ya sea en Windows o Linux.

3. Una vez clonado el proyecto, abre un bash y accede a la raíz del proyecto (por ejemplo, la carpeta `prueba`).

4. Ejecuta el siguiente comando para construir y ejecutar los contenedores en segundo plano:
   ```bash
   docker-compose up --build -d

# Guía de Uso

### Pasos para comprobar el correcto funcionamiento de la aplicación

1. Acceder al endpoint para verificar el estado de la aplicación:
   - **URL**: [http://localhost:8080/api/v1/saludo](http://localhost:8080/api/v1/saludo)
   - Este endpoint debería devolver un mensaje de saludo que indica que la aplicación está funcionando correctamente.

2. Probar los servicios utilizando la colección de Postman.
   - Importa la colección de Postman proporcionada y ejecuta los distintos servicios para asegurarte de que todas las funcionalidades están operativas.

### Notas

- Asegúrate de que la aplicación esté en ejecución antes de acceder al endpoint.
- La colección de Postman debe estar actualizada y configurada para apuntar a `localhost:8080` o a la dirección en la que se esté ejecutando la aplicación.

# Probar la Aplicación en AWS

Sigue estos pasos para verificar el correcto funcionamiento de la aplicación desplegada en AWS.

## Pasos

1. **Acceder a la URL de Prueba**
   - Abre tu navegador y dirígete a: [http://3.84.150.66:8080/api/v1/saludo](http://3.84.150.66:8080/api/v1/saludo)
   - Verifica que el servicio responda correctamente.

2. **Probar Servicios con Postman**
   - Usa la colección de Postman correspondiente para probar los diferentes endpoints de la API.
   - Asegúrate de cambiar el direccionamiento de cada solicitud a la instancia en AWS (`http://3.84.150.66:8080`).
