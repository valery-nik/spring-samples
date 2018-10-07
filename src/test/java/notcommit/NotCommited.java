package notcommit;

import com.example.demo.properties.SupportedRoleTemplatesProperties;
import com.example.demo.properties.YAMLConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ActiveProfiles("test")
@TestExecutionListeners(MockitoTestExecutionListener.class)
@ContextConfiguration(classes = MyConfig.class, initializers = ConfigFileApplicationContextInitializer.class)
public class NotCommited extends AbstractTestNGSpringContextTests {

    @Autowired
    YAMLConfig myConfig;

    @Autowired
    SupportedRoleTemplatesProperties supportedRoleTemplatesProperties;

    @Test
    public void simpleTest() {
        System.out.println("using environment: " + myConfig.getEnvironment());
        System.out.println("name: " + myConfig.getName());
        System.out.println("servers: " + myConfig.getServers());
    }

    @Test
    public void printRolesYml() {
        supportedRoleTemplatesProperties.getSupportedRoleTemplates().forEach(System.out :: println);
    }

}
