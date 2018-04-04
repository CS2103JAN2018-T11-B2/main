package seedu.address.logic.commands;

/**
 * Displays the status of the current session
 */
public class CheckStatusCommand extends Command {

    public static final String COMMAND_WORD = "status";

    public CommandResult execute() {
        String details = (model.getSessionDetails());
        return new CommandResult(details);
    }

}