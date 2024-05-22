
package model;


import org.json.JSONObject;


public class Model_register {

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Model_register(String usreName, String password) {
        this.userName = usreName;
        this.password = password;
    }

    
    
    public Model_register() {
    }

    private String userName;
   private  String password;


  public JSONObject toJsonObject(){
      try {
          JSONObject json = new JSONObject();
          json.put("userName", userName);
          json.put("password", password);
          return json;
      } catch (Exception e) {
          return null;
      }

  }
 }

 

