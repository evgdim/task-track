package com.github.evgdim.tasktrack.project;

import com.github.evgdim.tasktrack.user.User;
import com.github.evgdim.tasktrack.user.UserRepository;
import com.github.evgdim.tasktrack.user.UserService;
import io.vavr.control.Try;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectIT {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserRepository userRepository;
    @Test
    public void createProject_ShoulWork() {
        User user = new User();
        user.setName("test");
        user.setPassword("pass");
        User savedUser = userRepository.save(user);
        Try<Project> createProject = projectService.createProject("test", savedUser.getId());
        Assertions.assertThat(createProject.isSuccess()).isTrue();
    }
}
