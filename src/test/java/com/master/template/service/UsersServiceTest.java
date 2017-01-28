/*
package co.id.collega.gw.service;

import co.id.collega.gw.GatewayApp;
import co.id.collega.gw.domain.User;
import co.id.collega.gw.domain.UserExample;
import co.id.collega.gw.mapper.UserMapper;
import co.id.collega.gw.service.util.RandomUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GatewayApp.class)
@ActiveProfiles("dev")
public class UsersServiceTest {


    @Inject
    private UserAndPrivilegeService userService;

    @Inject
    private UserMapper userMapper;

    @Test
    public void assertThatCreateUserTrue(){
        User user = userService.saveUser("edwar", "edwar", "Edwar", "Saripudin", "edwar.saripudin92@gmail.com", "en-US","system", ZonedDateTime.now());
        assertThat(user != null).isFalse();
        userMapper.deleteByPrimaryKey(user.getUserId());

    }

    @Test
    public void  assertThatActivateRegistrationTrue(){
        UserExample criteria=new UserExample();
        User user=new User();
        criteria.createCriteria().andUserNameEqualTo("edwar");
        user.setActivationKey(RandomUtil.generateActivationKey());
        userMapper.updateByExampleSelective(user,criteria);
        user=userMapper.selectByExample(criteria).get(0);
        Optional<User> result=userService.activateRegistration(user.getActivationKey().toString());
        assertThat(result.isPresent()).isTrue();

    }

    @Test
    public void assertThatActivateRegistrationFalse(){
        UserExample criteria=new UserExample();
        User user=new User();
        criteria.createCriteria().andUserNameEqualTo("edwar");
        user.setActivationKey(RandomUtil.generateActivationKey());
        userMapper.updateByExampleSelective(user,criteria);
        Optional<User> result=userService.activateRegistration("");
        assertThat(result.isPresent()).isFalse();

    }


}
*/
