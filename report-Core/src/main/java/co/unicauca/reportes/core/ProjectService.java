package co.unicauca.reportes.core;

import co.unicauca.reportes.common.entities.Project;
import co.unicauca.reportes.common.entities.enumProgram;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

public class ProjectService {
    
    public List<Project> getAll() {
        List<Project> projects = new ArrayList<>();
        
        // Crear fechas usando Calendar para compatibilidad con Date
        Calendar cal = Calendar.getInstance();
        
        // Fecha para el primer proyecto: 15 de mayo 2025
        cal.set(2025, Calendar.MAY, 15);
        Date fecha1 = cal.getTime();
        
        // Fecha para el segundo proyecto: 20 de junio 2025
        cal.set(2025, Calendar.JUNE, 20);
        Date fecha2 = cal.getTime();
        
        // Fecha para el tercer proyecto: 30 de julio 2025
        cal.set(2025, Calendar.JULY, 30);
        Date fecha3 = cal.getTime();
        
        // Datos de ejemplo según el taller - usando los valores correctos del enum
        projects.add(new Project(
            "101",
            "Sistema de Detección de Plagas con IA",
            fecha1,
            Arrays.asList("Ana Pérez", "Luis Gómez"),
            "Dr. Juan Torres",
            "Investigación",
            enumProgram.INGENIERIA_DE_SISTEMAS
        ));
        
        projects.add(new Project(
            "205",
            "Automatización de Riego por Sensores",
            fecha2,
            Arrays.asList("Sofía Rojas"),
            "Ing. Carlos Méndez",
            "Práctica Profesional",
            enumProgram.INGENIERIA_ELECTRONICA_Y_TELECOMUNICACIONES
        ));
        
        projects.add(new Project(
            "310",
            "Robot de Limpieza Autónomo",
            fecha3,
            Arrays.asList("Jorge Arias", "Diana Castro"),
            "Dr. Laura Vélez",
            "Investigación",
            enumProgram.AUTOMATICA_INDUSTRIAL
        ));
        
        return projects;
    }
}