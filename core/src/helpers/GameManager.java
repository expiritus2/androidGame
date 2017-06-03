package helpers;


public class GameManager {
    private static final GameManager ourInstance = new GameManager();


    private GameManager() {
    }

    public static GameManager getInstance() {
        return ourInstance;
    }
}
