# Microkernel Reportes - Common

Este módulo contiene las entidades y interfaces comunes que son compartidas entre el núcleo del microkernel y todos los plugins de generación de reportes.

## 📋 Tabla de Contenidos

- [Descripción](#descripción)
- [Características](#características)
- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Uso](#uso)
- [Desarrollar Plugins](#desarrollar-plugins)
- [Colaboración](#colaboración)
- [Contribuir](#contribuir)
- [Licencia](#licencia)

## 📖 Descripción

El módulo `Reportes-common` es la base fundamental del sistema de microkernel de reportes académicos. Proporciona las definiciones compartidas que permiten la comunicación entre el núcleo del sistema y los diferentes plugins de generación de reportes.

### Componentes Principales

- **Entidades**: Modelos de datos comunes (Project, enumProgram)
- **Interfaces**: Contratos para la implementación de plugins (IReportPlugin)

## ✨ Características

- ✅ Modelo de datos unificado para proyectos académicos
- ✅ Interface estándar para plugins de reportes
- ✅ Compatible con Java 22
- ✅ Estructura modular y extensible
- ✅ Fácil integración con Maven

## 🔧 Requisitos

- **Java**: 22 o superior
- **Maven**: 3.6 o superior
- **IDE**: IntelliJ IDEA, Eclipse, VSCode, etc.

## 📦 Instalación

### 1. Compilar e Instalar en Repositorio Maven Local

```bash
# Clonar el repositorio y cambiar a la rama common
git clone https://github.com/FaberGG/Microkernel-Reportes.git
cd Microkernel-Reportes
git checkout common

# Compilar e instalar en repositorio local
mvn clean install
```

### 2. Agregar Dependencia a tu Proyecto

Para usar este módulo común en tus proyectos (plugins o core), agrega la siguiente **dependencia** en tu `pom.xml`:

```xml
<dependency>
    <groupId>co.unicauca.reportes</groupId>
    <artifactId>Reportes-common</artifactId>
    <version>0.1.0</version>
</dependency>
```

## 🚀 Uso

### Modelo Project

```java
import co.unicauca.reportes.common.entities.Project;
import java.util.Arrays;
import java.util.Date;

// Crear un nuevo proyecto
Project project = new Project(
    "PRJ-001",
    "Sistema de Gestión Académica",
    new Date(),
    Arrays.asList("Juan Pérez", "María García"),
    "Dr. Carlos López",
    "Trabajo de Grado",
    enumProgram.INGENIERIA_SISTEMAS
);
```

### Interface IReportPlugin

```java
import co.unicauca.reportes.common.interfaces.IReportPlugin;
import co.unicauca.reportes.common.entities.Project;
import java.util.List;

public class MyReportPlugin implements IReportPlugin {
    @Override
    public String generateReport(List<Project> projects) {
        // Implementar lógica de generación de reporte
        return "Reporte generado";
    }
}
```

## 🔌 Desarrollar Plugins

### Pasos para Crear un Plugin

1. **Crear nuevo proyecto Maven**:
```bash
mvn archetype:generate -DgroupId=co.unicauca.reportes.plugins \
                       -DartifactId=mi-plugin-reporte \
                       -DarchetypeArtifactId=maven-archetype-quickstart \
                       -DinteractiveMode=false
```

2. **Configurar pom.xml**:
```xml
<dependencies>
    <dependency>
        <groupId>co.unicauca.reportes</groupId>
        <artifactId>Reportes-common</artifactId>
        <version>0.1.0</version>
    </dependency>
</dependencies>
```

3. **Implementar IReportPlugin**:
```java
package co.unicauca.reportes.plugins;

import co.unicauca.reportes.common.interfaces.IReportPlugin;
import co.unicauca.reportes.common.entities.Project;
import java.util.List;

public class MiReportPlugin implements IReportPlugin {
    @Override
    public String generateReport(List<Project> projects) {
        // Tu lógica personalizada aquí
        StringBuilder report = new StringBuilder();
        for (Project project : projects) {
            report.append("Proyecto: ").append(project.getName()).append("\n");
            // ... más lógica
        }
        return report.toString();
    }
}
```

4. **Compilar y empaquetar**:
```bash
mvn clean install | mvn clean package
```


## 👥 Colaboración

### Configuración Inicial

1. **Fork del repositorio**:
   - Ve a https://github.com/FaberGG/Microkernel-Reportes
   - Haz clic en "Fork"

2. **Clonar tu fork**:
```bash
git clone https://github.com/TU_USUARIO/Microkernel-Reportes.git
cd Microkernel-Reportes
```

3. **Agregar repositorio upstream**:
```bash
git remote add upstream https://github.com/FaberGG/Microkernel-Reportes.git
```

### Flujo de Trabajo

1. **Sincronizar con upstream**:
```bash
git fetch upstream
git checkout common
git merge upstream/common
```

2. **Crear nueva rama para tu feature**:
```bash
git checkout -b feature/mi-nueva-funcionalidad
```

3. **Realizar cambios y commits**:
```bash
# Hacer cambios en el código
git add .
git commit -m "feat: agregar nueva funcionalidad X"
```

4. **Push a tu fork**:
```bash
git push origin feature/mi-nueva-funcionalidad
```

5. **Crear Pull Request**:
   - Ve a tu fork en GitHub
   - Haz clic en "Compare & pull request"
   - Completa la descripción y envía

### Convenciones de Commit

```
feat: nueva funcionalidad
fix: corrección de bug
docs: cambios en documentación
style: formateo, comas faltantes, etc.
refactor: refactoring de código
test: agregar tests
chore: actualizar dependencias, etc.
```


## 🤝 Contribuir

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'feat: Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

### Reportar Issues

Si encuentras un bug o tienes una sugerencia:

1. Verifica que no exista un issue similar
2. Crea un nuevo issue con:
   - Descripción clara del problema
   - Pasos para reproducir
   - Comportamiento esperado vs actual
   - Versión de Java y Maven

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.


**¿Necesitas ayuda?** Revisa la [documentación](https://github.com/FaberGG/Microkernel-Reportes/wiki) o abre un [issue](https://github.com/FaberGG/Microkernel-Reportes/issues).
