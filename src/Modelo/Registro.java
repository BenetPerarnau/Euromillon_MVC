package Modelo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Registro {

	private static Calendar c;
	/*
	 * metodo que escribirá en el final del fichero o creará un fichero nuevo en caso de no existir,
	 * los datos del sorteo y añadiendole un time-stamp con la fecha y la hora
	 */
	public static void escribirFichero(Path ruta, String registro){
		c=new GregorianCalendar();
		BufferedWriter bw=null;
		try {
			bw=Files.newBufferedWriter(ruta, 
					java.nio.file.StandardOpenOption.CREATE,
					java.nio.file.StandardOpenOption.APPEND);
			
			for(int i=0; i<registro.length()/2; i++){
				bw.write("–");
			}		
			bw.newLine();
			bw.write(c.get(Calendar.DAY_OF_MONTH)+"/"+((c.get(Calendar.MONTH))+1)+"/"+c.get(Calendar.YEAR)+"\t"
					+ ""+c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND)+""
					+ "\n"+registro);
			bw.newLine();
			for(int i=0; i<registro.length()/2; i++){
				bw.write("–");
			}		
			bw.newLine();
			
		} catch (IOException e) {
			System.out.println("Error en escribir en el fichero");
		}finally{
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
