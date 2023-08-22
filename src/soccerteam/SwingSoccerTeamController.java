package soccerteam;

import java.time.LocalDate;

/**.
 * The SwingSoccerTeamController class is the controller for the Soccer Team application.
 * It communicates with the SoccerTeamModel and SwingSoccerTeamView classes to
 * handle user interactions and update the UI accordingly.
 */
public class SwingSoccerTeamController {
  private final SoccerTeamModel model;
  private final SwingSoccerTeamView view;

  /**.
   * Constructor for the SwingSoccerTeamController class.
   * @param model The SoccerTeamModel instance that the controller will communicate with.
   * @param view The SwingSoccerTeamView instance that the controller will communicate with.
   */
  public SwingSoccerTeamController(SoccerTeamModel model, SwingSoccerTeamView view) {
    this.model = model;
    this.view = view;
  }

  /**.
   * Method called when the "Add Player" button is pressed. It retrieves the player information
   * entered by the user from the SwingSoccerTeamView instance
   * and creates a new Player instance with that information. It then calls the addPlayer method
   * of the SoccerTeamModel instance to add the player to the team.
   */
  public void addPlayerButtonPressed() {
    String firstName = view.getFirstName();
    String lastName = view.getLastName();
    Position pos = view.getPreferredPosition();
    int skillLevel = view.getSkillLevel();
    String[] date = view.getDateOfBirth().split("-");
    LocalDate dateOfBirth = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]),
        Integer.parseInt(date[2]));
    Player newPlayer = new Player(firstName, lastName, pos, skillLevel, dateOfBirth);
    try {
      model.addPlayer(newPlayer);
      view.appendToOutputArea("Player added successfully!");
    } catch (IllegalArgumentException e) {
      view.appendToOutputArea("Sorry, you cannot add this player to the team. "
          + "The player is over 10 years old.");
    }
  }

  /**.
   * Method called when the "Create Team" button is pressed. It checks if there are
   * at least 10 players in the team, and if there are, it calls the SoccerTeamModel instance's
   * createTeam method to create a team.
   */
  public void createTeamButtonPressed() {
    if (model.getTeamSize() < 10) {
      view.appendToOutputArea("Not enough players to form a team. "
          + "There must be at least ten players.");
    } else {
      view.appendToOutputArea("Team created successfully!");
    }
  }

  /**.
   * Method called when the "Print Team" button is pressed.
   * It calls the getRoster method of the SoccerTeamModel instance to get the current team roster,
   * and then formats the data into a 2D String array to be displayed in a JTable in the
   * SwingSoccerTeamView instance.
   * @return The formatted team roster data as a 2D String array.
   */
  public String[][] printTeamButtonPressed() {
    if (model.getTeamSize() < 10) {
      view.appendToOutputArea("Not enough players to form a team. "
          + "There must be at least ten players.");
      return new String[0][0];
    }
    String data = model.getRoster();
    String[] lines = data.split("\n");
    String[][] tableData = new String[lines.length][3];

    for (int i = 0; i < lines.length; i++) {
      String[] parts = lines[i].split(":");
      String[] nameParts = parts[0].split(",");
      String lastName = nameParts[0].trim();
      String firstName = nameParts[1].trim();
      String jerseyNumber = parts[1].trim();
      tableData[i] = new String[] { lastName, firstName, jerseyNumber };
    }

    return tableData;

  }

  /**.
   * Method called when the "Generate Lineup" button is pressed.
   * It calls the getLineUp method of the SoccerTeamModel instance to get the current lineup,
   * and then formats the data into a 2D String array to be displayed in a JTable in the
   * SwingSoccerTeamView instance.
   * @return The formatted lineup data as a 2D String array.
   */
  public String[][] generateLineUpButtonPressed() {
    if (model.getTeamSize() < 10) {
      view.appendToOutputArea("Cannot generate a line up. Currently there is no team.");
      return new String[0][0];
    }
    String data = model.getLineUp();
    String[] lines = data.split("\n");
    String[][] tableData = new String[lines.length][4];

    for (int i = 0; i < lines.length; i++) {
      String[] parts = lines[i].split(":");
      String[] nameParts = parts[0].split(",");
      String lastName = nameParts[0].trim();
      String firstName = nameParts[1].trim();
      String[] info = parts[1].split(";");
      String jerseyNumber = info[0].trim();
      String pos = info[1].trim();
      tableData[i] = new String[] { lastName, firstName, jerseyNumber, pos };
    }

    return tableData;

  }
}
