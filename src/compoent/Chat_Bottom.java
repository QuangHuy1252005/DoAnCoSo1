//đã sửa
package compoent;

import Event.PublicEvent;
import app.MessageType;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import model.Model_User_account;
import model.Model_send_message;
import net.miginfocom.swing.MigLayout;
import service.Service;
import swing.JIMSendTextPane;
import swing.SrollBar;




//public class Chat_Bottom extends javax.swing.JPanel {
//
//    public Model_User_account getUser() {
//        return user;
//    }
//
//    public void setUser(Model_User_account user) {
//        this.user = user;
//    }
//private Model_User_account user;
//  
//    public Chat_Bottom() {
//        initComponents();
//        init();
//    }
//private void init(){
//    setLayout(new MigLayout("fillx, filly","0[fill]0[]0[]2","2[fill]2"));
//    JScrollPane scroll = new JScrollPane();
//    scroll.setBorder(null);
//    JIMSendTextPane txt = new JIMSendTextPane();
//    txt.addKeyListener(new KeyAdapter() {
//    
// public void keyTyped(KeyEvent ke){
//  refresh();
// }});
//    txt.setBorder(new EmptyBorder(5,5,5,5));
//    txt.setHintText("Write Messendger to here ...");
//    scroll.setViewportView(txt);
//    SrollBar sb = new SrollBar();
//    sb.setBackground(new Color(229,229,229));
//    sb.setPreferredSize(new Dimension(2, 10));
//    scroll.setVerticalScrollBar(sb);
//    add(sb);
//    add(scroll,"w 100%");
//    JPanel panel = new JPanel();
//    panel.setLayout(new MigLayout("filly","0[]0","0[bottom]0"));
//    panel.setPreferredSize(new Dimension(35,28));
//    panel.setBackground(Color.WHITE);
//    JButton cmd = new JButton();
//    cmd.setBorder(null);
//    cmd.setContentAreaFilled(false);
//    cmd.setCursor(new Cursor(Cursor.HAND_CURSOR) 
//    );
//    cmd.setIcon(new ImageIcon(getClass().getResource("/icon/send.png")));
//    cmd.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//          String tesst = txt.getText().trim();
//          if(!tesst.equals("")){
//              Model_send_message message = new Model_send_message(service.Service.getInstance().getUser().getUserID(), user.getUserID(), tesst);
//              send(message);
//              PublicEvent.getInstance().getEventChat().sendMess(message);
//              txt.setText("");
//              txt.grabFocus();
//              refresh();
//          }else{
//              txt.grabFocus();
//          }
//        }
//    });
//    
//    panel.add(cmd);
//    add(panel);
//}
//
//private void send(Model_send_message data){
//    service.Service.getInstance().getClient().emit("send_to_user", data.toJSONObject());
//}
//
//  private void refresh(){
//      revalidate();
//  }




public class Chat_Bottom extends javax.swing.JPanel {

    public Model_User_account getUser() {
        return user;
    }

    public void setUser(Model_User_account user) {
        this.user = user;
        panelMore.setUser(user);
    }

    private Model_User_account user;

    public Chat_Bottom() {
        initComponents();
        init();
    }

    private void init() {
        mig = new MigLayout("fillx, filly", "0[fill]0[]0[]2", "2[fill]2[]0");
        setLayout(mig);
        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(null);
        JIMSendTextPane txt = new JIMSendTextPane();
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                refresh();
                
                if(ke.getKeyChar() == 10&&ke.isControlDown()){
                    eventSend(txt);
                }
            }
        });
        txt.setBorder(new EmptyBorder(5, 5, 5, 5));
        txt.setHintText("Write Message Here ...");
        scroll.setViewportView(txt);
        SrollBar sb = new SrollBar();
        sb.setBackground(new Color(229, 229, 229));
        sb.setPreferredSize(new Dimension(2, 10));
        scroll.setVerticalScrollBar(sb);
        add(sb);
        add(scroll, "w 100%");
        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("filly", "0[]3[]0", "0[bottom]0"));
        panel.setPreferredSize(new Dimension(30, 28));
        panel.setBackground(Color.WHITE);
        JButton cmd = new JButton();
        cmd.setBorder(null);
        cmd.setContentAreaFilled(false);
        cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmd.setIcon(new ImageIcon(getClass().getResource("/icon/send.png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //
                eventSend(txt);
                
          }
        });
        
        
        JButton cmdMore = new JButton();
        cmdMore.setBorder(null);
        cmdMore.setContentAreaFilled(false);
        cmdMore.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdMore.setIcon(new ImageIcon(getClass().getResource("/icon/more.png")));
        cmdMore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            if(panelMore.isVisible()){
                cmdMore.setIcon(new ImageIcon(getClass().getResource("/icon/more.png")));
                panelMore.setVisible(false);
                mig.setComponentConstraints(panelMore, "dock south, h 0!");
                revalidate();
            }
            else{
                  cmdMore.setIcon(new ImageIcon(getClass().getResource("/icon/more_mau.png")));
                panelMore.setVisible(true);
                mig.setComponentConstraints(panelMore, "dock south, h 170!");
                revalidate();
            }
            }
        });
        
        panel.add(cmdMore);
        panel.add(cmd);
        add(panel,"wrap");
        panelMore = new Panel_More();
        panelMore.setVisible(false);
        add(panelMore, "dock south, h 0!"); //set height = 0
    }
    
    private void eventSend(JIMSendTextPane txt){
        String text = txt.getText().trim();
       if (!text.equals("")) {
            Model_send_message message = new Model_send_message(MessageType.TEXT,Service.getInstance().getUser().getUserID(), user.getUserID(), text);
            send(message);
            PublicEvent.getInstance().getEventChat().sendMess(message);
            txt.setText("");
            txt.grabFocus();
            refresh();
        } else {
            txt.grabFocus();
        }
    }

    private void send(Model_send_message data) {
        Service.getInstance().getClient().emit("send_to_user", data.toJSONObject());
    }

    private void refresh() {
        revalidate();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(229, 229, 229));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
private  MigLayout mig;
private Panel_More panelMore;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
