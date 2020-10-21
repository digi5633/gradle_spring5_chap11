package gradle_spring5_chap11.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ ContextDataSource.class, ContextSqlSession.class })
@ComponentScan(basePackages = { "gradle_spring5_chap11.controller", "gradle_spring5_chap11.survey" })
public class ControllerConfig {

}
