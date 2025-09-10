package co.edu.unicauca.report.json;

import co.unicauca.reportes.common.interfaces.*;
import co.unicauca.reportes.common.entities.*;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonReportPlugin implements IReportPlugin {
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public String generateReport(List<Project> projects) {
        if (projects == null || projects.isEmpty()) {
            return generateEmptyReport();
        }

        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n");
        jsonBuilder.append("  \"report\": {\n");
        jsonBuilder.append("    \"title\": \"Reporte de Proyectos Académicos\",\n");
        jsonBuilder.append("    \"format\": \"JSON\",\n");
        jsonBuilder.append("    \"generatedAt\": \"").append(dateFormatter.format(new Date())).append("\",\n");
        jsonBuilder.append("    \"totalProjects\": ").append(projects.size()).append(",\n");
        jsonBuilder.append("    \"projects\": [\n");

        for (int i = 0; i < projects.size(); i++) {
            Project project = projects.get(i);
            jsonBuilder.append(generateProjectJson(project, i == projects.size() - 1));
        }

        jsonBuilder.append("    ]\n");
        jsonBuilder.append("  }\n");
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }

    private String generateProjectJson(Project project, boolean isLast) {
        StringBuilder projectJson = new StringBuilder();
        projectJson.append("      {\n");
        projectJson.append("        \"id\": \"").append(escapeJsonString(project.getId())).append("\",\n");
        projectJson.append("        \"name\": \"").append(escapeJsonString(project.getName())).append("\",\n"); // CORREGIDO: getName()
        projectJson.append("        \"approvalDate\": \"").append(formatDate(project.getApprovalDate())).append("\",\n"); // CORREGIDO: getApprovalDate()
        projectJson.append("        \"students\": ").append(generateStudentsJson(project.getStudents())).append(",\n"); // CORREGIDO: getStudents()
        projectJson.append("        \"professor\": \"").append(escapeJsonString(project.getProfessor())).append("\",\n"); // CORREGIDO: getProfessor()
        projectJson.append("        \"type\": \"").append(escapeJsonString(project.getType())).append("\",\n"); // CORREGIDO: getType()
        projectJson.append("        \"program\": \"").append(project.getProgram()).append("\"\n"); // CORREGIDO: getProgram()
        projectJson.append("      }");
        if (!isLast) {
            projectJson.append(",");
        }
        projectJson.append("\n");
        return projectJson.toString();
    }

    private String generateStudentsJson(List<String> students) {
        if (students == null || students.isEmpty()) {
            return "[]";
        }
        StringBuilder studentsJson = new StringBuilder();
        studentsJson.append("[");
        for (int i = 0; i < students.size(); i++) {
            studentsJson.append("\"").append(escapeJsonString(students.get(i))).append("\"");
            if (i < students.size() - 1) {
                studentsJson.append(", ");
            }
        }
        studentsJson.append("]");
        return studentsJson.toString();
    }

    private String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        return dateFormatter.format(date);
    }

    private String escapeJsonString(String str) {
        if (str == null) return "";
        return str.replace("\\", "\\\\")
                  .replace("\"", "\\\"")
                  .replace("\n", "\\n")
                  .replace("\r", "\\r")
                  .replace("\t", "\\t")
                  .replace("\b", "\\b")
                  .replace("\f", "\\f");
    }

    private String generateEmptyReport() {
        return "{\n" +
               "  \"report\": {\n" +
               "    \"title\": \"Reporte de Proyectos Académicos\",\n" +
               "    \"format\": \"JSON\",\n" +
               "    \"generatedAt\": \"" + dateFormatter.format(new Date()) + "\",\n" +
               "    \"totalProjects\": 0,\n" +
               "    \"message\": \"No hay proyectos disponibles para generar el reporte\",\n" +
               "    \"projects\": []\n" +
               "  }\n" +
               "}";
    }
}