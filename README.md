# Microkernel Reportes - Sistema Completo

Sistema de microkernel modular para la generación de reportes académicos. Permite la generación de reportes en múltiples formatos mediante una arquitectura de plugins extensible.

## 📖 Descripción

Este es un sistema completo de microkernel que implementa una arquitectura modular para la generación de reportes académicos. El sistema permite agregar nuevos formatos de reporte mediante plugins sin modificar el código core, siguiendo los principios de arquitectura limpia y extensibilidad.

### Principios de Diseño

- **Modularidad**: Cada componente es independiente y reutilizable
- **Extensibilidad**: Fácil adición de nuevos plugins sin modificar el core
- **Separación de responsabilidades**: Core maneja la lógica, plugins manejan formatos específicos
- **Bajo acoplamiento**: Comunicación a través de interfaces bien definidas

## 🏗️ Arquitectura

```
┌─────────────────┐    ┌──────────────────┐    ┌──────────────────┐
│   report-Core   │────│  report-common   │────│     Plugins      │
│   (Orquestador) │    │  (Interfaces +   │    │ - HTML Plugin    │
│                 │    │   Entidades)     │    │ - JSON Plugin    │
│                 │    │                  │    │ - otros          |
└─────────────────┘    └──────────────────┘    └──────────────────┘
```

## ✨ Características

- 🔌 **Arquitectura de Plugins**: Extensible mediante plugins independientes
- 📊 **Múltiples Formatos**: HTML, JSON y más formatos disponibles
- 🎯 **Core Minimalista**: Núcleo ligero que orquesta los plugins
- 🔄 **Hot-plugging**: Carga dinámica de plugins en tiempo de ejecución
- 📋 **Gestión de Proyectos**: Manejo completo de información académica
- 🛠️ **Fácil Desarrollo**: API simple para crear nuevos plugins

## 🔧 Requisitos

- **Java**: 22 o superior
- **Maven**: 3.6 o superior
- **Git**: Para clonar el repositorio
- **IDE**: IntelliJ IDEA, Eclipse, VSCode (opcional pero recomendado)

## 📦 Instalación y Ejecución

### 1. Clonar el Repositorio

```bash
git clone https://github.com/FaberGG/Microkernel-Reportes.git
cd Microkernel-Reportes
```

### 2. Compilar e Instalar Módulos

```bash
# Instalar módulo común (dependencia base)
cd report-common
mvn clean install
cd ..

# Instalar plugin HTML
cd report-html-plugin
mvn clean install
cd ..

# Instalar plugin JSON
cd report-json-plugin
mvn clean install
cd ..

# Ejecutar el sistema
cd report-Core
mvn exec:java -Dexec.mainClass="co.unicauca.reportes.core.Application"
```

## 🎯 Demostración

Para ejecutar una demostración completa del sistema:

```bash
# Paso 1: Compilar todas las dependencias
cd report-common && mvn clean install && cd ..
cd report-html-plugin && mvn clean install && cd ..
cd report-json-plugin && mvn clean install && cd ..

# Paso 2: Ejecutar la aplicación principal
cd report-Core
mvn exec:java -Dexec.mainClass="co.unicauca.reportes.core.Application"
```

La aplicación mostrará:
- ✅ Carga de plugins disponibles
- 📊 Generación de reportes de ejemplo
- 🎨 Salida en diferentes formatos (HTML, JSON)
- 📋 Listado de proyectos académicos procesados

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.


---

**¿Listo para contribuir?** ¡Clona el repositorio y comienza a desarrollar tu propio plugin! 🚀
