import org.example.Todos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TodosTests {

    Todos todos;

    @BeforeEach
    public void beforeEachMethod() {
        todos = new Todos();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Работа", "Учеба"})
    public void test_add_task(String g) {
        todos.addTask(g);
        Assertions.assertTrue(todos.getAllTasks().contains(g));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Работа", "Учеба"})
    public void test_remove_task(String g) {
        todos.addTask(g);
        todos.removeTask(g);
        Assertions.assertFalse(todos.getAllTasks().contains(g));
    }

    @Test
    public void test_get_all_tasks() {
        todos.addTask("Учеба");
        todos.addTask("Работа");
        String expected = "Работа Учеба";
        String result = todos.getAllTasks();
        Assertions.assertEquals(result, expected);
    }
}
