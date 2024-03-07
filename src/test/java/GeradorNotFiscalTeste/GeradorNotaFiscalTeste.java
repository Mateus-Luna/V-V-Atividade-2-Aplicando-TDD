package GeradorNotFiscalTeste;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import GeradordeNotaFiscal.fatura;
import GeradordeNotaFiscal.geradornotafiscal;
import GeradordeNotaFiscal.notaFiscalDao;
import GeradordeNotaFiscal.notafiscal;
import GeradordeNotaFiscal.sap;
import GeradordeNotaFiscal.smtp;

class GeradorNotaFiscalTeste {
	private notaFiscalDao notaFiscalDaoTest;
	private sap sapTest;
	private smtp smtpTest;
	private geradornotafiscal gerador;
	
	@BeforeEach
	void setUp() {
		notaFiscalDaoTest = mock(notaFiscalDao.class);
		sapTest = mock(sap.class);
		smtpTest = mock(smtp.class);
		
		gerador = new geradornotafiscal(notaFiscalDaoTest, sapTest, smtpTest);
	}

	@Test
	void gerarNotadeConsultoria() {
		fatura fatura1 = new fatura("Mateus Medeiros", "Rua Azevêdo 92", "CONSULTORIA", 1000);
		fatura fatura2 = new fatura("Mateus Medeiros", "Rua Azevêdo 92", "CONSULTORIA", 999);

		notafiscal nf1 = gerador.geraNotaFiscal(fatura1);
		notafiscal nf2 = gerador.geraNotaFiscal(fatura2);

		assertEquals(1000, nf1.getValorNota());
		assertEquals(250, nf1.getValorImposto());
		
		assertEquals(999, nf2.getValorNota());
		assertEquals(249.75, nf2.getValorImposto());
	}
	@Test
	void gerarNotadeTreinamento() {
		fatura fatura1 = new fatura("Mateus Medeiros", "Rua Azevêdo 92", "TREINAMENTO", 313);
		fatura fatura2 = new fatura("Matheus Medeiros", "Rua Azevêdo 82", "TREINAMENTO", 3133);

		notafiscal nf1 = gerador.geraNotaFiscal(fatura1);
		notafiscal nf2 = gerador.geraNotaFiscal(fatura2);

		assertEquals(313, nf1.getValorNota());
		assertEquals(46.95, nf1.getValorImposto());
		
		assertEquals(3133, nf2.getValorNota());
		assertEquals(469.95, nf2.getValorImposto());

	}
	
	@Test
	void gerarNotaOutros() {
		fatura fatura1 = new fatura("Mateus Medeiros", "Rua Azevêdo 92", "assistência", 224);
		fatura fatura2 = new fatura("Mateus Medeiros", "Rua Azevêdo 92", "outra coisa :)", 332);

		notafiscal nf1 = gerador.geraNotaFiscal(fatura1);
		notafiscal nf2 = gerador.geraNotaFiscal(fatura2);
		
		assertEquals(224, nf1.getValorNota());
		assertEquals(13.44, nf1.getValorImposto());
		
		assertEquals(332, nf2.getValorNota());
		assertEquals(19.92, nf2.getValorImposto());

	}
	


}
