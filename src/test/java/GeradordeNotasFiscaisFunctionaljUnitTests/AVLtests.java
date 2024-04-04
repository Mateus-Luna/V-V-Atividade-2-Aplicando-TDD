package GeradordeNotasFiscaisFunctionaljUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import GeradordeNotaFiscal.fatura;
import GeradordeNotaFiscal.geradornotafiscal;
import GeradordeNotaFiscal.notaFiscalDao;
import GeradordeNotaFiscal.notafiscal;
import GeradordeNotaFiscal.sap;
import GeradordeNotaFiscal.smtp;

class AVLtests {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
    public void testeTipoServicoLimiteInferior() {
        notaFiscalDao nfDaoMock = Mockito.mock(notaFiscalDao.class);
        sap sapMock = Mockito.mock(sap.class);
        smtp smtpMock = Mockito.mock(smtp.class);
        geradornotafiscal gerador = new geradornotafiscal(nfDaoMock, sapMock, smtpMock);

        fatura fatura = new fatura("Cliente", "Rua X", "CONSULTORIA", 100.0);
        notafiscal nf = gerador.geraNotaFiscal(fatura);

        assertEquals(25.0, nf.getValorImposto(), 0.001);
    }
	@Test
    public void testeTipoServicoLimiteSuperior() {
        notaFiscalDao nfDaoMock = Mockito.mock(notaFiscalDao.class);
        sap sapMock = Mockito.mock(sap.class);
        smtp smtpMock = Mockito.mock(smtp.class);
        geradornotafiscal gerador = new geradornotafiscal(nfDaoMock, sapMock, smtpMock);

        fatura fatura = new fatura("Cliente", "Rua Y", "TREINAMENTO", 1000.0);
        notafiscal nf = gerador.geraNotaFiscal(fatura);

        assertEquals(150.0, nf.getValorImposto(), 0.001);
    }
	@Test
    public void testeOutrosServicos() {
        notaFiscalDao nfDaoMock = Mockito.mock(notaFiscalDao.class);
        sap sapMock = Mockito.mock(sap.class);
        smtp smtpMock = Mockito.mock(smtp.class);
        geradornotafiscal gerador = new geradornotafiscal(nfDaoMock, sapMock, smtpMock);
        fatura fatura = new fatura("Cliente", "Rua Y", "sss", 1000.0);
        notafiscal nf = gerador.geraNotaFiscal(fatura);

        assertEquals(60.0, nf.getValorImposto(), 0.001);

    }





}
