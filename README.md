# Java-Gestor-Usuarios
¡Bienvenido/a! Esta aplicación de escritorio desarrollada en **Java Swing** con arquitectura orientada a objetos (Modelo-Controlador) y persistencia de datos mediante **JDBC** conectado a **MySQL**. Permite gestionar la creación, consulta y administración básica de usuarios en tiempo real.

---

## CARACTERISTICAS
* Alta de Usuarios: Validación de campos y registro en la base de datos.
* Visualización Dinámica: Visualización de registros actualizados automáticamente en un componente `JTable`.
* Manejo de Excepciones SQL: Control de errores y mensajes interactivos para el usuario mediante `JOptionPane`.


## DESARROLLO EN

- Lenguaje: Java (JDK 8+).
- GUI: Java Swing.
- Base de Datos: MySQL / MariaDB.
- Conectividad: JDBC.
- IDE: NetBeans IDE.


## INSTALAR APLICACION
1. **CLONAR EL REPOSITORIO:**
   ```bash
      git clone https://github.com/mireyalopezdev/Java-Gestor-Usuarios.git
   ```
2. **IMPORTAR LA BD: **
   ```sql
      CREATE DATABASE IF NOT EXISTS gestor_usuarios;
      USE gestor_usuarios;
      CREATE TABLE IF NOT EXISTS `usuarios` (
        `iduser` int NOT NULL AUTO_INCREMENT,
        `user` varchar(100) NOT NULL,
        `password` varchar(100) NOT NULL,
        `fecha` timestamp NOT NULL,
        PRIMARY KEY (`iduser`)
      ) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
   ```
3. **JBDC**
      Abre tu proyecto en NetBeans y agrega la driver JDBC ( mysql-connector-j-x.x.x.jar).
4. **CONEXIÓN**
      Modifica la conexión en archivo **Conexion.java*.
      Agrega el usuario, contraseña y la url.
5. **EJECUTA**
      Finalmente ya puedes ejecutar la aplicación.
