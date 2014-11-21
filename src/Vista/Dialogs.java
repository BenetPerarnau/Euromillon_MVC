package Vista;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * Clase en la cual existen dos metodos que mostraran por pantalla grafica
 */

public class Dialogs {

	private static Icon error;
	private static Icon sorteo;
	private final static String a="No te olvides de que puedes guardar el ticket del sorteo.\nMenu/Guardar\nGracias por participar.";
	/*
	 * error en los valores que se quiera empezar a jugar
	 */
	public static void getDialogErrorJugar(Eromillones_Vista vista, String msg){	
		if(error==null){
			error=new ImageIcon("Imagenes/error1.png");
		}	
		JOptionPane .showMessageDialog(vista, msg, "Error", JOptionPane.WARNING_MESSAGE, error);
	}
	/*
	 * resultado del sorteo
	 */
	public static void getDialogResultadoJugar(Eromillones_Vista vista, String msg){
		if(sorteo==null){
			sorteo=new ImageIcon("Imagenes/euro.png");
		}
		JOptionPane.showMessageDialog(vista, msg+a,"Resultado Sorteo",JOptionPane.WARNING_MESSAGE, sorteo);
			
			
	}
	
}
