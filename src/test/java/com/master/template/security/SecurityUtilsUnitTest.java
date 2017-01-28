/*
package co.id.collega.gw.security;

import co.id.collega.gw.GatewayApp;
import co.id.collega.gw.domain.UserExample;
import co.id.collega.gw.mapper.RoleMapper;
import co.id.collega.gw.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GatewayApp.class)
@ActiveProfiles("dev")
public class SecurityUtilsUnitTest {

    @Inject
    private UserMapper userMapper;

   */
/* @Inject
    private RoleMapper roleMapper;*//*


    @Test
    public void testLogin() {
       // userMapper.selectJoinRoleByUserName("edwar");
        UserExample criteria=new UserExample();
        criteria.createCriteria().andUserNameEqualTo("edwar");
        userMapper.selectJoinRoleByUserName("edwar");
       */
/* SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        securityContext.setAuthentication(new UsernamePasswordAuthenticationToken("edwar", "edwar"));
        SecurityContextHolder.setContext(securityContext);
        String login = SecurityUtils.getCurrentUserLogin();
        assertThat(login).isEqualTo("edwar");*//*

    }

    @Test
    public void testgetCurrentUserLogin() {
        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        securityContext.setAuthentication(new UsernamePasswordAuthenticationToken("edwar", "edwar"));
        SecurityContextHolder.setContext(securityContext);
        String login = SecurityUtils.getCurrentUserLogin();
        assertThat(login).isEqualTo("edwar");
    }

    @Test
    public void testIsAuthenticated() {
        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        securityContext.setAuthentication(new UsernamePasswordAuthenticationToken("edwar", "edwar"));
        SecurityContextHolder.setContext(securityContext);
        boolean isAuthenticated = SecurityUtils.isAuthenticated();
        assertThat(isAuthenticated).isTrue();
    }

    @Test
    public void testAnonymousIsNotAuthenticated() {
        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(AuthoritiesConstants.ANONYMOUS));
        securityContext.setAuthentication(new UsernamePasswordAuthenticationToken("anonymous", "anonymous", authorities));
        SecurityContextHolder.setContext(securityContext);
        boolean isAuthenticated = SecurityUtils.isAuthenticated();
        assertThat(isAuthenticated).isFalse();
    }
}
*/
