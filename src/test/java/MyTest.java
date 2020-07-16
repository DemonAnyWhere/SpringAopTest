import com.lirui.controller.MySpringAopController;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        MySpringAopController mySpringAopController = context.getBean(MySpringAopController.class);
        mySpringAopController.add(1,1);
        System.out.println(mySpringAopController.getClass());
    }
}
