package br.ce.wcaquino.taskbackend.controller;

import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class TaskControllerTest {

    @Mock
    private TaskRepo taskRepo;

    @InjectMocks
    private TaskController taskController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void naoDeveSalvarTaskSemDescricao() throws Exception {

        Task todo = new Task();
        todo.setDueDate(LocalDate.now());
        try {
            taskController.save(todo);
            Assert.fail("Nao deveria chegar nesse ponto");
        }catch (ValidationException e){
            Assert.assertEquals("Fill the task description", e.getMessage());
        }

    }

    @Test
    public void naoDeveSalvarTaskSemData(){
        Task todo = new Task();
        todo.setTask("Descricao");
        try {
            taskController.save(todo);
            Assert.fail("Nao deveria chegar nesse ponto");
        }catch (ValidationException e){
            Assert.assertEquals("Fill the due date", e.getMessage());
        }
    }

    @Test
    public void naoDeveSalvarTaskComDataPassada(){
        Task todo = new Task();
        todo.setTask("Descricao");
        todo.setDueDate(LocalDate.of(2015, 01, 01));
        try {
            taskController.save(todo);
            Assert.fail("Nao deveria chegar nesse ponto");
        }catch (ValidationException e){
            Assert.assertEquals("Due date must not be in past", e.getMessage());
        }
    }

    @Test
    public void deveSalvarTaskComSucesso() throws ValidationException {
        Task todo = new Task();
        todo.setTask("Descricao");
        todo.setDueDate(LocalDate.now());
        taskController.save(todo);
        Mockito.verify(taskRepo).save(todo);

    }


}
