import java.util.ArrayList;
import java.util.Objects;

public class Game {

    protected ArrayList<String> isRegistered = new ArrayList<>();
    private Player[] players = new Player[0];

    public ArrayList<String> register(Player player) {
        isRegistered.add(player.getName());
        return isRegistered;
    }

    private Player[] addToArray(Player[] current, Player player) {
        Player[] tmp = new Player[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = player;
        return tmp;
    }

    public void add(Player player) {
        players = addToArray(players, player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (Objects.equals(player.getName(), name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        boolean isRegOne = isRegistered.contains(playerName1);
        boolean isRegTwo = isRegistered.contains(playerName2);
        int strOne = findByName(playerName1).getStrength();
        int strTwo = findByName(playerName2).getStrength();

        if (!(isRegOne & isRegTwo)) {
            throw new NotRegisteredException(
                    "Please sing up"
            );
        }
        if (strOne > strTwo) {
            return 1;
        } else if (strOne < strTwo) {
            return 2;
        }
        return 0;
    }
}
