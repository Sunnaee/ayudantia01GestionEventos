# Gestión de Acceso a Eventos
###### Estudiante: Sabrina López
Descripción: Desarrollar un programa en Java para gestionar la entrada a un evento. El sistema debe trabajar con una matriz de 10x5 donde cada fila contiene la siguiente información:
1. Nombre: Nombre de la persona.
2. Edad: Edad de la persona.
3. Entrada: Tipo de entrada que tiene la persona: "General", "VIP", o "False" si no tiene entrada.
4. Invitados: Número de invitados adicionales que acompañan a la persona. Solo las personas con entrada "VIP" pueden tener invitados; en caso contrario, este valor debe ser 0.
5. Ingresado: Indica si la persona ya se encuentra dentro del evento. Si está dentro, se ingresa “True”; si no, “False”.
- El programa debe gestionar dos aforos máximos independientes:
   - Sala VIP: Exclusiva para los asistentes con entrada "VIP" y sus invitados.
   - Sala General: Para aquellos que tengan entrada "General".
