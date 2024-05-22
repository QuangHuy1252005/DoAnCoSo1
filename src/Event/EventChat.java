//đã xem
package Event;


import model.Model_recive_message;
import model.Model_send_message;


public interface EventChat {
    public void sendMess(Model_send_message data);
    public void receiVeMessage(Model_recive_message data);
}
