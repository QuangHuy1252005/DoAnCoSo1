//đã sửa
package service;

import Event.PublicEvent;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import java.util.List;
import model.Model_File_Receiver;
import model.Model_File_Sender;
import model.Model_User_account;
import model.Model_recive_message;
import model.Model_send_message;










//public class Service {
//
//    private static Service instance;
//    private Socket client;
//
//  
//    private JTextArea textArea;
//    private final int PORT_NUMBER = 1205;
//   private final String IP = "localhost";
//   private Model_User_account user;
//
//   
//
//   
//    public static Service getInstance() {
//        if (instance == null) {
//            instance = new Service();
//        }
//        return instance;
//    }
//
//    private Service() {
//      
//    }
//
//    public void startServer() {
//        try {
//       client = IO.socket("http://" + IP + ":" + PORT_NUMBER);
//       client.on("list_user", new Emitter.Listener() {
//           @Override
//           public void call(Object... os) {
//               List<Model_User_account> users  = new ArrayList<>();
//               for(Object o : os){
//                   Model_User_account userr = new Model_User_account(o);
//                  if(userr.getUserID()!= user.getUserID()){
//                       users.add(userr);
//                  }
//               }
//               PublicEvent.getInstance().getEventMenuLeft().newUser(users);
//               System.out.println("Serviece1  " + Arrays.toString(os));
//               System.out.println("Serviece  "+ users);
//                 System.out.println("Serviece  "+ user.getUserName());
//           }
//       });
//       
//
//       
//       
//       client.on("user_status", new Emitter.Listener() {
//           @Override
//           public void call(Object... os) {
//               int userID = (Integer) os[0];
//               boolean status = (Boolean) os[1];
//               if(status){
//                   PublicEvent.getInstance().getEventMenuLeft().userConect(userID);
//               }else{
//                   PublicEvent.getInstance().getEventMenuLeft().userDisconect(userID);
//               }
//                }
//       });
//       
//       client.on("receive_ms", new Emitter.Listener() {
//           @Override
//           public void call(Object... os) {
//               Model_recive_message message = new Model_recive_message(os[0]);
//               PublicEvent.getInstance().getEventChat().receiVeMessage(message);
//           }
//       });
//       
//       
//       client.open();
//        } catch (URISyntaxException e) {
//            error(e);
//            e.printStackTrace();
//        }
//      }
//    
//    
////   private void updateOnlineStatus(List<Model_User_account> connectedUsers) {
////        PublicEvent.getInstance().getEventMenuLeft().updateOnlineStatus(connectedUsers);
////    }
//      public Socket getClient() {
//        return client;
//    }
//    
//          public Model_User_account getUser() {
//        return user;
//    }
//
//    public void setUser(Model_User_account user) {
//        this.user = user;
//    }
//    private void error(Exception e){
//        System.err.println(e);
//    }
//}



public class Service {

    private static Service instance;
    private Socket client;
    private final int PORT_NUMBER = 1205;
    private final String IP = "localhost";
    private Model_User_account user;
    private  List<Model_File_Sender> fileSender ;
    private List<Model_File_Receiver> fileReceiver;

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    private Service() {
        fileSender = new ArrayList<>();
           fileReceiver = new ArrayList<>();
        
    }

    public void startServer() {
        try {
            client = IO.socket("http://" + IP + ":" + PORT_NUMBER);
            client.on("list_user", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    //  list user
                    List<Model_User_account> users = new ArrayList<>();
                    for (Object o : os) {
                        Model_User_account u = new Model_User_account(o);
                        if (u.getUserID() != user.getUserID()) {
                            users.add(u);
                        }
                    }
                    PublicEvent.getInstance().getEventMenuLeft().newUser(users);
                }
            });
            client.on("user_status", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    int userID = (Integer) os[0];
                    boolean status = (Boolean) os[1];
                    if (status) {
                        //  connect
                        PublicEvent.getInstance().getEventMenuLeft().userConect(userID);
                    } else {
                        //  disconnect
                        PublicEvent.getInstance().getEventMenuLeft().userDisconect(userID);
                    }
                }
            });
            client.on("receive_ms", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    Model_recive_message message = new Model_recive_message(os[0]);
                    PublicEvent.getInstance().getEventChat().receiVeMessage(message);
                }
            });
            client.open();
        } catch (URISyntaxException e) {
            error(e);
        }
    }
    
    
    public  Model_File_Sender addFile(File file, Model_send_message message) throws IOException{
        Model_File_Sender data = new Model_File_Sender(file, client, message);
        message.setFile(data);
        fileSender.add(data);
        if(fileSender.size()==1){
            data.initSend();
    }
        return data;
    }
    
    public void fileSendFinish(Model_File_Sender data)throws  IOException{
        fileSender.remove(data);
        if(!fileSender.isEmpty()){
            fileSender.get(0).initSend();
        }
    }
    
    
     public void fileReceiveFinish(Model_File_Receiver data) throws IOException {
        fileReceiver.remove(data);
        if (!fileReceiver.isEmpty()) {
            fileReceiver.get(0).initReceive();
        }
    }

    public void addFileReceiver(int fileID, Event.EventFileReceiver event) throws IOException {
        Model_File_Receiver data = new Model_File_Receiver(fileID, client, event);
        fileReceiver.add(data);
        if (fileReceiver.size() == 1) {
            data.initReceive();
        }
    }

    public Socket getClient() {
        return client;
    }

    public Model_User_account getUser() {
        return user;
    }

    public void setUser(Model_User_account user) {
        this.user = user;
    }

    private void error(Exception e) {
        System.err.println(e);
    }
}