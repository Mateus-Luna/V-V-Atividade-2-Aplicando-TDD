package GeradordeNotasFiscaisFunctionaljUnitTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import GeradordeNotaFiscal.fatura;
import GeradordeNotaFiscal.geradornotafiscal;
import GeradordeNotaFiscal.notaFiscalDao;
import GeradordeNotaFiscal.notafiscal;
import GeradordeNotaFiscal.sap;

class PEtests {
	@Mock
    private notaFiscalDao mockNotaFiscalDao;
	@Mock
	private geradornotafiscal geradornotafiscal;
	@Mock
	private sap mockSAP;
	@Mock
	private sap mockSmtp;

    public void testeFaturaPositiva() {
        fatura fatura = new fatura("Cliente", "endereço","CONSULTORIA", 100.0);
        doNothing().when(mockNotaFiscalDao).salva(any(notafiscal.class));
        notafiscal nf = geradornotafiscal.geraNotaFiscal(fatura);
        assertEquals("Cliente", nf.getNome());
        assertEquals(125.0, nf.getValorNota(), 0.01);
        assertEquals(25.0, nf.getValorImposto(), 0.01);
        verify(mockNotaFiscalDao, times(1)).salva(any(notafiscal.class));
		verify(mockSAP, times(1)).envia(any(notafiscal.class));
        verify(mockSmtp, times(1)).envia(any(notafiscal.class));
    }



	@Test
    public void testeFaturaZero() {
        fatura fatura = new fatura("Cliente", "endereço", "TREINAMENTO", 0.0);
        assertThrows(NullPointerException.class, () -> {
            geradornotafiscal.geraNotaFiscal(fatura);
        });





    }

    @Test
    public void testeFaturaNegativa() {
        fatura fatura = new fatura("Cliente", "endereço", "OUTROS", -100.0);
        assertThrows(NullPointerException.class, () -> {        
        	geradornotafiscal.geraNotaFiscal(fatura);
} );
    }


}
