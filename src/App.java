import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Gimnasio uptcGym = new Gimnasio();
        int opcion = 0;
        while (true) {
            String menu = """
                    1. Añadir nuevo miembro
                    2. Eliminar miembro por id
                    3. Consultar el costo total de la mensualidad de un usuario por su id
                    4. Actualizar la información de membresía de un miembro por id
                    5. Adquirir el servicio de coach para un miembro por su id.
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
                    String mensajeConfirmacion = uptcGym.anhadirCliente(nombre, apellido, cedula, antiguedad, edad,
                            antiguedad, membresia);
                    System.out.println(mensajeConfirmacion);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    System.out.println(uptcGym.mostrarMiembros());
                    break;
                default:
                    break;
            }
        }
    }
}
