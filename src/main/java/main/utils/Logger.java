package main.utils;

public class Logger {

    public static void log(Logger.TYPE type, String message) {
        System.out.println(String.format("LOGGING --> %s : -- %s --", type.getName(), message));
    }


    public enum TYPE {

        INFO(0),
        ERROR(1),
        WARNING(2);

        private int index;

        TYPE(int index) {
            this.index = index;
        }
        public String getName() {
            switch (index) {
                case 0:
                    return "INFO";
                case 1:
                    return "ERROR";
                case 2:
                    return "WARNING";
                default:
                    return "NONE";
            }

        }
    }
}

