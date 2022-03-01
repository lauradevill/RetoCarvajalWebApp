# RetoCarvajalWebApp
Proyecto de creación de una aplicación Web que permita mostrar productos y que el usuario pueda seleccionarlos en una lista de deseos en donde los podrá ver, modificar y eliminar. Adicionalmente el usuario podra acceder a un historial con todos los productos que han sido agregados a lo largo del tiempo a la lista de deseos

##PRE-REQUISITOS
Entorno:
Back-end: Java 11-Spring Boot-JPA-Gradle
	  Intellij IDEA
	  PostgreSQL

Front-end: Visual Studio Code

##PRUEBAS
De APIRest con el cliente Postman, realizando peticiones HTTP a los endpoints dados en las clases Controller.

##DESPLIEGUE
El proyecto está configurado para correr en local en el puerto 8080.
se debe clonar el repositorio del Back-end y el repositorio del Front-end

Para realizar el despliegue:
1. La base de datos a usar es PostgreSQL, en el archivo application.properties se encuentra la configuración y se debe crear una base de datos con nombre reto carvajal y modificar el password
2. Una vez modificadas las variable de entorno en application.properties se debe correr el Back-end preferiblemente en Intellij IDEA
2. Mediante postman se crerán algunos productos para poder visualizarlos en la aplicación web:
-Endpoint: http://localhost:8080/api/Product/save
-Con este body en formato JSON:
    {
        "name": "Vaso Térmico",
        "price": 690.90,
        "quantity": 100,
        "description": "Material EPS Color Blanco"
    }

3. Abrir en el navegador el archivo indexRetoCarvajal.html que está en la carpeta static del proyecto


##CONSTRUIDO CON
Back-end: Java 11-Spring boot-JPA-Gradle
Base de datos: PostgreSQL
Front-end: JavaScript, HTML, CSS, Bootstrap, Jquery

##AUTOR
Laura De Villeros
