package cinema.config;

import static cinema.model.Role.RoleName.ADMIN;
import static cinema.model.Role.RoleName.USER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsService userDetailsService;

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(getEncoder());
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers(HttpMethod.POST, "/register").anonymous()
                .mvcMatchers(HttpMethod.GET, "/cinema-halls",
                        "/movies", "/movie-sessions/available")
                .hasAnyRole(USER.name(), ADMIN.name())
                .mvcMatchers(HttpMethod.GET, "/users/by-email")
                .hasRole(ADMIN.name())
                .mvcMatchers(HttpMethod.POST, "/cinema-halls",
                        "/movies", "/movie-sessions")
                .hasRole(ADMIN.name())
                .mvcMatchers(HttpMethod.PUT, "/movie-sessions/**")
                .hasRole(ADMIN.name())
                .mvcMatchers(HttpMethod.DELETE, "/movie-sessions/**")
                .hasRole(ADMIN.name())
                .mvcMatchers(HttpMethod.GET, "/orders", "/shopping-carts/by-user")
                .hasRole(USER.name())
                .mvcMatchers(HttpMethod.POST, "/orders/complete")
                .hasRole(USER.name())
                .mvcMatchers(HttpMethod.PUT, "/shopping-carts/movie-sessions")
                .hasRole(USER.name())
                .and()
                .formLogin()
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }
}
