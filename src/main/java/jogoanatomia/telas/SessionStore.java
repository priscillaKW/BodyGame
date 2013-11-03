package jogoanatomia.telas;

import jogoanatomia.entidades.User;

public class SessionStore {
    private static User loggedUser = null;

    private SessionStore() {};

    public static void setLoggedUser(User user) {
        loggedUser = user;
    }

    public static User getLoggedUser() {
        return loggedUser;
    }
}
