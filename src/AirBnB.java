import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AirBnB {

    static Scanner sc = new Scanner(System.in);
    private ArrayList<Alojamiento> alojamientos;
    private ArrayList<Reserva> reservas;
    private ArchAlojamientos archivoAlojamientos;
    private ArchCalificaciones archivoCalificaciones;
    private ArchReservas archivoReservas;

    public static void main(String[] args) throws IOException {
        AirBnB menu = new AirBnB();
        menu.mostrarMenu();
    }

    public AirBnB() {
        sc = new Scanner(System.in);
        archivoAlojamientos = new ArchAlojamientos();
        archivoReservas = new ArchReservas();
        alojamientos = archivoAlojamientos.leerAlojamientos();
        reservas=archivoReservas.cargarReservasDesdeArchivo(alojamientos);
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("=== Menú ===");
            System.out.println("1. Huésped");
            System.out.println("2. Anfitrión");
            System.out.println("3. Mostrar Alojamientos disponibles");
            System.out.println("4. Calificar habitación");
            System.out.println("5. Salir");
            System.out.print("Ingrese su opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    menuHuesped();
                    break;
                case 2:
                    menuAnfitrion();
                    break;
                case 3:
                    mostrarAlojamientos();
                    break;
                case 4:
                    calificarAlojamiento();
                    break;
                case 5:
                    archivoAlojamientos.guardarAlojamientos(alojamientos);
                    archivoReservas.guardarReservasEnArchivo(reservas);
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private void mostrarAlojamientos() {
        System.out.println("=== Alojamientos Disponibles ===");
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento.getEstado()) {
                System.out.println(alojamiento);
            }else{
                System.out.println("No hay alojamientos disponibles");
            }
        }
        System.out.println();
    }

    private void menuHuesped() {
        while (true) {
            System.out.println("=== Menú Huésped ===");
            System.out.println("1. Hacer reserva");
            System.out.println("2. Regresar");
            System.out.print("Ingrese su opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    hacerReserva();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private void hacerReserva() {

        System.out.print("Ingrese el número de alojamiento a reservar: ");
        int codigoAlojamiento = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        Alojamiento alojamiento = buscarAlojamiento(codigoAlojamiento);
        if (alojamiento == null) {
            System.out.println("El alojamiento no existe. Intente nuevamente.");
            return;
        }

        if (!alojamiento.getEstado()) {
            System.out.println("El alojamiento seleccionada no está disponible. Intente nuevamente.");
            return;
        }

        System.out.print("Ingrese el nombre del huésped: ");
        String nombreHuesped = sc.nextLine();

        System.out.print("Ingrese la fecha de inicio (YYYY-MM-DD): ");
        String fechaInicioStr = sc.nextLine();
        LocalDate fechaInicio = LocalDate.parse(fechaInicioStr);

        System.out.print("Ingrese la fecha de fin (YYYY-MM-DD): ");
        String fechaFinStr = sc.nextLine();
        LocalDate fechaFin = LocalDate.parse(fechaFinStr);

        System.out.println("Monto total de su pago para la reservacion: ");
        Double monto = sc.nextDouble();

        if (fechaFin.isBefore(fechaInicio)) {
            System.out.println("La fecha de fin no puede ser anterior a la fecha de inicio.");
            return;
        }

        Reserva reserva = new Reserva(codigoAlojamiento, nombreHuesped, fechaInicio, fechaFin,new Pago(monto) );
        reservas.add(reserva);
        archivoReservas.guardarReservasEnArchivo(reservas);
        alojamiento.reservar();
        System.out.println("El pago se a realizado con exito");
        System.out.println("Reserva realizada con éxito.");
        System.out.println();
    }


    private void menuAnfitrion() {
        while (true) {
            System.out.println("=== Menú Anfitrión ===");
            System.out.println("1. Agregar Alojamiento");
            System.out.println("2. Regresar");
            System.out.print("Ingrese su opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    agregarAlojamiento();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private void agregarAlojamiento() {
        System.out.print("Ingrese el Codigo del Alojamiento: ");
        int codigoAlojamiento = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer del scanner

        System.out.print("Ingrese el precio: ");
        double Precio = sc.nextDouble();
        sc.nextLine(); // Limpiar el buffer del scanner

        System.out.print("Ingrese la capacidad del Alojamiento: ");
        int capacidad = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer del scanner

        System.out.print("Ingrese la Cuidad del Alojamiento: ");
        String ciudad = sc.nextLine();
        sc.nextLine(); // Limpiar el buffer del scanner

        System.out.print("Ingrese el direccion del Alojamiento: ");
        String direccion = sc.nextLine();
        sc.nextLine(); // Limpiar el buffer del scanner

        System.out.print("Ingrese una Imagen del Alojamiento: ");
        String imagen = sc.nextLine();
        sc.nextLine(); // Limpiar el buffer del scanner


        Alojamiento alojamiento = new Alojamiento(codigoAlojamiento, Precio,capacidad,ciudad,direccion, imagen);
        alojamientos.add(alojamiento);
        archivoAlojamientos.guardarAlojamientos(alojamientos);
        System.out.println("Habitación agregada con éxito.");
    }

    private void calificarAlojamiento() {
        System.out.print("Ingrese el número de habitación a calificar: ");
        int codigoAlojamiento = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer del scanner

        Alojamiento alojamientoSeleccionado = null;

        for (Alojamiento habitacion : alojamientos) {
            if (habitacion.getIdAlojamiento() == codigoAlojamiento) {
                alojamientoSeleccionado = habitacion;
                break;
            }
        }

        if (alojamientoSeleccionado != null && !alojamientoSeleccionado.getEstado()) {
            System.out.print("Ingrese la calificación (del 1 al 5): ");
            int calificacion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer del scanner

            alojamientoSeleccionado.setCalificacion(calificacion);
            System.out.println("Habitación calificada con éxito.");
        } else {
            System.out.println("Habitación no encontrada o no disponible para calificar.");
        }

    }

    private void cargarCalificaciones() {
        ArrayList<Calificacion> calificaciones = archivoCalificaciones.leerCalificaciones();

        for (Calificacion calificacion : calificaciones) {
            Alojamiento alojamiento = buscarAlojamiento(calificacion.getidAlojamiento());
            if (alojamiento != null) {
                alojamiento.setCalificacion(calificacion.getCalificacion());
            }
        }
    }
    private void guardarCalificaciones() {
        ArrayList<Calificacion> calificaciones = new ArrayList<>();

        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento.getCalificacion() > 0) {
                Calificacion calificacion = new Calificacion(alojamiento.getIdAlojamiento(),
                        alojamiento.getCalificacion());
                calificaciones.add(calificacion);
            }
        }

        archivoCalificaciones.guardarCalificaciones(calificaciones);
    }
    private Alojamiento buscarAlojamiento(int numeroHabitacion) {
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento.getIdAlojamiento() == numeroHabitacion) {
                return alojamiento;
            }
        }
        return null;
    }

}