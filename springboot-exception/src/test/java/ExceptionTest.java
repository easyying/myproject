import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ExceptionTest {

    @Autowired
    MockMvc mockMvc;//实现了对Http请求的模拟

    @Test
    public void should_return_400_if_param_not_valid() throws Exception {
        mockMvc.perform(get("/illegalArgumentException"))
                .andExpect(status().is(400))
                .andExpect(jsonPath("$.message").value("参数错误!"));
    }

    @Test
    public void should_return_404_if_business_found() throws Exception {
        mockMvc.perform(get("/businessException"))
                .andExpect(status().is(404))
                .andExpect(jsonPath("$.message").value("自定义异常错误!"));
    }

}
