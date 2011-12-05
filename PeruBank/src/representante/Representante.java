package representante;

public class Representante {
	private String tipoDocumento;
	private String numeroDocumento;
	private String nombres;
	private String apellidos;
	private String cargoEmpresa;
	private String grupoBastanteo;//(A,B,C,D,entre otras)	
	
	
	public Representante(String tipoDocumento, String numeroDocumento,
			String nombres, String apellidos, String cargoEmpresa,
			String grupoBastanteo) {
		
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.cargoEmpresa = cargoEmpresa;
		this.grupoBastanteo = grupoBastanteo;
	}
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCargoEmpresa() {
		return cargoEmpresa;
	}
	public void setCargoEmpresa(String cargoEmpresa) {
		this.cargoEmpresa = cargoEmpresa;
	}
	public String getGrupoBastanteo() {
		return grupoBastanteo;
	}
	public void setGrupoBastanteo(String grupoBastanteo) {
		this.grupoBastanteo = grupoBastanteo;
	}
	
	
}
