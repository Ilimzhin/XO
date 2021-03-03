package xo.model;

public class Game {
    private final Player[] players;
    private final Field field;
    private final String getName;

    public Game(final Player[] players,
                final Field field,
                final String getName) {
        this.players = players;
        this.field = field;
        this.getName = getName;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Field getField() {
        return field;
    }

    public String getGetName() {
        return getName;
    }
}
