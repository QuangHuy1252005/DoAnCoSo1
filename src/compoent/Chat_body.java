
package compoent;

import app.MessageType;
import java.awt.Adjustable;
import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.Icon;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import model.Model_recive_message;
import model.Model_send_message;
import net.miginfocom.swing.MigLayout;
import swing.SrollBar;


public class Chat_body extends javax.swing.JPanel {

    public Chat_body() {
        initComponents();
        init();

    }

 private void init() {
    body.setLayout(new MigLayout("fillx","","5[]5"));
    sp.setVerticalScrollBar(new SrollBar());
    sp.getVerticalScrollBar().setBackground(Color.white);

 }
 public void addItemLeft(Model_recive_message data) {
    if(data.getMessageType() == MessageType.TEXT){
         Chat_left item = new Chat_left();
     item.setText(data.getText());
     item.setTime();
     //item.setUserProfile(user);//thêm tên vào đoạn chat
     body.add(item,"wrap, w 100::80%");// đoạn lệnh làm cho phần tử không vượt quá 80% nếu quá nó sẽ tự xuống dòng
    } else if(data.getMessageType() == MessageType.EMOJI){
         Chat_left item = new Chat_left();
     item.setEmoji(Emoj.Emogi.getInstance().getImoji(Integer.valueOf(data.getText())).getIcon());
     item.setTime();
     //item.setUserProfile(user);//thêm tên vào đoạn chat
     body.add(item,"wrap, w 100::80%");// đoạn lệnh làm cho phần tử không vượt quá 80% nếu quá nó sẽ tự xuống dòng
    } else if(data.getMessageType() == MessageType.IMAGE){
              Chat_left item = new Chat_left();
     item.setText("");
     item.setImage(data.getDataImage());
     item.setTime();
      body.add(item,"wrap, w 100::80%");// đoạn lệnh làm cho phần tử không vượt quá 80% nếu quá nó sẽ tự xuống dòng
    }
   repaint();
    revalidate();
 }
 
 
  public void addItemLeft(String text, String user, String[] image) {
     Chat_left_With_profile item = new Chat_left_With_profile();
     item.setText(text);
     item.setImage(image);
     item.setTime();
     //item.setUserProfile(user);//thêm tên vào đoạn chat
     body.add(item,"wrap, w 100::80%");// đoạn lệnh làm cho phần tử không vượt quá 80% nếu quá nó sẽ tự xuống dòng
     body.repaint();
     body.revalidate();
 }
 
 public void addItemRight(Model_send_message data) {
      if(data.getMessageType() == MessageType.TEXT){
            Chat_right item = new Chat_right();
     item.setText(data.getText());
      item.setTime();
     body.add(item,"wrap,al right, w 100::80%");// đoạn lệnh làm cho phần tử không vượt quá 80% nếu quá nó sẽ tự xuống dòng(bên phải)
   
    
      } else if(data.getMessageType() == MessageType.EMOJI){
            Chat_right item = new Chat_right();
     item.setEmoji(Emoj.Emogi.getInstance().getImoji(Integer.valueOf(data.getText())).getIcon());
      item.setTime();
     body.add(item,"wrap,al right, w 100::80%");// đoạn lệnh làm cho phần tử không vượt quá 80% nếu quá nó sẽ tự xuống dòng(bên phải)
   
    
      }  else if(data.getMessageType() == MessageType.IMAGE){
                 Chat_right item = new Chat_right();
                 item.setText("");
                 item.setImage(data.getFile());
                 item.setTime();
    
     body.add(item,"wrap,al right, w 100::80%");// đoạn lệnh làm cho phần tử không vượt quá 80% nếu quá nó sẽ tự xuống dòng(bên phải)
   
     
      }
      repaint();//yêu cầu việc vẽ lại
     revalidate();//yêu cầu việc cập nhật lại
     scrollToBottom();
 }
 
 
 
  public void addItemFileRight(String text, String fileName, String fileSize) {
     Chat_right item = new Chat_right();
      item.setText(text);
     item.setFile(fileName, fileSize);
     body.add(item,"wrap,al right, w 100::80%");// đoạn lệnh làm cho phần tử không vượt quá 80% nếu quá nó sẽ tự xuống dòng(bên phải)
     body.repaint();//yêu cầu việc vẽ lại
     body.revalidate();//yêu cầu việc cập nhật lại
 }
 
   public void addItemFile(String text, String user, String fileName, String fileSize) {
     Chat_left_With_profile item = new Chat_left_With_profile();
    
     item.setText(text);
     item.setFile(fileName,fileSize);
     item.setTime();
     item.setUserProfile(user);//thêm tên vào đoạn chat
     body.add(item,"wrap, w 100::80%");// đoạn lệnh làm cho phần tử không vượt quá 80% nếu quá nó sẽ tự xuống dòng
     body.repaint();
     body.revalidate();
 }
 
 public void addDate(String date) {
     Chat_Date item = new Chat_Date();
     item.setDate(date);
     body.add(item, "wrap, al center");
       body.repaint();
     body.revalidate();
 }
 
 public void clearChat(){
     body.removeAll();
     repaint();
     revalidate();
 }
 
    @SuppressWarnings("unchecked")
    private void scrollToBottom() {
    JScrollBar verticalBar = sp.getVerticalScrollBar();
    AdjustmentListener downScroller = new AdjustmentListener() {
        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {
            Adjustable adjustable = e.getAdjustable();
            adjustable.setValue(adjustable.getMaximum());
            verticalBar.removeAdjustmentListener(this);
        }
    };
    verticalBar.addAdjustmentListener(downScroller);
}
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        body = new javax.swing.JPanel();

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        body.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 691, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );

        sp.setViewportView(body);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
