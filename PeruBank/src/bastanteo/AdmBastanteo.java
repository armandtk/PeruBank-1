package bastanteo;

import grupo.Grupo;

import java.util.ArrayList;
import java.util.List;

import poder.Poder;

import cliente.Cliente;

public class AdmBastanteo {
	Cliente cliente;
	List<Bastanteo> listaBastanteo;
	
	public AdmBastanteo(){
		listaBastanteo=new ArrayList<Bastanteo>();
	}
	public AdmBastanteo(Grupo grupo){
		listaBastanteo=grupo.getListaBastanteo();
	}
	public AdmBastanteo(Cliente cliente){
		this.cliente=cliente;
	}
	public void registrarBastanteo(String grupoDes,String tipoIntervencion,
			double importe, String fechaVencimiento,String combinacion) throws BastanteoException{
		
		validarCamposVaciosBastanteo(grupoDes,tipoIntervencion, importe,
				fechaVencimiento,combinacion);
		
		boolean existe=bastanteoExiste(grupoDes,tipoIntervencion, combinacion);
		if(existe==true){
			System.out.println("El bastanteo ya existe");
			throw new BastanteoException("El bastnateo ya existe");
		}
		Bastanteo bastanteo=new Bastanteo( tipoIntervencion, importe, fechaVencimiento, combinacion);
		int validarGrupo=0;
		for(Grupo grupo:cliente.getGrupos()){
			
			if(grupo.getDescripcionGrupo().equals(grupoDes)){
				
				grupo.agregarBastanteo(bastanteo);
				validarGrupo=1;
				
			}
			if(validarGrupo==0){
				System.out.println("El grupo que ingreso no existe, por favor ingrese otro grupo");
			}
		}
		
	}
	
	public void agregarPoderesBastanteo(Poder poder,String grupoDes,String tipoIntervencion,String combinacion) throws BastanteoException{
		validaAgregarPoderes(grupoDes, tipoIntervencion);
		boolean existe=validarSiExistePoder(poder, grupoDes, tipoIntervencion, combinacion);
		System.out.println("Exite "+existe);
		if(existe==true){
			System.out.println("El poder ya existe");
			throw new BastanteoException("El poder ya existe");
		}
		for(Grupo grupo:cliente.getGrupos()){
			for(Bastanteo basta:grupo.getListaBastanteo()){
				if(grupoDes.equals(grupo.getDescripcionGrupo())){
					if(basta.getCombinacion().equals(combinacion) && basta.getTipoIntervencion().equals(tipoIntervencion)){
						basta.getPoderesBastanteo().add(poder);
						
					}
				}
			}
		}
	}
	private boolean validarSiExistePoder(Poder poder, String grupoDes,
			String tipoIntervencion, String combinacion) {
		boolean existe=false;
		
		for(Grupo grupo:cliente.getGrupos()){
			for(Bastanteo basta:grupo.getListaBastanteo()){
				if(grupoDes.equals(grupo.getDescripcionGrupo())){
					if(basta.getCombinacion().equals(combinacion) && basta.getTipoIntervencion().equals(tipoIntervencion)){
						
						for(Poder p:basta.getPoderesBastanteo()){
						
							if(p.getCodigoCorto().equals(poder.getCodigoCorto())){
								
								existe=true;
								
							}
						}
					}
				}
			}
		}
		return existe;
	}
	private void validaAgregarPoderes(String grupoDes, String tipoIntervencion) throws BastanteoException {
		String mensaje="";
		
		if(grupoDes.equals("")){
			mensaje+="Debe de indicar un grupo ";
		}
		if(tipoIntervencion.equals("")) {
			mensaje+="El tipo de intervención no puede estar vacia";
		}
		
	
		if(!mensaje.equals("")){
			System.out.println(mensaje);
			throw new BastanteoException(mensaje);
		}
	}
	
	private boolean bastanteoExiste(String grupoDes,String tipoIntervencion, String combinacion) {
		boolean existe=false;
		for (Grupo grupo:cliente.getGrupos()) {
			for(Bastanteo bast:grupo.getListaBastanteo()){
				if(bast.getCombinacion().equals(combinacion) && bast.getTipoIntervencion().equals(tipoIntervencion) && grupo.getDescripcionGrupo().equals(grupoDes)){
					existe=true;
				}
			}
		}
		return existe;
	}
	private void validarCamposVaciosBastanteo(String grupoDes,
			String tipoIntervencion, double importe, String fechaVencimiento, String combinacion)
			throws BastanteoException {
		String mensaje="";
		
			if(grupoDes.equals("")){
				mensaje+="\nDebe de indicar un grupo ";
			}
			if(tipoIntervencion.equals("")) {
				mensaje+="\nEl tipo de intervención no puede estar vacia";
			}
			if(importe==0){
				mensaje+="\nEl importe no puede ser cero";				
			}
			if(fechaVencimiento.equals("")) {
				mensaje+="\nLa fecha de vencimiento no puede estar vacia";
			}
		
		if(!mensaje.equals("")){
			System.out.println(mensaje);
			throw new BastanteoException(mensaje);
		}
	}
	
	public Cliente obtenerClienteActualizado(){
		return cliente;
	}
}
