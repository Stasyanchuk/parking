package ru.study.parking.configuration;

import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableWebSecurity
//@EnableOAuth2Sso
public class WebSecurityConfig /*extends WebSecurityConfigurerAdapter */{
/*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/login**", "/js/**","/error**").permitAll()
                .anyRequest().authenticated()
                .and().logout().logoutSuccessUrl("/").permitAll()
                .and().csrf().disable();
    }

    @Bean
    public PrincipalExtractor principalExtractor(UserDao userDao){
        return map -> {
            String id = (String) map.get("sub");
            UserEntity user = userDao.getById(id);
            if(user == null){
                user = new UserEntity();
                user.setId(id);
                user.setEmail((String)map.get("email"));
                user.setName((String)map.get("name"));
                user.setUserpic((String)map.get("picture"));
                user.setUserpic((String)map.get("picture"));
                user.setLastVisit(LocalDateTime.now());
                userDao.save(user);
            } else {
                user.setLastVisit(LocalDateTime.now());
                userDao.update(user);
            }

            return user;
        };
    }*/
}
