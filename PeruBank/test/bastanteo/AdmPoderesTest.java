package bastanteo;

import static org.junit.Assert.*;
import org.junit.Test;

import poder.AdmPoderes;
import poder.Poder;
import poder.PoderException;

public class AdmPoderesTest {
	
	
	//Este metodo es para probar que el objeto Poder creado se encuentra dentro de la lista
	@Test
	public void seCreoCorrectamnteElObjetoPoder() throws PoderException{
		
		String codigoCorto="CHCO";
		String nombrePoder="COBRO DE CHEQUES";
		String tipoProducto="ACTIVO";
		
		AdmPoderes admPoder=new AdmPoderes();
		System.out.println("");
		System.out.println("****Primer Test:Si el registro de poderes se realizó Correntamente****");
		System.out.println("");
		admPoder.registrarPoder(codigoCorto, nombrePoder, tipoProducto);
		
		Poder poder=admPoder.bucarPoder(codigoCorto);
		//Validar si el objeto es nulo
		assertNotNull(poder);
		
	}
	//Este metodo prueba qu eno se ingrsen datos repetidos
	@Test(expected=PoderException.class)
	public void deberiaValidarIngresoDeDatosNecesarios() throws PoderException{
		String codigoCorto="";
		String nombrePoder="";
		String tipoProducto="";
		
		AdmPoderes admPoder=new AdmPoderes();
		System.out.println("");
		 System.out.println("****Segundo Test: Deberia validar que se registren los datos necesarios del poder");
		System.out.println("");
		admPoder.registrarPoder(codigoCorto, nombrePoder, tipoProducto);
	}
	
	//Este  metodo se usa para probar que no se registre dos veces un mismo poder
	@Test(expected=PoderException.class)
	public void noDeberiaRegistrarDosVecesUnPoder() throws PoderException{
		
		String codigoCorto="CHCO";
		String nombrePoder="COBRO DE CHEQUES";
		String tipoProducto="ACTIVO";
		
		AdmPoderes admPoder=new AdmPoderes();
		
		//Primer registro
		admPoder.registrarPoder(codigoCorto, nombrePoder, tipoProducto);
		 //Aqui en el segundo registro debe disparar  el error
		 System.out.println("");
		 System.out.println("****Tercer test: No debe registrar poder repetido****");
		 System.out.println("");
		 admPoder.registrarPoder(codigoCorto, nombrePoder, tipoProducto);
	}

}
