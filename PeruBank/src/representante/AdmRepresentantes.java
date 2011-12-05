package representante;

import grupo.Grupo;

import java.util.ArrayList;
import java.util.List;


import cliente.Cliente;

public class AdmRepresentantes {
	
    public	List<Representante> representantes;
	
    //En el constructor se usa como parametro un cliente debido a que el cliente puede tener varios representantes
	public AdmRepresentantes(Grupo grupo){			
		representantes=grupo.getRepresentantes();
	}
	
	//Este metodo sirve para ingresar un objeto  representate en la lista previa validacion de datos necesarios y si hay duplicados
	public void registrarRepresentate(String tipoDocumento, String numeroDocumento,
			String nombres, String apellidos, String cargoEmpresa,
			String grupoBastanteo) throws RepresentanteException{
		
		validarDatosRepresentante(tipoDocumento, numeroDocumento, nombres,
				apellidos, cargoEmpresa, grupoBastanteo);
		boolean verificacion=representanteExiste(tipoDocumento, numeroDocumento);
		
		if(verificacion==false){
			Representante repre=new Representante(tipoDocumento, numeroDocumento, nombres, apellidos, cargoEmpresa, grupoBastanteo);			
			representantes.add(repre);
			System.out.println("El representante se registro con exito");
		}else{
			System.out.println("El representante ya existe");
			throw new RepresentanteException("El representante ya existe");
		}
		
		
	}
	
	//Valida si el representante ya existe en la lista
	private boolean representanteExiste(String tipoDocumento,
			String numeroDocumento) {
		boolean existe=false;
		for (Representante representante:representantes) {
			if(representante.getTipoDocumento().equals(tipoDocumento) && representante.getNumeroDocumento().equals(numeroDocumento) ){
				existe=true;
			}
		}
		return existe;
	}

	//Este metodo valida que se ingresen los datos obligatorios
	private void validarDatosRepresentante(String tipoDocumento,
			String numeroDocumento, String nombres, String apellidos,
			String cargoEmpresa, String grupoBastanteo)
			throws RepresentanteException {
		String mensaje="";
		if(tipoDocumento.equals(""))
			mensaje+="El tipo de docuemnto es requerido";
		if(numeroDocumento.equals(""))
			mensaje+="\nEl número es requerido";
		if(nombres.equals(""))
			mensaje+="\nLos nombres no pueden ser vacio";
		if(apellidos.equals(""))
			mensaje+="\nLos apellidos no pueden ser vacio";
		if(cargoEmpresa.equals(""))
			mensaje+="\nIngrese el cargo que ocupa en la empresa";
		if(grupoBastanteo.equals(""))
			mensaje+="\nIngrese el grupo de bastanteo";
		
		if(!mensaje.equals("")){		
			System.out.println(mensaje);
			 throw new RepresentanteException(mensaje);	
			 
		}
	}
	
	
	//Este metodo busca un representante de una empresa por tiepo de documento y numero de documento
	public Representante buscarRepresentante(String tipoDocumento, String numeroDocumento){
		
		
		for(Representante representante:representantes){
			
			if(representante.getTipoDocumento().equals(tipoDocumento) && representante.getNumeroDocumento().equals(numeroDocumento)){
				return representante;
			}
		}
		return null;
		
	}
	public List<Representante> obtieneListaRepresentantes(){
		return representantes;
	}
}
