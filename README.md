# Laboratorio N°3 - Taller de Bases de Datos

Laboratorio de Taller de Bases de Datos desarrollado por el equipo 6.

## Integrantes
* [Javiera Godoy](https://github.com/JavieraGodoy)
* [Ignacio Lara](https://github.com/kappita)
* [David Martinez](https://github.com/davidmartinez-esc)
* [Claudio Palma](https://github.com/claudiopalma2001)
* [Paloma Zepeda](https://github.com/cukidev)

## Descripción
PóneleVoluntAPP surge como solución a la necesidad de coordinar eficazmente el flujo de voluntarios espontáneos en situaciones de emergencia en Chile. 

Esta plataforma facilita la gestión de esfuerzos voluntarios, emparejando habilidades y disponibilidades con las necesidades específicas de cada emergencia, y permitiendo a los coordinadores organizar y asignar tareas de forma estratégica para una respuesta ágil y efectiva ante desastres naturales.

El repositorio incluye las siguientes carpetas principales:
* [Carpeta Backend](https://github.com/kappita/tbd-3/tree/main/backend): Contiene todo el Backend y las clases de las entidades las cuales se distribuyen en los paquetes: Controllers, Entities, Services y Repositories.
* [Carpeta Frontend](https://github.com/kappita/tbd-3/tree/main/frontend): Contiene todo el Frontend y las vistas utilizadas con Vue.

## Requisitos y Versiones de las Tecnologías.

* [MongoDB Community Edition](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-windows/) versión 6.0.
* [MongoDB Compass](https://www.mongodb.com/try/download/compass) versión 1.34.2.
* [IntelliJ IDEA Ultimate](https://www.jetbrains.com/es-es/idea/download/#section=windows) versión 2024.1, aunque debería funcionar con cualquier versión.
* JDK Versión 17.
* [VUE](https://es.vuejs.org/v2/guide/installation) versión 2.x.
* [Postman](https://www.postman.com/downloads/) versión Postman 10.24.22.

## Instrucciones de Instalación.

1. Clonar el repositorio: Esto proporcionará las tres carpetas principales para el proyecto de Laboratorio. Para clonarlo, se debe usar el siguiente comando en el directorio deseado:
```sh
git clone https://github.com/kappita/tbd-3.git
```

2. Ir al siguiente [link](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-windows/) e instalar MongoDB Community Edition y seguir las instrucciones del instalador.
3. Ir al siguiente [link](https://www.mongodb.com/try/download/compass) e instalar MongoDB Compass y seguir las instrucciones del instalador.

4. Instalar IntelliJ IDEA Ultimate: Ingresar al sitio web oficial de IntelliJ IDEA y seleccionar una opción dependiendo del Sistema Operativo que use:
* Para Windows, utilizar el siguiente [link](https://www.jetbrains.com/idea/download/#section=windows).
* Para Linux, utilizar el siguiente [link](https://www.jetbrains.com/es-es/idea/download/#section=linux).
* Para MacOs, utilizar el siguiente [link](https://www.jetbrains.com/es-es/idea/download/#section=mac).

5. Abrir IntelliJ IDEA Ultimate, abrir un nuevo proyecto y seleccionar la carpeta **Backend**. Debemos esperar unos minutos a que el proyecto se configure y se instalen los plugins necesarios.

6. Configurar las credenciales del aplication.properties del disclaimer del punto 2.
7. Configurar el JDK: Al abrir una clase IntelliJ nos solicitará configurar un JDK. Debemos asegurarnos de seleccionar JDK versión 17. De no tener JDK 17, IntelliJ nos proporciona una opción para instalarlo automáticamente.
- Si no nos aparece esta opción porque ya tenía IntelliJ instalado anteriormente, basta con ir a la navbar. File -> Proyect Structure. En esa sección en el apartado de SDK, se podrá cambiar la versión.
8. Ir al siguiente [link](https://nodejs.org/en/) e instalar la última versión de Node.js, siguiendo las instrucciones de instalación.
9. Abrir una consola / terminal dentro de la carpeta **Frontend** y aplicar el siguiente comando, el cual instalará todas las dependencias necesarias para el proyecto:
```sh
npm install
```
* Si por algún motivo lo anterior falla, se puede utilizar:
```sh
npm install --force
```
10. Ir al siguiente [link](https://www.postman.com/downloads/) e instalar la última versión de Postman.

Una vez finalizado estos nueve pasos, podemos seguir con las instrucciones de uso.


## Instrucciones de uso
1. Utilizando IntelliJ IDEA Ultimate, asegurarse de que se detecte correctamente Spring Boot y Gradle. Ejecutar la aplicación haciendo click en la opción "Run" dentro de IntelliJ IDEA.
2. Dentro de la carpeta Frontend, abrir una consola / terminal. Ejecutar el siguiente comando:
```sh
npm run dev
```
3. Con esto ya tenemos levantado FrontEnd y Backend.
