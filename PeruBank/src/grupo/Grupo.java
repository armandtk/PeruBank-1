package grupo;

import java.util.ArrayList;
import java.util.List;

import bastanteo.Bastanteo;

import representante.Representante;

public class Grupo {
	
	private String descripcionGrupo;
	private List<Representante> representantes=new ArrayList<Representante>();
	private List<Bastanteo> listaBastanteo;
	
	
	public Grupo(String descripcionGrupo) {
		
		this.descripcionGrupo = descripcionGrupo;
		this.representantes=new ArrayList<Representante>();
		this.listaBastanteo=new ArrayList<Bastanteo>();
	}
	
	
	
	public void agregarBastanteo(Bastanteo bastanteo){
		this.listaBastanteo.add(bastanteo);
	}
	
	public List<Bastanteo> getListaBastanteo() {
		return listaBastanteo;
	}



	public void setListaBastanteo(List<Bastanteo> listaBastanteo) {
		this.listaBastanteo = listaBastanteo;
	}



	public void agregarRepresentante(Representante representante){
		this.representantes.add(representante);
	}
	public String getDescripcionGrupo() {
		return descripcionGrupo;
	}

	public void setDescripcionGrupo(String descripcionGrupo) {
		this.descripcionGrupo = descripcionGrupo;
	}

	public List<Representante> getRepresentantes() {
		return representantes;
	}

	public void setRepresentantes(List<Representante> representantes) {
		this.representantes = representantes;
	}
	
	
}
