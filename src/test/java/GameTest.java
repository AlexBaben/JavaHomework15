import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player playerOne = new Player(101, "Vasya", 15);
    Player playerTwo = new Player(121, "Vlad", 17);
    Player playerThree = new Player(102, "Stas", 15);

    @Test
    public void ShouldRegister() {
        Game game = new Game();
        game.register(playerOne);

        boolean expected = true;
        boolean actual = game.isRegistered.contains("Vasya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldWinFirst() {
        Game game = new Game();
        game.add(playerTwo);
        game.add(playerThree);
        game.register(playerTwo);
        game.register(playerThree);

        int expected = 1;
        int actual = game.round("Vlad", "Stas");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldWinSecond() {
        Game game = new Game();
        game.add(playerOne);
        game.add(playerTwo);
        game.register(playerOne);
        game.register(playerTwo);

        int expected = 2;
        int actual = game.round("Vasya", "Vlad");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldBeTie() {
        Game game = new Game();
        game.add(playerOne);
        game.add(playerThree);
        game.register(playerOne);
        game.register(playerThree);

        int expected = 0;
        int actual = game.round("Vasya", "Stas");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldGetException() {
        Game game = new Game();
        game.add(playerOne);
        game.add(playerThree);
        game.register(playerOne);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Vasya", "Stas");
        });
    }

    @Test
    public void ShouldNotFindByName () {
        Game game = new Game();
        game.add(playerOne);
        game.add(playerThree);
        game.register(playerOne);
        game.register(playerThree);

        Player expected = null;
        Player actual = game.findByName("Egor");

        Assertions.assertEquals(expected, actual);
    }
}
