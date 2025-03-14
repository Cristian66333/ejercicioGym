import java.util.ArrayList;

public class Gimnasio {
    private ArrayList<Cliente> clientes;
    private Membresia gold;
    private Membresia platinum;
    private Membresia bronze;
    private ArrayList<Coach> coaches;

    public Gimnasio(){
        this.clientes = new ArrayList<Cliente>();
        this.gold = new Membresia(200000, "1", "Membresia full", true, true, "gold");
        this.platinum = new Membresia(120000, "2", "Membresia solo acceso a cardio", false, true, "platinum");
        this.bronze = new Membresia(80000, "3", "Membresia solo muscular", false, false, "bronze");
        this.coaches = new ArrayList<Coach>();
        this.coaches.add(new Coach("Juan", "Restrepo", 30, "Licenciado en educacion fisica con maestria en acondicionamiento fisico", 5));
        this.coaches.add(new Coach("Pablo", "Ordoñez", 25, "Fisioterapeuta", 0));
        this.coaches.add(new Coach("Jorge", "Maldonado", 40, "Tecnologo en educacion fisica", 10));
    }

    public String anhadirCliente(String nombre, String apellido, String cedula,
    int edad, double mensualidad, int antiguedad, int membresia){
        for (Cliente clienteAux : clientes) {
            if (clienteAux.getCedula().equals(cedula)) {
                return "La cedula ingresada ya existe";
            }
        }
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

    public String eliminarClientePorCedula(String cedulaE){
        for (int i = 0; i < clientes.size(); i++) {
            if (cedulaE.equals(clientes.get(i).getCedula())) {
                Cliente clienteEliminado = clientes.remove(i);
                return "Cliente "+ clienteEliminado.getNombre() +" ha sido eliminado";
            }
        }
        return "Cliente no encontrado";
    }

    public double calcularMensualidadPorCedula(String cedula){
        for (Cliente clienteAux : clientes) {
            if (clienteAux.getCedula().equals(cedula)) {
                return clienteAux.calcularMensualidad();
            }
        }
        return -1;
    }

    public boolean cambiarMembresiaPorCedula(String cedula, int nuevaMembresia){
        for (Cliente clienteAux : clientes) {
            if (clienteAux.getCedula().equals(cedula)) {
                if (nuevaMembresia == 1) {
                    clienteAux.setMembresia(this.gold);
                    return true;
                }else if (nuevaMembresia == 2) {
                    clienteAux.setMembresia(this.platinum);
                    return true;
                }else if (nuevaMembresia == 3) {
                    clienteAux.setMembresia(this.bronze);
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }

    public String listarCoaches(){
        String listaCoaches = "";
        for (int i = 0; i < coaches.size(); i++) {
            listaCoaches += (i+1)+". "+coaches.get(i).getNombre() + " experiencia "
            + coaches.get(i).getExperiencia()+" años\n";
        }
        return listaCoaches;
    }

    public int adquirirCoach(String cedula, int indiceCoach){
        for (Cliente clienteAux : clientes) {
            if (clienteAux.getCedula().equals(cedula)) {
               clienteAux.setCoach(this.coaches.get(indiceCoach-1));
               return 100;
            }
        }
        return -100;
    }
}
