package finalproj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.sql.*;

import org.apache.derby.jdbc.EmbeddedDataSource;

public class Player1 {

	private int id;
	private String name;
	private int score;

	/**
	method to display player info after it has been retrieved from the database
	 */
	private void displayPlayerInfo() {
		System.out.println("Player ID: " + id);
		System.out.println("Player Name: " + name);
		System.out.println("Player Score: " + score);
	}
	/**
	method to load playerdata from database into Player1 class
	 loads the kitchen_database to do this
	 */
	public void loadPlayerData(int playerId) {


		try {
			// Use EmbeddedDataSource to establish a connection to the database
			EmbeddedDataSource ds = new EmbeddedDataSource();
			ds.setDatabaseName("kitchen_database");

			try (Connection connection = ds.getConnection()) {
				// Fetch player data from the Players table
				String sql = "SELECT id, name, score FROM Players WHERE id = ?";
				try (PreparedStatement statement = connection.prepareStatement(sql)) {
					statement.setInt(1, playerId);

					try (ResultSet resultSet = statement.executeQuery()) {
						if (resultSet.next()) {
							// Populate the Player1 object with retrieved data
							this.id = resultSet.getInt("id");
							this.name = resultSet.getString("name");
							this.score = resultSet.getInt("score");
						}
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * The main method starts the program and accepts user input.
	 * After input is received, it is passed to the ReviewInput method.
	 * If quit is entered, the program stops.
	 *
	 * @param args
	 * @throws IOException
	 */
	//Begins the game and calls the class to review player input
	public static void main(String[] args) throws IOException {

	/**
 	* Assumes that we only have 1 player to load.
	 * instantiates the Player class and calls the loadPlayerData method and displays that data using the displayPlayerinfo method.
 	*/
		int playerIdToLoad = 1;
		Player1 player = new Player1();

		// Load player data from the database
		player.loadPlayerData(playerIdToLoad);

		// Display player information
		player.displayPlayerInfo();



/**Scanner in = new Scanner(System.in);**/
		BufferedReader in;
		String input;
		String output;
		System.out.println("Welcome to the text-based adventure game. You are a chef at an Italian restaurant. A customer ordered a plate of spaghetti. ");
		System.out.println("The ingredients for this dish are noodles, sauce, and meat. You are in the kitchen, and you may enter the pantry, dining room, or freezer. ");
		System.out.println("What do you do?");

		/**String a = in.nextLine();**/
		in = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.println("> ");
			input = in.readLine();
			output = ReviewInput(input);

			System.out.println(output);
		} while (!"quit".equals(input));

	}

	/**
	 * This is the next method after the user enters input.
	 * It checks to make sure something was entered, otherwise it sends a message to the user.
	 * If something was entered, the WorldList method is called and splits the input into individual words.
	 * Then these words are passed into the ParseVerbNoun method to check if the words are in the lists/enums.
	 * After these methods run, this method asks the user for the next input and the process runs again.
	 *
	 * @param inputstr
	 * @return
	 */
	public static String ReviewInput(String inputstr) {
		List<String> wordlist;
		String next = "What do you do next?";
		String lowstr = inputstr.trim().toLowerCase();

		if (lowstr.equals("")) {
			next = "You must enter a command";
		} else {
			wordlist = WordList(lowstr);

			ParseVerbNoun(wordlist);
		}
		return next;
	}

	/**
	 * This method takes the user's input and deliminates the words by spaces.
	 * It then puts the individual words in an array.
	 * This utilizes the string tokenizer import to identify the words as they are deliminated by the spaces.
	 *
	 * @param input
	 * @return
	 */
	public static List<String> WordList(String input) {
		String delims = " ";
		List<String> stringList = new ArrayList<>();
		StringTokenizer word = new StringTokenizer(input, delims);
		String w;

		while (word.hasMoreTokens()) {
			w = word.nextToken();
			stringList.add(w);
		}
		return stringList;
	}

	/**
	 * The ParseVerbNoun method is called in the ReviewInput method after input is found and the WordList method
	 * splits the input into words. This method checks to make sure the input words are in the list/enum.
	 * If there are more than 2 words in the array, it throws an error.
	 * Position 0 in the array is the verb, and position 1 is the noun.
	 *
	 * @param wordlist
	 */
	public static void ParseVerbNoun(List<String> wordlist) {
		String verb;
		String noun;
		String quit;
		/** These arrays should direct to the enums once these are built out**/
		List<String> verbs = new ArrayList<>(Arrays.asList("take", "drop"));
		List<String> nouns = new ArrayList<>(Arrays.asList("knife", "spoon", "bowl", "plate"));
		if (wordlist.size() > 2) {
			System.out.println("Please enter a 2 word command.");
		} else {
			verb = wordlist.get(0);
			if (verb.equals("quit")) {
				System.out.println("Goodbye.");
			} else {

				if (!verbs.contains(verb)) {
					System.out.println("Sorry, " + verb + " is not a known verb.");
				} else {
					noun = wordlist.get(1);
					if (!nouns.contains(noun)) {
						System.out.println("Sorry, " + noun + " is not a known noun.");

					} else {
						System.out.println("You selected: " + verb + " " + noun + ".");
						/**System.out.println("What do you do next?");**/
					}
				}
			}
		}
	}


}