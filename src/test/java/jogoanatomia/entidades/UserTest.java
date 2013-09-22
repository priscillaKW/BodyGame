package jogoanatomia.entidades;

import static org.junit.Assert.*;

import jogoanatomia.utils.JSONParser;
import org.junit.Test;

public class UserTest {
    @Test
    public void fromJsonTest() {
        String json = "{\"id\":1,\"username\":\"someone\",\"password\":\"inicial1234\",\"created_at\":\"2013-09-22T01:18:25.963Z\",\"updated_at\":\"2013-09-22T01:18:25.963Z\"}";

        User user = JSONParser.fromJson(json, User.class);

        assertEquals(new Integer(1), user.getId());
        assertEquals("someone", user.getLogin());
        assertEquals("inicial1234", user.getPassword());
    }
}
