Feature: Registrar Hora Médica

  Scenario: Registro de Hora Médica
    Given el usuario está en la página de agendar cita
    When el usuario introduce el ID de mascota "3"
    And el usuario introduce el Rut del Dueño "12345678-9"
    And el usuario introduce el Nombre de la Mascota "Pelusa"
    And el usuario introduce la Hora "12:45"
    And el usuario introduce la Fecha '2024/04/25'
    And el usuario presiona el botón "Agendar Cita"
    Then el usuario de la agenda debería ver un mensaje "Tu cita ha sido agendada correctamente."
