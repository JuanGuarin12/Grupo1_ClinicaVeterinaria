public class Veterinario extends Persona {

    private String especialidad;

    public Veterinario(String identificacion, String nombre, String telefono, String especialidad) {
        super(identificacion, nombre, telefono);
        if (especialidad == null || especialidad.isBlank()) {
            throw new IllegalArgumentException("La especialidad no puede estar vacía.");
        }
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String rolEnClinica() {
        return "Veterinario (" + especialidad + ")";
    }
}