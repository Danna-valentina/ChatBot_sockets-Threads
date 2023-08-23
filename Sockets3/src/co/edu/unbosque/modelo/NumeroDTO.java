package co.edu.unbosque.modelo;

import java.io.Serializable;

public class NumeroDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6215462561977325652L;
	
	private long valor;
	
	
	public NumeroDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public NumeroDTO(long valor) {
		super();
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "numeroDTO [valor=" + valor + "]";
	}

	public long getValor() {
		return valor;
	}
	public void setValor(long valor) {
		this.valor = valor;
	}

}
