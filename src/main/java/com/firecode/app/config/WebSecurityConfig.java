package com.firecode.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.firecode.app.controller.security.LoggingAccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.context.request.RequestContextListener;

@Configuration
@EnableWebSecurity
//@EnableAutoConfiguration
//@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true) //  Habilita a seguranca nos metodos
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,
                        "/app/assets/**",
                        "/app/public**", "/authentication",
                        "/error",
                        "/recover/password").permitAll()
                .antMatchers("/app/upload**").authenticated()
                .antMatchers(HttpMethod.GET, "/coachees").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/coachees/create").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/coachees/update/{\\d+}").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/coachees/view/{\\d+}").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/coachees/assessments/view/{\\d+}").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/coachees/assessments/assessment/view/{\\d+}").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/coachees/{\\d+}/assessments/reader").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/coachees/{\\d+}/session/reader").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/coachees/create").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/coachees/update/{\\d+}").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/coachees/delete/{\\d+}").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/coachees/filter").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/authentication")
                .defaultSuccessUrl("/dashboard", true)
                .loginProcessingUrl("/perform_login")
                .passwordParameter("password")
                .usernameParameter("username")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/?logout")
                .permitAll()
                .and()
                .rememberMe()
                .userDetailsService(this.userDetailsService)
                .and()
                .sessionManagement()
                .maximumSessions(1)
                .expiredUrl("/authentication?expired")
                .and()
                .sessionFixation().migrateSession()
                .invalidSessionUrl("/authentication?invalid")
                .sessionAuthenticationErrorUrl("/authentication?invalid")
                .and()
                .exceptionHandling()
                .accessDeniedHandler(this.accessDeniedHandler)
                .and()
                .csrf().disable();
    }

    @Bean
    SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    // Register HttpSessionEventPublisher
    @Bean
    public static ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean<>(new HttpSessionEventPublisher());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService).passwordEncoder(this.passwordEncoder());
    }

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsService uds) throws Exception {
    auth
        .userDetailsService(uds);
}

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/app/assets/**", "/app/public**");
    }

}
