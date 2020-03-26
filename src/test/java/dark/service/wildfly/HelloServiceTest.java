import static org.junit.jupiter.api.Assertions.assertEquals;

import com.darkwolf.service.wildfly.HelloService;

import org.junit.jupiter.api.Test;

class HelloServiceTest {

    private final HelloService CUT = new HelloService();

    @Test
    public void getHelloWorld() {
        assertEquals("Hello World!", CUT.getNameString(null));
    }

    @Test
    public void getHelloEric() {
        assertEquals("Eric!", CUT.getNameString("Eric"));
    }

    @Test
    public void getHelloDan() {
        assertEquals("Dan!", CUT.getNameString("Dan"));
    }

    @Test
    public void getHelloSteve() {
        assertEquals("Nathan!", CUT.getNameString("Nathan"));
    }

    @Test
    public void getHelloJosh() {
        assertEquals("Josh!", CUT.getNameString("Josh"));
    }

}