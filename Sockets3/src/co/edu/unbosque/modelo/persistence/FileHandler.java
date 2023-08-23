package co.edu.unbosque.modelo.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class FileHandler {
	
	private static Scanner lector;
	private static File archivo;
	private static ObjectInputStream ois;
	
	public FileHandler() {
		
	}
    
	public static String abrirArchivoDeTexto(String nombre) {
		archivo= new File("src/co/edu/unbosque/modelo/persistence/"+ nombre);
		StringBuilder contenido= new StringBuilder();
		try {
			lector= new Scanner(archivo);
			while(lector.hasNext()) {
				contenido.append(lector.nextLine() + "\n");
				
			}
			lector.close();
		}catch (FileNotFoundException e) {
			System.out.println("Error de lectura: Archivo no encontrado txt");
			e.printStackTrace();
		}catch (IOException e1) {
			System.out.println("Error de lectura: Revise permisos");
		
		}
		return contenido.toString();
	}
}
