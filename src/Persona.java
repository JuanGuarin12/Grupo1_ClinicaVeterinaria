public abstract class Persona implements RolEnClinica {
    private String identificacion;
    private String nombre;
    private String telefono;

    public Persona(String identificacion, String nombre, String telefono) {
        if (identificacion == null || identificacion.isBlank()) {
            throw new IllegalArgumentException("La identificación no puede estar vacía.");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getIdentificacion() { 
        return identificacion; 
    }
    
    public String getNombre() { 
        return nombre; 
    }
    
    public String getTelefono() { 
        return telefono; 
    }

    @Override
    public String datosResumen() {
        return "ID: " + identificacion + " - Nombre: " + nombre + " - Tel: " + telefono;
    }
}
