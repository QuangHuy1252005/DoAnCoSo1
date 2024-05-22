
package compoent;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;
import swing.WrapLayout;
import Emoj.Emogi;
import Emoj.Model_Emoji;
import Event.PublicEvent;
import app.MessageType;
import java.awt.Component;
import java.awt.Cursor;
import java.io.File;
import java.io.IOException;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import model.Model_User_account;
import model.Model_send_message;
import swing.SrollBar;


public class Panel_More extends javax.swing.JPanel {
    public Model_User_account getUser() {
        return user;
    }

    public void setUser(Model_User_account user) {
        this.user = user;
    }

    private Model_User_account user;
    public Panel_More() {
        initComponents();
        init();
    }

  private void init(){
      setLayout(new MigLayout("fillx"));
      panelHeader = new JPanel();
      panelHeader.add(getButtonFile());
       panelHeader.add(getEmojiStyle1());
        panelHeader.add(getEmojiStyle2());
      panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.LINE_AXIS));
      panelHeader.add(getButtonImagefake());
      add(panelHeader,"w 100%, h 30!, wrap");
      
      panelDetail = new JPanel();
      panelDetail.setLayout(new WrapLayout(WrapLayout.LEFT));
      
      JScrollPane ch = new JScrollPane(panelDetail);
      ch.setBorder(null);
      ch.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      ch.setVerticalScrollBar(new SrollBar());
//      panelDetail.setBackground(Color.red);
      add(ch, "w 100%, h 100%");
  }
  
  
//private JButton getButtonImage(){
//    OptionButon cmd = new OptionButon();
//      cmd.setIcon(new ImageIcon(getClass().getResource("/icon/ghe.jpg")));
//      cmd.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//        JFileChooser ch = new JFileChooser();
//        ch.setMultiSelectionEnabled(true);
//        ch.setFileFilter(new FileFilter(){
//            @Override
//            public boolean accept(File f) {
//         return f.isDirectory() || isImageFile(f);
//            }
//
//            @Override
//            public String getDescription() {
//       return "Image File";
//            }
//            });
//        int option = ch.showOpenDialog(Main.Main.getFrames()[0]);
//        if(option == JFileChooser.APPROVE_OPTION){
//            File files[] = ch.getSelectedFiles();
//            try {
//                for(File file :files){
//                   Model_send_message message = new Model_send_message(MessageType.IMAGE, service.Service.getInstance().getUser().getUserID(),user.getUserID(),"");
//                 service.Service.getInstance().addFile(file, message);
//                            PublicEvent.getInstance().getEventChat().sendMess(message);
//                }
//
//            } catch (IOException e) {     
//                e.printStackTrace();
//            }
//    
//         }
//        }
//      });
//      
//      
//      return cmd;
//}
  
  
  // vô lý
  
  
  private JButton getButtonImagefake() {
        OptionButon cmd = new OptionButon();
        cmd.setIcon(new ImageIcon(getClass().getResource("/icon/ghe.jpg")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser ch = new JFileChooser();
                ch.setMultiSelectionEnabled(true);
                ch.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File file) {
                        return file.isDirectory() || isImageFile(file);
                    }

                    @Override
                    public String getDescription() {
                        return "Image File";
                    }
                });
                int option = ch.showOpenDialog(Main.Main.getFrames()[0]);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File files[] = ch.getSelectedFiles();
                    try {
                        for (File file : files) {
                            Model_send_message message = new Model_send_message(MessageType.IMAGE,  service.Service.getInstance().getUser().getUserID(), user.getUserID(), "");
                            service.Service.getInstance().addFile(file, message);
                            PublicEvent.getInstance().getEventChat().sendMess(message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        return cmd;
    }
  
  private JButton getButtonFile(){
      OptionButon cmd = new OptionButon();
      cmd.setIcon(new ImageIcon(getClass().getResource("/icon/link.png")));
       cmd.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              JFileChooser ch = new JFileChooser();
              ch.showOpenDialog(Main.Main.getFrames()[0]);
          }
       });
      return cmd;
  }
  
  private JButton getEmojiStyle1(){
        OptionButon cmd = new OptionButon();
      cmd.setIcon(Emogi.getInstance().getImoji(1).toSize(25, 25).getIcon());
      cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearSelected();
                cmd.setSelected(true);
          panelDetail.removeAll();
          for(Model_Emoji d : Emogi.getInstance().getStyle1()){
              panelDetail.add(getButton(d));
          }
          panelDetail.repaint();
          panelDetail.revalidate();
            }
      });
      
          return cmd;
  }
  
    private JButton getEmojiStyle2(){
        OptionButon cmd = new OptionButon();
      cmd.setIcon(Emogi.getInstance().getImoji(21).toSize(25, 25).getIcon());
      cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearSelected();
                cmd.setSelected(true);
          panelDetail.removeAll();
          for(Model_Emoji d : Emogi.getInstance().getStyle2()){
              JButton c = new JButton(d.getIcon());
              c.setName(d.getId() +"" );
              c.setBorder(new EmptyBorder(3,3,3,3));
              c.setCursor(new Cursor(Cursor.HAND_CURSOR));
              c.setContentAreaFilled(false);
              panelDetail.add(getButton(d));
          }
          panelDetail.repaint();
          panelDetail.revalidate();
            }
      });
      
          return cmd;
  }
    
    private JButton getButton(Model_Emoji data){
         JButton cmd = new JButton(data.getIcon());
              cmd.setName(data.getId() +"" );
              cmd.setBorder(new EmptyBorder(3,3,3,3));
              cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
              cmd.setContentAreaFilled(false);
              cmd.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
           Model_send_message message = new Model_send_message(MessageType.EMOJI, service.Service.getInstance().getUser().getUserID(), user.getUserID(), data.getId()+"");
                 senMessage(message);
                 PublicEvent.getInstance().getEventChat().sendMess(message);
             }
              });
              return cmd;
    }
    
    private void senMessage(Model_send_message data){
        service.Service.getInstance().getClient().emit("send_to_user", data.toJSONObject());
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
            .addGap(0, 65, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void clearSelected(){
        for(Component c : panelHeader.getComponents()){
            if(c instanceof OptionButon ){
                ((OptionButon) c).setSelected(false);
            }
        }
    }
    
    
    
    private boolean isImageFile(File file){
        String name = file.getName().toLowerCase();
        return name.endsWith(".jpg") || name.endsWith(".png")  || name.endsWith(".jpeg")  || name.endsWith(".gif");
    }
private JPanel panelHeader;
private JPanel panelDetail;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
