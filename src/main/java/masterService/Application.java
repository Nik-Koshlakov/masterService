package masterService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Created by Nik on 27.03.2017.
 */
@SpringBootApplication
//@EnableScheduling
public class Application {
    public static void main(String[] args)
    {
        ApplicationContext app = SpringApplication.run(Application.class,args);
    }
}
