
package swing;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;


public class SrollBar extends JScrollBar{
    public SrollBar() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(5, 5));
        setBackground(new Color(242,242,242));
        setUnitIncrement(20);
    }
}
