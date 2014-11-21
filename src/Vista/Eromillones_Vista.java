package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Controlador.Euromillones_Controlador;

/*
 * Esta es la clase encargada de la visulización de la interfaz gáfica.
 */

public class Eromillones_Vista extends JFrame {
	
	private static JRadioButton[] numeros;
	private static JRadioButton[] estrellas;
	private static JButton btnI;
	private static JButton btnR;
	private static JMenuItem save;
	private static JFileChooser fc;
	
	public Eromillones_Vista(){
		/*
		 * Definimos el contenedor de nuestra frame 
		 * con el layout BoxLayout
		 */
		JPanel contenedor=(JPanel)this.getContentPane();
		BoxLayout l=new BoxLayout(contenedor, BoxLayout.Y_AXIS);
		contenedor.setLayout(l);
		contenedor.setBackground(Color.YELLOW);
		/*
		 * Definimos 2 paneles donde se insertaran los JRadioButton
		 * con el layout GridLayout
		 */
		JPanel panelN=new JPanel(new GridLayout(10,2));
		panelN.setBackground(Color.RED);
		JPanel panelE=new JPanel(new GridLayout(3,3));
		panelE.setBackground(Color.RED);
		/*
		 * Definimos el ultimo panel para los botones del pie de la aplicación.
		 * con Flowlayout
		 */
		FlowLayout flow = new FlowLayout();
		JPanel panelOp=new JPanel(flow);
		/*
		 * Empezamos a insertar secuencialmente los componentes en nuestra frame
		 * añadir titulo encima de los numeros
		 */
		JLabel tituloNumeros=new JLabel("Numeros");
		tituloNumeros.setAlignmentX(CENTER_ALIGNMENT);
		contenedor.add(tituloNumeros);
		/*
		 * añadir los diferentes JRadioButton al panel
		 */
		numeros=new JRadioButton[50];
		for(int i=0; i<50; i++){
			
			numeros[i]=new JRadioButton(i+1+"");
			numeros[i].setSelected(false);
			panelN.add(numeros[i]);
		}
		contenedor.add(panelN);
		/*
		 * añadir titulo encima de las estrellas
		 */
		JLabel tituloEstrellas=new JLabel("Estrellas");
		tituloEstrellas.setAlignmentX(CENTER_ALIGNMENT);
		contenedor.add(tituloEstrellas);
		/*
		 * añadir los diferentes JRadioButton al panel
		 */
		estrellas=new JRadioButton[9];
		for(int i=0; i<9; i++){
			estrellas[i]=new JRadioButton(i+1+"");
			estrellas[i].setSelected(false);
			panelE.add(estrellas[i]);
		}
		panelE.setAlignmentX(RIGHT_ALIGNMENT);
		contenedor.add(panelE);
		/*
		 * añadir los dos botones al final de la aplicación.
		 */
		btnI=new JButton("JUGAR");
		btnR=new JButton("REINICIAR");
		panelOp.add(btnI);
		panelOp.add(btnR);
		panelOp.setMaximumSize(new Dimension(200,20));
		panelOp.setBackground(Color.BLUE);
		contenedor.add(panelOp);
		/*
		 * creación de un JMenuBar para que el usuario pueda guardar el sorteo
		 */
		JMenuBar menuBar=new JMenuBar();
		menuBar.setBackground(Color.BLUE);
		JMenu op=new JMenu("Menu");
		op.setBackground(Color.blue);
		save=new JMenuItem("Guardar");
		op.add(save);
		menuBar.add(op);
		this.setJMenuBar(menuBar);
		/*
		 * creamos un JFileChooser para que al guardar abra un panel donde podremos
		 * escoger donde guardar el sorteo
		 */
		fc=new JFileChooser();
		/*
		 * finalmente hacemos visible la ventana y le damos propiedades
		 */
		this.setTitle("Euromillon");
		this.setVisible(true);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/*
	 * metodos que devuelven los diferentes componentes de la vista
	 * asi el controlador podrá trabajar con ellos
	 */
	public static JRadioButton[] getButtonsNumeros(){return numeros;}
	public static JRadioButton[] getButtonsEstrellas(){return estrellas;}
	public static JButton getbtnR(){return btnR;}
	public static JButton getbtnI(){return btnI;}
	public static JMenuItem getSave() {return save;}
	public static JFileChooser getFc() {return fc;}
	/*
	 * Metodo que pondrá a la escutcha los componentes que interactuan con
	 * el usuario.
	 */
	public static void addListeners(Euromillones_Controlador controlador){
		for(int i=0; i<numeros.length; i++){
			numeros[i].addActionListener((ActionListener) controlador);
		}
		for(int i=0; i<estrellas.length; i++){
			estrellas[i].addActionListener((ActionListener) controlador);
		}
		btnI.addActionListener((ActionListener) controlador);
		btnR.addActionListener((ActionListener) controlador);
		save.addActionListener((ActionListener) controlador);
	}
	/*
	 * metodo que pondra todos los JRadioButton sin seleccionar.
	 */
	public static void restSelect(){
		for(int i=0; i<numeros.length; i++){
			numeros[i].setSelected(false);;
		}
		for(int i=0; i<estrellas.length; i++){
			estrellas[i].setSelected(false);;
		}
	}
	
}
