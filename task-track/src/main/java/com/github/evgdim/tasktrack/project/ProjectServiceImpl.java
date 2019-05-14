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
    private final BacklogRepository backlogRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository, UserService userService, BacklogRepository backlogRepository) {
        this.projectRepository = projectRepository;
        this.userService = userService;
        this.backlogRepository = backlogRepository;
    }

    @Override
    public Try<Project> createProject(String name, Long leadUserId) {
        return Try.of(() -> {
            Optional<User> leadUser = userService.findById(leadUserId);
            if(!leadUser.isPresent())
                throw new UserNotFoundException(leadUserId, "ProjectServiceImpl::crateProject");
            Backlog savedBacklog = this.backlogRepository.save(new Backlog());
            Project project = new Project();
            project.setName(name);
            project.setBacklog(savedBacklog);
            project.setLead(leadUser.get());
            Project savedProject = this.projectRepository.save(project);
            return project;
        });
    }
}
