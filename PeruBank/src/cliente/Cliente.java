package cliente;

import grupo.Grupo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import representante.Representante;


public class Cliente implements Serializable{

	private String codigo;
	private String ruc;
	private String razonSocial;
	private String fechaInicio;
	private String tipoEmpresa;
	private int empleados;
	private List<Grupo> grupos;

	public Cliente(String codigo, String ruc, String razonSocial,
			String fechaInicio, String tipoEmpresa, int empleados) {
		super();  //el super siempre va en primer lugar
		this.codigo = codigo;
		this.ruc = ruc;
		this.razonSocial = razonSocial;
		this.fechaInicio = fechaInicio;
		this.tipoEmpresa = tipoEmpresa;
		this.empleados = empleados;
		this.grupos=new ArrayList<Grupo>();
	}
	
	 
	public void agregarGrupo(Grupo grupo){
		this.grupos.add(grupo);
	}
	
	public List<Grupo> getGrupos() {
		return grupos;
	}



	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}



	public String getCodigo() {
		
		return codigo;
	}

	public String getRuc() {
		
		return ruc;
	}

	public String getRazonSocial() {
		
		return razonSocial;
	}

	public String getFechaInicio() {
		
		return fechaInicio;
	}

	public String getTipoEmpresa() {
		
		return tipoEmpresa;
	}

	public int getEmpleados() {

		return empleados;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	public void setEmpleados(int empleados) {
		this.empleados = empleados;
	}

	

}
