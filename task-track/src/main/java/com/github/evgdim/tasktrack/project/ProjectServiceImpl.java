package com.github.evgdim.tasktrack.project;

import com.github.evgdim.tasktrack.user.User;
import com.github.evgdim.tasktrack.user.UserService;
import io.vavr.control.Try;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final UserService userService;

    public ProjectServiceImpl(ProjectRepository projectRepository, UserService userService) {
        this.projectRepository = projectRepository;
        this.userService = userService;
    }

    @Override
    public Try<Project> createProject(String name, Long leadUserId) {
        return Try.of(() -> {
            Optional<User> leadUser = userService.findById(leadUserId);
            if(!leadUser.isPresent())
                throw new UserNotFoundException(leadUserId, "ProjectServiceImpl::crateProject");

            Project project = new Project();
            project.setName(name);
            project.setBacklog(new Backlog());
            project.setLead(leadUser.get());
            Project savedProject = this.projectRepository.save(project);
            return project;
        });
    }
}
