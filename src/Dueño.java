public class Dueño {

    private String id;
    private String nombre;

    public Dueño(String id, String nombre) {

        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("La identificaci+on no puede estar vacía."); 
 }

 if (nombre == null || nombre.isBlank()){
    throw new IllegalArgumentException("El nombre no puede estar vacío.");
 }

        this.id = id;
        this.nombre = nombre; 
    }

    public String getId() {
        return id; 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre; 
    }
}
