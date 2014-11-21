package Modelo;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*
 * Esta clase es la encargada de marcar los patrones y restricciones que tendra
 * el juego.
 */
public class Euromillones_Modelo {

	private static final String[] numeros=new String[5];//array que guardará los numeros escogidos por el usuario.
	private static final String[] estrellas=new String[2];//array que guardará las estrellas escogidos por el usuario.
	private static final Set <String> numpremiado=new TreeSet<String>();//lista que guardará los numeros ganadores del sorteo.
	private static final Set <String> estrellapremiado=new TreeSet<String>();//lista que guardará las estrellas ganadoras del sorteo
	private static byte contN;//contador para numeros
	private static byte contE;//contador para estrellas
	private static byte aciertos;//variable donde se obtendrá el número de aciertos
	private static double premio;//dinero obtenido tras el sorteo
	
	public Euromillones_Modelo() {
		this.contN=0;
		this.contE=0;
		this.aciertos=0;
	}
	/*
	 * metodos que retornan los diferentes atributos del modelo
	 */
	public String getNumeros() {return numeros[0]+","+numeros[1]+","+numeros[2]+","+numeros[3]+","+numeros[4];}
	public String getEstrellas() {return estrellas[0]+","+estrellas[1];}
	public static byte getContN() {return contN;}
	public static byte getContE() {return contE;}
	public static String getAciertos(){return "Aciertos: "+aciertos;}	
	public static String getNumerosPeemiados(){
		
		Iterator it=numpremiado.iterator();
		String aux="Numeos Premiados:";
		while(it.hasNext()){
			if(aux.equalsIgnoreCase("Numeos Premiados:")){
				aux=aux+" "+it.next();
			}else{
				aux=aux+","+it.next();
			}
		}
		
		return aux;
	}
	public static String getEstrellasPremiadas(){
		
		Iterator it=estrellapremiado.iterator();
		String aux="Estrellas Premiadas:";
		while(it.hasNext()){
			if(aux.equalsIgnoreCase("Estrellas Premiadas:")){
				aux=aux+" "+it.next();
			}else{
				aux=aux+","+it.next();
			}
		}
		
		return aux;
	}
	public static double getPremio(){
		switch(aciertos){
		case 0:
			premio=0;
			break;
		case 1:
			premio=2;
			break;
		case 2:
			premio=8;
			break;
		case 3:
			premio=20;
			break;
		case 4:
			premio=1000;
			break;
		case 5:
			premio=1000000;
			break;
		case 6:
			premio=8000000;
			break;
		case 7:
			premio=15000000;
			break;
		}
		return premio;
	}
	
	/*
	 * este metodo es el encargado de añadir a la lista de numeros seleccionados el
	 * numero que hemos marcado en la interfaz.
	 * Si el contN es superior a 4 devolverá false ya que no es posible jugar con
	 * mas de 5 numeros
	 */
	public static boolean addnumero(String numero){
		if(contN<5){
			
			if(numeros[contN]==null){
				
				numeros[contN]=numero;

			}else{
				byte aux=-1;
				do{
					aux++;
				}while(numeros[aux]!="");
				numeros[aux]=numero;
			}

			contN++;
		
		return true;
		}
		return false;
		
	}
	/*
	 * este metodo es el encargado de añadir a la lista de estrellas seleccionados el
	 * numero que hemos marcado en la interfaz.
	 * Si el contE es superior a 1 devolverá false ya que no es posible jugar con
	 * mas de 2 estrellas
	 */
	public static boolean addestrella(String estrella){
		if(contE<estrellas.length){
			
			if(estrellas[contE]==null){
				estrellas[contE]=estrella;
			}else{
				byte aux=-1;
				do{
					aux++;
				}while(estrellas[aux]!="");
				estrellas[aux]=estrella;
			}
			
			contE++;
			
			return true;
			}
			return false;
	}
	/*
	 * este metodo es el encargado de borrar de la lista de numeros seleccionados el
	 * numero que hemos desseleccionado en la interfaz.
	 */
	public static boolean removeNumero(String numero){
		
		for(int i=0; i<5; i++){
			
			if(numeros[i].equalsIgnoreCase(numero)){

				numeros[i]="";
				contN--;
				return true;
			}
		}
		return false;
		
	}
	/*
	 * este metodo es el encargado de borrar de la lista de estrellas seleccionados el
	 * numero que hemos desseleccionado en la interfaz.
	 */
	public static boolean removeEstrella(String estrella){
		
		for(int i=0; i<2; i++){
			
			if(estrellas[i].equalsIgnoreCase(estrella)){
				
				estrellas[i]="";
				contE--;
				return true;
			}
		}
		return false;
	}
	/*
	 * metodo que se encargará de simular un sorteo definiendo:
	 * 	5 numeros ganadores 
	 * 	2 estrellas ganadoras
	 */
	public static boolean jugar(){
		
		if(contE==2 && contN==5){
			
			aciertos=0;
			estrellapremiado.removeAll(estrellapremiado);
			numpremiado.removeAll(numpremiado);
			/*
			 * bucle que generará 5 numeros ganadores diferentes del 1 al 50
			 */
			for(int i=0; i<contN; i++){
				if(!numpremiado.add((int)((Math.random()*50)+1)+"")){
					i--;
				}
			}
			/*
			 * bucle que generará 2 estrellas ganadoras diferentes del 1 al 9
			 */
			for(int i=0; i<contE; i++){
				if(!estrellapremiado.add((int)((Math.random()*9)+1)+"")){
					i--;
				}
			}
			/*
			 * bucle que comparará los numeros que hemos seleccionado y los premiados
			 * sumando 1 acierto por cada coincidencia	(numeros)
			 */
			for(int i=0; i<contN; i++){	
				Iterator it=numpremiado.iterator();
				while(it.hasNext()){
					String  b=(String) it.next();
					if(b.equalsIgnoreCase(numeros[i])){
						aciertos++;
					}
				}
			}
			/*
			 * bucle que comparará los numeros que hemos seleccionado y los premiados
			 * sumando 1 acierto por cada coincidencia	(estrellas)
			 */
			for(int i=0; i<contE; i++){	
				Iterator it=estrellapremiado.iterator();
				while(it.hasNext()){
					String  b=(String) it.next();
					if(b.equalsIgnoreCase(estrellas[i])){
						aciertos++;
					}
				}
			}
			return true;
		}else{
			return false;
		}
	}
	/*
	 * metodo para reseterar las propiedades del modelo 
	 */
	public static void reset(){
		contE=0;
		contN=0;
		aciertos=0;
		estrellapremiado.removeAll(estrellapremiado);
		numpremiado.removeAll(numpremiado);
	}

}
