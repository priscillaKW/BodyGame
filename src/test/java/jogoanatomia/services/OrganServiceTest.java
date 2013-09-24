package jogoanatomia.services;

import static org.junit.Assert.*;

import jogoanatomia.entidades.Organ;
import org.junit.Test;

import java.util.List;

public class OrganServiceTest {
    private OrganService service = new OrganServiceImpl();

    @Test
    public void allTest() {
        List<Organ> organs = service.all();

        assertNotNull(organs);
        assertFalse(organs.isEmpty());

        for (Organ organ: organs) {
            assertNotNull(organ.getId());
            assertNotNull(organ.getName());
            assertNotNull(organ.getImageFileName());
        }
    }
}
