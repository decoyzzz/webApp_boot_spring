package com.examplewebapp.mywebapp.service;

import com.examplewebapp.mywebapp.dto.Task;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;

import java.util.*;

import java.io.IOException;
import java.nio.file.*;

@Service
public class TaskService {
    private List<Task> tasks = new ArrayList<>();
    private final Path file = Paths.get("mywebapp", "src", "main", "java", "com", "examplewebapp", "mywebapp", "tasks.json");
    private final ObjectMapper mapper = new ObjectMapper();

    public TaskService() {
        loadTasks();
    }

    private void loadTasks()
    {
        if(Files.exists(file))
        {
            try
            {
                tasks = mapper.readValue(file.toFile(), new TypeReference<List<Task>>() {});
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private void updateTasks()
    {
        try
        {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file.toFile(), tasks);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task addTask(Task task) {
        tasks.add(task);
        updateTasks();
        return task;
    }

    public void toggleTask(Long id)
    {

        for(Task t : tasks)
        {
            if (t.getId().equals(id))
            {
                t.setDone(!t.isDone());
                updateTasks();
                return;
            }
        }

        throw new RuntimeException("Task with ID " + id + " not found.");
    }


    public void deleteTask(Long id) {
    Iterator<Task> iterator = tasks.iterator();

    while (iterator.hasNext())
    {
        Task t = iterator.next();

        if (t.getId().equals(id))
        {
            iterator.remove();
            updateTasks();
            return;
        }
    }

    throw new RuntimeException("Task with ID " + id + " not found.");
}
}
