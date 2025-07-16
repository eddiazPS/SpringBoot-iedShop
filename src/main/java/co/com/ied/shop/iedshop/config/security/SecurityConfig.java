package co.com.ied.shop.iedshop.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@Deprecated
public class SecurityConfig {


/*    @Bean
    public UserDetailsManager userDetailsManager (DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "SELECT user_id, pw , active FROM members WHERE user_id=?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT user_id, role FROM roles WHERE user_id=?");


        return jdbcUserDetailsManager;
    }*/



   /* @Bean
    public SecurityFilterChain filterChain(HttpSecurity http ) throws Exception{
        http.authorizeHttpRequests( configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/iedapi/productos").hasAnyRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/iedapi/productos/**").hasAnyRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/iedapi/productos").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.PATCH, "/iedapi/productos/**").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/iedapi/productos/**").hasAnyRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/iedapi/inventario").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/iedapi/inventario/**").hasAnyRole("ADMIN")
                      //  .requestMatchers(HttpMethod.POST,"/iedapi/venta/**").hasAnyRole("ADMIN")

*//*
                        .requestMatchers(HttpMethod.GET, "/iedapi/inventario/**").hasAnyRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/iedapi/inventario").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.PATCH, "/iedapi/inventario/**").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/iedapi/inventario/**").hasAnyRole("ADMIN")
        *//*

        );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        return http.build();

    }
*/

}
