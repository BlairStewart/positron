package theluminary.positron.framework.adapter;

import com.google.gson.Gson;
import spark.ModelAndView;
import spark.ResponseTransformer;
import spark.Route;
import spark.Spark;

import java.util.HashMap;
import java.util.Map;

public class FrameworkController extends ControllerBase  {

    @Override
    public void register() {
        get("/_system/debug", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return getRender(model, "debug");
        });
    }
}
