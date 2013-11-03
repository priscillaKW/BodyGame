package jogoanatomia.entidades;


import jogoanatomia.utils.JSONParser;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    
    @Test
    public void fromJsonTest() {
        String json = "{\"id\":\"1\",\"username\":\"someone\",\"password\":\"inicial1234\",\"created_at\":\"2013-09-22T01:18:25.963Z\",\"updated_at\":\"2013-09-22T01:18:25.963Z\"}";

        User user = JSONParser.fromJson(json, User.class);

        assertEquals("1", user.getId());
        assertEquals("someone", user.getLogin());
        assertEquals("inicial1234", user.getPassword());
    }
}
