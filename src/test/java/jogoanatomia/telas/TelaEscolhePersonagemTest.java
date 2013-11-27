package jogoanatomia.telas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jogoanatomia.entidades.User;

public class TelaEscolhePersonagemTest {

	private TelaSelecionaPersonagens window;
	User usuario;
	
		@Before
	    public void setUp() {
			usuario = new User();
			usuario.setId("abcd");
	        window = new TelaSelecionaPersonagens(usuario);
	        window.setVisible(true);
	    }
	    
	    @After
	    public void tearDown() {
	        window.dispose();
	    }
	
	    /**
	     * Test of main method, of class TelaInicial.
	     */
	    @Test
	    public void testMain() {
	        System.out.println("main");
	        String[] args = null;
	        TelaInicial.main(args);     
	    }
	    
	    /**
	     * Testa se a tela está sendo exibida
	     */
	    @Test
	    public void testIsShowing(){
	        assertTrue(window.isShowing());
	    }
	    
	    /**
	     * Testa se está salvando o personagem no usuário
	     */
	    @Test
	    public void testIsUsuarioAtualizando(){
	    	window.rdbtnMulher.setSelected(true);
	    	window.btnOk.doClick();
	    	assertTrue(window.personagem.equals("female"));
	    }
	

}
