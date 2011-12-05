package bastanteo;

import grupo.AdmGrupo;
import grupo.Grupo;
import grupo.GrupoException;

import org.junit.Before;
import org.junit.Test;

import poder.AdmPoderes;
import poder.Poder;
import poder.PoderException;

import representante.RepresentanteException;

import cliente.AdmClientes;
import cliente.Cliente;
import cliente.ClienteException;

public class AdmBastanteoTest {
	Cliente cliente;
	Grupo grupo;
@Before
public void prepararEscenario() throws ClienteException, GrupoException{
		String ruc = "20565455656";
		String codigo = "CL001";
		String razonSocial = "ACME Solutions";
		String fechaInicio = "01/01/2010";
		String tipoEmpresa = "SAC";
		int empleados = 10;
    
	
    
		AdmClientes adm=new AdmClientes();
    
		adm.registrarCliente(codigo, ruc, razonSocial, fechaInicio, tipoEmpresa, empleados);      
		cliente=adm.buscarCliente(codigo);
    
		String descripcionGrupo="A";
		AdmGrupo admGru=new AdmGrupo(cliente);
		admGru.registrarGrupo(descripcionGrupo);
		grupo=admGru.buscarGrupo(descripcionGrupo);
		cliente.agregarGrupo(grupo);
		//System.out.println(cliente.getGrupos().get(0).getDescripcionGrupo());
		
	}
	@Test(expected=BastanteoException.class)
	public void deberiaValidarDatosRequeridos()throws BastanteoException{
		String grupoDes="";
		String tipoIntervencion="";
		double importe=0;
		String fechaVencimiento="";
		String combinacion="";
		AdmBastanteo admBast=new AdmBastanteo(cliente);
		
		admBast.registrarBastanteo(grupoDes, tipoIntervencion, importe, fechaVencimiento, combinacion);
		
	}
	@Test(expected=BastanteoException.class)
	public void noDeberiaRegistrarRepetidosBastanteo()throws BastanteoException{
		String grupoDes="A";
		String tipoIntervencion="A sola firma";
		double importe=12354;
		String fechaVencimiento="12/05/2012";
		String combinacion="B";
		AdmBastanteo admBast=new AdmBastanteo(cliente);
		
		admBast.registrarBastanteo(grupoDes, tipoIntervencion, importe, fechaVencimiento, combinacion);
		
		admBast.registrarBastanteo(grupoDes, tipoIntervencion, importe, fechaVencimiento, combinacion);
		
	}
	@Test(expected=BastanteoException.class)
	public void noDeberiaRegistrarRepetidosPoderesEnBastanteo()throws BastanteoException, PoderException{
		String grupoDes="A";
		String tipoIntervencion="A sola firma";
		double importe=12354;
		String fechaVencimiento="12/05/2012";
		String combinacion="B";
		AdmBastanteo admBast=new AdmBastanteo(cliente);
		AdmPoderes admPoder=new AdmPoderes();
		String codigoCorto="CHCO";
		String nombrePoder="Cobro de cheques"; 
		String tipoProducto="Activo";
		admPoder.registrarPoder(codigoCorto, nombrePoder, tipoProducto);
		Poder poder=admPoder.bucarPoder(codigoCorto);
		admBast.registrarBastanteo(grupoDes, tipoIntervencion, importe, fechaVencimiento, combinacion);
		
		admBast.agregarPoderesBastanteo(poder, grupoDes, tipoIntervencion, combinacion);
		admBast.agregarPoderesBastanteo(poder, grupoDes, tipoIntervencion, combinacion);
		
		
		
	}
}
