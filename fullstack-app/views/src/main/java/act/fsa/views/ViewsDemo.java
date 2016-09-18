package act.fsa.views;

import act.boot.app.RunApp;
import act.controller.Controller;
import org.osgl.mvc.annotation.GetAction;

public class ViewsDemo extends Controller.Util {

    private String title = "ActFramework View Demo";
    private String who = "ActFramework";

    @GetAction
    public void home() {
        renderTemplate(title, who);
    }

    @GetAction("beetl")
    public void beetl() {
        renderTemplate(title, who);
    }

    public static void main(String[] args) throws Exception {
        RunApp.start(ViewsDemo.class);
    }

}
