package bastanteo;

import java.util.ArrayList;
import java.util.List;

import grupo.Grupo;
import poder.Poder;

public class Bastanteo {
	
	private List<Poder> poderesBastanteo;
	private String tipoIntervencion;
	private double importe;
	private String fechaVencimiento;
	private String combinacion;
	
	
	
	public Bastanteo(  String tipoIntervencion,
			double importe, String fechaVencimiento, String combinacion) {
		 
		this.tipoIntervencion = tipoIntervencion;
		this.importe = importe;
		this.fechaVencimiento = fechaVencimiento;
		this.combinacion = combinacion;
		this.poderesBastanteo=new ArrayList<Poder>();
	}

	public String getCombinacion() {
		return combinacion;
	}

	public void setCombinacion(String combinacion) {
		this.combinacion = combinacion;
	}

	public List<Poder> getPoderesBastanteo() {
		return poderesBastanteo;
	}
	public void setPoderesBastanteo(List<Poder> poderesBastanteo) {
		this.poderesBastanteo = poderesBastanteo;
	}
	public String getTipoIntervencion() {
		return tipoIntervencion;
	}
	public void setTipoIntervencion(String tipoIntervencion) {
		this.tipoIntervencion = tipoIntervencion;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	public void agregarPoderBastanteo(Poder poder ){
		this.poderesBastanteo.add(poder);
	}
	
}
