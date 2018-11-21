package theluminary.positron.framework.adapter;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import theluminary.positron.boot.ComponentBase;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Container;

import static spark.Spark.port;
import static theluminary.positron.framework.application.LessCode.fmt;

public class FrameworkComponent extends ComponentBase {

    @Override
    public void register() {
        makePanel();
    }

    private void makePanel() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1024, 768);
        frame.setLocationRelativeTo(null);

        Container contentPane = frame.getContentPane();
        BoxLayout layout = new BoxLayout(contentPane, BoxLayout.PAGE_AXIS);
        contentPane.setLayout(layout);
        JFXPanel jfxPanel = getWebViewer();
        contentPane.add(jfxPanel);

        frame.setVisible(true);
    }

    private JFXPanel getWebViewer() {
        JFXPanel jfxPanel = new JFXPanel(); // Scrollable JCompenent
        Platform.runLater(() -> { // FX components need to be managed by JavaFX
            WebView webView = new WebView();
            int port = port();
            webView.getEngine().load( fmt("http://localhost:%s/_system/debug", port) );
            jfxPanel.setScene( new Scene(webView ) );
        });
        return jfxPanel;
    }
}
