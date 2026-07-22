import java.util.List;
import java.util.Set;

import controllers.ProjectController;
import data.ProjectData;
import models.SoftwareProject;

public class App {
    public static void main(String[] args) throws Exception {
        List<SoftwareProject> projects = ProjectData.createProjects();
        ProjectController controller = new ProjectController();

        Set<SoftwareProject> ordered = controller.filterAndOrderProjects(projects, 500);
        List<SoftwareProject> critical = controller.classifyAndExtractProjects(projects, "CRITICAL");
        System.out.println("Método A: " + ordered.size());
        System.out.println("CRITICAL: " + critical.size());

    }
}
