# gestion-vehiculos-backend

Este proyecto utiliza Quarkus, el Supersonico Subatômico Framework Java.

Para más informaciones sobre el Quarkus, sigue: https://quarkus.io/ .

# Antes de Empezar

````
Deben estar instalados en tu equipo:
    - El Java JDK v.11
    - El Maven v.3.6.X
````

## Ejecutando la aplicación en modo desenvolvedor in dev mode

Usted puede ejecutar la aplicación en modo desarrollador activando el "live coding" haciendo:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus ahora se envía con una interfaz de usuario de desarrollo, que está disponible en modo de desarrollo solo en http://localhost:8080/q/dev/.

## Empaquetando y ejecutando la aplicación

La aplicación puede ser empaquetada de manera:
```shell script
./mvnw package
```
Produce el archivo `quarkus-run.jar` en el directorio` target / quarkus-app / `.
Tenga en cuenta que no es un _über-jar_ ya que las dependencias se copian en el directorio `target / quarkus-app / lib /`.

## Ejecutando los testes
```shell script
./mvnw test
```

## La documentación de la API puede ser accedida en: [swagger-ui](http://localhost:8080/q/swagger-ui/)

### RESTEasy JAX-RS

Inicie fácilmente sus servicios web RESTful

[Guía relacionado](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
