package co.unicauca.reportes.core;

import co.unicauca.reportes.common.entities.Project;
import co.unicauca.reportes.common.interfaces.IReportPlugin;
import java.util.List;

public class ReportService {
    
    private ReportPluginManager pluginManager;
    
    public ReportService() {
        this.pluginManager = new ReportPluginManager();
    }
    
    public String generateHtmlReport(List<Project> projects) {
        IReportPlugin htmlPlugin = pluginManager.createPlugin("HTML");
        return htmlPlugin.generateReport(projects);
    }
    
    public String generateJsonReport(List<Project> projects) {
        IReportPlugin jsonPlugin = pluginManager.createPlugin("JSON");
        return jsonPlugin.generateReport(projects);
    }
}