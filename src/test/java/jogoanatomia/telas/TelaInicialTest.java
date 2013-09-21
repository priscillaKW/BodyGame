/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoanatomia.telas;

import java.awt.AWTEvent;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

/**
 *
 * @author Jessica
 */
public class TelaInicialTest extends TestCase {
    
    public TelaInicialTest(String testName) {
        super(testName);
    }
    
    TelaInicial window;
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        window = new TelaInicial();
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
        window.jButtonEntrar.doClick();
        String message = (String) window.jLabelMessage.getText();
        assertEquals(window.loginOK, false);     
        assertEquals(message, "Insira o login");
    }
    
    public void testTextoSenhaVazio(){
        window.jTextLogin1.setText("jessica");
        window.jButtonEntrar.doClick();
        String message = (String) window.jLabelMessage.getText();
        assertEquals(window.loginOK, false);     
        assertEquals(message, "Insira a senha");
    }
    
    public void testTextoLoginIncorreto(){
        window.jTextLogin1.setText("jessica");
        window.jTextSenha.setText("1234");
        window.jButtonEntrar.doClick();
        String message = (String) window.jLabelMessage.getText();
        assertEquals(window.loginOK, false);     
        assertEquals(message, "Login ou senha inválidos!");
    }
}
