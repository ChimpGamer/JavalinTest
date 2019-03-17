package nl.chimpgamer.javalintest;

import io.javalin.Javalin;

public class Main {
    private static Javalin app;

    public static void main(String[] args) {
        app = Javalin.create()
                .enableCorsForAllOrigins()
                .start(777);
        app.get("/", ctx -> ctx.result("Hello world!"));

        Runtime.getRuntime().addShutdownHook(new Shutdown());
    }

    public static class Shutdown extends Thread {

        @Override
        public void run() {
            Main.app.stop();
        }
    }
}
