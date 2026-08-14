public class Animal {
    String nombre;
    String especie;
    String raza;
    int edad;
    double identificacion;
    
    public Animal(String nombre, String raza, String especie, int edad, double identificacion){
        this.nombre= nombre;
        this.especie=especie;
        this.raza=raza;
        this.edad=edad;
        this.identificacion=identificacion;
    }
    public void MostrarInfo(){
    System.out.println("nombre:" + this.nombre);
    System.out.println("especie:" + this.especie);
    System.out.println("raza:" + this.raza);
    System.out.println("edad:" + this.edad + " años");
    System.out.println("identificacion:" + this.identificacion);

    }
}
