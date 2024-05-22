
package compoent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.Icon;
//tạo ô chứa avata trên đoạn chat
public class Chat_left_With_profile extends javax.swing.JLayeredPane {

    public Chat_left_With_profile() {
        initComponents();
         txt.setBackground(new Color(242,242,242));
    }
    
    public void setUserProfile(String user) {
        txt.setUserProfile(user);
    }
    
      public void setImageProfile(Icon image) {
          image_one.setImage(image);
      }
    
    public void setText(String text) {
        if(text.equals("" )){
            txt.hideText();
           }
        else {
            txt.setText(text);
        }
       }
  
     public void setImage(Icon... image) {
     //    txt.setImage(false, image);
     }
     
     
      public void setImage(String... image) {
     //    txt.setImage(false, image);
     }
      
      public void setFile(String fileName, String fileSize){
          txt.setFile(fileName, fileSize);
      }
      

     public void setTime() {
         txt.setTime("10:30 PM");
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        image_one = new swing.ImageAvata();
        txt = new compoent.Chat_item();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        image_one.setBorderSize(0);
        image_one.setImage(new javax.swing.ImageIcon(getClass().getResource("/icon/avatar_anime_1.png"))); // NOI18N
        image_one.setMinimumSize(new java.awt.Dimension(31, 31));
        image_one.setPreferredSize(new java.awt.Dimension(31, 31));

        javax.swing.GroupLayout image_oneLayout = new javax.swing.GroupLayout(image_one);
        image_one.setLayout(image_oneLayout);
        image_oneLayout.setHorizontalGroup(
            image_oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );
        image_oneLayout.setVerticalGroup(
            image_oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jLayeredPane1.setLayer(image_one, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(image_one, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(image_one, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        add(jLayeredPane1);
        add(txt);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ImageAvata image_one;
    private javax.swing.JLayeredPane jLayeredPane1;
    private compoent.Chat_item txt;
    // End of variables declaration//GEN-END:variables
}
