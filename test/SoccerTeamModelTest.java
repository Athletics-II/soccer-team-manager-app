import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import soccerteam.Player;
import soccerteam.Position;
import soccerteam.SoccerTeamModelImpl;


/**.
 * A JUnit class that tests the integral implementation of the model
 * and the Player class
 */
public class SoccerTeamModelTest {
  private final SoccerTeamModelImpl team1 = new SoccerTeamModelImpl();
  private Player player1;
  private Player player2;
  private Player player3;
  private Player player4;
  private Player player5;
  private Player player6;
  private Player player7;
  private Player player8;
  private Player player9;
  private Player player10;
  private Player player11;
  private Player player12;
  private Player player13;
  private Player player14;
  private Player player15;
  private Player player16;
  private Player player17;
  private Player player18;
  private Player player19;
  private Player player20;
  private Player player21;

  /**.
   * Sets up some Player objects for testing
   */
  @Before
  public void setUp() {
    player1 = new Player("Dexter", "Grif", Position.Goalie,
        1, LocalDate.of(2014, 1, 25));
    player2 = new Player("Richard", "Simmons", Position.Defender,
        2, LocalDate.of(2014, 1, 25));
    player3 = new Player("Sarge", "Sgt", Position.Forward,
        3, LocalDate.of(2014, 1, 1));
    player4 = new Player("Franklin", "Donut", Position.Midfielder,
        3, LocalDate.of(2014, 1, 25));
    player5 = new Player("Frank", "DuFresne", Position.Goalie,
        2, LocalDate.of(2014, 1, 25));
    player6 = new Player("Leonard", "Church", Position.Midfielder,
        3, LocalDate.of(2014, 1, 25));
    player7 = new Player("Lavernius", "Tucker", Position.Midfielder,
        4, LocalDate.of(2014, 1, 25));
    player8 = new Player("Michael", "Caboose", Position.Midfielder,
        3, LocalDate.of(2014, 1, 25));
    player9 = new Player("David", "Washington", Position.Midfielder,
        5, LocalDate.of(2014, 1, 25));
    player10 = new Player("Kaikaina", "Grif", Position.Midfielder,
        3, LocalDate.of(2014, 1, 25));
    player11 = new Player("Lopez", "Robot", Position.Midfielder,
        5, LocalDate.of(2014, 1, 25));
    player12 = new Player("Vanessa", "Kimball", Position.Midfielder,
        3, LocalDate.of(2014, 1, 25));
    player13 = new Player("Katie", "Jensen", Position.Midfielder,
        3, LocalDate.of(2014, 1, 25));
    player14 = new Player("Antoine", "Bitters", Position.Midfielder,
        3, LocalDate.of(2014, 1, 25));
    player15 = new Player("John", "Smith", Position.Midfielder,
        3, LocalDate.of(2014, 1, 25));
    player16 = new Player("Charles", "Palomo", Position.Midfielder,
        3, LocalDate.of(2014, 1, 25));
    player17 = new Player("Donald", "Doyle", Position.Midfielder,
        3, LocalDate.of(2014, 1, 25));
    player18 = new Player("Emily", "Grey", Position.Midfielder,
        3, LocalDate.of(2014, 1, 25));
    player19 = new Player("Felix", "Merc", Position.Forward,
        5, LocalDate.of(2014, 1, 25));
    player20 = new Player("Locus", "Merc", Position.Defender,
        5, LocalDate.of(2014, 1, 25));
    player21 = new Player("Jonathan", "Doherty", Position.Midfielder,
        5, LocalDate.of(2014, 1, 25));
  }

  @Test
  public void testPlayerCreation() {
    assertEquals(this.player1.getFirstName(), "Dexter");
    assertEquals(this.player1.getLastName(), "Grif");
    assertTrue(this.player1.getAge() < 10);
    assertEquals(this.player1.getPreferredPos(), Position.Goalie);
    assertEquals(this.player1.getSkillLevel(), 1);
  }

  @Test
  public void testTeamCreation() {
    assertEquals(team1.getTeamSize(), 0);
  }

  @Test
  public void testGenerateJerseyNumIndex() {
    int actualOutput = player1.generateJerseyNumIndex(20);
    assertTrue(actualOutput >= 0 && actualOutput < 20);
  }

  @Test
  public void testAddPlayer() {
    team1.addPlayer(player1);
    team1.addPlayer(player2);
    assertEquals(team1.getTeamSize(), 2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testBadAddPlayer() {
    team1.addPlayer(new Player("Sarge", "Sgt", Position.Forward,
        3, LocalDate.of(1990, 1, 1)));
  }

  @Test (expected = IllegalStateException.class)
  public void testIllegalSetJersey() {
    team1.addPlayer(player1);
    player1.setJerseyNum(18);
  }

  @Test
  public void testGetRosterValidSize() {
    team1.addPlayer(player1);
    team1.addPlayer(player2);
    team1.addPlayer(player4);
    team1.addPlayer(player5);
    team1.addPlayer(player6);
    team1.addPlayer(player7);
    team1.addPlayer(player8);
    team1.addPlayer(player9);
    team1.addPlayer(player10);
    team1.addPlayer(player11);
    team1.addPlayer(player12);
    team1.addPlayer(player13);
    team1.addPlayer(player14);
    System.out.println(team1.getRoster());
    team1.addPlayer(player15);
    System.out.println(team1.getRoster());
  }

  @Test
  public void testOverloadTeamDropPlayer() {
    team1.addPlayer(player1);
    team1.addPlayer(player2);
    team1.addPlayer(player3);
    team1.addPlayer(player4);
    team1.addPlayer(player5);
    team1.addPlayer(player6);
    team1.addPlayer(player7);
    team1.addPlayer(player8);
    team1.addPlayer(player9);
    team1.addPlayer(player10);
    team1.addPlayer(player11);
    team1.addPlayer(player12);
    team1.addPlayer(player13);
    team1.addPlayer(player14);
    team1.addPlayer(player15);
    team1.addPlayer(player16);
    team1.addPlayer(player17);
    team1.addPlayer(player18);
    team1.addPlayer(player19);
    team1.addPlayer(player20);
    team1.addPlayer(player21);
    assertEquals(team1.getTeamSize(), 20);
    assertFalse(team1.getTeam().containsKey(player1));
  }

  @Test
  public void testGetLineUp() {
    team1.addPlayer(player1);
    team1.addPlayer(player2);
    team1.addPlayer(player3);
    team1.addPlayer(player4);
    team1.addPlayer(player5);
    team1.addPlayer(player6);
    team1.addPlayer(player7);
    team1.addPlayer(player8);
    team1.addPlayer(player9);
    team1.addPlayer(player10);
    System.out.println(team1.getLineUp());
    team1.addPlayer(player11);
    System.out.println(team1.getLineUp());
  }

}
