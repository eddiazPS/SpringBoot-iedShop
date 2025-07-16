package co.com.ied.shop.iedshop.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {


    @Bean
    public UserDetailsManager userDetailsManager (DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "SELECT user_id, pw , active FROM members WHERE user_id=?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT user_id, role FROM roles WHERE user_id=?");


        return jdbcUserDetailsManager;

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http ) throws Exception{
        http.authorizeHttpRequests( configurer ->
                configurer

                        //DATA REST productos
                        .requestMatchers(HttpMethod.GET, "/productos").hasAnyRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/productos/**").hasAnyRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/productos").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.PATCH, "/productos/**").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/productos/**").hasAnyRole("ADMIN")

                        //DATA REST inventario
                        .requestMatchers(HttpMethod.GET, "/inventario").hasAnyRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PATCH, "/inventario/**").hasAnyRole("MANAGER")



                        //permitAll
                        .requestMatchers(HttpMethod.GET, "/prod/all").permitAll()
                        .requestMatchers(HttpMethod.POST, "/inve/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/inve/producto/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/swagger-ui/index.html").permitAll()
                        .requestMatchers(HttpMethod.GET, "/swagger-ui.html").permitAll()

        );


        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        return http.build();

    }


}
