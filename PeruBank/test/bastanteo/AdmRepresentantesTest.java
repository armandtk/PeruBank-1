package bastanteo;

import static org.junit.Assert.*;
import grupo.AdmGrupo;
import grupo.Grupo;
import grupo.GrupoException;


import org.junit.Before;
import org.junit.Test;

import representante.AdmRepresentantes;
import representante.Representante;
import representante.RepresentanteException;

import cliente.AdmClientes;
import cliente.Cliente;
import cliente.ClienteException;


public class AdmRepresentantesTest {
	
	Cliente cliente;
	Grupo grupo;
	
	
	//Se usa este metodo para preparar el escenario, ya que se registrar representantes por cliente
	@Before
	public void prepararEscenario() throws ClienteException,GrupoException{
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
	}
	
	//Este metodo se usa para probar si el registro se realiza correctamnte y el objeto Representante se encuentra dentro de la lista
	@Test
	public void siIngresoDeRepresentanteSeRealizo() throws RepresentanteException, ClienteException{
		
        
		 String tipoDocumento="DNI";
		 String numeroDocumento="31814527";
		 String nombres="Luis";
		 String apellidos="Zevallos Castro";
		 String cargoEmpresa="JEFE RECURSOS HUMANOS";
		 String grupoBastanteo="A";
		 
		 
		 AdmRepresentantes admiRep=new AdmRepresentantes(grupo);
		 
		 System.out.println("");
		 System.out.println("****Primer Test:Si el registro de representante se realizó Correntamente****");
		 System.out.println("");
		 admiRep.registrarRepresentate(tipoDocumento, numeroDocumento, nombres, apellidos, cargoEmpresa, grupoBastanteo);
		 Representante representante=admiRep.buscarRepresentante(tipoDocumento, numeroDocumento);
		
		 //Verificar que no sea nulo el objeto
		 assertNotNull(representante);
		 
	}
	
	
	/*Este metodo se usa para comprobar que no se registre un representante sin los datos requeridos y en caso que no se ingresen esos datos 
	  muestre un mensaje de error*/		
	@Test(expected=RepresentanteException.class)
	public void deberiaValidarDatosRequeridosRepresentante() throws RepresentanteException{
		 String tipoDocumento="";
		 String numeroDocumento="";
		 String nombres="";
		 String apellidos="";
		 String cargoEmpresa="";
		 String grupoBastanteo="";
		 
		
		 AdmRepresentantes admiRep=new AdmRepresentantes(grupo);
		 System.out.println("");
		 System.out.println("****Segundo Test: Deberia validar que se registren los datos necesarios");
		 System.out.println("");
		 admiRep.registrarRepresentate(tipoDocumento, numeroDocumento, nombres, apellidos, cargoEmpresa, grupoBastanteo);
		
		 
	}
	//Este metodo se usa para validar que no haya dos registros con el mismo representante en una empresa
	@Test(expected=RepresentanteException.class)
	public void noDeberiaRegistrarRepresentanteRepetidoParaUnaEmpresa() throws RepresentanteException{
		
		String tipoDocumento="DNI";
		 String numeroDocumento="31814527";
		 String nombres="Luis";
		 String apellidos="Zevallos Castro";
		 String cargoEmpresa="JEFE RECURSOS HUMANOS";
		 String grupoBastanteo="A";
		 
		
		 AdmRepresentantes admiRep=new AdmRepresentantes(grupo);
		 
		 admiRep.registrarRepresentate(tipoDocumento, numeroDocumento, nombres, apellidos, cargoEmpresa, grupoBastanteo);
		 
		 //Aqui en el segundo registro debe disparar  el error
		 System.out.println("");
		 System.out.println("****Tercer test: No debe registrar Representante Repetido para una misma empresa****");
		 System.out.println("");
		 admiRep.registrarRepresentate(tipoDocumento, numeroDocumento, nombres, apellidos, cargoEmpresa, grupoBastanteo);
	}
	
	
}
