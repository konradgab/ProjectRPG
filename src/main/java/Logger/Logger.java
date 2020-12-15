package Logger;

public class Logger {
        public static final String RESET = "\u001B[0m";

        public static final String BLACK = "\u001B[30m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String PURPLE = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
        public static final String WHITE = "\u001B[37m";

        public static final String BRIGHT_BLACK = "\u001B[90m";
        public static final String BRIGHT_RED = "\u001B[91m";
        public static final String BRIGHT_GREEN = "\u001B[92m";
        public static final String BRIGHT_YELLOW = "\u001B[93m";
        public static final String BRIGHT_BLUE = "\u001B[94m";
        public static final String BRIGHT_PURPLE = "\u001B[95m";
        public static final String BRIGHT_CYAN = "\u001B[96m";
        public static final String BRIGHT_WHITE = "\u001B[97m";

        public static final String BG_BLACK = "\u001B[40m";
        public static final String BG_RED = "\u001B[41m";
        public static final String BG_GREEN = "\u001B[42m";
        public static final String BG_YELLOW = "\u001B[43m";
        public static final String BG_BLUE = "\u001B[44m";
        public static final String BG_PURPLE = "\u001B[45m";
        public static final String BG_CYAN = "\u001B[46m";
        public static final String BG_WHITE = "\u001B[47m";

        public static final String BRIGHT_BG_BLACK = "\u001B[100m";
        public static final String BRIGHT_BG_RED = "\u001B[101m";
        public static final String BRIGHT_BG_GREEN = "\u001B[102m";
        public static final String BRIGHT_BG_YELLOW = "\u001B[103m";
        public static final String BRIGHT_BG_BLUE = "\u001B[104m";
        public static final String BRIGHT_BG_PURPLE = "\u001B[105m";
        public static final String BRIGHT_BG_CYAN = "\u001B[106m";
        public static final String BRIGHT_BG_WHITE = "\u001B[107m";

        public static final String BOLD = "\u001B[1m";
        public static final String FAINT = "\u001B[2m";
        public static final String ITALIC = "\u001B[3m";
        public static final String UNDERLINE = "\u001B[4m";
        public static final String BLINK_SLOW = "\u001B[5m";
        public static final String BLINK_RAPID = "\u001B[6m";

        public static void printError(String content) {
            System.out.println("[" + RED + BLINK_SLOW + "ERROR" + RESET + "] " + content);
        }

        public static void printWarning(String content) {
            System.out.println("[" + YELLOW + "WARNING" + RESET + "] " + content);
        }

        public static void printInfo(String content) {
            System.out.println(WHITE + "[" + CYAN + "INFO" + RESET + "] " + content);
        }
}
