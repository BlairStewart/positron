package theluminary.positron.boot;

import com.google.inject.Inject;
import theluminary.positron.framework.adapter.FrameworkComponent;
import theluminary.positron.framework.adapter.WebComponent;

public class ComponentBooter {

    private final FrameworkComponent frameworkComponent;
    private final WebComponent webComponent;

    @Inject
    public ComponentBooter(FrameworkComponent frameworkComponent, WebComponent webComponent) {
        this.frameworkComponent = frameworkComponent;
        this.webComponent = webComponent;
    }

    public void boot() {
        webComponent.register();

        frameworkComponent.register();
    }

}
