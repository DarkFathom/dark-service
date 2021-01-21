import static org.junit.jupiter.api.Assertions.assertEquals;
import com.darkwolf.service.wildfly.HelloService;

/*import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;*/
import static org.mockito.Mockito.when;

import java.util.ArrayList;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class HelloServiceTest {
 
    @Mock
    HttpServletRequest request;
 
    @Mock
    HttpServletResponse response;
 
    
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
 
    @Test
    public void getNameStringWithoutDBConnection() {
        HelloService CUT = new HelloService();
        ArrayList<String> empty = new ArrayList<String>();
        assertEquals(
            empty,
            CUT.getNameString());
    }

    @Test
    public void testResponse() throws IOException, ServletException {
        try{
            setUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        
        when(response.getWriter()).thenReturn(pw);
            
        HelloService CUT = new HelloService();
        CUT.doGet(request, response);
        String result = sw.getBuffer().toString().trim();

        assertEquals(result, new String(
        "<HTML>\n<HEAD><TITLE>Web Demo</TITLE></HEAD>\n<BODY>\n<P>A hello from all the users.</P>\n<P></P>\n</BODY></HTML>"));
        
    }

}
