package com.myappexample.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author diego.lopes.da.costa
 * Coment: Classe que representa o modelo
 * 
 */
@Entity
@Table(name="tb_user")
@SequenceGenerator(name = "SEQ_USER", sequenceName = "SEQ_USER", initialValue=1, allocationSize=1)
public class User implements Serializable{


	@Id
	@GeneratedValue(generator = "SEQ_USER", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name="nome")
	private String nome;

	@Column(name="endereco")
	private String endereco;

	@Column(name="rendimento")
	private double rendimento;

	@Column(name="risco")
	private String risco;

	@Column(name="tipo")
	private String tipo;
	
	@Column(name="empregado")
	private String empregado;
	
	@Column(name="patrimonio")
	private double patrimonio;
	
	@Column(name="divida")
	private double divida;
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the rendimento
	 */
	public double getRendimento() {
		return rendimento;
	}

	/**
	 * @param rendimento the rendimento to set
	 */
	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}

	/**
	 * @return the risco
	 */
	public String getRisco() {
		return risco;
	}

	/**
	 * @param risco the risco to set
	 */
	public void setRisco(String risco) {
		this.risco = risco;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the empregado
	 */
	public String getEmpregado() {
		return empregado;
	}

	/**
	 * @param empregado the empregado to set
	 */
	public void setEmpregado(String empregado) {
		this.empregado = empregado;
	}

	/**
	 * @return the patrimonio
	 */
	public double getPatrimonio() {
		return patrimonio;
	}

	/**
	 * @param patrimonio the patrimonio to set
	 */
	public void setPatrimonio(double patrimonio) {
		this.patrimonio = patrimonio;
	}

	/**
	 * @return the dividas
	 */
	public double getDivida() {
		return divida;
	}

	/**
	 * @param dividas the dividas to set
	 */
	public void setDivida(double divida) {
		this.divida = divida;
	}

	
	/**
	 * @param id
	 * @param nome
	 * @param endereco
	 * @param rendimento
	 * @param risco
	 * @param tipo
	 * @param empregado
	 * @param patrimonio
	 * @param divida
	 */
	public User(String nome, String endereco, double rendimento, String risco, String tipo, String empregado,
			double patrimonio, double divida) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.rendimento = rendimento;
		this.risco = risco;
		this.tipo = tipo;
		this.empregado = empregado;
		this.patrimonio = patrimonio;
		this.divida = divida;
	}
	
	public User() {
	
	}
	
	
	
}
