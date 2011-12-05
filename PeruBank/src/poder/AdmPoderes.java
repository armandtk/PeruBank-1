package poder;

import java.util.ArrayList;
import java.util.List;


public class AdmPoderes {
	
	public List<Poder> poderes;
	
	
	public AdmPoderes(){
		this.poderes=new ArrayList<Poder>();
	}
	
	//Este metodo registra un pode previa validación de datos necesarios y si elpoder ya existe en la lista
	public void registrarPoder(String codigoCorto, String nombrePoder, String tipoProducto) throws PoderException{
		
		validarDatosPoder(codigoCorto, nombrePoder, tipoProducto);
		
		validarDatosDuplicadosPoder(codigoCorto);
		
		Poder poder=new Poder(codigoCorto, nombrePoder, tipoProducto);
		poderes.add(poder);
		System.out.println("EL poder ha sido registado correctamente");
		
	}

	//Este medtodo valida si el poder ya existe y manda una exceocion
	private void validarDatosDuplicadosPoder(String codigoCorto)
			throws PoderException {
		if(poderExiste(codigoCorto)){
			System.out.println("Poder duplicado");
			throw new PoderException("Poder duplicado");
			
		}
	}
	
	
	private boolean poderExiste(String codigoCorto) {
		boolean existe=false;
		for(Poder poder:poderes){
			
			if(poder.getCodigoCorto().equals(codigoCorto))
				existe=true;
		}
		return existe;
	}
	
	//Este metodo valida que se registren los datos necesarios
	private void validarDatosPoder(String codigoCorto, String nombrePoder,
			String tipoProducto) throws PoderException {
		String mensaje="";
		if(codigoCorto.equals(""))
			mensaje+="El codigo corto no puede estar vacio";
		if(nombrePoder.equals(""))
			mensaje+="\nEl nombre del poder no puede estar vacio";
		if(tipoProducto.equals(""))
			mensaje+="\nEl tipo de producto no puede estar vacio";
		
		if(!mensaje.equals("")){
			System.out.println(mensaje);
			throw new PoderException(mensaje);
			
		}
	}
	//Este metodo busca unpoder usando como criterio el codigo corto
	public Poder bucarPoder(String codigoCorto){
		
		for(Poder poder:poderes){
			if(poder.getCodigoCorto().equals(codigoCorto)){
				return poder;
			}
		}
		
		return null;
	}

}
