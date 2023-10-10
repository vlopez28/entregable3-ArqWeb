Ejercicio Integrador
Tome como punto de partida el ejercicio integrador del TP2
Agregamos carpeta de tp2 como punto de partida, se debe correr el main de la misma, para poder poblar la base de datos.

1) Considere el diseño de un registro de estudiantes, con la siguiente información: nombres,
apellido, edad, género, número de documento, ciudad de residencia, número de libreta
universitaria, carrera(s) en la que está inscripto, antigüedad en cada una de esas carreras, y
si se graduó o no.
2) Implementar las consultas mediante servicios REST para:
a) dar de alta un estudiante:
POST   http://localhost:8080/api/estudiantes
b) matricular un estudiante en una carrera
POST  http://localhost:8080/api/estudianteCarrera
c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
GET http://localhost:8080/api/estudiantes/OrdenadosPorApellido
d) recuperar un estudiante, en base a su número de libreta universitaria.
GET http://localhost:8080/api/estudiantes/LU/127899
e) recuperar todos los estudiantes, en base a su género.
GET  http://localhost:8080/api/estudiantes/genero/fem
f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
GET  http://localhost:8080/api/estudianteCarrera/carreraConInscriptos
g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
GET  http://localhost:8080/api/estudianteCarrera/estudiantesPorCarreraPorCiudad/Tandil/Tudai
h) generar un reporte de las carreras, que para cada carrera incluya información de los
inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y
presentar los años de manera cronológica.
GET  http://localhost:8080/api/estudianteCarrera/Reporte


