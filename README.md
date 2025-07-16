# SpringBoot-iedShop

# Develop

Api Producto usa el unicializador Data Rest de SpringBoot no es necesario definir controlador 



# Start MySql Docker

mysql 

```
#docker run --name mysql -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql
#docker start mysql
```
Crear:

`Esquema: db_springboot_backend`   
`Usuario: bancausuario`

# Run Scripts

En la carpeta de recursos del proyecto src/main/resources/projectdocs
Ejecutar `ScriptSecurty.sql`
-- 1) run script on mysql DB: db_springboot_backend user: bancausuario.
-- 2) select * from members.
-- 3) select * from roles.


# Start app Docker

app iedShop

```
docker run -d --name appiedShop -p 8080:8080 app1:0.0
```

Nota: Al iniciar la app se crean las tablas en BD y se poblan automaticamente

datos:

Producto

| ID | Cantidad | Producto_ID |
|----|----------|-------------|
| 1  | 5        | 1           |
| 2  | 5        | 2           |
| 3  | 5        | 3           |


Inventario

| ID | Cantidad | Producto_ID |
|----|----------|-------------|
| 1  | 5        | 1           |
| 2  | 5        | 2           |
| 3  | 5        | 3           |





# go Postman 

1) revisar la coleccion postman en la carpeta de recursos del proyecto  `src/main/resources/projectdocs/IedShop-docker.postman_collection.json `
   
     Cargar la coleccion en el postman y Consumir cualquiera de los end points...



2) El API cuenta con Autenticacion Basica 
   tener en cuenta  estos usuario  Y roles 


   | Name  | Role          | Password |
   |-------|---------------|----------|
   | john  | ROLE_EMPLOYEE | fun123   |
   | mary  | ROLE_EMPLOYEE | fun123   |
   | mary  | ROLE_MANAGER  | fun123   |
   | edgar | ROLE_EMPLOYEE | fun123   |
   | edgar | ROLE_MANAGER  | fun123   |
   | edgar | ROLE_ADMIN    | fun123   |


# logs 

el archivo log de la aplicacion se almacena en la carpeta del proyecto  `logs/IEDshopApp.log`

hay un archivo log de muestra que esta en la direccion `src/main/resources/projectdocs/ej-IEDshopApp.log`



# Docker app 

Generar imagen con el doquer file que esta en los recursos del proyecto

Correr el contenedor 

Nota: asegurarse que Bd my sql tenga el esquema y el usuario habilitados

usar postman y la coleccion de request 

