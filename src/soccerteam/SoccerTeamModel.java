package soccerteam;

import java.util.TreeMap;

/**.
 * The model for a soccer team generation program, allows user to add
 * player {@link Player} to a team with a headcount limit between 10 and 20,
 * get the full roster, and get a list of an automatically generated line-up
 * according to players' skill levels.
 */
public interface SoccerTeamModel {

  /**
   * Adds a new player to the team.
   * Throws an IllegalArgumentException if the player is over 10 years old.
   * If the team size is less than 20, adds the player to the team with a new unique jersey number.
   * If the team size is already at the maximum capacity, replaces the player with the lowest
   * skill level with the new player.
   * @param newPlayer the player to be added to the team
   * @throws IllegalArgumentException if the player is over 10 years old
   */
  void addPlayer(Player newPlayer) throws IllegalArgumentException;

  /**.
   * Returns a treemap of the current team.
   * @return a TreeMap of the current team where the keys are Players
   *        and the values are their jersey numbers
   */
  TreeMap<Player, Integer> getTeam();

  /**.
   * Returns the current team size.
   * @return the current team size
   */
  int getTeamSize();

  /**.
   * Prints the roster of the team in alphabetical order based on player last name.
   * If the team has less than 10 players, it will print an error message.
   * Uses a TreeMap to sort the team by player last name using a custom playerComparator.
   * @return a string of team roster
   */
  String getRoster();

  /**.
   * Prints the generated lineup sorted according to the positions of the players,
   * or alphabetically if two players are of the same position.
   * If the team has less than 10 players, it will print an error message.
   * Uses a TreeMap to sort the lineup using a custom lineUpComparator.
   * @return a string of team lineup
   */
  String getLineUp();
}
