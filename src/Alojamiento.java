import java.io.*;
import java.util.ArrayList;


public class Alojamiento {
    private int idAlojamiento;
    private double precio;
    private int capacidad;
    private String ciudad;
    private String direccion;
    private Boolean estado;
    private String imagen;
    private int calificacion;


    public Alojamiento(int idAlojamiento, double precio, int capacidad, String ciudad, String direccion, String imagen) {
        this.idAlojamiento = idAlojamiento;
        this.precio = precio;
        this.capacidad = capacidad;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.estado = true;
        this.imagen = imagen;
        this.calificacion = 0;
    }
    public void reservar() {
        this.estado = false;
    }

    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Alojamiento{" +
                "idAlojamiento=" + idAlojamiento +
                ", precio=" + precio +
                ", capacidad=" + capacidad +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", estado=" + estado +
                ", imagen='" + imagen + '\'' +
                ", calificacion=" + calificacion +
                '}';
    }
}
