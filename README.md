## TALLER DE DE MODULARIZACIÓN CON VIRTUALIZACIÓN E INTRODUCCIÓN A DOCKER Y A AWS


### Instalando

Según la arquitectura:

![img.png](img/img.png)

Se crean las máquinas virtuales en AWS:

![img_1.png](img/img_1.png)

En una se corre:

```
 java -cp target/classes:target/dependency/* org.example.HelloWorld
```

Y en la otra:

```
 java -cp target/classes:target/dependency/* org.example.OtherService
```

![img_2.png](img/img_2.png)

Se evidencia el acceso a la ruta en cada una:

![img_3.png](img/img_3.png)

![img_4.png](img/img_4.png)


Se evidencia la comunicación entre ambas usando http + SSL = https:

![img_5.png](img/img_5.png)

![img_6.png](img/img_6.png)

### Video
[Enlace Video](https://pruebacorreoescuelaingeduco-my.sharepoint.com/:v:/g/personal/wilson_delgado_mail_escuelaing_edu_co/EVmt1kjDqLZMiDteXk6av3YB6UA05A0Paun37cIWm-WuSA?e=OlcdUw)


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Versioning

*  Se hizo uso de git para el manejo de versionamiento.

## Authors

* **Wilson Alirio Delgado Hernández** 

