package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.session.Session;
import seedu.address.model.session.UniqueScheduleList;

public class ScheduleList implements ReadOnlyScheduleList {

    private final UniqueScheduleList sessions;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        sessions = new UniqueScheduleList();
    }

    public ScheduleList() {}

    /**
     * Creates an ScheduleList using the Sessions in the {@code toBeCopied}
     */
    public ScheduleList(ReadOnlyScheduleList toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the Session list with {@code Session}.
     * {@code Sessions} must not contain duplicate Sessions.
     */
    public void setSessions(List<Session> sessions) {
        this.sessions.setSessions(sessions);
    }

    /**
     * Resets the existing data of this {@code ScheduleList} with {@code newData}.
     */
    public void resetData(ReadOnlyScheduleList newData) {
        requireNonNull(newData);

        setSessions(newData.getScheduleList());
    }

    //// Client-level operations

    /**
     * Returns true if a Session with the same identity as {@code Session} exists in the address book.
     */
    public boolean hasSession(Session session) {
        requireNonNull(session);
        return sessions.contains(session);
    }

    /**
     * Adds a Session to the schedule list.
     * The Session must not already exist in the schedule list.
     */
    public void addSession(Session s) {
        sessions.add(s);
    }

    /**
     * Replaces the given Session {@code target} in the list with {@code editedSession}.
     * {@code target} must exist in the address book.
     * The Session identity of {@code editedSession} must not be the same as another existing Session.
     */
    public void setSession(Session target, Session editedSession) {
        requireNonNull(editedSession);

        sessions.setSession(target, editedSession);
    }

    /**
     * Removes {@code key} from this {@code ScheduleList}.
     * {@code key} must exist in the schedule list.
     */
    public void removeSession(Session key) {
        sessions.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return sessions.asUnmodifiableObservableList().size() + " Sessions";
        // TODO: refine later
    }

    @Override
    public ObservableList<Session> getScheduleList() {
        return sessions.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ScheduleList // instanceof handles nulls
                && sessions.equals(((ScheduleList) other).sessions));
    }

    @Override
    public int hashCode() {
        return sessions.hashCode();
    }
}