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
        assertEquals("Hello Eric!", CUT.getNameString("Eric"));
    }

    @Test
    public void getHelloDan() {
        assertEquals("Hello Dan!", CUT.getNameString("Dan"));
    }

    @Test
    public void getHelloSteve() {
        assertEquals("Hello Nathan!", CUT.getNameString("Nathan"));
    }

    @Test
    public void getHelloJosh() {
        assertEquals("Hello Josh!", CUT.getNameString("Josh"));
    }

}