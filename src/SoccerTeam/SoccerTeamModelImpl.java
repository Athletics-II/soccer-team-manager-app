package SoccerTeam;

import java.util.HashMap;
import java.util.ArrayList;

public class SoccerTeamModelImpl {
    private HashMap<Player, Integer> team;
    private int teamSize;
    private HashMap<Player, Position> lineUp;
    private ArrayList<Integer> jerseyList;

    public SoccerTeamModelImpl() {
        this.team = new HashMap<>();
    }

    private HashMap addPlayer() {
        //generate jersey
        //if validateJersey()
        //team.put(Player, jersey)
        //jerseyList.add()
        //else
        //generate jersey
        return team;
    }

    private boolean validateJersey() {
        return true;
    }
}

