package nl.chimpgamer.javalintest;

import io.javalin.Javalin;
import net.md_5.bungee.api.plugin.Plugin;

public class MainBungee extends Plugin {
    private Javalin app;

    @Override
    public void onEnable() {
        app = Javalin.create()
                .enableCorsForAllOrigins()
                .start(777);
        app.get("/", ctx -> ctx.result("Hello world!"));
    }

    @Override
    public void onDisable() {
        this.app.stop();
    }
}