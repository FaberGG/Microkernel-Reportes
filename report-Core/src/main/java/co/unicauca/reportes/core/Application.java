package co.unicauca.reportes.core;

import co.unicauca.reportes.common.entities.Project;
import java.util.List;

public class Application {
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE REPORTES DE PROYECTOS ===\n");
        
        // Obtener proyectos
        ProjectService projectService = new ProjectService();
        List<Project> projects = projectService.getAll();
        
        // Generar reportes
        ReportService reportService = new ReportService();
        
        // Reporte HTML
        System.out.println("Reporte en formato HTML:");
        String htmlReport = reportService.generateHtmlReport(projects);
        System.out.println(htmlReport);
        
        System.out.println("\n" + "=".repeat(80) + "\n");
        
        // Reporte JSON
        System.out.println("Reporte en formato JSON:");
        String jsonReport = reportService.generateJsonReport(projects);
        System.out.println(jsonReport);
    }
}