
# Evaluación Programador Java Web
Deberás generar una aplicación Web con alguna tecnología Java2EE (Springboot/Grails es un plus) la
cual permita resolver la siguiente situación:
Existe una problemática en un hospital la cual consiste en que los doctores del área de Medicina Interna
no saben cuántas ni a qué hora tienen citas durante el día.
### La aplicación debe tener registrada la siguiente información:
● Doctores (3 a 5 para el ejercicio, se pueden insertar manualmente)
● Nombre
● Apellido Paterno
● Apellido Materno
● Especialidad
### Consultorios (3 a 5 para el ejercicio, se pueden insertar manualmente)
● Numero de consultorio
● Piso
### Citas (se generan dinámicamente)
● Consultorio
● Doctor
● Horario de consulta
● Nombre del paciente
## Las citas se generan por una asistente por tanto el sistema deberá contar con las siguientes pantallas o
módulos:
● Alta de cita (solicita los datos necesarios obligatorios)
● Las reglas para el alta son:
▪ No se puede agendar cita en un mismo consultorio a la misma hora.
▪ No se puede agendar cita para un mismo Dr. a la misma hora.
▪ No se puede agendar cita para un paciente a la una misma hora ni con menos de 2 horas
de diferencia para el mismo día. Es decir, si un paciente tiene 1 cita de 2 a 3pm, solo
podría tener otra el mismo día a partir de las 5pm.
▪ Un mismo doctor no puede tener más de 8 citas en el día.
● Consulta de citas.
▪ Puedes consultar por fecha, consultorio y por Dr. (Si soy el Dr. Ramos y quiero saber
cuántas citas tengo para hoy o para mañana debe ser posible consultarlo en el sistema)
▪ Puedes cancelar una cita que aun este pendiente de realizarse según su horario.
▪ Puedes editar una cita tomando en cuenta las reglas de alta.
NOTAS:
✔ Es ideal que puedas incluir en medida de lo posible las características de la POO como
herencia, polimorfismo, etc.
✔ Se deben generar las tablas necesarias para el sistema.
✔ Se tomarán en cuenta validaciones, así como mensajes de error.
✔ La persistencia de datos
✔ Presentación o vista del sistema, lo mejor que puedas tomando el cuenta el corto tiempo para la
prueba.
✔ Utilizar el patrón MVC
Al terminar sube tu proyecto a un repositorio público en GITHUB y comparte el URL por linkedIn a tu
ejecutivo Kosmos para que sea revisado.
Puedes usar el IDE de tu preferencia, así mismo el gestor de base de datos SQL y servidor de aplicación
con el que estés más familiarizado.