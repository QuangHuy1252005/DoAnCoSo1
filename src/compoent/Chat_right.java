
package compoent;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Icon;
import model.Model_File_Sender;

public class Chat_right extends javax.swing.JLayeredPane {

    public Chat_right() {
        initComponents();
        txt.setBackground(new Color(179,233,255));
    }
 
     public void setText(String text) {
        if(text.equals("" )){
            txt.hideText();
           }
        else {
            txt.setText(text);
        }
        txt.send();
       }
  
     public void setImage(Model_File_Sender fileSender) {
         txt.setImage(true, fileSender);
     }
     
     
        public void setImage(String... image) {
        // txt.setImage(false, image);
     }

         public void setFile(String fileName, String fileSize){
          txt.setFile(fileName, fileSize);
      }
      
         
         public void setEmoji(Icon icon){
             txt.hideText();
             txt.setEmoji(true, icon);
         }
        
     public void setTime() {
         txt.setTime("10:30 PM");
     }
     


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new compoent.Chat_item();

        setLayer(txt, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
