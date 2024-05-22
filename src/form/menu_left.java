//đã sửa
package form;

import Event.EventMenuLeft;
import Event.PublicEvent;
import compoent.item_People;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import model.Model_User_account;
import net.miginfocom.swing.MigLayout;
import swing.SrollBar;






//public class menu_left extends javax.swing.JPanel {
//private  List<Model_User_account> userAccount;
// 
//    public menu_left() {
//        initComponents();
//         userAccount = new ArrayList<>();
////  menuMess.setBorderPainted(false);
////menuGroup.setBorderPainted(false);
////menuBox.setBorderPainted(false);
//        init();
//    }
//private void init() {
//    jScrollPane2.setVerticalScrollBar(new SrollBar());
//    menuList.setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
//    userAccount = new ArrayList<>();
//   
//    PublicEvent.getInstance().addEventMenuLeft(new EventMenuLeft() {
//
//        @Override
//        public void newUser(List<Model_User_account> users) {
//              for (Model_User_account d : users) {
//                    userAccount.add(d);
//                    menuList.add(new item_People(d), "wrap");
//                    refreshMenuList();
//                }
//                
//            }
//
//
//      
//        @Override
//        public void userConect(int userID) {
//            for(Model_User_account u : userAccount){
//                if(u.getUserID() == userID){
//                    u.setStatus(true);
//                    PublicEvent.getInstance().getEventMain().updateUser(u);
//                    break;
//                }
//                    
//                
//            }
//            if(menuMess.isSelected()){
//                for(Component com : menuList.getComponents()){
//                    item_People item = (item_People)com;
//                    if(item.getUser().getUserID() == userID){
//                        item.updateStatus();
//                        break;
//                    }
//                }
//            }
//              }
////        public void userConect(int userID) {
////    for (Component comp : menuList.getComponents()) {
////        if (comp instanceof item_People) {
////            item_People item = (item_People) comp;
////            Model_User_account user = item.getUser();
////            if (user.getUserID() == userID) {
////                user.setStatus(true);
////                item.updateStatus();
////                break;
////            }
////        }
////    }
////}
//
//        @Override
//        public void userDisconect(int userID) {
//                for(Model_User_account u : userAccount){
//                if(u.getUserID() == userID){
//                    u.setStatus(false);
//                       PublicEvent.getInstance().getEventMain().updateUser(u);
//                    break;
//                }
//                    
//                
//            }
//         if (menuMess.isSelected()) {
//                    for (Component com : menuList.getComponents()) {
//                        item_People item = (item_People) com;
//                        if (item.getUser().getUserID() == userID) {
//                            item.updateStatus();
//                            break;
//                        }
//                    }
//                }
//            }
////        public void userDisconect(int userID) {
////    for (Component comp : menuList.getComponents()) {
////        if (comp instanceof item_People) {
////            item_People item = (item_People) comp;
////            Model_User_account user = item.getUser();
////            if (user.getUserID() == userID) {
////                user.setStatus(false);
////                item.updateStatus();
////                break;
////            }
////        }
////    }
////}
//
//
//        });
//    
//
//    
//    showMessage();
//
//
//
//  
//}
//
// private void showMessage() {
//        //  test data
//        menuList.removeAll();
//        for (Model_User_account d : userAccount) {
//            menuList.add(new item_People(null), "wrap");
//        }
//        refreshMenuList();
//    }
//private void showGroup() {
//        //  test data
//        menuList.removeAll();
//        for (int i = 0; i < 5; i++) {
//            menuList.add(new item_People(null), "wrap");
//        }
//        refreshMenuList();
//    }
//
// private void showBox() {
//        //  test data
//        menuList.removeAll();
//        for (int i = 0; i < 10; i++) {
//            menuList.add(new item_People(null), "wrap");
//        }
//        refreshMenuList();
//    }
//
////sau mỗi lần gọi thì left sẽ xóa hết và vẽ lại từng list
//private void refreshMenuList() {
//        menuList.repaint();
//        menuList.revalidate();
//    }





public class menu_left extends javax.swing.JPanel {

    private List<Model_User_account> userAccount;

    public menu_left() {
        initComponents();
        init();
    }

