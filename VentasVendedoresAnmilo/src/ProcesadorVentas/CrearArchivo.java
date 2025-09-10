package ProcesadorVentas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CrearArchivo {
	public static void main(String[] args) {
		String nombreArchivo = "archivos_vendedores/vendedor1.txt";
		String contenido = "CC;1001\nRef01;2;\nRef02;1;\nRef03;5;";
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))){
			writer.write(contenido);
			System.out.println("Archivo creado exitosamente.");
		} catch (IOException e) {
			System.out.println("Error al crear el archivo: " + e.getMessage());
		}
	}

}
