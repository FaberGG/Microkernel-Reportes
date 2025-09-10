/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.report.html;

import co.unicauca.reportes.common.interfaces.IReportPlugin;
import co.unicauca.reportes.common.entities.Project;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Lyz
 */
/**
 * Plugin que genera un reporte en formato HTML.
 */
public class ReportHtmlPlugin implements IReportPlugin {
    
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    
    // Constructor vacío obligatorio para que lo instancie la reflexión
    public ReportHtmlPlugin() {}
    
    @Override
    public String generateReport(List<Project> projects) {
        StringBuilder html = new StringBuilder();
        
        // Encabezado básico HTML
        html.append("<!DOCTYPE html>\n");
        html.append("<html lang='es'>\n");
        html.append("<head>\n");
        html.append("  <meta charset='UTF-8'>\n");
        html.append("  <title>Reporte de Proyectos de Grado</title>\n");
        html.append("  <style>\n");
        html.append("    body { font-family: Arial, sans-serif; margin: 20px; }\n");
        html.append("    table { border-collapse: collapse; width: 100%; }\n");
        html.append("    th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }\n");
        html.append("    th { background-color: #f2f2f2; font-weight: bold; }\n");
        html.append("    tr:nth-child(even) { background-color: #f9f9f9; }\n");
        html.append("    h1 { color: #333; }\n");
        html.append("  </style>\n");
        html.append("</head>\n");
        html.append("<body>\n");
        html.append("  <h1>Reporte de Proyectos de Grado</h1>\n");
        
        // Verificar si hay proyectos
        if (projects == null || projects.isEmpty()) {
            html.append("  <p>No hay proyectos disponibles para mostrar.</p>\n");
        } else {
            // Tabla
            html.append("  <table>\n");
            html.append("    <thead>\n");
            html.append("      <tr>\n");
            html.append("        <th>ID</th>\n");
            html.append("        <th>Nombre del Proyecto</th>\n");
            html.append("        <th>Fecha Aprobación Formato A</th>\n");
            html.append("        <th>Estudiantes</th>\n");
            html.append("        <th>Profesor</th>\n");
            html.append("        <th>Tipo</th>\n");
            html.append("        <th>Programa</th>\n");
            html.append("      </tr>\n");
            html.append("    </thead>\n");
            html.append("    <tbody>\n");
            
            // Filas con los proyectos - CORREGIDO: usando los métodos correctos
            for (Project p : projects) {
                html.append("      <tr>\n");
                html.append("        <td>").append(escapeHtml(p.getId())).append("</td>\n");
                html.append("        <td>").append(escapeHtml(p.getName())).append("</td>\n"); // CORREGIDO: getName()
                html.append("        <td>").append(formatDate(p.getApprovalDate())).append("</td>\n"); // CORREGIDO: getApprovalDate()
                html.append("        <td>").append(formatStudents(p.getStudents())).append("</td>\n"); // CORREGIDO: getStudents()
                html.append("        <td>").append(escapeHtml(p.getProfessor())).append("</td>\n"); // CORREGIDO: getProfessor()
                html.append("        <td>").append(escapeHtml(p.getType())).append("</td>\n"); // CORREGIDO: getType()
                html.append("        <td>").append(escapeHtml(String.valueOf(p.getProgram()))).append("</td>\n"); // CORREGIDO: getProgram()
                html.append("      </tr>\n");
            }
            
            html.append("    </tbody>\n");
            html.append("  </table>\n");
            
            // Estadísticas adicionales
            html.append("  <p><strong>Total de proyectos: </strong>").append(projects.size()).append("</p>\n");
        }
        
        // Cierre HTML
        html.append("</body>\n");
        html.append("</html>");
        
        return html.toString();
    }
    
    /**
     * Método auxiliar para formatear la lista de estudiantes como una cadena HTML
     */
    private String formatStudents(List<String> students) {
        if (students == null || students.isEmpty()) {
            return "<em>Sin estudiantes</em>";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < students.size(); i++) {
            result.append(escapeHtml(students.get(i)));
            if (i < students.size() - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }
    
    /**
     * Método auxiliar para formatear fechas
     */
    private String formatDate(Date date) {
        if (date == null) {
            return "<em>Sin fecha</em>";
        }
        return dateFormatter.format(date);
    }
    
    /**
     * Método auxiliar para escapar caracteres HTML
     */
    private String escapeHtml(String str) {
        if (str == null) {
            return "";
        }
        return str.replace("&", "&amp;")
                  .replace("<", "&lt;")
                  .replace(">", "&gt;")
                  .replace("\"", "&quot;")
                  .replace("'", "&#39;");
    }
}