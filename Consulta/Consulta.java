public class Consulta { 
    //Definimos atributos de la clase Consulta
    String sede;
    Double precio;
    int hora;
    
    //Definimos el metodo de la clase Consulta
    void datosConsulta(){
    System.out.println("sede: " + this.sede);
    System.out.println("hora:" + this.hora);
    System.out.println("precio: " + this.precio);
    }

    //Definimos el metodo constructor de la clase Consulta
    public Consulta(String sede, int hora, Double precio){
        this.sede = sede;
        this.precio = precio;
        this.hora = hora;
    }




    }
