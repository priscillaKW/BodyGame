/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoanatomia.telas;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;

/**
 *
 * @author Jessica
 */
public class TelaCadastroTest extends TestCase {
    
    public TelaCadastroTest(String testName) {
        super(testName);
    }
    
    TelaCadastro window;
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        window = new TelaCadastro();
        window.setVisible(true);
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        window.dispose();
    }

    /**
     * Test of main method, of class TelaInicial.
     */
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        TelaInicial.main(args);     
    }
    
    /**
     * Testa se a tela está sendo exibida
     */
    public void testIsShowing(){
        assertTrue(window.isShowing());
    }
    
    public void testTextoLoginVazio(){
        window.jButtonCadastrar.doClick();
        String message = (String) window.jLabelMessage.getText();
        assertEquals(window.cadastroOK, false);     
        assertEquals(message, "Insira o login");
    }
    
    public void testTextoSenhaVazio(){
        window.jTextLogin1.setText("jessica");
        window.jButtonCadastrar.doClick();
        String message = (String) window.jLabelMessage.getText();
        assertEquals(window.cadastroOK, false);     
        assertEquals(message, "Insira a senha");
    }
    
    public void testTextoLoginIncorreto(){
        window.jTextLogin1.setText("jessica");
        window.jTextSenha.setText("1234");
        window.jButtonCadastrar.doClick();
        String message = (String) window.jLabelMessage.getText();
        assertEquals(window.cadastroOK, false);     
        assertEquals(message, "Login já cadastrado no sistema, tente outro");
    }
}
