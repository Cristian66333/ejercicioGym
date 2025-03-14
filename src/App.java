import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Gimnasio uptcGym = new Gimnasio();
        int opcion = 0;
        boolean control = true;
        while (control) {
            String menu = """
                    1. Añadir nuevo miembro
                    2. Eliminar miembro por cedula
                    3. Consultar el costo total de la mensualidad de un usuario por su cedula
                    4. Actualizar la información de membresía de un miembro por cedula
                    5. Adquirir el servicio de coach para un miembro por su cedula.
                    6. Mostrar todos los miembros
                    7. salir
                    """;
            System.out.println(menu);
            System.out.print("Ingrese la opción deseada:");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese el apellido");
                    String apellido = sc.nextLine();
                    System.out.println("Ingrese la cedula");
                    String cedula = sc.nextLine();
                    System.out.println("Ingrese el edad");
                    int edad = sc.nextInt();
                    System.out.println("Ingrese el antiguedad");
                    int antiguedad = sc.nextInt();
                    System.out.print("""
                            Que membresia desea adquirir:
                            1. gold
                            2. platinum
                            3. bronce
                            """);
                    int membresia = sc.nextInt();
                    String mensajeConfirmacion = uptcGym.anhadirCliente(nombre, apellido, cedula, edad, 0,
                            antiguedad, membresia);
                    System.out.println(mensajeConfirmacion);
                    break;
                case 2:
                    System.out.println("Ingrese la cedula del usuario a eliminar");
                    String cedulaEliminar = sc.nextLine();
                    String respuestaEliminar = uptcGym.eliminarClientePorCedula(cedulaEliminar);
                    System.out.println(respuestaEliminar);
                    break;
                case 3:
                    System.out.println("Ingrese la cedula del cliente");
                    String cedulaCosto = sc.nextLine();
                    double costoMensual = uptcGym.calcularMensualidadPorCedula(cedulaCosto);
                    if (costoMensual == -1) {
                        System.out.println("Cliente no encontrado");
                        
                    }else{
                        System.out.println("El costo de la mensualidad es: "+costoMensual);
                    }

                    break;
                case 4:
                    System.out.println("Ingrese la cedula del usuario");
                    String cedulaCambiar = sc.nextLine();
                    System.out.println("""
                            Ingrese la membresia que quiere asignar
                            1. gold
                            2. platinum
                            3. bronze
                            """);
                    int membresiaNueva = sc.nextInt();
                    boolean actualizoMembresia = uptcGym.cambiarMembresiaPorCedula(cedulaCambiar, membresiaNueva);
                    if (actualizoMembresia) {
                        System.out.println("Membresia actualizada");
                    }else{
                        System.out.println("No se pudo actualizar");
                    }
                    break;
                case 5:
                        System.out.println("Ingrese la cedula");
                        String cedulaAgregarCoach = sc.nextLine();
                        System.out.println(uptcGym.listarCoaches());
                        int coachSeleccionado = sc.nextInt();
                        int respuestaCoach = uptcGym.adquirirCoach(cedulaAgregarCoach, coachSeleccionado);
                        if (respuestaCoach==100) {
                            System.out.println("El coach fue adquirido");
                        }else if (respuestaCoach ==-100) {
                            System.out.println("Error al adquirir coach");
                        }
                    break;
                case 6:
                    System.out.println(uptcGym.mostrarMiembros());
                    break;
                default:
                        control = false;
                    break;
            }
        }
        sc.close();
    }
}
