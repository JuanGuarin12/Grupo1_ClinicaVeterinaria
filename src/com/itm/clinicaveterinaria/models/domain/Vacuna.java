
import java.time.LocalDate;

public class Vacuna {
        private String nombre;
        private LocalDate fechaAplicacion;
        private LocalDate proximaFecha;

        public Vacuna(String nombre, LocalDate fechaAplicacion, LocalDate proximaFecha) {
                this.nombre = nombre;
                this.fechaAplicacion = fechaAplicacion;
                this.proximaFecha = proximaFecha;
        }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(LocalDate fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public LocalDate getProximaFecha() {
        return proximaFecha;
    }

    public void setProximaFecha(LocalDate proximaFecha) {
        this.proximaFecha = proximaFecha;
    }
        

        


}
