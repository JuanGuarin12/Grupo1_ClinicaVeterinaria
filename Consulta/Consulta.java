import java.time.LocalDate;

public class Consulta { 
    
    private String motivo;
    private String diagnostico;
    private String tratamiento;
    private LocalDate Fecha;

    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public String getDiagnostico() {
        return diagnostico;
    }
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    public String getTratamiento() {
        return tratamiento;
    }
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }
    public LocalDate getFecha() {
        return Fecha;
    }
    public void setFecha(LocalDate fecha) {
        Fecha = fecha;
    }

    public Consulta(String motivo, String diagnostico, String tratamiento, LocalDate fecha) {
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.Fecha = fecha;
    }
}
