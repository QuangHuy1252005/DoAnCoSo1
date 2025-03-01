
package compoent;

import Event.PublicEvent;
import java.awt.Component;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.Icon;
import net.miginfocom.swing.MigLayout;
import swing.Picture_Box;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import model.Model_File_Sender;
import model.Model_Receive_Image;

public class Chat_image extends javax.swing.JLayeredPane {

  
    public Chat_image(boolean right) {
        initComponents();
        setLayout(new MigLayout("","0["+(right ? "right" : "left")+"]0","3[]3"));
    }
    
    public void addImage(Model_File_Sender fileSender) {
          Icon image = new ImageIcon(fileSender.getFile().getAbsolutePath());
           Image_item pic = new Image_item();
            pic.setPreferredSize(new Dimension(getAutoSize(image, 200, 200)));//kích thước ưu tiên
            pic.setImage(image, fileSender);
            addEvent(pic, image);
            add(pic, "wrap");
      
    }
    
      public void addImage(Model_Receive_Image dataImage) {
        
            Image_item pic = new Image_item();
          pic.setPreferredSize(new Dimension( dataImage.getWidth(), dataImage.getHeight()));//kích thước ưu tiên
            pic.setImage(dataImage);
          //  addEvent(pic, image);
            add(pic, "wrap");
        
    }
    
   private void addEvent(Component com, Icon image) {
        com.setCursor(new Cursor(Cursor.HAND_CURSOR));// hiện nút bàn tay ở chuột khi rê vào
        com.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    PublicEvent.getInstance().getEventImageView().viewImage(image);
                }
            }
        });
    }

     private Dimension getAutoSize(Icon image, int w, int h) {
//        int w = getWidth();
//        int h = getHeight();
         if(w> image.getIconWidth()){
            w = image.getIconWidth();
        }
         if(h> image.getIconHeight()){
            h = image.getIconHeight();
        }
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.min(xScale, yScale);
        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
       
        return  new Dimension(width, height);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
