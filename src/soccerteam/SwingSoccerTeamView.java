package soccerteam;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**.
 * The SwingSoccerTeamView class is the view for the Soccer Team application.
 * It provides a graphical interface for the user to input data, communicates with the controller,
 * and displays data returned by the controller to the user.
 */
public class SwingSoccerTeamView {

  private SwingSoccerTeamController controller;
  private final JTextField firstNameField = new JTextField(10);
  private final JTextField lastNameField = new JTextField(10);
  private final JTextField dateOfBirthField = new JTextField(10);
  private final SpinnerNumberModel skill = new SpinnerNumberModel(1, 1, 5, 1);
  private final JSpinner skillSpinner = new JSpinner(skill);
  private final JTextField preferredPosField = new JTextField(10);
  private final JTextArea outputArea = new JTextArea(20, 60);

  /**.
   * Constructor for the SwingSoccerTeamView class.
   * Sets up the structure of the graphical user interface and assigns action listeners to
   * the addPlayer, createTeam, printTeam, generateLineUp buttons
   */
  public SwingSoccerTeamView() {
    JFrame frame = new JFrame("Soccer Team Manager");
    frame.setSize(800, 800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());

    JPanel inputPanel = new JPanel();
    JLabel firstNameLabel = new JLabel("First Name:");
    inputPanel.add(firstNameLabel);
    inputPanel.add(firstNameField);
    JLabel lastNameLabel = new JLabel("Last Name:");
    inputPanel.add(lastNameLabel);
    inputPanel.add(lastNameField);
    JLabel dateOfBirthLabel = new JLabel("Date of Birth (YYYY-MM-DD):");
    inputPanel.add(dateOfBirthLabel);
    inputPanel.add(dateOfBirthField);
    JLabel skillLevelLabel = new JLabel("Skill Level:");
    inputPanel.add(skillLevelLabel);
    inputPanel.add(skillSpinner);
    JLabel preferredPosLabel = new JLabel("Preferred Position:");
    inputPanel.add(preferredPosLabel);
    inputPanel.add(preferredPosField);

    JScrollPane outputScrollPane = new JScrollPane(outputArea);
    JPanel outputPanel = new JPanel();
    JButton addPlayerButton = new JButton("Add Player");
    outputPanel.add(addPlayerButton);
    JButton createTeamButton = new JButton("Create Team");
    outputPanel.add(createTeamButton);
    JButton printTeamButton = new JButton("Print Team");
    outputPanel.add(printTeamButton);
    JButton generateLineUpButton = new JButton("Generate Lineup");
    outputPanel.add(generateLineUpButton);
    outputPanel.add(outputScrollPane);

    frame.add(inputPanel, BorderLayout.NORTH);
    frame.add(outputPanel, BorderLayout.CENTER);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    addPlayerButton.addActionListener(e -> controller.addPlayerButtonPressed());

    createTeamButton.addActionListener(e -> controller.createTeamButtonPressed());

    printTeamButton.addActionListener(e -> {
      String[][] roster = controller.printTeamButtonPressed();
      if (roster.length == 0) {
        return;
      }
      JTable table = new JTable(roster,
          new String[] { "Last Name", "First Name", "Jersey Number" });
      final JScrollPane scrollPane = new JScrollPane(table);
      JDialog dialog = new JDialog();
      dialog.setTitle("Team Roster");
      dialog.setModal(true);
      dialog.setResizable(true);
      dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      dialog.getContentPane().add(scrollPane);
      dialog.pack();
      dialog.setLocationRelativeTo(null);
      dialog.setVisible(true);
    });

    generateLineUpButton.addActionListener(e -> {
      String[][] lineUp = controller.generateLineUpButtonPressed();
      if (lineUp.length == 0) {
        return;
      }
      JTable table = new JTable(lineUp,
          new String[] { "Last Name", "First Name", "Jersey Number", "Position" });
      final JScrollPane scrollPane = new JScrollPane(table);
      JDialog dialog = new JDialog();
      dialog.setTitle("Team Lineup");
      dialog.setModal(true);
      dialog.setResizable(true);
      dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      dialog.getContentPane().add(scrollPane);
      dialog.pack();
      dialog.setLocationRelativeTo(null);
      dialog.setVisible(true);
    });
  }

  public void setController(SwingSoccerTeamController controller) {
    this.controller = controller;
  }

  public String getFirstName() {
    return firstNameField.getText();
  }

  public String getLastName() {
    return lastNameField.getText();
  }

  public String getDateOfBirth() {
    return dateOfBirthField.getText();
  }

  public int getSkillLevel() {
    return Integer.parseInt(skillSpinner.getValue().toString());
  }

  public Position getPreferredPosition() {
    return Position.valueOf(preferredPosField.getText());
  }

  /**.
   * Appends the given string to the output area.
   * @param message the string to append to the output area
   */
  public void appendToOutputArea(String message) {
    outputArea.append(message + "\n");
  }

}
