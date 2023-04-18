public class ReceiptDetails {
    private Booking booking;
    private Extra[] extra;

    public Booking getBooking() {
        return booking;
    }

    public Extra[] getExtra() {
        return extra;
    }

    public int calculatePrice() {
        int result = booking.getRoom().getProperty().getPrice();
        for (Extra i : extra) {
            result += (i.getPrice() * i.getQuantity());
        }
        return result;
    }
}
