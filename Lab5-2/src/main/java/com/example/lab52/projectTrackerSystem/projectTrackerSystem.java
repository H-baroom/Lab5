package com.example.lab52.projectTrackerSystem;

import com.example.lab52.ApiResponse.ApiResponse;
import com.example.lab52.Project.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/project")
public class projectTrackerSystem {
    ArrayList<Project> projects = new ArrayList<>();

    @GetMapping("/displayProject")
    public ArrayList<Project> getProjects() {
        return projects;
    }

    @PostMapping("/add")
    public ApiResponse addProject(@RequestBody Project project) {
        projects.add(project);
        return new ApiResponse("Project Added");
    }
    @DeleteMapping("/delete/{index}")
    public ApiResponse removeProject(@PathVariable int index) {
        projects.remove(index);
        return new ApiResponse("Project Removed");
    }
    @PutMapping("/update/{index}")
    public ApiResponse updateProject(@RequestBody Project project,@PathVariable int index) {
        projects.set(index, project);
        return new ApiResponse("Project Updated");
    }

    @PutMapping("/changeStatus/{index}")
    public ApiResponse changeStatus(@PathVariable int index) {
        if (!(projects.get(index).getStatus().equals("done"))) {
            projects.get(index).setStatus("done");
        }
        return new ApiResponse("Project Updated");
    }

    @GetMapping("/searchProjectByTitle/{title}")
    public Project searchProjectByTitle(@PathVariable String title) {
        for (Project project : projects) {
            if (project.getTitle().equals(title)) {
                return project;
            }
        }
        return null;
    }

    @GetMapping("/displayAllProjectsByCompanyName/{companyName}")
    public ArrayList<Project> displayAllProjectsByCompanyName(@PathVariable String companyName) {
        ArrayList<Project> projectsCompanyName = new ArrayList<>();
        for (Project project : projects) {
            if (project.getCompanyName().equals(companyName)) {
                projectsCompanyName.add(project);
            }
        }
        return projectsCompanyName;
    }
}
