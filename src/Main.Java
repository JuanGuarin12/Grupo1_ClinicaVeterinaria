public class Main {

    public static void main(String[] args) {

        Dueño dueño = new Dueño("12345", "Juan"); 

        System.out.println("Nombre: " + dueño.getNombre());
        System.out.println("id: " + dueño.getId());

        Animal Luna=new Animal("LUNA", "PUG", "PERRO", 2, 1234);
        Animal Kalala=new Animal("KALALA", "VAQUITA", "GATO", 4, 1245);
        Luna.MostrarInfo();
        Kalala.MostrarInfo();
    }
}