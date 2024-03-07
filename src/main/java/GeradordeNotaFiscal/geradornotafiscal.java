package GeradordeNotaFiscal;

public class geradornotafiscal {
	private notaFiscalDao nfDao;
	private sap sap;
	private smtp smtp;

	public geradornotafiscal(notaFiscalDao nfDao,sap sap, smtp smtp) {
		// TODO Auto-generated constructor stub
		this.nfDao = nfDao;
		this.sap = sap;
		this.smtp = smtp;
	}
	public notafiscal geraNotaFiscal(fatura fatura) {
		double valorImposto = calculaValorImposto(fatura);
		notafiscal nf = new notafiscal(fatura.getNome(), fatura.getValor(), valorImposto);
		
		nfDao.salva(nf);
		sap.envia(nf);
		smtp.envia(nf);
		
		return nf;
	}
	private double calculaValorImposto(fatura fatura) {
		double valorImposto = 0;
		// TODO Auto-generated method stub
		if(fatura.getServico().equals("CONSULTORIA")) {
			 valorImposto = (fatura.getValor()* 0.25);
		}
		else if(fatura.getServico().equals("TREINAMENTO")) {
			 valorImposto = (fatura.getValor()* 0.15);

		}
		else {
			 valorImposto = (fatura.getValor()* 0.06);
		}
		valorImposto = Math.round(valorImposto * 100.0) / 100.0;
		return valorImposto;
	}

}
