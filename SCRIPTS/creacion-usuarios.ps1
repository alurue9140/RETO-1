# Menu para crear y borrar todos los usuarios y grupos
function creartodo
{

    $file_groups=Import-Csv -Path C:\Users\irueda\Desktop\SCRIPTS\CONTRASEÑAS\grupos.csv 
    foreach ($group in $file_groups) { 
        New-LocalGroup -Name $group.nombre -Description $group.Descripcion
    }

    $file_users=Import-Csv -Path C:\Users\irueda\Desktop\SCRIPTS\CONTRASEÑAS\usuarios.csv 
    foreach ($user in $file_users) { 
        $clave=ConvertTo-SecureString $user.password -AsPlainText -Force
        New-LocalUser -Name $user.cuenta -Description $user.descripcion -Password $clave -FullName $user.nombre
        net user $user.cuenta /logonpasswordchg:yes
        #Añadimos la cuenta de usuario en el grupo de Usuarios del sistema
        Add-LocalGroupMember -Group $user.grupo -Member $user.cuenta
        Add-LocalGroupMember -Group $user.grupo2 -Member $user.cuenta

    }

    return
}
function borrartodo
{

    $usuarios=Import-Csv -Path C:\Users\irueda\Desktop\SCRIPTS\CONTRASEÑAS\usuarios.csv
    foreach  ($user in $usuarios)
    {
	    Remove-LocalUser $user.cuenta
    }

    $grupos=Import-Csv -Path C:\Users\irueda\Desktop\SCRIPTS\CONTRASEÑAS\grupos.csv
    foreach  ($grupo in $grupos)
    {
	    Remove-LocalGroup $grupo.nombre
    }

}

function mostrarMenu 
{ 
     param ( 
           [string]$Titulo = 'Selección de opciones' 
     ) 
     Clear-Host 
     Write-Host "================ $Titulo================" 
      
     
     Write-Host "1. Creacion usuarios y grupos" 
     Write-Host "2. Borrar usuarios y grupos" 
     Write-Host "s. Presiona 's' para salir" 
}

do 
{ 
     mostrarMenu 
     $input = Read-Host "Elegir una Opción" 
     switch ($input) 
     { 
           '1' {
                creartodo
                return
           } '2' {
                borrartodo
                return   
           } 's' {
                'Saliendo del script...'
                return 
           }  
     } 
     pause 
} 
until ($input -eq 's')
