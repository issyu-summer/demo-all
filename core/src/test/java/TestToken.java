import com.example.core.entity.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import com.example.core.util.JwtUtil;

/**
 * @author issyu 30320182200070
 * @date 2021/1/19 17:11
 */
@Slf4j
public class TestToken {


    @Test
    public void Test(){
        LoginUser loginUser = new LoginUser(1L,"test","test");

        String token = JwtUtil.createToken(loginUser,2);

        log.error(token);
    }

}
