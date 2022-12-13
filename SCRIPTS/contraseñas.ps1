#Establecer política de contraseñas con comandos NET

#Bloqueo de cuentas 
#Se configura para que se bloquee si se falla al intento 3.
net accounts /lockoutthreshold:3
#Duración del bloqueo 60 minutos
net accounts /lockoutduration:120
#Ventana de bloqueo (tiempo en minutos antes de que se restablezca el contador de intentos fallidos de contraseña )
net accounts /lockoutwindow:60

#Establecer los dias máximos para cambiar el password.
net accounts /maxpwage:14
#Establecer los dias mínimos para cambiar el password.
net accounts /minpwage:5
#Establecer la longitud mínima del password.
net accounts /minpwlen:8
#Establecer la cantidad de contraseñas a guardar
net accounts /uniquepw:5
#Exportar la politica de contraseñas para poder activar la complejidad de caracteres (ya que esta no se puede configurar mediante un comando comun)
secedit.exe /export /cfg C:\secconfig.cfg
#Editar el archivo de politica de contraseñas
notepad C:\secconfig.cfg
pause
#Importar el archivo de politica de contraseñas 
secedit.exe /configure /db C:\Windows\securitynew.sdb /cfg C:\secconfig.cfg /areas SECURITYPOLICY

#Para consultar la configuración de los parámetros establecidos
net accounts 
