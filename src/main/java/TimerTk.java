import java.util.TimerTask;

public class TimerTk extends TimerTask {
    
    private MyFrame frame;
    public TimerTk(MyFrame myFrame) {
        this.frame = myFrame;
    }
    @Override
    public void run() {
        frame.highlight();
    }
}
