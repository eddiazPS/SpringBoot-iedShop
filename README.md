# SpringBoot-iedShop


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














This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 17.3.8.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.





# Backend en Nest

```
docker compose up -d
```


corre al app en modo de desarrollo ```npm run start:dev ```


Copiar el   ```.env.template```    y renombrarlo a    ```.env```