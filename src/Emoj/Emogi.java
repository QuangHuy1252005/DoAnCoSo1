
package Emoj;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;


public class Emogi {
    private static  Emogi istence;
    public static Emogi getInstance(){
        if(istence ==null){
            istence = new Emogi();
        }
        return istence;
    }
    
    private Emogi(){
        
    }
    
    
    public List<Model_Emoji> getStyle1(){
        List<Model_Emoji> list = new ArrayList<>();
        for(int i=1; i<=20; i++){
            list.add(new Model_Emoji(i, new ImageIcon(getClass().getResource("/Emoj_icon/" +i+ ".png"))));
        }
        
        return list;
    }
    
    
    
      public List<Model_Emoji> getStyle2(){
        List<Model_Emoji> list = new ArrayList<>();
        for(int i=21; i<=35; i++){
            list.add(new Model_Emoji(i, new ImageIcon(getClass().getResource("/Emoj_icon/" +i+ ".png"))));
        }
        
        return list;
    }
      
      
      
      public Model_Emoji getImoji(int id){
          return new Model_Emoji(id,new ImageIcon(getClass().getResource("/Emoj_icon/" +id+ ".png")));
      }
}
