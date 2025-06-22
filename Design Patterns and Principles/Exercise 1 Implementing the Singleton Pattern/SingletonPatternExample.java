class Logger {
    private static Logger instance;

    private Logger() {
        System.out.println("Logger initialized.");
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[Log]: " + message);
    }
}

public class SingletonPatternExample {
    public static void main(String[] args) {
        Logger loggerA = Logger.getInstance();
        Logger loggerB = Logger.getInstance();

        loggerA.log("Application started.");
        loggerB.log("Processing user input.");

        if (loggerA == loggerB) {
            System.out.println("Singleton confirmed: Both logger instances are the same.");
        } else {
            System.out.println("Singleton violated: Different instances exist.");
        }
    }
}
