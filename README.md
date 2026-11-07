# Kata 4: Cliente HTTP con responsabilidades separadas

## Objetivo de la entrega
El objetivo de esta práctica es abandonar el uso directo de `URL.openStream` para construir un cliente HTTP pequeño, explícito y verificable. Se busca consumir un servicio HTTP separando estrictamente la interfaz que pide la operación, el adaptador que realiza la petición, el mapper de la respuesta y la presentación final.

## Cómo compilar y ejecutar
1. Clona este repositorio público.
2. Abre el proyecto en IntelliJ IDEA (o tu IDE de preferencia).
3. Asegúrate de cargar el proyecto como Maven para que se descarguen las dependencias del archivo `pom.xml`.
4. Ejecuta el método `main` ubicado en la clase `Main`.

## Dependencias y versión de JDK
* **JDK:** Java 27 para poder utilizar la API nativa `java.net.http.HttpClient`.
* **Dependencias:** `Gson` (v2.10.1) configurado en el `pom.xml` para parsear las respuestas JSON.

## Estructura de la entrega y clases principales
El diseño del código evita acoplamientos innecesarios y no expone rutas absolutas:
* `Task` (DTO): *Record* de Java que representa el objeto de dominio al que se mapea el JSON.
* `TaskClient` (Puerto de servicio): Interfaz que expresa únicamente lo que necesita la aplicación, sin depender de clases HTTP concretas.
* `HttpTaskAdapter` (Adaptador): Implementación de la interfaz que centraliza la construcción de la petición, delega en el cliente nativo de Java, gestiona los fallos HTTP y usa Gson para el parseo.
* `Main`: Punto de entrada que configura la URL base, inyecta el adaptador en la interfaz y formatea la salida para el usuario.

## Dinámica de repetición deliberada
La kata se ha repetido tres veces con alcance equivalente (ver historial de commits) para ganar soltura técnica, introduciendo variaciones pequeñas en el endpoint y los campos destacados:
1. **Repetición 1:** Consumo del endpoint `/posts/1` mapeando el DTO `Post` (título y cuerpo).
2. **Repetición 2:** Consumo del endpoint `/users/1` mapeando el DTO `User` (nombre y email).
3. **Repetición 3 (Versión Final):** Consumo del endpoint `/todos/1` mapeando el DTO `Task` (título y estado de completado).

## Evidencias de verificación
El cliente se ha probado bajo los siguientes escenarios:
* **Ejecución normal:** Respuesta correcta mostrando los datos mapeados del servicio público `jsonplaceholder.typicode.com`.
* **Servicio no disponible / URL inválida:** Comprobación de que una URL errónea lanza un error de red controlado en el `catch`, sin romper la aplicación abruptamente.
* **Código HTTP de error:** Comprobación de que buscar un identificador inexistente activa la validación del estado HTTP distinto de 200, lanzando una excepción comprensible.

## Vídeo explicativo
https://youtu.be/gE-RciLuxd4
