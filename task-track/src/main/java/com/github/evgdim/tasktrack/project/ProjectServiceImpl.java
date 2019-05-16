package com.github.evgdim.tasktrack.project;

import com.github.evgdim.tasktrack.user.UserService;
import io.vavr.Tuple;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

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
    public Mono<Project> createProject(String name, Long leadUserId) {
        return
            userService.findById(leadUserId)
                    .log()
                    .switchIfEmpty(Mono.error(new UserNotFoundException(leadUserId, "ProjectServiceImpl::crateProject")))
                    .flatMap(u -> this.backlogRepository.save(new Backlog())
                                        .map(b -> Tuple.of(u, b)))
                    .log()
                    .flatMap(t -> {
                        Project project = new Project();
                        project.setName(name);
                        project.setBacklog(t._2);
                        project.setLead(t._1);
                        return this.projectRepository.save(project);
                    })
                    .log();
    }

}
