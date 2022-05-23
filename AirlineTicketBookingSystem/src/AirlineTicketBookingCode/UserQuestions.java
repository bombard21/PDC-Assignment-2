package AirlineTicketBookingCode;

import java.io.IOException;

public interface UserQuestions{
    void askUser();
    void validateDestination() throws IOException;
    void validAirplaneType() throws IOException;
    void validMethodOfTransport() throws IOException;
    void sendToFile() throws IOException;

}
