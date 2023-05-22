import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static Logger instance = null;
    protected static int num = 1;

    private Logger() {
    }

    public void log(String msg) {
        Date data = new Date();
        SimpleDateFormat dataF = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        System.out.println(String.format("[%s %d] %s", dataF.format(data), num++, msg));
    }

    public static Logger getInstance() {
        return instance != null ? instance : new Logger();
    }
}
