package cz.cvut.fit.dpo.adventure.view;


public class CommandParser {

	static final String EXAMINE = "examine";
	static final String EXIT_TO = "exit";
	static final String PICK_UP = "take";
	static final String DROP = "drop";
	static final String USE_ON = "use";
	// TODO manipulate
	
	static final String LOOK_AROUND = "status";
	
	static final String HELP = "help";
	static final String QUIT = "quit";
	
	public static boolean isNullaryCommand(String command) {
		return (command.startsWith(HELP) ||
				command.startsWith(QUIT) ||
				command.startsWith(LOOK_AROUND));
	}
	
	public static boolean isUnaryCommand(String command) {
		return (command.startsWith(EXAMINE) ||
				command.startsWith(EXIT_TO) ||
				command.startsWith(PICK_UP) ||
				command.startsWith(DROP));
	}
	
	public static boolean isBinaryCommand(String command) {
		return command.startsWith(USE_ON);
	}

}
