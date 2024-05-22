
package form;

import model.Model_User_account;
import net.miginfocom.swing.MigLayout;


public class home extends javax.swing.JLayeredPane {
private chat chat1;
  
    public home() {
        initComponents();
        init();
    }
    private void init() {
        setLayout(new MigLayout(" fillx,filly", "0[ 200!]5[fill,100%]5[165!]0","0[fill]0"));
    this.add(new menu_left());
        chat1 = new chat();
    this.add(chat1);
    this.add(new menu_right());
    chat1.setVisible(false);
    }
    
    public void setUser(Model_User_account user){
        chat1.setUser(user);
         chat1.setVisible(true);
    }

    
     public void updateUser(Model_User_account user){
                  chat1.updateUser(user); 
         }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 811, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
