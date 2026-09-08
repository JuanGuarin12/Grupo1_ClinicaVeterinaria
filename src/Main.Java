public class Main {

    public static void main(String[] args) {

        Dueño dueño = new Dueño("12345", "Juan"); 

        System.out.println("Nombre: " + dueño.getNombre());
        System.out.println("id: " + dueño.getId());

        Animal Luna=new Animal("LUNA", "PUG", "PERRO", 2);
        Animal Kalala=new Animal("KALALA", "VAQUITA", "GATO", 4);
        Luna.MostrarInfo();
        Kalala.MostrarInfo();+
        

        
    }
}