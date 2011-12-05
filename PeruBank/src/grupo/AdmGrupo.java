package grupo;

import java.util.ArrayList;
import java.util.List;

import representante.Representante;

import cliente.Cliente;

public class AdmGrupo {
	
	public List<Grupo> grupos;
	
	public AdmGrupo(Cliente cliente){
		grupos=new ArrayList<Grupo>();
		if(cliente.getGrupos()!=null){
			grupos=cliente.getGrupos();
		}
		
	}
	public void registrarGrupo(String descripcionGrupo) throws GrupoException{
		String mensaje="";
		if(descripcionGrupo.equals("")){
			mensaje="La descripcion de grupo no puede estar vacia";
		}
		if(!mensaje.equals("")){
			System.out.println(mensaje);
			throw new GrupoException(mensaje); 
		}
		Grupo grupo=new Grupo(descripcionGrupo);
		grupos.add(grupo);
		System.out.println("El grupo se registró con exito");
		
	}
	
	public Grupo buscarGrupo(String descripcionGrupo){
		for(Grupo grupo:grupos){
			if(grupo.getDescripcionGrupo().equals(descripcionGrupo)){
				return grupo;
			}
		}
		return null;
	}
	public List<Grupo> obtieneListaGrupos(){
		return grupos;
	}
}
