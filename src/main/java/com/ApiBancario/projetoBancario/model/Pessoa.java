package com.ApiBancario.projetoBancario.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Client_Information")
public class Pessoa implements Serializable {

	public static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private long id;
	
	@Column(name = "Name_Owner", length = 50, nullable = false, unique = true)
	private String nome;
	
	@Column(name = "Agency_Code", nullable = false, length = 4)
	private String codAgencia;
	
	@Column(name = "Number_Account", nullable = false, length = 8)
	private String numConta;
	
	@Column(name = "Digit_Verification", nullable = false, length = 3)
	private String digitoVerificador;
	
	@Column(name = "Register_Id", length = 20, nullable = false, unique = true)
	private String registroID;
	
	
	
	public Pessoa(long id, String nome, String cod_agencia, String num_conta, String digito_verificador, String registro_ID, String codAgencia, String numConta, String digitoVerificador, String registroID) {
		super();
		this.id = id;
		this.nome = nome;
		this.codAgencia = codAgencia;
		this.numConta = numConta;
		this.digitoVerificador = digitoVerificador;
		this.registroID = registroID;
	}

	public Pessoa() {
	}
	
	public Long getId() {
		return id;
	}
	
	public void SetId(Long id) {
		return;
	}
	
	public String getNome() {
	return nome;
	}
	
	public void SetNome (String nome) {
		this.nome = nome;
	}
	
	public String getCodAgencia() {
		return codAgencia;
	}
	
	public void SetCodAgencia(String codAgencia) {
		this.codAgencia = codAgencia;
	}
	
	public String getNumConta() {
		return numConta;
	}
	
	public void SetNumConta(String numConta) {
		this.numConta = numConta;
	}
	
	public String getDigitoVerificador() {
		return digitoVerificador;
	}
		
	public void SetDigitoVerificador(String digitoVerificador) {
		this.digitoVerificador = digitoVerificador;
	}
			
	public String getRegistroID() {
		return registroID;
	}
				
	public void SetRegistroID(String registroID) {
		this.registroID = registroID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return id == other.id;
	}
	
	
}
