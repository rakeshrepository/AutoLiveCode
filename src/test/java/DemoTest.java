import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DemoTest {

    @Test
    @DisplayName("Demo")
    public void test() {
        String str = "name";
        Assertions.assertEquals("name", str);
    }


}
