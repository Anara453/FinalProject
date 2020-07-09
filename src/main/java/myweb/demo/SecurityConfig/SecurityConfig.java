package myweb.demo.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)

         .usersByUsernameQuery("select login,password,is_active from users where login=?")
         .usersByUsernameQuery("select u.login,ur.role_name from user_role ur inner join users u on ur.user_id=u.id where u.login=? and u.is_active=1");

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.GET,"/cars").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/cars").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/cars").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/cars").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/cars").hasRole("ADMIN")
                .and().csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
