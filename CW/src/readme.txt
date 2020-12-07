## Part 1 ##
I have implemented the classes - Team, Character - following the coursework specification.

Team.java
- Added a boolean hasAliveMembers() method that checks if the team has any alive members
- Added a getter for the ArrayList's size - getSize();
- Added a getLeastTanky method that will be used in the move() method for both StudentTeam and MonsterTeam.
	It returns a character based on a formula to calculate the best target from the enemyTeam.
	The formula essentially returns the enemy with most attack that is easiest to kill.

Character.java
- Added a getter method for the characters level.
- Added a boolean isAlive() method that checks if the characters hp is above 0
- Added a boolean HPAbove50() method that checks if the characters hp is above 50%
- Added a compareTo using the Comparable interface in order to compare different characters' speeds;

## Part 2 ##
I have implemented the classes - Student, CSStudent, AIStudent, CyberStudent, SEStudent - following the coursework specification.

Student.java
-Added a resetKP() method that sets the student's KP to 0.
-Added a boolean hasMaxKP() method that cheks if the students currentKP is equal to their maxKP

## Part 3 ##
I have implemented the classes - Monster, Minion, Boss - following the coursework specification.

-Used the Random class instead of a Toolbox for the Random number generation.

## Part 4 ##
I have implemented the classes - MonsterTeam, StudentTeam, Guild - following the coursework specification.

StudentTeam.java
- Each of the different Student classes has a slighly different logic behind their attack pattern.
	-Firstly every class will use their special abilities if they have MaxKP - (hasMaxKP() method)
	-If they dont have maxKP they will always use JavaProgramming

-AIStudent - If the AIStudent has below 50% hp they will healthemselves using naturalLanguageProcessing(); If they do have above 50% hp they will use machineLearning.

-CSStudent - Will check if any allies need healing (have below 50%hp) and use support on them if they do. If not will get the ally (or himself as stated in the FAQ)
	with the highest Attack stat using the maxAttackFriend(Character member) method.
	The maxAttackFriend(Character member) creates a temp array of character, sorts them and returns the one with the highest attack.

-CyberStudent - Will use cyberAttack() if it has maxKP.

-SEStudent - Uses the friendsNeedHealing() method which returns true if more than one ally has below 50% hp. If so uses groupDiscussion. Else uses groupWork().


MonsterTeam.java
- Monster will always use strike on the getLeastTanky() character.


Guild.java
-Created the getTeam method to take (Team enemyTeam, String name) in order to create the a team. It will get the first 5 alive members of the guild and put them into the team. If there are less than 5 it will take however many there are.

## Part 5 ##
I have implemented the class - Battle - following the coursework specification.

Battle.java
- Addded Character[] allCharacters variable to store the characters of both teams.
- Added a displayTeams() method - which will display both teams characters their hp/MaxHP, level, and speed.
- Added a checkWinner() method - which checks if each team has alive members and returns the other if not.
- Decided to end the battle as a stalemate if the rounds were above 30 and throw an exception - however this never happened in testing.

## Part 6 ##
I have implemented the class - TowerOfMonsters - following the coursework specification.

-Added a studentGuild variable, teamName1 and teamName2 Strings, and the studentTeam and monsterTeam teams.
-Also added an int floor to track which floor(line) we are on.
-File reading is done via a BufferedReader. For each line of the file a new monsterTeam is crated.

-Added an addStudentGuild() method which adds students to the student guild.
-Added an addMonstersToMonsterTeam(String line) method that takes a line from the .txt and creates a monsterTeam depending on it. (See details in code comments)

In the main method we create a new battle with new teams for each line of the document or until the studentGuild has no alive members yet.