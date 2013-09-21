/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoanatomia.entidades.actor;

import junit.framework.TestCase;

/**
 *
 * @author Jessica
 */
public class CadastroActorTest extends TestCase {
    
    public CadastroActorTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of cadastrar method, of class CadastroActor.
     */
    public void testCadastrar() {
        System.out.println("cadastrar");
        String login = "jessica";
        String senha = "1234";
        CadastroActor instance = new CadastroActor();
        boolean expResult = false;
        boolean result = instance.cadastrar(login, senha);
        assertEquals(expResult, result);
    }
}
