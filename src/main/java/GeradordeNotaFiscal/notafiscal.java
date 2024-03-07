package GeradordeNotaFiscal;

public class notafiscal {
	private String nome;
	private double valorNota;
	private double valorImposto;
	public notafiscal(String nome,double valorNota, double valorImposto) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
		this.valorNota = valorNota;
		this.valorImposto = valorImposto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValorNota() {
		return valorNota;
	}
	public void setValorNota(double valorNota) {
		this.valorNota = valorNota;
	}
	public double getValorImposto() {
		return valorImposto;
	}
	public void setValorImposto(double valorImposto) {
		this.valorImposto = valorImposto;
	}
	
}
