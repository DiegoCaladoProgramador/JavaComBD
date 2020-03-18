package model;


public class Telefone {
	private int id;
	private int id_telefone;
	private int ddd;
	private String numero;
	private String tipo;
	
	public int getId() {
		return id;
	}
	

	public int getId_telefone() {
		return id_telefone;
	}


	public void setId_telefone(int id_telefone) {
		this.id_telefone = id_telefone;
	}


	public void setId(int id) {
		this.id = id;
	}

	public int getDdd() {
		return ddd;
	}
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String número) {
		this.numero = número;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String toString() {
		return "Telefone [id=" + id + ", id_telefone=" + id_telefone + ", ddd=" + ddd + ", numero=" + numero + ", tipo="
				+ tipo + "]";
	}

	
	
}
