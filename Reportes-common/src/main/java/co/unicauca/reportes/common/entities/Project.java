package co.unicauca.reportes.common.entities;
import java.util.Date;
import java.util.List;
/**
 * Clase que representa un proyecto académico.
 */
public class Project {
    // Attributes
    private String id;
    private String name;
    private Date approvalDate;
    private List<String> students;
    private String professor;
    private String type;
    private enumProgram program;

    // Constructor
    public Project(String id, String name, Date approvalDate, List<String> students, String professor, String type, enumProgram program) {
        this.id = id;
        this.name = name;
        this.approvalDate = approvalDate;
        this.students = students;
        this.professor = professor;
        this.type = type;
        this.program = program;
    }


    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public List<String> getStudents() {
        return students;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public enumProgram getProgram() {
        return program;
    }

    public void setProgram(enumProgram program) {
        this.program = program;
    }
}
