import java.util.TimerTask;
import java.util.Timer;
public class TimerTk extends TimerTask {
    
    private MyFrame myFrame;
    private Timer timer;
    private int count = 0;

    public TimerTk(MyFrame myFrame, Timer timer) {
        this.myFrame = myFrame;
        this.timer = timer;
    }
    @Override
    public void run() {
        if(count < 20) {
            count++;
            myFrame.highlight();
        } 
    }
}
