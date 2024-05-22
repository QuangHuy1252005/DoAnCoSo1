
package compoent;

import Event.EventFileReceiver;
import Event.EventFileSender;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import model.Model_File_Sender;
import model.Model_Receive_Image;
import service.Service;
import swing.burhash.BlurHash;

public class Image_item extends javax.swing.JLayeredPane {


    public Image_item() {
        initComponents();
        
    }
    
    
        public void setImage(Icon image, Model_File_Sender fileSender){
        //decoder
         fileSender.addEvent(new EventFileSender() {
             @Override
             public void onSending(double percentage) {
          progess1.setValue((int) percentage);
             }

             @Override
             public void onStartSending() {
          
             }

             @Override
             public void onFinish() {
           progess1.setVisible(false);
             }
         });
        picture_Box1.setImage(image);
    }

    public void setImage(Model_Receive_Image dataImage){
        //decoder
        int width = dataImage.getWidth();
        int height = dataImage.getHeight();
int[] data = BlurHash.decode(dataImage.getImage(), width, height, 1);
BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
img.setRGB(0, 0, width, height, data, 0, width);
        Icon icon = new ImageIcon(img);
        picture_Box1.setImage(icon);
        
        try {
            Service.getInstance().addFileReceiver(dataImage.getFileID(), new EventFileReceiver() {
                @Override
                public void onReceiving(double percentage) {
                    progess1.setValue((int) percentage);
                }

                @Override
                public void onStartReceiving() {

                }

                @Override
                public void onFinish(File file) {
                    progess1.setVisible(false);
                    picture_Box1.setImage(new ImageIcon(file.getAbsolutePath()));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        picture_Box1 = new swing.Picture_Box();
        progess1 = new swing.Progess();

        setBackground(new java.awt.Color(209, 209, 209));

        picture_Box1.setBackground(new java.awt.Color(209, 209, 209));

        progess1.setBorder(null);
        progess1.setForeground(new java.awt.Color(255, 255, 255));
        progess1.setProgressType(swing.Progess.ProgressType.CANCEL);

        picture_Box1.setLayer(progess1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout picture_Box1Layout = new javax.swing.GroupLayout(picture_Box1);
        picture_Box1.setLayout(picture_Box1Layout);
        picture_Box1Layout.setHorizontalGroup(
            picture_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(picture_Box1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(progess1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        picture_Box1Layout.setVerticalGroup(
            picture_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(picture_Box1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(progess1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        setLayer(picture_Box1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(picture_Box1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(picture_Box1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Picture_Box picture_Box1;
    private swing.Progess progess1;
    // End of variables declaration//GEN-END:variables
}
