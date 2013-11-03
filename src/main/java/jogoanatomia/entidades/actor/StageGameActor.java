package jogoanatomia.entidades.actor;

import jogoanatomia.entidades.Game;
import jogoanatomia.entidades.Organ;
import jogoanatomia.entidades.User;
import jogoanatomia.services.GameService;

import java.util.List;

public abstract class StageGameActor<T extends Game> {
    private GameService service;
    private Organ organ;
    private User user;
    private List<T> games;

    private float completedPercentage;
    private int actualStage = -1;
    private int completedStageCount = -1;

    public StageGameActor(GameService service, User user, Organ organ) {
        this.service = service;
        this.user = user;
        this.organ = organ;
        init();
    }

    private void init() {
        this.games = service.listGamesByOrganId(organ.getId(), getGameType());
        this.completedPercentage = service.getCompletedPercentage(user.getId(), organ.getId(), getGameType());
    }

    public T nextStage() {
        completedStageCount++;
        actualStage++;

        if(games.size() > actualStage) {
            T nextStage = games.get(actualStage);
            afterSelectNextStage(nextStage);
            return nextStage;
        }

        return null;
    }

    public float actualCompletedPercentage() {
        return (100 * completedStageCount) / getTotalStages();
    }

    public void finish() {
        if (actualCompletedPercentage() > completedPercentage) {
            service.updateCompletedPercentage(user.getId(), organ.getId(), actualCompletedPercentage(), getGameType());
        }
    }

    public int getActualStage() {
        return actualStage;
    }

    public int getTotalStages() {
        return games.size();
    }

    abstract void afterSelectNextStage(T stage);
    abstract Class<T> getGameType();
}
