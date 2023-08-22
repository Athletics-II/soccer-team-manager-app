package soccerteam;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

/**.
 * A class that represents a player in a sports team.
 * Default jersey set to flag value -1 to ensure jersey can only be set once.
 * This class provides the information of a player, including first and last name,
 * birthday, preferred position, and skill level.
 */
public class Player implements Comparable<Player> {
  private final String firstName;
  private final String lastName;
  private final LocalDate dateOfBirth;
  private final Position preferredPos;
  private final int skillLevel;
  private int jerseyNum = -1;

  /**.
   * Constructs a new player with the given parameters.
   * @param first the first name of the player.
   * @param last the last name of the player.
   * @param pos the preferred position of the player.
   * @param skill the skill level of the player.
   * @param dateOfBirth the date of birth of the player.
   */
  public Player(String first, String last, Position pos, int skill, LocalDate dateOfBirth) {
    this.firstName = first;
    this.lastName = last;
    this.dateOfBirth = dateOfBirth;
    this.preferredPos = pos;
    this.skillLevel = skill;
  }

  /**.
   * Returns the first name of the player.
   * @return the first name of the player.
   */
  public String getFirstName() {
    return firstName;
  }

  /**.
   * Returns the last name of the player.
   * @return the last name of the player.
   */
  public String getLastName() {
    return lastName;
  }

  /**.
   * Returns the age of the player in years.
   * @return the age of the player in years.
   */
  public long getAge() {
    return ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
  }

  /**.
   * Returns the preferred position of the player.
   * @return the preferred position of the player.
   */
  public Position getPreferredPos() {
    return preferredPos;
  }

  /**.
   * Returns the skill level of the player.
   * @return the skill level of the player.
   */
  public int getSkillLevel() {
    return skillLevel;
  }

  /**.
   * Generates a random index for the jersey number list.
   * @param jerseyListSize the size of the jersey number list.
   * @return a random index for the jersey number list.
   */
  public int generateJerseyNumIndex(int jerseyListSize) {
    Random random = new Random();
    return random.nextInt(jerseyListSize);
  }

  /**
   * Sets the jersey number of the player.
   * @param jersey the jersey number of the player.
   * @throws IllegalStateException if the jersey number is already set and cannot be changed.
   */
  public void setJerseyNum(int jersey) throws IllegalStateException {
    if (jerseyNum != -1) {
      throw new IllegalStateException("Jersey number is already set and cannot be changed.");
    }
    this.jerseyNum = jersey;
  }

  /**.
   * Returns the jersey number of the player.
   * @return the jersey number of the player.
   */
  public int getJerseyNum() {
    return jerseyNum;
  }

  /**.
   * Compares this player to another player based on their skill levels.
   * @param o the player to compare to.
   * @return a negative integer, zero, or a positive integer as
   *        this player has a lower, same, or higher skill level.
   */
  @Override
  public int compareTo(Player o) {
    return Integer.compare(this.skillLevel, o.skillLevel);
  }
}

