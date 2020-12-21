import static org.junit.jupiter.api.Assertions.assertEquals;

import com.darkwolf.service.wildfly.HelloService;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class HelloServiceTest {

    private final HelloService CUT = new HelloService();

    @Test
    public void getNameStringWithoutDBConnection() {
        ArrayList<String> empty = new ArrayList<String>();
        assertEquals(
            empty,
            CUT.getNameString());
    }

}