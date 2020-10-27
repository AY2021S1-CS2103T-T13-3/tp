package seedu.address.model.schedule;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.model.CheckExisting;
import seedu.address.model.client.Client;
import seedu.address.model.session.ExerciseType;
import seedu.address.model.session.Interval;
import seedu.address.model.session.Session;

public class Schedule implements CheckExisting<Schedule>, Comparable<Schedule> {
    private Client client;
    private Session session;
    private PaymentStatus paymentStatus;
    private Remark remark;
    private Weight weight;

    /**
     * Every field must be present and not null.
     */
    public Schedule(Client client, Session session, PaymentStatus paymentStatus, Remark remark, Weight weight) {
        requireAllNonNull(client, session);
        this.client = client;
        this.session = session;
        this.paymentStatus = paymentStatus;
        this.remark = remark;
        this.weight = weight;
    }

    /**
     * Every field must be present and not null. payment is set to not paid. remark is set to an empty string
     */
    public Schedule(Client client, Session session) {
        requireAllNonNull(client, session);
        this.client = client;
        this.session = session;
        this.paymentStatus = PaymentStatus.PAYMENT_STATUS_UNPAID;
        this.remark = Remark.EMPTY_REMARK;
        this.weight = Weight.getDefaultWeight();
    }

    public Client getClient() {
        return client;
    }

    public Session getSession() {
        return session;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public boolean isPaid() {
        return paymentStatus.isPaid();
    }

    public Remark getRemark() {
        return remark;
    }

    public Weight getWeight() {
        return weight;
    }

    public ExerciseType getExerciseType() {
        return session.getExerciseType();
    }

    public Interval getInterval() {
        return session.getInterval();
    }

    public Schedule setClient(Client newClient) {
        return new Schedule(newClient, this.session, this.paymentStatus, this.remark, this.weight);
    }

    public Schedule setSession(Session newSession) {
        return new Schedule(this.client, newSession, this.paymentStatus, this.remark, this.weight);
    }

    /**
     * Returns true if both Schedules have the same identity.
     */
    @Override
    public boolean isUnique(Schedule otherSchedule) {
        if (otherSchedule == this) {
            return true;
        }

        if (otherSchedule == null) {
            return false;
        }

        return otherSchedule.client.equals(this.client) && otherSchedule.session.equals(this.session);
    }

    /**
     * Returns true if both Schedule have the same identity.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Schedule)) {
            return false;
        }

        Schedule otherSchedule = (Schedule) other;
        return otherSchedule.client.equals(this.client) && otherSchedule.session.equals(this.session)
                && otherSchedule.paymentStatus.equals(paymentStatus) && otherSchedule.remark.equals(this.remark)
                && otherSchedule.weight.equals(weight);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(client, session);
    }

    @Override
    public int compareTo(Schedule other) {
        return this.getSession().compareTo(other.getSession());
    }

    @Override
    public String toString() {
        String paymentStatusString = "Payment status: " + paymentStatus;
        String remarkPresent = !remark.equals(Remark.EMPTY_REMARK) ? "Remark: " + remark : "";
        String weightPresent = Weight.isValidWeight(weight) ? "Weight: " + weight : "";
        return "Client "
                + client
                + "\n"
                + " with session "
                + session
                + "\n"
                + paymentStatusString
                + "\n"
                + remarkPresent
                + "\n"
                + weightPresent;
    }
}
