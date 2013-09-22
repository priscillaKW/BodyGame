package jogoanatomia.services;

import jogoanatomia.entidades.User;

public interface UserService {
    public User create(String username, String password);
    public User login(String username, String password);
}
