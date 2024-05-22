//đã sửa
package compoent;

import Event.PublicEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Model_User_account;


//public class item_People extends javax.swing.JPanel {
//   public Model_User_account getUser(){
//       return user;
//   }
//   private boolean moseOver;
//   private final Model_User_account user;
//  
//
//   
////    public item_People(Model_User_account user) {
////
////initComponents();
////    this.user = user; // Gán giá trị của user từ tham số được truyền vào
////    jLabel1.setText(user.getUserName());
////    activeStatus.setActive(user.isStatus());
////    init();
////    }
//    public item_People(Model_User_account user) {
//        this.user = user;
//        initComponents();
//        jLabel1.setText(user.getUserName());
//       activeStatus.setActive(user.isStatus());
//      // activeStatus.setActive(true);
//        System.out.println("xác định" + user.isStatus());
//      
//        init();
//    }
//   public void updateStatus() {
//        activeStatus.setActive(user.isStatus());
//          revalidate();
//          repaint();
//    }
//    
//    
//public void init() {
//    addMouseListener(new MouseAdapter() {
//        @Override
//        public void mouseEntered(MouseEvent e) {
//             setBackground(new Color(230,230,230));
//             moseOver = true;
//        }
//
//        @Override
//        public void mouseExited(MouseEvent e) {
//             setBackground(new Color(242,242,242));
//                  moseOver = false;
//        }
//
//        @Override
//        public void mouseReleased(MouseEvent e) {
//        if(moseOver){
//            PublicEvent.getInstance().getEventMain().selectUser(user);
//        }
//        }
//        
//        
//        
//        
//    });
//}



public class item_People extends javax.swing.JPanel {

    public Model_User_account getUser() {
        return user;
    }
    private boolean mouseOver;
    private final Model_User_account user;

    public item_People(Model_User_account user) {
        this.user = user;
        initComponents();
        jLabel1.setText(user.getUserName());
        activeStatus.setActive(user.isStatus());
        init();
    }

    public void updateStatus() {
        activeStatus.setActive(user.isStatus());
    }

    private void init() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(new Color(230, 230, 230));
                mouseOver = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(new Color(242, 242, 242));
                mouseOver = false;
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (mouseOver) {
                    PublicEvent.getInstance().getEventMain().selectUser(user);
                }
            }
        });
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvata1 = new swing.ImageAvata();
        jLabel1 = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        activeStatus = new swing.ActiveStatus();

        imageAvata1.setBorderSize(0);
        imageAvata1.setImage(new javax.swing.ImageIcon(getClass().getResource("/icon/profile.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Name");

        lbStatus.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(140, 138, 138));
        lbStatus.setText("new user");

        activeStatus.setActive(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imageAvata1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbStatus)
                        .addGap(2, 2, 2)
                        .addComponent(activeStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageAvata1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(activeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ActiveStatus activeStatus;
    private swing.ImageAvata imageAvata1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbStatus;
    // End of variables declaration//GEN-END:variables
}
