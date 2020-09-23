package rsbuttom;

public class Filtrar {
	
	private String nombre, apellido,edad,ano,institucion, acudiente, telefono,correo,licencia,pass ;

	public Filtrar(String nombre,String apellido, String edad, String pass) {
		this(nombre,apellido,edad,"","","","","","Free",pass);
	}
	
	public Filtrar(String nombre, String apellido, String edad, String ano, String institucion, String acudiente,
			String telefono, String correo, String licencia, String pass) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.ano = ano;
		this.institucion = institucion;
		this.acudiente = acudiente;
		this.telefono = telefono;
		this.correo = correo;
		this.licencia = licencia;
		this.pass = pass;
	}//fin constructor

	protected String getNombre() {
		return nombre;
	}

	protected String getApellido() {
		return apellido;
	}

	protected String getEdad() {
		return edad;
	}

	protected String getAno() {
		return ano;
	}

	protected String getInstitucion() {
		return institucion;
	}

	protected String getAcudiente() {
		return acudiente;
	}

	protected String getTelefono() {
		return telefono;
	}

	protected String getCorreo() {
		return correo;
	}

	protected String getLicencia() {
		return licencia;
	}

	protected String getPass() {
		return pass;
	}


	
}
