package co.edu.unbosque.modelo;

import java.io.Serializable;

public class MensajeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4811275981251764559L;
	private int mensaje;
	
	public MensajeDTO() {
		// TODO Auto-generated constructor stub
	}

	public MensajeDTO(int mensaje) {
		super();
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "MensajeDTO [mensaje=" + mensaje + "]";
	}

	public int getMensaje() {
		return mensaje;
	}

	public void setMensaje(int mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
