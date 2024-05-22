
package swing;

import javax.swing.Icon;
import javax.swing.JProgressBar;

public class Progess extends JProgressBar{
private ProgressType progressType = ProgressType.NONE;

    public ProgressType getProgressType() {
        return progressType;
    }

    public void setProgressType(ProgressType progressType) {
        this.progressType = progressType;
       repaint();
    }

    public Progess() {
        setOpaque(false);
        setUI(new ProgressCircleUI(this));
    }
    public static enum ProgressType{
       NONE, DOWN_FILE, CANCEL,FILE
    }
}
