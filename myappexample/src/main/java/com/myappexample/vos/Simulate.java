package com.myappexample.vos;

/**
 * @author diego.lopes.da.costa
 * Coment: Classe que representa os daos necessários para realizar uma simulação, sem precisar ser persistida na base
 * 
 */
public class Simulate {

	private double emprestimo;
	private int meses;
	private String risco;

	/**
	 * @return the emprestimo
	 */
	public double getEmprestimo() {
		return emprestimo;
	}
	/**
	 * @param emprestimo the emprestimo to set
	 */
	public void setEmprestimo(double emprestimo) {
		this.emprestimo = emprestimo;
	}
	/**
	 * @return the meses
	 */
	public int getMeses() {
		return meses;
	}
	/**
	 * @param meses the meses to set
	 */
	public void setMeses(int meses) {
		this.meses = meses;
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
	 * @param emprestimo
	 * @param meses
	 * @param risco
	 */
	public Simulate(double emprestimo, int meses, String risco) {
		super();
		this.emprestimo = emprestimo;
		this.meses = meses;
		this.risco = risco;
	}
	
	public Simulate() {
		
	}
	
	
	
}
