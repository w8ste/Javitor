import java.util.TimerTask;
public class TimerTk extends TimerTask {
    
    private MyFrame myFrame;
    private int count = 0;

    public TimerTk(MyFrame myFrame) {
        this.myFrame = myFrame;
    }
    @Override
    public void run() {
        if(count < 20) {
            count++;
            myFrame.getHighlighter().highlight(myFrame.getLang());
        } 
    }
}
