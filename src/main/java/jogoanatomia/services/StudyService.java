package jogoanatomia.services;

import jogoanatomia.entidades.Study;

import java.util.List;

public interface StudyService {
    public List<Study> listByOrganId(String organId);
    public Study find(String id);
}
