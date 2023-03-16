## TALLER DE DE MODULARIZACIÓN CON VIRTUALIZACIÓN E INTRODUCCIÓN A DOCKER Y A AWS


### Instalando

Según la arquitectura:

![img_1.png](img/img_1.png)

Se crean las máquinas virtuales en AWS:

![img.png](img/img.png)


Se accede desde las terminales y se colocan a correr los servicios:
LogService se usa el comando 

```
java -cp target/classes:target/dependency/* org.example.RESTLogService
```

![img_2.png](img/img_2.png)

Se instala y se pone a correr el servicio de mongo:

![img_3.png](img/img_3.png)

Y luego el servicio de RoundRobin con el comando

```
java -cp target/classes:target/dependency/* org.example.SparkWebServer
```

![img_4.png](img/img_4.png)

En este caso, se puede acceder a la dirección http://3.239.164.158:4567/ y se obtiene

![img_5.png](img/img_5.png)

Al enviar el mensaje se puede evidenciar que envía la peticion a una de las máquinas de LogService
implementando de forma efectiva el roundRobin

![img_6.png](img/img_6.png)


![img_7.png](img/img_7.png)

![img_8.png](img/img_8.png)


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Versioning

*  Se hizo uso de git para el manejo de versionamiento.

## Authors

* **Wilson Alirio Delgado Hernández** 

