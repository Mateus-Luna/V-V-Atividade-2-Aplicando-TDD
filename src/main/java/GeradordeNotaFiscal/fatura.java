package GeradordeNotaFiscal;

public class fatura {
	private String nome;
	private String endereco;
	private String servico;
	private double valor;
	public fatura(String nome,String endereco,String servico, double valor) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
		this.endereco = endereco;
		this.servico = servico;
		this.valor = valor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getServico() {
		return servico;
	}
	public void setServico(String servico) {
		this.servico = servico;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	

}
