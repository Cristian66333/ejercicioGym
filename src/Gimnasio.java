import java.util.ArrayList;

public class Gimnasio {
    private ArrayList<Cliente> clientes;
    private Membresia gold;
    private Membresia platinum;
    private Membresia bronze;

    public Gimnasio(){
        this.clientes = new ArrayList<Cliente>();
        this.gold = new Membresia(200000, "1", "Membresia full", true, true, "gold");
        this.platinum = new Membresia(120000, "2", "Membresia solo acceso a cardio", false, true, "platinum");
        this.bronze = new Membresia(80000, "3", "Membresia solo muscular", false, false, "bronze");
    }

    public String anhadirCliente(String nombre, String apellido, String cedula,
    int edad, double mensualidad, int antiguedad, int membresia){
        if (membresia == 1) {
            this.clientes.add(new Cliente(nombre, apellido, cedula, this.gold, edad, mensualidad, antiguedad));
        }else if (membresia == 2) {
            this.clientes.add(new Cliente(nombre, apellido, cedula, this.platinum, edad, mensualidad, antiguedad));
        }else if(membresia == 3){
            this.clientes.add(new Cliente(nombre, apellido, cedula, this.bronze, edad, mensualidad, antiguedad));
        }
        return "Cliente agregado exitosamente";

    }

    public String mostrarMiembros(){
        String clientesString = "";
        for (int i = 0; i < clientes.size(); i++) {
            clientesString = clientesString + "Nombre: "+clientes.get(i).getNombre()+
            " Apellido: "+clientes.get(i).getApellido() + " Membresia: "+ clientes.get(i).getMembresia().getCategoria()+"\n";
        }
        return clientesString;
    }

}
