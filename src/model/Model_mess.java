
package model;


public class Model_mess {

    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Model_mess(boolean action, String message) {
        this.action = action;
        this.message = message;
    }

    
    
    public Model_mess() {
    }
    
    
   private boolean action;
   private String message;
}
