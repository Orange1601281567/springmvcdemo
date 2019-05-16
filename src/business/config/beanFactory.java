package business.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("business")
@Import( jdbcConfig.class )
public class beanFactory {


}
