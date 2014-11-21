package Test;
import Controlador.Euromillones_Controlador;
import Modelo.Euromillones_Modelo;
import Vista.Eromillones_Vista;
/*
Ejercicio M03-UF5.4 -04....el super reto! 

Su realización se valorará como trabajo adicional de la UF
Crea una app Java que haga uso del patrón de diseño MVC, que permita simular el juego del Euromillon.
La apuesta del usuario consta de 5 números y 2 estrellas (apuesta sencilla). 
	 Números: 1-50.
	 Estrellas: 1-9.
Para que el usuario introduzca su apuesta puedes usar checkboxes, togglebuttons, buttons, etc.
La GUI dispondrá de dos botones “Jugar” y “Reiniciar”.
El botón “Jugar” estará deshabilitado hasta que el usuario no haya introducido completamente 
su combinación (5 números y 2 estrellas).
Cuando el usuario haya introducido su apuesta completa, podrá pulsar el botón “Jugar”.
La aplicación calculará la combinación ganadora de forma aleatoria y se la mostrará al usuario.
Además la aplicación informará al usuario de sus aciertos:
	número de Números acertados, 
	número de Estrellas acertadas.
En el cálculo de la combinación ganadora, ten en cuenta que los 5 Números deben ser diferentes 
(no pueden repetirse), y que las 2 Estrellas tampoco pueden repetirse.
Permite que la aplicación disponga de un JMenuBar que contenga un JMenuItem denominado “Guardar”.
Cuando el usuario pulse el JMenuItem “Guardar”: 
	se creará un fichero con la combinación ganadora, 
	la combinación seleccionada por el usuario 
	y la fecha actual.
Se le permitirá al usuario seleccionar el nombre del fichero, y dónde quiere guardarlo mediante un JFileChooser.
Utiliza JOptionPane para mostrar mensajes de aviso/error al usuario:
	• Si pulsa “Jugar” y no ha seleccionado la combinación de Números y Estrellas mínimo
	• Si intenta seleccionar más de 5 Números
	• Si intenta seleccionar más de 2 Estrellas
	• Le informe de sus aciertos: número de Números acertados, número de Estrellas acertadas.
 */
public class Test_Eromillones {
	
	public static void main(String[]args){
		
		Euromillones_Modelo m=new Euromillones_Modelo();
		Eromillones_Vista v=new Eromillones_Vista();
		Euromillones_Controlador c=new Euromillones_Controlador(v,m); 
		
	}
}
