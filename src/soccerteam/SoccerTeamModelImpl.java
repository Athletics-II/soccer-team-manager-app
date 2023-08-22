package soccerteam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**.
 * Implementation of the SoccerTeamModel interface. This class provides methods to
 * manage a soccer team, including adding and removing players, setting their jersey numbers
 * and creating a lineup for the team.
 */
public class SoccerTeamModelImpl implements SoccerTeamModel {
  private final TreeMap<Player, Integer> team;
  private int teamSize = 0;
  private final TreeMap<Player, Position> lineUp;
  private final ArrayList<Integer> jerseyList;

  /**.
   * Constructs a new SoccerTeamModelImpl object with an empty team and lineup, and a jersey list
   * with integers from 1 to 20. The team and lineup are sorted based on player skill level using
   * the skillComparator defined in the Player class.
   */
  public SoccerTeamModelImpl() {
    SkillComparator skillComparator = new SkillComparator();
    this.team = new TreeMap<>(skillComparator);
    this.jerseyList = new ArrayList<>();
    for (int i = 1; i < 21; i++) {
      jerseyList.add(i);
    }
    this.lineUp = new TreeMap<>(skillComparator);
  }

  private static class SkillComparator implements Comparator<Player> {
    @Override public int compare(Player p1, Player p2) {
      if (p1.getSkillLevel() >= p2.getSkillLevel()) {
        return -1;
      } else {
        return 1;
      }
    }
  }

  @Override
  public void addPlayer(Player newPlayer) throws IllegalArgumentException {
    if (newPlayer.getAge() > 10) {
      throw new IllegalArgumentException();
    }
    if (teamSize < 20) {
      int newJerseyNum = generateJerseyNum(newPlayer);
      team.put(newPlayer, newJerseyNum);
      jerseyList.remove(Integer.valueOf(newJerseyNum));
      newPlayer.setJerseyNum(newJerseyNum);
      teamSize++;
    } else {
      System.out.println("The team size has reached its maximum capacity. The player with "
                + "the lowest skill level will be replaced.\n");
      Player lastPlayer = team.lastKey();
      int replacedJersey = lastPlayer.getJerseyNum();
      team.put(newPlayer, replacedJersey);
      System.out.printf("%s %s has been removed from the team.\n",
                lastPlayer.getFirstName(), lastPlayer.getLastName());
      team.remove(lastPlayer);
    }
  }

  private int generateJerseyNum(Player newPlayer) {
    int jerseyNumIndex = newPlayer.generateJerseyNumIndex(jerseyList.size());
    return jerseyList.get(jerseyNumIndex);
  }

  private void createLineUp() {
    ArrayList<Position> lineUpPos = new ArrayList<>(Arrays.asList(Position.Forward,
            Position.Defender, Position.Goalie, Position.Midfielder, Position.Midfielder,
            Position.Midfielder, Position.Defender));
    Set<Player> keys = team.keySet();
    List<Player> players = new ArrayList<>(keys);
    for (int j = 0; j < 7; j++) {
      lineUp.put(players.get(j), lineUpPos.get(j));
    }
  }

  private static class PlayerComparator implements Comparator<Player> {
    @Override public int compare(Player p1, Player p2) {
      for (int i = 0; i < Math.min(p1.getLastName().length(), p2.getLastName().length()); i++) {
        if (p1.getLastName().charAt(i) != p2.getLastName().charAt(i)) {
          return Character.compare(p1.getLastName().charAt(i), p2.getLastName().charAt(i));
        } else {
          for (int j = 0; j < Math.min(p1.getFirstName().length(),
              p2.getFirstName().length()); j++) {
            if (p1.getFirstName().charAt(j) != p2.getFirstName().charAt(j)) {
              return Character.compare(p1.getFirstName().charAt(j), p2.getFirstName().charAt(j));
            }
          }
        }
      }
      return 1;
    }
  }

  @Override
  public TreeMap<Player, Integer> getTeam() {
    return team;
  }

  @Override
  public int getTeamSize() {
    return teamSize;
  }

  @Override
  public String getRoster() {
    PlayerComparator comparator = new PlayerComparator();
    TreeMap<Player, Integer> sorted = new TreeMap<>(comparator);
    sorted.putAll(team);
    StringBuilder roster = new StringBuilder();
    for (Map.Entry<Player, Integer> entry : sorted.entrySet()) {
      roster.append(String.format("%s, %s: %d\n", entry.getKey().getLastName(),
          entry.getKey().getFirstName(), entry.getValue()));
    }
    return roster.toString();
  }

  private static class LineUpComparator implements Comparator<Map.Entry<Player, Position>> {
    private final Position[] order = {Position.Goalie, Position.Defender, Position.Midfielder,
        Position.Forward};

    @Override
    public int compare(Entry<Player, Position> o1, Entry<Player, Position> o2) {
      int index1 = getIndex(o1.getValue());
      int index2 = getIndex(o2.getValue());
      int cmp = Integer.compare(index1, index2);
      if (cmp == 0) {
        for (int i = 0; i < Math.min(o1.getKey().getLastName().length(),
            o2.getKey().getLastName().length()); i++) {
          if (o1.getKey().getLastName().charAt(i) != o2.getKey().getLastName().charAt(i)) {
            return Character.compare(o1.getKey().getLastName().charAt(i),
                o2.getKey().getLastName().charAt(i));
          }
        }
      }
      return cmp;
    }

    private int getIndex(Position pos) {
      for (int i = 0; i < order.length; i++) {
        if (order[i].equals(pos)) {
          return i;
        }
      }
      return order.length;
    }
  }

  @Override
  public String getLineUp() {
    lineUp.clear();
    createLineUp();
    LineUpComparator lineUpComparator = new LineUpComparator();
    List<Entry<Player, Position>> entries = new ArrayList<>(lineUp.entrySet());
    entries.sort(lineUpComparator);
    StringBuilder lineUpString = new StringBuilder();
    for (Map.Entry<Player, Position> entry : entries) {
      lineUpString.append(String.format("%s, %s: %d; %s\n", entry.getKey().getLastName(),
          entry.getKey().getFirstName(), entry.getKey().getJerseyNum(), entry.getValue()));
    }
    return lineUpString.toString();
  }
}



