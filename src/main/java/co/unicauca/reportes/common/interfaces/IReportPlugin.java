package co.unicauca.reportes.common.interfaces;
import co.unicauca.reportes.common.entities.Project;
import java.util.List;
public interface IReportPlugin {

    /**
     * Genera un reporte en formato específico a partir de una lista de proyectos.
     *
     * @param projects Lista de proyectos a incluir en el reporte.
     * @return Reporte generado en formato específico (por ejemplo, JSON, XML, CSV).
     */
    String generateReport(List<Project> projects);
}
