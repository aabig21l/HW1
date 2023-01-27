import org.junit.jupiter.api.Test;

import javax.xml.validation.Validator;
import java.util.LinkedList;
import java.util.Queue;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;
public class HtmlValidatorTest {
    private static final String EXPECTED_TEMPLATE = "expected_output/expected_output_for_test%d.txt";
    private static final String INPUT_TEMPLATE = "expected_output/test%d.html";



    @Test
    public void testGetTags() {
        Queue<HtmlTag> tags = new LinkedList<HtmlTag>();
        HtmlValidator validator = new HtmlValidator(tags);
        tags.add(new HtmlTag("html", true));
        tags.add(new HtmlTag("body", true));
        tags.add(new HtmlTag("b", true));
        tags.add(new HtmlTag("b", false));
        tags.add(new HtmlTag("i", true));
        tags.add(new HtmlTag("b", true));
        tags.add(new HtmlTag("b", false));
        tags.add(new HtmlTag("br"));
        tags.add(new HtmlTag("i", false));
        tags.add(new HtmlTag("body", false));
        tags.add(new HtmlTag("html", false));

    }

    @Test
    public void removeAllTest(){
        Queue<HtmlTag> tags = new LinkedList<>();
        tags.add(new HtmlTag("html", true));
        tags.add(new HtmlTag("body", true));
        tags.add(new HtmlTag("b", true));
        tags.add(new HtmlTag("p", true));
        tags.add(new HtmlTag("b", false));
        tags.add(new HtmlTag("p", false));
        tags.add(new HtmlTag("body", false));
        tags.add(new HtmlTag("html", false));
        HtmlValidator validator = new HtmlValidator(tags);
        validator.removeAll("p");
        assertEquals(6,tags.size());
        assertFalse(tags.contains(new HtmlTag("p, true")));

    }
    @Test
    public void testValidate1(){
        Queue<HtmlTag> tags = new LinkedList<>();
        tags.add(new HtmlTag("html", true));
        assertEquals(1,tags.size());
    }
    @Test
    public void testValidate2(){
        Queue<HtmlTag> tags = new LinkedList<>();
        tags.add(new HtmlTag("html", true));
        tags.add(new HtmlTag("body", true));

        assertEquals(2,tags.size());
    }
    @Test
    public void testValidate3(){
        Queue<HtmlTag> tags = new LinkedList<>();
        tags.add(new HtmlTag("html", true));
        tags.add(new HtmlTag("body", true));
        tags.add(new HtmlTag("b", true));

        assertEquals(3,tags.size());
    }
    @Test
    public void testValidate4(){
        Queue<HtmlTag> tags = new LinkedList<>();
        tags.add(new HtmlTag("html", true));
        tags.add(new HtmlTag("body", true));
        tags.add(new HtmlTag("b", true));
        tags.add(new HtmlTag("i", true));
        assertEquals(4,tags.size());
    }
    @Test
    public void testValidate5(){
        Queue<HtmlTag> tags = new LinkedList<>();
        tags.add(new HtmlTag("html", true));
        tags.add(new HtmlTag("body", true));
        tags.add(new HtmlTag("b", true));
        tags.add(new HtmlTag("i", true));
        tags.add(new HtmlTag("i", false));
        assertEquals(5,tags.size());
    }
    @Test
    public void testValidate6(){
        Queue<HtmlTag> tags = new LinkedList<>();
        tags.add(new HtmlTag("html", true));
        tags.add(new HtmlTag("body", true));
        tags.add(new HtmlTag("b", true));
        tags.add(new HtmlTag("i", true));
        tags.add(new HtmlTag("i", false));
        tags.add(new HtmlTag("b", false));
        assertEquals(6,tags.size());
    }
    @Test
    public void testValidate7(){
        Queue<HtmlTag> tags = new LinkedList<>();
        tags.add(new HtmlTag("html", true));
        tags.add(new HtmlTag("body", true));
        tags.add(new HtmlTag("b", true));
        tags.add(new HtmlTag("i", true));
        tags.add(new HtmlTag("i", false));
        tags.add(new HtmlTag("b", false));
        tags.add(new HtmlTag("body", false));
        assertEquals(7,tags.size());
    }
    @Test
    public void testValidate8(){
        Queue<HtmlTag> tags = new LinkedList<>();
        tags.add(new HtmlTag("html", true));
        tags.add(new HtmlTag("body", true));
        tags.add(new HtmlTag("b", true));
        tags.add(new HtmlTag("i", true));
        tags.add(new HtmlTag("i", false));
        tags.add(new HtmlTag("b", false));
        tags.add(new HtmlTag("body", false));
        tags.add(new HtmlTag("html", false));
        assertEquals(8,tags.size());
    }


}



