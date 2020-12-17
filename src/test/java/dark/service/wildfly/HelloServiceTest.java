import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.darkwolf.service.wildfly.HelloService;

import org.junit.jupiter.api.Test;

class HelloServiceTest {

    private final HelloService CUT = new HelloService();

    @Test
    public void getNameString() {
        assertNotNull(CUT.getNameString());
    }

}