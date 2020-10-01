package seedu.address.logic.commands.session;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.session.CliSyntax.PREFIX_DURATION;
import static seedu.address.logic.parser.session.CliSyntax.PREFIX_EXERCISE_TYPE;
import static seedu.address.logic.parser.session.CliSyntax.PREFIX_GYM;
import static seedu.address.logic.parser.session.CliSyntax.PREFIX_START_TIME;


import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.session.Session;

/**
 * Adds a session
 */
public class AddSessionCommand extends Command {
    public static final String COMMAND_WORD = "sadd";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a Session to FitEgo. "
            + "Parameters: "
            + PREFIX_GYM + "GYM "
            + PREFIX_EXERCISE_TYPE + "EXERCISE TYPE "
            + PREFIX_START_TIME + "EMAIL "
            + PREFIX_DURATION + "ADDRESS "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_GYM + "Machoman "
            + PREFIX_EXERCISE_TYPE + "Bodybuilder "
            + PREFIX_START_TIME + "29/09/2020 1600 "
            + PREFIX_DURATION + "311, Clementi Ave 2, #02-25 ";

    public static final String MESSAGE_SUCCESS = "New Session added: %1$s";
    public static final String MESSAGE_DUPLICATE_SESSION = "This Session overlaps with an existing Session in FitEgo";

    private final Session toAdd;

    /**
     * Creates an AddSession to add the specified {@code Session}
     */
    public AddSessionCommand(Session session) {
        requireNonNull(session);
        toAdd = session;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasSession(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_SESSION);
        }

        model.addSession(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddSessionCommand // instanceof handles nulls
                && toAdd.equals(((AddSessionCommand) other).toAdd));
    }
}
