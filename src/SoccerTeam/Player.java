package SoccerTeam;
import java.time.LocalDate;
public class Player {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Position preferredPos;
    private int skillLevel;
    //TODO: jersey

    public Player(String first, String last, Position pos, int skill) throws IllegalArgumentException {
        this.firstName = first;
        this.lastName = last;
        this.preferredPos = pos;
        this.skillLevel = skill;

        //TODO: if age < 10 || invalid name skill pos throw exception
    }


}

