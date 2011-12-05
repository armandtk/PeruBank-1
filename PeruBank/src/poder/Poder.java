package poder;

public class Poder {
	private String codigoCorto;
	private String nombrePoder;
	private String tipoProducto;
	
	
	
	
	public Poder(String codigoCorto, String nombrePoder, String tipoProducto) {
		
		this.codigoCorto = codigoCorto;
		this.nombrePoder = nombrePoder;
		this.tipoProducto = tipoProducto;
	}
	
	public String getCodigoCorto() {
		return codigoCorto;
	}
	public void setCodigoCorto(String codigoCorto) {
		this.codigoCorto = codigoCorto;
	}
	public String getNombrePoder() {
		return nombrePoder;
	}
	public void setNombrePoder(String nombrePoder) {
		this.nombrePoder = nombrePoder;
	}
	public String getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	
	
}
