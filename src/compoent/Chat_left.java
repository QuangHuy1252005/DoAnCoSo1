
package compoent;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Icon;
import model.Model_Receive_Image;

public class Chat_left extends javax.swing.JLayeredPane {

    public Chat_left() {
        initComponents();
         txt.setBackground(new Color(242,242,242));
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
        // txt.setImage(false, image);
     }
     
     
        public void setImage(Model_Receive_Image dataImage) {
         txt.setImage(false, dataImage);
     }
        
        public void setFile(String fileName, String fileSize){
          txt.setFile(fileName, fileSize);
      }
        
            public void setEmoji(Icon icon){
             txt.hideText();
             txt.setEmoji(false, icon);
         }
      

     public void setTime() {
         txt.setTime("10:30 PM");
     }
     


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new compoent.Chat_item();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private compoent.Chat_item txt;
    // End of variables declaration//GEN-END:variables
}
