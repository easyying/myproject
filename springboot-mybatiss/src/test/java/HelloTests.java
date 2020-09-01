import com.alibaba.fastjson.JSON;
import com.example.myproject.ApplicationC;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.net.URL;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationC.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloTests {
    private MockMvc mvc;
    @Autowired
    private TestRestTemplate restTemplate;
    private URL base;
    //private int port = 8080;
    @LocalServerPort
    private int port;//classes属性指定启动类，SpringBootTest.WebEnvironment.RANDOM_PORT经常和测试类中@LocalServerPort一起在注入属性时使用。会随机生成一个端口号。


    @Before
    public void setUp() throws Exception {
        String url = String.format("http://localhost:%d/", port);
        System.out.println(String.format("port is : [%d]", port));
        this.base = new URL(url);
    }

    /**
     * 无入参
     * 向"/hello"地址发送请求，并打印返回结果
     * @throws Exception
     */
    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = this.restTemplate.getForEntity(
                this.base.toString() + "/hello", String.class, "");
        System.out.println(String.format("测试结果为：%s", response.getBody()));
    }


    @Autowired
    DataSourceProperties dataSourceProperties;
    @Autowired
    ApplicationContext applicationContext;
    @Resource(name = "myDataSource")
    private DataSource myDataSource;
    /**
     * 测试数据路连接成功没
     * @throws Exception
     */
    @Test
    public void contextLoads() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(myDataSource);
        List<?> resultList = jdbcTemplate.queryForList("select * from userspringboot");
        System.out.println("===>>>>>>>>>>>" + JSON.toJSONString(resultList));
    }
    @Test
    public void test(){
        System.out.println("测试数据库连接成功没："+ myDataSource.getClass());
    }

    @Autowired
    DataSource dataSource;
    @Test
    public void contextLoads1() throws Exception{
        System.out.println("获取的数据库连接为:"+ dataSource.getConnection());
    }



    /*@Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }*/

   /* @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
                //.andExpect(content().string(equalTo("Hello World")));
    }*/



}

