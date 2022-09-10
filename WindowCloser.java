import java.awt.event.*;

// This gives the ability to close the window
//
public class WindowCloser extends WindowAdapter {
    public void windowClosing(WindowEvent evt) {
        System.exit(0);
    }
}
