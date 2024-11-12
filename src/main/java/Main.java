import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Mascota> mascotas = new ArrayList<>();

        // Leer mascotas desde el archivo JSON
        ObjectMapper mapper = new ObjectMapper();
        try {
            mascotas = mapper.readValue(new File("mascotas.json"), new TypeReference<List<Mascota>>() {});
            System.out.println("Mascotas cargadas desde JSON.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }

        // Leer mascotas manualmente desde el archivo CSV
        try (BufferedReader br = new BufferedReader(new FileReader("mascotas.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");

                // No es necesario, pero nos aseguramos de que tenemos 3 campos en la linea.
                if (datos.length == 3) {
                    String nombre = datos[0].trim();
                    String especie = datos[1].trim();
                    int edad = Integer.parseInt(datos[2].trim());
                    mascotas.add(new Mascota(nombre, especie, edad));
                }
            }
            System.out.println("Mascotas añadidas manualmente desde CSV.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }

        // Escribir el informe en un archivo de texto
        try (PrintWriter writer = new PrintWriter(new FileWriter("informe_mascotas.txt"))) {
            writer.println("Informe de Mascotas:");
            writer.println("====================");
            for (Mascota mascota : mascotas) {
                writer.println(mascota);
            }
            System.out.println("Informe generado en informe_mascotas.txt.");
        } catch (IOException e) {
            System.err.println("Error al escribir el informe: " + e.getMessage());
        }
    }
}