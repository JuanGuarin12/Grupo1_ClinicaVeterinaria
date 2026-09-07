public class Dueño extends Persona {
    private String direccion;

    public Dueño(String identificacion, String nombre, String telefono, String direccion) {
        super(identificacion, nombre, telefono);
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String rolEnClinica() {
        return "Dueño";
    }
}
