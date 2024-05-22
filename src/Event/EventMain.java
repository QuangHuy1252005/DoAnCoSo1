//đã xem
package Event;

import model.Model_User_account;


public interface EventMain {
    public void showLoading(boolean  show);
    public void initChat();
    public void selectUser(Model_User_account user);
    public void updateUser(Model_User_account user);
}
