
@EnableConfigurationProperties - активирует механизм @ConfigurationProperties, но классы пропертей всеравно надо самому
    класть в контекст или через аннотацию @Component
@EnableConfigurationProperties({YAMLConfig.class}) - или по-другому, здесь не надо класть в контекст
    и помечать YAMLConfig аннотацией @Component

@PropertySource("classpath:roles.properties") - задает кастомизированный источник хранения настроек, 
    поддерживает только properties файлы. 
@ConfigurationProperties - инкапсуляция пропертей в своем java классе    

@ConfigurationProperties(ignoreUnknownFields = true, prefix = "ldap")
ignoreUnknownFields = false - если в блоке ldap будет неизвестное поле - сгенерить exception
prefix = ldap, говорит о том, что в окружении будут свойства с префиксом ldap, и данный префикс можно использовать 
    только один раз 

- Название полей в ConfigurationProperties-классе должно совпадать с названием в файле пропертей.
----------------------------------------------------------------------
@Configuration
@EnableConfigurationProperties(SupportedRoleTemplatesProperties.class)
@ComponentScan(basePackages = "com.example.demo")
public class AppConfig {
}


--- Конфигурация на основе внешнего файла roles.properties ---
ldap.username=admin
ldap.supportedRoleTemplates[0]=AdminDBO2
ldap.supportedRoleTemplates[1]=SupportOperatorDBO2
ldap.supportedRoleTemplates[2]=GODOperatorDBO2
ldap.supportedRoleTemplates[3]=SecurityManagerDBO2

--------------------------------------------------------------
environment: test
servers:
    - www.abc.test.com
    - www.xyz.test.com
ldap:
  username: roles.yml
  supportedRoleTemplates:
    - YYYYY
    - AdminDBO2
    - SupportOperatorDBO2
    - GODOperatorDBO2
    - SecurityAdminDBO2
    - SecurityManagerDBO2
    - OperatorDBO2
    - ControllerDBO2
    - FraudOperatorDBO2
    - SystemFraudDBO2
    - TechSignerDBO2
    - SystemAccessControlDBO2
    - SystemAuthInternalDBO2
    - SystemMigrationDBO2
---
spring:
    profiles: default
name: prod-YAML
environment: production
servers:
    - www.abc.com
    - www.xyz.com
    
--------------------------------------------------------------

@Data
@Component
@PropertySource("classpath:roles.properties") 
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "ldap")
public class SupportedRoleTemplatesProperties {

    private List<String> supportedRoleTemplates = new ArrayList<>();
    private String username;

}

------------------------------------------------------------------
---- загрузка пропертей в тестах ------
@ActiveProfiles("test") -- загрузятся тестовые конфиги
@TestExecutionListeners(MockitoTestExecutionListener.class)
@ContextConfiguration(classes = MyConfig.class, initializers = ConfigFileApplicationContextInitializer.class) -- загружается application.yml
@ContextConfiguration(classes = MyConfig.class) -- загружается *.properties файл, в зависимости он пути в анотации @PropertySource
public class NotCommited extends AbstractTestNGSpringContextTests {

    @Autowired
    YAMLConfig myConfig;

    @Autowired
    SupportedRoleTemplatesProperties supportedRoleTemplatesProperties;

    @Test
    public void printRolesYml() {
        supportedRoleTemplatesProperties.getSupportedRoleTemplates().forEach(System.out :: println);
    }

}

---- загрузка yaml пропертей в приложении ------
yaml будет загружаться, только если приложение помечено @SpringBootApplication

@SpringBootApplication
public class MyApplication implements CommandLineRunner {

    @Autowired
    private YAMLConfig myConfig;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MyApplication.class);
        app.run();
    }

    public void run(String... args) throws Exception {
        System.out.println("using environment: " + myConfig.getEnvironment());
        System.out.println("name: " + myConfig.getName());
        System.out.println("servers: " + myConfig.getServers());
    }
}

---- загрузка properties пропертей в приложении ------
@EnableConfigurationProperties + @SpringBootConfiguration - загрузит любые properties

@SpringBootApplication - загрузит еще и yaml пропертис
