public class Main {

    public static void main(String[] args) {

        Dueño dueño = new Dueño("12345", "Juan"); 

        System.out.println("Nombre: " + dueño.getNombre());
        System.out.println("id: " + dueño.getId());

        Animal Luna=new Animal("LUNA", "PUG", "PERRO", 2);
        Animal Kalala=new Animal("KALALA", "VAQUITA", "GATO", 4);
        Luna.MostrarInfo();
        Kalala.MostrarInfo();

        // Creamos el Dueño pasando los 4 datos requeridos
        Dueño dueño = new Dueño("12345", "Juan", "3001234567", "Calle 100 # 45-20");

        // Probamos los métodos heredados y propios
        System.out.println("Nombre: " + dueño.getNombre());
        System.out.println("ID: " + dueño.getIdentificacion());
        System.out.println("Teléfono: " + dueño.getTelefono());
        System.out.println("Dirección: " + dueño.getDireccion());
        System.out.println("Rol: " + dueño.rolEnClinica());
        System.out.println("Resumen: " + dueño.datosResumen());
    }
}