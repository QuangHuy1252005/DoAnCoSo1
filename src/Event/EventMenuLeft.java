//đã xem
package Event;

import java.util.List;
import model.Model_User_account;

public interface EventMenuLeft {
 public void newUser(List<Model_User_account> users);
 public void userConect(int userID);
 public void userDisconect(int userID);

}
