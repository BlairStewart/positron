package theluminary.positron;

import com.google.inject.ConfigurationException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.log4j.Logger;
import theluminary.positron.boot.AppModule;
import theluminary.positron.boot.ComponentBooter;

import java.util.ArrayList;

import static theluminary.positron.framework.application.LessCode.fmt;

public class App {

    private static Logger log = Logger.getLogger(App.class);

    public static void main( String[] args ) {

        try {
            Injector injector = Guice.createInjector(new AppModule());
            ComponentBooter booter = injector.getInstance(ComponentBooter.class);
            booter.boot();
        } catch (ConfigurationException e) {
            String message = fmt("Failed to start application: %s", new ArrayList<>(e.getErrorMessages()).get(0));
            log.error(message, e);
        } catch (Exception e) {
            String message = fmt("Failed to start application: %s", e.getMessage());
            log.error(message, e);
        }

    }
}
