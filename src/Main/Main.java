//đã sửa
package Main;

import Event.EventImageView;
import Event.EventMain;
import Event.PublicEvent;

//import io.socket.emitter.Emitter;


//import java.util.logging.Level;
//import java.util.logging.Logger;



import model.Model_User_account;
import swing.ComponentResizer;




import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


//public class Main extends javax.swing.JFrame {
//
// 
//    public Main() {
//        initComponents();
//        init();
//    }
//    private void init() {
//        setIconImage(new ImageIcon(getClass().getResource("/icon/icon.png")).getImage());
//        ComponentResizer com = new ComponentResizer();
//        com.registerComponent(this);
//        com.setMinimumSize(new Dimension(900, 500));
//        com.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
//        com.setSnapSize(new Dimension(10, 10));
//         login1.setVisible(true);
//          loaddding1.setVisible(false);
//        view_image.setVisible(false);
//        home.setVisible(false);
//        initEvent();
//        service.Service.getInstance().startServer();
//    }
//        
//    
//    private void initEvent(){
//        PublicEvent.getInstance().addEventMain(new EventMain() {
//            @Override
//            public void showLoading(boolean show) {
//                
//               loaddding1.setVisible(show);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//                }
//               }
//
//            @Override
//            public void initChat() {
//                home.setVisible(true);
//                login1.setVisible(false);
//          
//                service.Service.getInstance().getClient().emit("list_user", service.Service.getInstance().getUser().getUserID());
//            }
//
//            @Override
//            public void selectUser(Model_User_account user) {
//           home.setUser(user);
//            }
//
//            @Override
//            public void updateUser(Model_User_account user) {
//          home.updateUser(user);
//            }
//            
//            
//        });
//            PublicEvent.getInstance().addEventImageView(new EventImageView() {
//                @Override
//                public void viewImage(Icon image) {
//                    view_image.viewImage(image);
//                }
//
//                @Override
//                public void saveImage(Icon image) {
//                    System.out.println("save image update next");
//                    }
//                
//                 
//            });
//            
//            
//    }\






public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        init();
    }

    private void init() {
        setIconImage(new ImageIcon(getClass().getResource("/icon/icon.png")).getImage());
        ComponentResizer com = new ComponentResizer();
        com.registerComponent(this);
        com.setMinimumSize(new Dimension(900, 500));
        com.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        com.setSnapSize(new Dimension(10, 10));
        login1.setVisible(true);
        loaddding1.setVisible(false);
        view_image.setVisible(false);
        home.setVisible(false);
        initEvent();
        service.Service.getInstance().startServer();
    }

    private void initEvent() {
        PublicEvent.getInstance().addEventMain(new EventMain() {
            @Override
            public void showLoading(boolean show) {
                loaddding1.setVisible(show);
            }

            @Override
            public void initChat() {
                home.setVisible(true);
                login1.setVisible(false);
                service.Service.getInstance().getClient().emit("list_user", service.Service.getInstance().getUser().getUserID());
            }

            @Override
            public void selectUser(Model_User_account user) {
                home.setUser(user);
            }

            @Override
            public void updateUser(Model_User_account user) {
                home.updateUser(user);
            }

        });
        PublicEvent.getInstance().addEventImageView(new EventImageView() {
            @Override
            public void viewImage(Icon image) {
                view_image.viewImage(image);
            }

            @Override
            public void saveImage(Icon image) {
                System.out.println("Save Image next update");
            }

        });
    }
    

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boder = new javax.swing.JPanel();
        background = new javax.swing.JPanel();
        title = new javax.swing.JPanel();
        cmdMinizine = new javax.swing.JButton();
        cmdClose = new javax.swing.JButton();
        body = new javax.swing.JLayeredPane();
        login1 = new form.Login();
        view_image = new form.View_image();
        home = new form.home();
        loaddding1 = new form.loaddding();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        boder.setBackground(new java.awt.Color(229, 229, 229));

        background.setBackground(new java.awt.Color(255, 255, 255));

        title.setBackground(new java.awt.Color(229, 229, 229));
        title.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                titleMouseDragged(evt);
            }
        });
        title.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titleMousePressed(evt);
            }
        });

        cmdMinizine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/mize.png"))); // NOI18N
        cmdMinizine.setBorder(null);
        cmdMinizine.setContentAreaFilled(false);
        cmdMinizine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMinizineActionPerformed(evt);
            }
        });

        cmdClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close1.png"))); // NOI18N
        cmdClose.setBorder(null);
        cmdClose.setContentAreaFilled(false);
        cmdClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout titleLayout = new javax.swing.GroupLayout(title);
        title.setLayout(titleLayout);
        titleLayout.setHorizontalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cmdMinizine)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdClose))
        );
        titleLayout.setVerticalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmdMinizine, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
            .addComponent(cmdClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        body.setLayout(new java.awt.CardLayout());
        body.add(login1, "card4");
        body.setLayer(view_image, javax.swing.JLayeredPane.POPUP_LAYER);
        body.add(view_image, "card3");
        body.add(home, "card2");
        body.add(loaddding1, "card5");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
                .addContainerGap())
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout boderLayout = new javax.swing.GroupLayout(boder);
        boder.setLayout(boderLayout);
        boderLayout.setHorizontalGroup(
            boderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boderLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        boderLayout.setVerticalGroup(
            boderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boderLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(boder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(boder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
  private  int pX;
  private  int pY;
    private void titleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleMouseDragged
                           
        this.setLocation(this.getLocation().x + evt.getX() - pX, this.getLocation().y + evt.getY() - pY);                               
    }//GEN-LAST:event_titleMouseDragged

    private void titleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleMousePressed
        pX = evt.getX();
        pY = evt.getY();
    }//GEN-LAST:event_titleMousePressed

    private void cmdMinizineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMinizineActionPerformed
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_cmdMinizineActionPerformed

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
System.exit(0);
    }//GEN-LAST:event_cmdCloseActionPerformed

  
    public static void main(String args[]) {
        FlatArcIJTheme.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel boder;
    private javax.swing.JLayeredPane body;
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdMinizine;
    private form.home home;
    private form.loaddding loaddding1;
    private form.Login login1;
    private javax.swing.JPanel title;
    private form.View_image view_image;
    // End of variables declaration//GEN-END:variables
}
