package ProcesadorVentas;

//** @Autora: Ana Milena Lobo Ospina @Anmilo


import java.io.*;
import java.nio.file.*;

public class ProcesadorVentas {
    public static void main(String[] args) {
        String carpeta = "archivos_vendedores"; // carpeta donde están los archivos

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(carpeta), "*.txt")) {
            for (Path archivo : stream) {
                procesarArchivo(archivo.toFile());
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivos: " + e.getMessage());
        }
    }

    public static void procesarArchivo(File archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
			String tipoDoc = "", numDoc = "", tipoName = "";

            int contador = 0;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (contador == 0) {
                    tipoDoc = partes[0];
                    numDoc = partes[1];
                    tipoName = partes[2];
                    System.out.println("Vendedor: " + tipoDoc + " " + numDoc + " " + tipoName);
                } else {
                    if (partes.length >= 2) {
                        String idProducto = partes[0];
						String infProducto = partes[1];
                        String cantidad = partes[2];
						String precio = partes[3];
                        System.out.println("Producto: " + idProducto + " - informacion producto: " + infProducto + " - Cantidad: " + cantidad + " - Valor Unitario: $" + precio);
                    }
                }
                contador++;
            }
            System.out.println("-----");
        } catch (IOException e) {
            System.out.println("Error al procesar archivo " + archivo.getName() + ": " + e.getMessage());
        }
    }
}
