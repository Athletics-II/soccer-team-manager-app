##About/Overview

This soccer team program is designed to help coaches manage their team rosters and lineups more efficiently. The program addresses the problems of managing player information and eligibility, creating and retrieving team roster, and creating lineups for games by providing functionality to each of the above mentioned problem.

##List of Features

With the help of this program, coaches can easily add players by inputting their basic information, who will be assigned a jersey number upon added to the team, control the team size to be somewhere in between 10 and 20 players, and will not accidentally add players older than 10 years old.

It is also possible to retrieve the team roster that lists the players' last names, first names, and jersey numbers in a table, in which the players are sorted alphabetically by their last names.

Coaches can also create lineups for games and see the lineup information that lists the players' last names, first names, jersey numbers, and positions in another table. This feature helps coaches to ensure that their team is well-prepared for each game and has the best chance of winning.

##How to Run
1. Make sure you have Java installed on your computer. If not, you can download and install it from the official Java website.
2. Open a command prompt or terminal window on your computer.
3. Navigate to the directory where the JAR file is located using the "cd" command.
4. Once you are in the directory, type "java -jar SoccerTeam.jar" and press Enter.
5. The program should start running and you should see the output in the command prompt or terminal window.

##How to Use the Program
User can input the first name, last name, date of birth (in the format of YYYY-MM-DD), preferred position, and select the skill level of a player in the top section of the program.
Then, user can click the "Add Player" button to add the player to the team. Whether the player is successfully added is displayed on the right side panel.
User can create the team, and retrieve the team roster once the team reaches 10 players by clicking on the two buttons accordingly. If the team is underpopulated, the failure message will be displayed on the right side panel.
User can generate and retrieve a lineup by clicking on the "Generate Lineup" button as well.

##Design/Model Changes
Compared to earlier designs, this version implemented several custom comparators to achieve different sorting requirements. Also, this version currently has a jerseyList in the model class and a method generateJerseyNumIndex in the Player class to mitigate the problem of generating repetitive jersey numbers as the team size grows.

##Assumptions
This program is built based on the assumption that:
1. There are no two players who have the exact same name for the implementation of alphabetical sorting of names.
2. The user will give good input, meaning that the name follows naming convention, the date of birth follows the given format and does not exceed the current date, the preferred position is within the designated enum.

##Limitations
Currently this version does not support active removing of a certain player, active selecting players for the lineup, and does not consider players' preference when generating a lineup. These functionalities may be implemented in later versions.

##Citations
[1]"Compile and build applications with IntelliJ IDEA | IntelliJ IDEA," IntelliJ IDEA Help. https://www.jetbrains.com/help/idea/compiling-applications.html#rebuild_project (accessed Apr. 18, 2023).
