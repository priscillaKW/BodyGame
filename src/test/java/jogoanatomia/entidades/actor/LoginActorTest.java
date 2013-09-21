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
public class LoginActorTest extends TestCase {
    
    public LoginActorTest(String testName) {
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
     * Test of verificaLogin method, of class LoginActor.
     */
    public void testVerificaLogin() {
        System.out.println("verificaLogin");
        String login = "jessica";
        String senha = "1234";
        LoginActor instance = new LoginActor();
        boolean expResult = false;
        boolean result = instance.verificaLogin(login, senha);
        assertEquals(expResult, result);
    }
}
