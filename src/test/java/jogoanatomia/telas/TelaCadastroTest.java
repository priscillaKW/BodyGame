/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoanatomia.telas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Jessica
 */
public class TelaCadastroTest {
    TelaCadastro window;
    
    @Before
    public void setUp() {
        window = new TelaCadastro();
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

    @Test
    public void testTextoLoginVazio(){
        window.jButtonCadastrar.doClick();
        String message = (String) window.jLabelMessage.getText();
        assertEquals(message, "Insira o login");
    }

    @Test
    public void testTextoSenhaVazio(){
        window.jTextLogin1.setText("jessica");
        window.jButtonCadastrar.doClick();
        String message = (String) window.jLabelMessage.getText();
        assertEquals(message, "Insira a senha");
    }

    @Test
    public void testTextoLoginIncorreto(){
        window.jTextLogin1.setText("jessica");
        window.jTextSenha.setText("1234");
        window.jButtonCadastrar.doClick();
        String message = (String) window.jLabelMessage.getText();
        assertEquals(message, "Login já cadastrado no sistema, tente outro");
    }
}
