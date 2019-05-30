package com.edutilos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * Created by Nijat Aghayev on 27.05.19.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
          http
            .authorizeRequests()
            .antMatchers("/", "/home")
            .access("hasRole('ROLE_USER')")
//            .antMatchers("/", "/**").access("permitAll")

            .and()
            .formLogin()
            .loginPage("/login")
//                  .loginProcessingUrl("/register")
//                  .successForwardUrl("/design")
//            .usernameParameter("username")
//            .passwordParameter("password")

            .and()
            .logout()
            .logoutSuccessUrl("/")

            .and()
            .csrf()
            .ignoringAntMatchers("/h2-console/**")

            .and()
            .headers()
            .frameOptions()
            .sameOrigin();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        LdapAuthenticationProviderConfigurer<AuthenticationManagerBuilder> builder =
//                auth.ldapAuthentication();
//
//                builder.userSearchBase("ou=people")
//                        .passwordEncoder(new BCryptPasswordEncoder())
//                .userSearchFilter("(uid={0})")
//                .groupSearchBase("ou=groups")
//                .groupSearchFilter("member={0}")
//                .contextSource()
//                .root("dc=tacocloud,dc=com")
//                .ldif("classpath:users.ldif")
//                .port(12345)
//                ;

//                builder.passwordCompare()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .passwordAttribute("passcode");

//    }


    //    @Autowired
//    private DataSource dataSource;
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .dataSource(dataSource);
//    }

    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("foo")
//                .password("{noop}bar")
//                .authorities("ROLE_USER")
//                .and()
//                .withUser("leo")
//                .password("{noop}messi")
//                .authorities("ROLE_USER");
//    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(createUser("foo", "bar", "ROLE_USER"));
//        manager.createUser(createUser("leo", "messi", "ROLE_USER"));
//        return manager;
//    }
//
//    private UserDetails createUser(String username, String password, String... authorities) {
//        return User.withDefaultPasswordEncoder()  // deprecated
//                .username(username)
//                .password(password)
//                .authorities(authorities)
//                .build();
//    }
}
