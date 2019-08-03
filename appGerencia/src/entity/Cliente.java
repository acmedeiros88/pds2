package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@Column(nullable=false)
	private int numTelefone;
	
	@Column(nullable=false)
	private String nomeCliente;
	
	@Column(nullable=true)
	private String estabelecimentoCliente;
	
	@Column(nullable=true)
	private String observacaoCliente;

	public Cliente() {

	}

	public Cliente(int telefone, String nome, String estabelecimento, String obs) {
		this.numTelefone = telefone;
		this.nomeCliente = nome;
		this.estabelecimentoCliente = estabelecimento;
		this.observacaoCliente = obs;
	}

	public int getNumTelefone() {
		return numTelefone;
	}

	public void setNumTelefone(int numTelefone) {
		this.numTelefone = numTelefone;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEstabelecimentoCliente() {
		return estabelecimentoCliente;
	}

	public void setEstabelecimentoCliente(String estabelecimentoCliente) {
		this.estabelecimentoCliente = estabelecimentoCliente;
	}

	public String getObservacaoCliente() {
		return observacaoCliente;
	}

	public void setObservacaoCliente(String observacaoCliente) {
		this.observacaoCliente = observacaoCliente;
	}

	@Override
	public String toString() {
		return "Cliente [numTelefone=" + numTelefone + ", nomeCliente=" + nomeCliente + ", estabelecimentoCliente="
				+ estabelecimentoCliente + ", observacaoCliente=" + observacaoCliente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numTelefone;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (numTelefone != other.numTelefone)
			return false;
		return true;
	}

}
