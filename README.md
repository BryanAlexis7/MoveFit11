# MoveFit

## Descripción del Proyecto
MoveFit es una aplicación desarrollada en Android Studio que permite a los usuarios registrarse, iniciar sesión y gestionar su información personal. Esta app está diseñada para el registro y seguimiento de usuarios en el ámbito de actividades físicas (futura funcionalidad) y actualmente permite realizar operaciones CRUD (crear, leer, actualizar y borrar) sobre la información de usuario.

## Funcionalidades Implementadas
1. **Registro y Login de Usuario:**
    - Permite que los usuarios se registren e inicien sesión de manera segura en la aplicación.

2. **Operaciones CRUD:**
    - **Crear** un nuevo usuario con sus datos personales.
    - **Leer** la información de usuario almacenada.
    - **Actualizar** la información de un usuario existente.
    - **Borrar** usuarios de la base de datos.

3. **Integración de Base de Datos (Room):**
    - La estructura de la base de datos está implementada con Room para gestionar de manera eficiente los datos de usuario.

4. **Interfaz de Usuario (UI):**
    - Diseño de pantallas de registro, login y gestión de usuarios, proporcionando una experiencia intuitiva y fluida para el usuario.

## Cómo Ejecutar la Aplicación
Para ejecutar MoveFit en tu entorno de desarrollo, sigue los pasos a continuación:

### Prerrequisitos
- **Android Studio**: Descarga e instala [Android Studio](https://developer.android.com/studio) en tu computadora.
- **Emulador o dispositivo Android**: Configura un emulador en Android Studio o conecta un dispositivo físico en modo desarrollador.

### Pasos de Ejecución
1. **Clona el repositorio**:
    - Abre una terminal y clona el proyecto desde GitHub:
      ```bash
      git clone https://github.com/tu_usuario/movefit.git
      ```
    - Alternativamente, puedes descargar el archivo `.zip` del proyecto desde GitHub y descomprimirlo.

2. **Importa el proyecto en Android Studio**:
    - Abre Android Studio.
    - Selecciona **File > Open** y elige la carpeta donde descargaste/clonaste MoveFit.

3. **Configura el proyecto**:
    - Verifica que las dependencias estén correctamente instaladas. Android Studio debería sincronizar automáticamente el archivo `build.gradle` cuando abras el proyecto.

4. **Ejecuta la aplicación**:
    - Haz clic en el botón **Run** (ícono de un triángulo verde) en Android Studio.
    - Selecciona un dispositivo/emulador y la aplicación se instalará y ejecutará en él.

5. **Prueba las funcionalidades**:
    - Realiza pruebas de registro, login y operaciones CRUD para asegurarte de que la app funcione según lo esperado.

## Tecnologías Utilizadas
- **Kotlin**: Lenguaje de programación principal para el desarrollo de la app.
- **Room**: Librería de persistencia de datos utilizada para gestionar la base de datos local.
- **SQLite**: Motor de base de datos utilizado a través de Room.
- **Android Jetpack**: Conjunto de componentes para facilitar el desarrollo en Android.

## Repositorio del Proyecto
Puedes acceder al código fuente y la documentación en el siguiente enlace:
- [GitHub - MoveFit](https://github.com/BryanAlexis7/MoveFit11.git)

---
