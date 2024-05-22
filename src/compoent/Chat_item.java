
package compoent;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.EmptyBorder;
import model.Model_File_Sender;
import model.Model_Receive_Image;


public class Chat_item extends javax.swing.JLayeredPane {
private JLabel label;
    public Chat_item() {
        initComponents();
        txt.setEditable(false);
        txt.setBackground(new Color(0,0,0,0));
        txt.setOpaque(false);
    }
    public void setText(String text){
        txt.setText(text);
    }
      public void setUserProfile(String user) {
        JLayeredPane layer = new  JLayeredPane();
        layer.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));//tạo và căn lề phải chứa label ||  0, 0 khoảng cách ngang dọc
        layer.setBorder(new EmptyBorder(10,10,0,10)); //tạo boder trên trái dưới phải
        JButton cmd = new JButton(user);
        cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));// chuyển mũi tên chuột thành bàn tay(chứng tỏ bấm dc)                
        cmd.setBorder(null);
        cmd.setBorderPainted(false);   // 32-tắt việc vẽ viền xung quanh nút JButton
        cmd.setContentAreaFilled(false);//33-tắt việc vẽ nền cho nút JButton.
        cmd.setFocusable(false);// vô hiệu hóa tương tác vì đây là 1 nút button
        cmd.setForeground(new Color(30,121,213));//chỉnh màu cho thành phần
        cmd.setFont(new java.awt.Font("Segoe UI", 1, 14)); //font chữ
        txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        layer.add(cmd);
        add(layer,0);
    }
    
    //set thời gian nhắn
    public void setTime(String time){
        JLayeredPane layer = new  JLayeredPane();
        layer.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));//tạo và căn lề phải chứa label ||  0, 0 khoảng cách ngang dọc
        layer.setBorder(new EmptyBorder(0,5,10,5)); //tạo boder trên trái dưới phải
         label = new JLabel(time);
        label.setForeground(new Color(110,110,110));
        label.setHorizontalTextPosition(JLabel.LEFT);//đưa phần tử sang trái
        layer.add(label);
        add(layer);
    }
    
    public void setImage(boolean right, Model_File_Sender fileSender) {
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(right ? FlowLayout.RIGHT : FlowLayout.LEFT));
         layer.setBorder(new EmptyBorder(0,5,0,5)); //tạo boder trên trái dưới phải
         Chat_image chatimage = new Chat_image(right);
         chatimage.addImage(fileSender);
          layer.add(chatimage);
          add(layer);
    }
    
        public void setImage(boolean right,Model_Receive_Image dataImage) {
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(right ? FlowLayout.RIGHT : FlowLayout.LEFT));
         layer.setBorder(new EmptyBorder(0,5,0,5)); //tạo boder trên trái dưới phải
         Chat_image chatimage = new Chat_image(right);
         chatimage.addImage(dataImage);
          layer.add(chatimage);
          add(layer);
    }
        
        
          public void setFile(String fileName, String fileSize) {
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(FlowLayout.LEFT));
         layer.setBorder(new EmptyBorder(0,5,0,5)); //tạo boder trên trái dưới phải
         Chat_file chatfile= new Chat_file();
         chatfile.setFile(fileName, fileSize);
          layer.add(chatfile);
          add(layer);
    }
          
          
        public void setEmoji(boolean right, Icon icon){
              JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(right ? FlowLayout.RIGHT : FlowLayout.LEFT));
         layer.setBorder(new EmptyBorder(0,5,0,5)); //tạo boder trên trái dưới phải
       
          layer.add(new JLabel(icon));
          add(layer);
            setBackground(null);
        }  
          
    
    public void sendSuccess(){
        if(label != null) {
            label.setIcon(new ImageIcon(getClass().getResource("/icon/tick.png")));
        }
    }

    
     public void send(){
        if(label != null) {
            label.setIcon(new ImageIcon(getClass().getResource("/icon/double_tick.png")));
        }
    }
 
     public void hideText() {
         txt.setVisible(true);
     }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new swing.JIMSendTextPane();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 5, 10));
        txt.setSelectionColor(new java.awt.Color(99, 178, 252));
        add(txt);
    }// </editor-fold>//GEN-END:initComponents
//đoạn mã trên có tác dụng vẽ một hình chữ nhật bo tròn với màu nền của thành phần và vẽ các thành phần con của JComponent
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
      if(getBackground() != null){
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0,0,getWidth(), getHeight(),15,15);
        
      }
        super.paintComponent(g); 
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.JIMSendTextPane txt;
    // End of variables declaration//GEN-END:variables
}
