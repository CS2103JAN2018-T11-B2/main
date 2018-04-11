package seedu.address.logic.commands;

/**
 * Attempts to log in user with given Username and Password
 */
public class LoginCommand extends Command {

    public static final String COMMAND_WORD = "login";

    public static final String MESSAGE_LOGIN_FAILURE = "Login failed. Username and/or Password entered incorrectly.";
    public static final String MESSAGE_LOGIN_SUCCESS = "Login Success";
    public static final String MESSAGE_ALREADY_LOGGED_IN = "You are already logged in. Please logout before " +
            "attempting to login with another account.";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Logs in with your username and password to gain "
            + "access to the Prison Book.\n"
            + "Parameters: user/YOUR_USERNAME pw/YOUR_PASSWORD...\n"
            + "Example: " + COMMAND_WORD + " user/prisonwarden99 pw/password1";

    private final String username;
    private final String password;

    public LoginCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public CommandResult execute() {
        if (model.checkIsLoggedIn()){
            return new CommandResult(MESSAGE_ALREADY_LOGGED_IN);
        }
        if (!model.attemptLogin(username, password)) {
            return new CommandResult(MESSAGE_LOGIN_FAILURE);
        } else {
            return new CommandResult(MESSAGE_LOGIN_SUCCESS);
        }
    }

}
