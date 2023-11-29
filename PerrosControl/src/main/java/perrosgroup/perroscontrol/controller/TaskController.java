package perrosgroup.perroscontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import perrosgroup.perroscontrol.model.Task;
import perrosgroup.perroscontrol.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task) {
        return service.addTask(task);
    }

    @GetMapping
    public List<Task> getTasks() {
        return service.findAllTasks();
    }

    @GetMapping("/{taskId}")
    public Task getTask(@PathVariable String taskId) {
        return service.getTaskByTaskId(taskId);
    }

    @GetMapping("/severity/{severity}")
    public List<Task> findTaskUsingSeverity(@PathVariable int severity) {
        return service.getTaskBySeverity(severity);
    }

    @GetMapping("/assignee/{assignee}")
    public List<Task> getTaskByAssignee(@PathVariable String assignee) {
        return service.getTaskByAssignee(assignee);
    }

    @PutMapping
    public Task modifyTask(@RequestBody Task task) {
        return service.updateTask(task);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable String taskId) {
        return service.deleteTask(taskId);
    }
}
