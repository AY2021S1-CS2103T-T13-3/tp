package seedu.address.logic.parser.schedule;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.ParserUtil.parseIndex;
import static seedu.address.logic.parser.schedule.CliSyntax.PREFIX_END_TIME;
import static seedu.address.logic.parser.schedule.CliSyntax.PREFIX_PAYMENT_STATUS;
import static seedu.address.logic.parser.schedule.CliSyntax.PREFIX_START_TIME;

import java.util.stream.Stream;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.schedule.EditPaymentCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.session.SessionParserUtil;
import seedu.address.model.schedule.PaymentStatus;
import seedu.address.model.session.Interval;

public class EditPaymentCommandParser implements Parser<EditPaymentCommand> {
    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

    /**
     * Parses the given {@code String} of arguments in the context of the EditSessionCommand
     * and returns an EditSessionCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditPaymentCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_PAYMENT_STATUS, PREFIX_START_TIME, PREFIX_END_TIME);

        Index clientIndex;

        if (!arePrefixesPresent(argMultimap, PREFIX_PAYMENT_STATUS, PREFIX_START_TIME, PREFIX_START_TIME)
                || argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditPaymentCommand.MESSAGE_USAGE));
        }

        try {
            clientIndex = parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    EditPaymentCommand.MESSAGE_USAGE), pe);
        }

        Interval interval = SessionParserUtil.parseIntervalFromStartAndEnd(
                argMultimap.getValue(PREFIX_START_TIME).get(),
                argMultimap.getValue(PREFIX_END_TIME).get()
        );

        PaymentStatus paymentStatus = ScheduleParserUtil
                .parsePaymentStatus(argMultimap.getValue(PREFIX_PAYMENT_STATUS).get());

        return new EditPaymentCommand(clientIndex, paymentStatus, interval);
    }
}
