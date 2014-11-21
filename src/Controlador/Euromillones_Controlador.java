package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

import javax.swing.JButton;
import javax.swing.JRadioButton;

import Modelo.Euromillones_Modelo;
import Modelo.Registro;
import Vista.Dialogs;
import Vista.Eromillones_Vista;

public class Euromillones_Controlador implements ActionListener {

	private static Eromillones_Vista vista;
	private static Euromillones_Modelo modelo;
	
	public Euromillones_Controlador(Eromillones_Vista vista,Euromillones_Modelo modelo) {
		this.vista=vista;
		this.modelo=modelo;
		this.vista.addListeners(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*
		 * bucle que recorre los diferentes numeros 
		 * añadirá o eliminará según la selección.
		 * 
		 */
		
		for(JRadioButton numeros:vista.getButtonsNumeros()){	
			if(e.getSource()==numeros){
				if(numeros.isSelected()){
					if(!modelo.addnumero(numeros.getText())){
						
						numeros.setSelected(false);
						Dialogs.getDialogErrorJugar(vista, "No puedes seleccionar mas de 5 numeros.");
					}		
				}else{
					
					modelo.removeNumero(numeros.getText());
					
				}
			}
		}
		
		/*
		 * bucle que recorre los diferentes estrellas 
		 * añadirá o eliminará según la selección.
		 * 
		 */
		
		for(JRadioButton estrellas:vista.getButtonsEstrellas()){
			
			if(e.getSource()==estrellas){
				if(estrellas.isSelected()){	
					if(!modelo.addestrella(estrellas.getText())){
						estrellas.setSelected(false);
						Dialogs.getDialogErrorJugar(vista, "No puedes seleccionar mas de 2 estrellas.");
					}
				}else{
					modelo.removeEstrella(estrellas.getText());
							
				}
			}
		}
		
		if(e.getSource()==vista.getbtnR()){
			/*
			 * boton encargado de reiniciar las selecciones de la interfaz gráfica
			 * y los valores del modelo
			 */
			modelo.reset();
			vista.restSelect();
			
		}else if(e.getSource()==vista.getbtnI()){
			/*
			 * boton que iniciará el sorteo si las selecciones son correctas
			 */
				if(!modelo.jugar()){
				byte auxN=modelo.getContN();
				byte auxE=modelo.getContE();
				String msg="Tienes que seleccionar 5 numeros y 2 Estrellas.\n"
						+ "Has seleccionado:\n"+auxN+" Numeros.\n"+auxE+" Estrellas.";
				
				Dialogs.getDialogErrorJugar(vista, msg);
				}else{
					
					String msg=modelo.getNumerosPeemiados()+"\n"
							+ ""+modelo.getEstrellasPremiadas()+"\n"
							+"Numeros  Jugados: "+modelo.getNumeros()+"\n"
							+"Estrellas Jugadas: "+modelo.getEstrellas()+"\n"
							+ "Aciertos: "+modelo.getAciertos()+"\n"
							+ "Premio: "+modelo.getPremio()+"€\n";
					
					Dialogs.getDialogResultadoJugar(vista, msg);	
				}
		
		}else if(e.getSource()==this.vista.getSave()){
			/*
			 * interacción con el menu/guardar
			 */
			this.vista.getFc().showSaveDialog(vista);//abre una ventana para seleccionar donde guardar y con que nombre
			Path ruta=this.vista.getFc().getSelectedFile().toPath();//obtenemos la ruta seleccionada
			String datos=modelo.getNumerosPeemiados()+" "
					+ modelo.getEstrellasPremiadas()+"\n"
					+"Numeros  Jugados: "+modelo.getNumeros()+" "
					+"Estrellas Jugadas: "+modelo.getEstrellas()+" "
					+modelo.getAciertos();
				
			Registro.escribirFichero(ruta,datos);//le pasamos la info al modelo que escribirá el ticket
		}
	}
}
