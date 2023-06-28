import java.time.LocalDate;

public class Reserva {
        private int idalojamiento;
        private String nombreHuesped;
        private LocalDate fechaInicio;
        private LocalDate fechaFin;
        private Pago pago;

        public Reserva(int idalojamiento, String nombreHuesped, LocalDate fechaInicio, LocalDate fechaFin, Pago pago) {
            this.idalojamiento = idalojamiento;
            this.nombreHuesped = nombreHuesped;
            this.fechaInicio = fechaInicio;
            this.fechaFin = fechaFin;
            this.pago=pago;
        }

    public int getIdalojamiento() { return idalojamiento;    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public String getNombreHuesped() { return nombreHuesped; }

        public LocalDate getFechaInicio() {
            return fechaInicio;
        }

        public LocalDate getFechaFin() {
            return fechaFin;
        }


}
