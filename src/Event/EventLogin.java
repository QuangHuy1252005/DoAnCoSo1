//đã xem
package Event;

import model.Model_login;
import model.Model_register;


public interface EventLogin {
    public void login(Model_login data);
    public void regster(Model_register data, EventMess message);
     public void goregster();
      public void goLogin();
}
