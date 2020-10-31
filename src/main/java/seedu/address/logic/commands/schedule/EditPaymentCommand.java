package seedu.address.logic.commands.schedule;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.session.CliSyntax.PREFIX_DURATION;
import static seedu.address.logic.parser.session.CliSyntax.PREFIX_EXERCISE_TYPE;
import static seedu.address.logic.parser.session.CliSyntax.PREFIX_GYM;
import static seedu.address.logic.parser.session.CliSyntax.PREFIX_START_TIME;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.commands.session.AddSessionCommand;
import seedu.address.model.Model;
import seedu.address.model.client.Client;
import seedu.address.model.schedule.PaymentStatus;
import seedu.address.model.schedule.Schedule;
import seedu.address.model.session.Interval;
import seedu.address.model.session.Session;

public class EditPaymentCommand extends Command {
    public static final String COMMAND_WORD = "payment";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a Session to FitEgo. "
            + "Parameters: "
            + PREFIX_GYM + "GYM "
            + PREFIX_EXERCISE_TYPE + "EXERCISE_TYPE "
            + PREFIX_START_TIME + "START_TIME "
            + PREFIX_DURATION + "DURATION "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_GYM + "Machoman "
            + PREFIX_EXERCISE_TYPE + "Bodybuilder "
            + PREFIX_START_TIME + "29/09/2020 1600 "
            + PREFIX_DURATION + "120 ";

    public static final String MESSAGE_SUCCESS = "New Session added: %1$s";
    public static final String MESSAGE_DUPLICATE_SESSION = "This Session overlaps with an existing Session in FitEgo";

    private final Index clientIndex;
    private final PaymentStatus paymentStatus;
    private final Interval interval;

    /**
     * Creates an AddSession to add the specified {@code Session}
     */
    public EditPaymentCommand(Index clientIndex, PaymentStatus paymentStatus, Interval interval) {
        requireAllNonNull(clientIndex, paymentStatus, interval);
        this.clientIndex = clientIndex;
        this.paymentStatus = paymentStatus;
        this.interval = interval;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        List<Client> lastShownClientList = model.getFilteredClientList();

        if (clientIndex.getZeroBased() >= lastShownClientList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_CLIENT_DISPLAYED_INDEX);
        }

        Client clientToEdit = lastShownClientList.get(clientIndex.getZeroBased());

        for (Schedule schedule : model.getAddressBook().getScheduleList()) {
            if schedule.getInterval().
        }

        Session sessionToSchedule = lastShownSessionList.get(sessionIndex.getZeroBased());

        if (model.hasAnyScheduleAssociatedWithClientAndSession(clientToSchedule, sessionToSchedule)) {
            throw new CommandException(MESSAGE_DUPLICATE_SCHEDULE);
        }

        Schedule scheduleToAdd = new Schedule(clientToSchedule, sessionToSchedule);
        model.addSchedule(scheduleToAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, scheduleToAdd));
    }

    public static boolean isOverlappingSession(Interval interval1, Interval interval2) {
        if (interval1.getStartTime().isAfter(getStartTime())) {
            // other session start time is > this session start time
            // this session: 2 - 4pm, other session: 4 - 6pm -> do not overlap
            // this session: 2 - 4.01pm, other session: 4 - 6pm -> overlap
            return getEndTime().isAfter(otherSession.getStartTime());
        } else {
            // other session start time is <= this session start time
            return otherSession.getEndTime().isAfter(getStartTime());
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddSessionCommand // instanceof handles nulls
                && toAdd.equals(((AddSessionCommand) other).toAdd));
    }
}
