public class Membresia {
    private double precio;
    private String id;
    private String descripcion;
    private boolean derechoSpa;
    private boolean derechoCardio;
    private String categoria;
    public Membresia(double precio, String id, String descripcion, boolean derechoSpa, boolean derechoCardio,
            String categoria) {
        this.precio = precio;
        this.id = id;
        this.descripcion = descripcion;
        this.derechoSpa = derechoSpa;
        this.derechoCardio = derechoCardio;
        this.categoria = categoria;
    }
    public Membresia(){

    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public boolean isDerechoSpa() {
        return derechoSpa;
    }
    public void setDerechoSpa(boolean derechoSpa) {
        this.derechoSpa = derechoSpa;
    }
    public boolean isDerechoCardio() {
        return derechoCardio;
    }
    public void setDerechoCardio(boolean derechoCardio) {
        this.derechoCardio = derechoCardio;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    

    
}