    private void init() {
        jScrollPane2.setVerticalScrollBar(new SrollBar());
        menuList.setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
        userAccount = new ArrayList<>();
        PublicEvent.getInstance().addEventMenuLeft(new EventMenuLeft() {
            @Override
            public void newUser(List<Model_User_account> users) {
                for (Model_User_account d : users) {
                    userAccount.add(d);
                  //  d.setStatus(true);//chỉnh sửa
                    menuList.add(new item_People(d), "wrap");
                    refreshMenuList();
                }
            }

            @Override
            public void userConect(int userID) {
                for (Model_User_account u : userAccount) {
                    if (u.getUserID() == userID) {
                        u.setStatus(true);
                        PublicEvent.getInstance().getEventMain().updateUser(u);
                        break;
                    }
                }
                if (menuMess.isSelected()) {
                    for (Component com : menuList.getComponents()) {
                        item_People item = (item_People) com;
                        if (item.getUser().getUserID() == userID) {
                            item.updateStatus();
                            break;
                        }
                    }
                }
            }

           

            @Override
            public void userDisconect(int userID) {
               for (Model_User_account u : userAccount) {
                    if (u.getUserID() == userID) {
                        u.setStatus(false);
                        PublicEvent.getInstance().getEventMain().updateUser(u);
                        break;
                    }
                }
                if (menuMess.isSelected()) {
                    for (Component com : menuList.getComponents()) {
                        item_People item = (item_People) com;
                        if (item.getUser().getUserID() == userID) {
                            item.updateStatus();
                            break;
                        }
                    }
                }
            }
        });
        showMessage();
    }

    private void showMessage() {
        //  test data
        menuList.removeAll();
        for (Model_User_account d : userAccount) {
            menuList.add(new item_People(null), "wrap");
        }
        refreshMenuList();
    }

    private void showGroup() {
        //  test data
        menuList.removeAll();
        for (int i = 0; i < 5; i++) {
            menuList.add(new item_People(null), "wrap");
        }
        refreshMenuList();
    }

    private void showBox() {
        //  test data
        menuList.removeAll();
        for (int i = 0; i < 10; i++) {
            menuList.add(new item_People(null), "wrap");
        }
        refreshMenuList();
    }

    private void refreshMenuList() {
        menuList.repaint();
        menuList.revalidate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JLayeredPane();
        menuMess = new javax.swing.JButton();
        menuGroup = new javax.swing.JButton();
        menuBox = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        menuList = new javax.swing.JLayeredPane();

        menu.setBackground(new java.awt.Color(200, 200, 200));
        menu.setLayout(new java.awt.GridLayout(1, 3));

        menuMess.setBackground(new java.awt.Color(229, 229, 229));
        menuMess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/mess_hai.png"))); // NOI18N
        menuMess.setBorder(null);
        menuMess.setBorderPainted(false);
        menuMess.setContentAreaFilled(false);
        menuMess.setMaximumSize(new java.awt.Dimension(60, 39));
        menuMess.setMinimumSize(new java.awt.Dimension(30, 30));
        menuMess.setPreferredSize(new java.awt.Dimension(30, 30));
        menuMess.setSelected(true);
        menuMess.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/mess_hai_mau.png"))); // NOI18N
        menuMess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMessActionPerformed(evt);
            }
        });
        menu.add(menuMess);

        menuGroup.setBackground(new java.awt.Color(229, 229, 229));
        menuGroup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/group_hai.png"))); // NOI18N
        menuGroup.setBorderPainted(false);
        menuGroup.setContentAreaFilled(false);
        menuGroup.setMaximumSize(new java.awt.Dimension(60, 39));
        menuGroup.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/group_mau_hai.png"))); // NOI18N
        menuGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGroupActionPerformed(evt);
            }
        });
        menu.add(menuGroup);

        menuBox.setBackground(new java.awt.Color(229, 229, 229));
        menuBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/mail_hai.png"))); // NOI18N
        menuBox.setBorderPainted(false);
        menuBox.setContentAreaFilled(false);
        menuBox.setMaximumSize(new java.awt.Dimension(60, 39));
        menuBox.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/mail_mau_hai.png"))); // NOI18N
        menuBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBoxActionPerformed(evt);
            }
        });
        menu.add(menuBox);

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        menuList.setBackground(new java.awt.Color(242, 242, 242));
        menuList.setOpaque(true);

        javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(menuList);
        menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuListLayout.setVerticalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(menuList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menuMessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMessActionPerformed
   if(!menuMess.isSelected()){
        menuMess.setSelected(true);
     menuGroup.setSelected(false);
     menuBox.setSelected(false);
     showMessage();
   }
        
    }//GEN-LAST:event_menuMessActionPerformed

    private void menuGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGroupActionPerformed
         if(!menuGroup.isSelected()){
        menuMess.setSelected(false);
     menuGroup.setSelected(true);
     menuBox.setSelected(false);
     showGroup();
    }//GEN-LAST:event_menuGroupActionPerformed
    }
    private void menuBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBoxActionPerformed
         if(!menuBox.isSelected()){
        menuMess.setSelected(false);
     menuGroup.setSelected(false);
     menuBox.setSelected(true);
     showBox();
         }
    }//GEN-LAST:event_menuBoxActionPerformed

public List<Model_User_account> getUserAccount() {
    return userAccount;
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLayeredPane menu;
    private javax.swing.JButton menuBox;
    private javax.swing.JButton menuGroup;
    private javax.swing.JLayeredPane menuList;
    private javax.swing.JButton menuMess;
    // End of variables declaration//GEN-END:variables
}
