
public class Cliente {
    private String nombre;
    private String apellido;
    private String cedula;
    private Membresia membresia;
    private int edad;
    private double mensualidad;
    private int antiguedad;
    private Coach coach;

    public Cliente(String nombre, String apellido, String cedula, Membresia membresia, int edad, double mensualidad,
            int antiguedad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.membresia = membresia;
        this.edad = edad;
        this.mensualidad = mensualidad;
        this.antiguedad = antiguedad;
        this.coach = null;
    }

    public Cliente() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getMensualidad() {
        return mensualidad;
    }

    public void setMensualidad(double mensualidad) {
        this.mensualidad = mensualidad;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public String cancelarMembresia() {
        this.membresia = null;

        return "La membresia se ha cancelado";
    }

    public double calcularMensualidad() {
        double costoMensualidad = this.membresia.getPrecio();
        double descuento = 0;
        
        if (this.edad < 18) {
            if (this.membresia.getCategoria().equals("platinum") || this.membresia.getCategoria().equals("bronze")) {
                descuento = 0.30;
            }
        } else if (this.edad > 60) {
            descuento = 0.50;
        } else if (this.edad >= 18 && this.edad <= 60 && this.antiguedad > 15) {
            descuento = 0.15;
        }
        double costoTotal = (costoMensualidad * (1 - descuento));
        if (coach!=null) {
            costoTotal = costoTotal + 200000 + this.coach.getExperiencia() *20000;
        }

        setMensualidad(costoTotal);

        return costoTotal;

    }

}