package adapters;

import models.Project;
import models.ResponseProject;
import models.ResponseStatus;

public class ProjectAdapter extends BaseAdapter {

    public ResponseStatus create(Project project, int status) {
        String response = post(gson.toJson(project), status, PROJECT_URL +"project/");
        return gson.fromJson(response, ResponseStatus.class);
    }

    public ResponseProject getProject(String code) {
        String response = get(200, PROJECT_URL + "project/" +code);
        return gson.fromJson(response, ResponseProject.class);
    }
}
