package soccerteam;

/**.
 * Driver class for the soccer team application.
 */
public class Main {
  /**.
   * Constructs a driver class for the soccer application.
   * @param args main args
   */
  public static void main(String[] args) {
    SoccerTeamModel teamModel = new SoccerTeamModelImpl();
    SwingSoccerTeamView teamView = new SwingSoccerTeamView();
    SwingSoccerTeamController teamController = new SwingSoccerTeamController(teamModel, teamView);
    teamView.setController(teamController);
  }

}