//dã sửa
package form;

import Event.EventChat;
import Event.PublicEvent;
import compoent.Chat_Bottom;
import compoent.Chat_body;
import compoent.Chat_title;
import model.Model_User_account;
import model.Model_mess;
import model.Model_recive_message;
import model.Model_send_message;
import net.miginfocom.swing.MigLayout;


public class chat extends javax.swing.JPanel {
//private Chat_title chatTitle;
//private Chat_body chatBody;
//private Chat_Bottom chatBotom;
//    public chat() {
//        initComponents();
//        init();
//    }
//     public void init(){
//         setLayout(new MigLayout("fillx","0[fill]0", "0[]0[100%,bottom]0[shrink 0]0"));
//          chatTitle = new Chat_title();
//          chatBody = new Chat_body();
//          chatBotom = new Chat_Bottom();
//         PublicEvent.getInstance().addEventChat(new EventChat() {
//             @Override
//             public void sendMess(Model_send_message data) {
//                 chatBody.addItemRight(data);
//                 }
//
//             @Override
//             public void receiVeMessage(Model_recive_message data) {
//               if(chatTitle.getUser().getUserID() == data.getFromUserID()){
//                     chatBody.addItemLeft(data);
//               }
//             }
//             
//             
//         });
//         add(chatTitle,"wrap");
//          add(chatBody,"wrap");
//           add(chatBotom,"h ::50%");
//         //  chatBody.setVisible(false);
//     }
//     
//         public void setUser(Model_User_account user){
//        chatTitle.setUserName(user);
//        chatBotom.setUser(user);
//        chatBody.clearChat();
//    }
//         
//         public void updateUser(Model_User_account user){
//                  chatTitle.updateUser(user); 
//         }
    
    
    
    
    
     private Chat_title chatTitle;
    private Chat_body chatBody;
    private Chat_Bottom chatBottom;

    public chat() {
        initComponents();
        init();
    }

    private void init() {
        setLayout(new MigLayout("fillx", "0[fill]0", "0[]0[100%, fill]0[shrink 0]0"));
        chatTitle = new Chat_title();
        chatBody = new Chat_body();
        chatBottom = new Chat_Bottom();
        PublicEvent.getInstance().addEventChat(new EventChat() {
     
            public void sendMess(Model_send_message data) {
                chatBody.addItemRight(data);
            }

         
            @Override
            public void receiVeMessage(Model_recive_message data) {
               if (chatTitle.getUser().getUserID() == data.getFromUserID()) {
                    chatBody.addItemLeft(data);
                }
            }
        });
        add(chatTitle, "wrap");
        add(chatBody, "wrap");
        add(chatBottom, "h ::50%");
    }

    public void setUser(Model_User_account user) {
        chatTitle.setUserName(user);
        chatBottom.setUser(user);
        chatBody.clearChat();
    }

    public void updateUser(Model_User_account user) {
        chatTitle.updateUser(user);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
