package theluminary.positron.framework.adapter;

import com.google.inject.Inject;
import theluminary.positron.boot.ComponentBase;

import static spark.Spark.before;
import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

public class WebComponent extends ComponentBase {

    private final FrameworkController frameworkController;

    @Inject
    public WebComponent(FrameworkController frameworkController) {
        this.frameworkController = frameworkController;
    }

    @Override
    public void register() {
        port(0);
        staticFileLocation("/public");
        before("/api/*", (request, response) -> {
            response.header("Content-Type", "application/json");
        });
        frameworkController.register();
    }
}
