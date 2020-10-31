package seedu.address.logic.commands.schedule;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.schedule.CliSyntax.PREFIX_END_TIME;
import static seedu.address.logic.parser.schedule.CliSyntax.PREFIX_PAYMENT_STATUS;
import static seedu.address.logic.parser.schedule.CliSyntax.PREFIX_START_TIME;

import java.util.List;
import java.util.function.Supplier;

import javafx.scene.layout.AnchorPane;
import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.client.Client;
import seedu.address.model.schedule.PaymentStatus;
import seedu.address.model.schedule.Schedule;
import seedu.address.model.session.Interval;
import seedu.address.ui.ClientInfoPage;

public class EditPaymentCommand extends Command {
    public static final String COMMAND_WORD = "payment";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Update payment status of the schedules "
            + "associated with the specified client and overlaps with the specified start and end time.\n"
            + "Parameters: "
            + "CLIENT_INDEX (must be a positive integer)"
            + PREFIX_PAYMENT_STATUS + "PAYMENT_STATUS (either paid or unpaid) "
            + PREFIX_START_TIME + "START_TIME "
            + PREFIX_END_TIME + "END_TIME "
            + "Example: " + COMMAND_WORD + " "
            + "1 "
            + PREFIX_PAYMENT_STATUS + "unpaid "
            + PREFIX_START_TIME + "29/09/2020 1600 "
            + PREFIX_END_TIME + "11/10/2020 1700";

    public static final String MESSAGE_SUCCESS = "The payment status of the scheduled contained in the interval"
            + " (if any) is updated!";

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
            if (schedule.getClient().equals(clientToEdit) && Interval.isOverlap(interval, schedule.getInterval())) {
                model.setSchedule(schedule, schedule.setPaymentStatus(paymentStatus));
            }
        }

        List<Schedule> scheduleByClient = model.findScheduleByClient(clientToEdit);

        Supplier<AnchorPane> mainWindowSupplier = () -> {
            ClientInfoPage cip = ClientInfoPage.getClientInfoPage(clientToEdit, scheduleByClient,
                    model.getPreferredWeightUnit());
            return cip.getRoot();
        };

        return new CommandResult(String.format(MESSAGE_SUCCESS), mainWindowSupplier);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof EditPaymentCommand // instanceof handles nulls
                && clientIndex.equals(((EditPaymentCommand) other).clientIndex)
                && paymentStatus.equals(((EditPaymentCommand) other).paymentStatus)
                && interval.equals(((EditPaymentCommand) other).interval));
    }
}
