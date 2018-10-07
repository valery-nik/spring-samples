package notcommit;

import com.example.demo.properties.YAMLConfig;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.demo.properties"})
@EnableConfigurationProperties()
//@EnableConfigurationProperties({YAMLConfig.class})
@SpringBootConfiguration
public class MyConfig {

//    @Bean
//    @ConfigurationProperties(prefix = "supportedRoleTemplates")
//    public SupportedRoleTemplates supportedRoleTemplates() {
//        return new SupportedRoleTemplates();
//    }
}
