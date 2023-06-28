import java.io.*;
import java.util.ArrayList;

public class ArchCalificaciones {
    private static final String archivo_Calificaciones = "calificaciones.txt";

    public ArrayList<Calificacion> leerCalificaciones() {
            ArrayList<Calificacion> calificaciones = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(archivo_Calificaciones))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    String[] datos = linea.split(",");
                    int numeroAlojamiento = Integer.parseInt(datos[0]);
                    int calificacion = Integer.parseInt(datos[1]);
                    calificaciones.add(new Calificacion(numeroAlojamiento, calificacion));
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo de calificaciones: " + e.getMessage());
            }

            return calificaciones;

    }

    public void guardarCalificaciones(ArrayList<Calificacion> calificaciones) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo_Calificaciones))) {
            for (Calificacion calificacion : calificaciones) {
                String linea = calificacion.getidAlojamiento() + "," + calificacion.getCalificacion();
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo de calificaciones: " + e.getMessage());
        }
    }
}
