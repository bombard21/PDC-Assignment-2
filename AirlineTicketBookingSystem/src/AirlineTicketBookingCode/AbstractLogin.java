package AirlineTicketBookingCode;


import java.io.IOException;

public abstract class AbstractLogin {

    protected final User user;

    public AbstractLogin(User user) {
        this.user = user;
    }

    public abstract void register() throws IOException;

    public abstract void login() throws IOException;

    public abstract boolean checkLogin(String username, String password);
}
