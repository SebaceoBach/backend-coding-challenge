# Backend Coding Challenge

## EndPoints with queries

Author: Sebastian Salazar

Desarrollo de API REST en Spring Boot utilizando H2SQL y Postman

Para utilizar el .tsv de las ciudades utilicé Postman en la pestaña Body para subir el archivo con la llave "file" en el siguiente path.

"http://localhost:8080/api/v1/suggestions/search"

Para buscar y filtrar una ciudad se puede agregar al link un aproximado al nombre,
ordenar por cualquier parámetro y además agregar otros filtros, Ejemplo:

"http://localhost:8080/api/v1/suggestions/search?q=Miami&sort=population,desc&lat=25.77427"
