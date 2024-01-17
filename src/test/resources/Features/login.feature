Feature: Iniciar sesión en el sistema

  Scenario: Ingreso de nombre de usuario con datos almacenados en BD
    Given el usuario esta en la pagina de inicio de sesion
    When el usuario introduce "usuario1" en el campo nombreUsuario y "contraseña1" en el campo password
    Then el usuario debería ser redirigido a la página de inicio

  Scenario: Ingreso de nombre de usuario y password con datos erróneos
    Given el usuario esta en la pagina de inicio de sesion
    When el usuario introduce "usuario_invalido" en el campo nombreUsuario y "password_invalido" en el campo password
    Then el usuario debería ver un mensaje "Nombre de usuario o contraseña incorrecto."
