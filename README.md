# SpringBoot-iedShop @Autor 'Edgar Hernando Diaz'

# Develop

Esta Api tienen seguridad basica con los roles de empleado, jefe y administrador.
Nota: revisar usarios, passwords y roles en la seccicion  **Run Scripts**

La Api iedShop usa un icializador llamado Data Rest de SpringBoot donde se declaran repositorios y se definen las enidades con esto y el inicializador Data Rest da y no es necesario definir servicio ni controlador para el CRUD de Productos e Inventarios ver los endPoints en la coleccion Postman en la seccion **go Postman** , estos endpoints estan indicados con -REST


# End Points

Esta api tiene estos endpoints


Producto

| Nombre                   | Endpoint                             | Controlador y Servicio |
|--------------------------|--------------------------------------|------------------------|
| All-productos_REST       | http://localhost:8080/productos      | NO                     |
| productosById-REST       | http://localhost:8080/productos/2    | NO                     |
| Crea-productos-REST      | http://localhost:8080/productos      | NO                     |
| Actualizaproductos-REST  | http://localhost:8080/productos/1    | NO                     |
| Productos-REST           | http://localhost:8080/productos/6    | NO                     |
| All-products-controller  | http://localhost:8080/prod/all       | SI                     |





Inventario

| Nombre                                   | Endpoint                                | Controlador y Servicio |
|------------------------------------------|-----------------------------------------|------------------------|
| All-inventario-REST                      | http://localhost:8080/inventario        | NO                     |
| ActualizaInventarioProductoID-controller | http://localhost:8080/inve/4            | SI                     |
| Actualizar-Inventario-inventario_id-REST | http://localhost:8080/inventario/1      | NO                     |
| ConsultaInventario-producto-controller   | http://localhost:8080/inve/producto/4   | SI                     |


# Start MySql Docker

MySql 

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


# Start Docker app

1) Generar Jar en el proyecto

2) Generar imagen con el Docker con el Dockerfile que esta en los recursos del proyecto

3) Correr el contenedor en el puerto 80:80

Nota: asegurarse que Bd my sql tenga el esquema y el usuario activo

4) Usar postman y la coleccion de request


# go Postman 

1) Revisar la coleccion postman en la carpeta de recursos del proyecto  `src/main/resources/projectdocs/IedShop-docker.postman_collection.json `
   
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

El archivo log de la aplicacion se almacena en la carpeta del proyecto  `logs/IEDshopApp.log`

Hay un archivo log de muestra que esta en la direccion `src/main/resources/projectdocs/ej-IEDshopApp.log`





