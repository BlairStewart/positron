package theluminary.positron.framework.adapter;

import com.google.gson.Gson;
import spark.ModelAndView;
import spark.ResponseTransformer;
import spark.Route;
import spark.Spark;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.Map;

import static theluminary.positron.framework.application.LessCode.fmt;

public abstract class ControllerBase {

    protected static ResponseTransformer json() {
        return new Gson()::toJson;
    }

    public abstract void register();

    protected void get(String path, Route route) {
        Spark.get(path, route);
    }

    protected String getRender(Map<String, Object> model, String page) {
        model.put("contentTemplate", fmt("templates/pages/%s.vm", page));
        model.put("pageName", page);
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "templates/master.vm")
        );
    }

}
