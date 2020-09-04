import java.text.DateFormat;
import java.util.Date;

import com.daguo.WebApplication;
import com.daguo.dao.UserWebDao;
import com.daguo.model.UserWebModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

/**
 * 单元测试：不是测试远程服务，所以无需写url之类的
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)//要指明WebApplication
public class UserWebDaoTest {
    @Autowired
    private UserWebDao userDao;

    /**
     * 测试jpa的dao（根据方法名自动生成sql）
     */
    @Test
    public void test(){
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userDao.save(new UserWebModel("aa1", "aa@126.com", "aa", "aa123456",formattedDate));
        userDao.save(new UserWebModel("bb2", "bb@126.com", "bb", "bb123456",formattedDate));
        userDao.save(new UserWebModel("cc3", "cc@126.com", "cc", "cc123456",formattedDate));

//		Assert.assertEquals(9, userRepository.findAll().size());
        Assert.assertEquals("bb2", userDao.findByUserNameOrEmail("bb", "xxx126.com").getNickName());
        userDao.delete(userDao.findByUserName("aa"));
    }
}
