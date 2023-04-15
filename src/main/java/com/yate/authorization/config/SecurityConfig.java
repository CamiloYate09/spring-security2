package com.yate.authorization.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

/**
 * Created by Yate on 2020/4/8
 * Clase para cambiar por defecto la seguridad de spring
 */

@Configuration
public class SecurityConfig {


    /**
     * Autorización de recursos
     * -----matchers
     * Example:
     *     1. AnyRequest -> cualquier petición
     *     2. RequestMatchers.antMatchers("/demo") -> solo la petición demo (Example 8)
           3. RequestMatchers with HttpMethods -> solo la petición demo con el método get (Example 9)
     *
     * -----Autorización rule
     * Example:
     *  1. permitAll -> todos los usuarios pueden acceder
     *  2. DenyAll -> todos los usuarios no pueden acceder
     *  3. Authenticated -> solo los usuarios autenticados pueden acceder
     *  4. hasRole("admin") -> solo los usuarios con el rol admin pueden acceder
     *  5. HasAuthority("read") -> solo los usuarios con el permiso read pueden acceder
     *  6. Access -> permite definir una expresión para validar la autorización
     *
     * @return
     */


    /**
     * Example 1:
     * Filter Base
     *
     * @param httpSecurity
     * @return
     * @throws Exception //    @Bean
     *                   //    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
     *                   //        return httpSecurity.httpBasic().and().build();
     *                   //    }
     */


    /**
     * Example 2:
     *  Podemos acceder a todos recursos sin problemas
     * @param httpSecurity
     * @return
     * @throws Exception
     *     @Bean
     *     public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
     *         return httpSecurity.httpBasic().and()
     *                 .authorizeHttpRequests(
     *                         authorize -> authorize
     *                                 .anyRequest().permitAll()
     *                 )
     *                 .build();
     *     }
     */


    /**
     * Example 3:
     *  No podra acceder a ningun recurso
     * @param httpSecurity
     * @return
     * @throws Exception
     *     @Bean
     *     public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
     *         return httpSecurity.httpBasic().and()
     *                 .authorizeHttpRequests(
     *                         authorize -> authorize
     *                                 .anyRequest().denyAll()
     *                 )
     *                 .build();
     *     }
     */


    /**
     * Example 4:
     * Solo los usuarios autenticados pueden acceder
     *
     * @param httpSecurity
     * @return
     * @throws Exception
     *     @Bean
     *     public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
     *         return httpSecurity.httpBasic().and()
     *                 .authorizeHttpRequests(
     *                         authorize -> authorize
     *                                 .anyRequest().authenticated()
     *                 )
     *                 .build();
     *     }
     */


    /**
     * Example 5:
     * Solom los usuarios que tengan el ROL ADMIN pueden acceder a los recursos
     * @param httpSecurity
     * @return
     * @throws Exception
     *     @Bean
     *     public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
     *         return httpSecurity.httpBasic().and()
     *                 .authorizeHttpRequests(
     *                         authorize -> authorize
     *                                 .anyRequest().hasRole("ADMIN")
     *                 )
     *                 .build();
     *     }
     *
     *     @Bean
     *     public UserDetailsService userDetailsService() {
     *         return new InMemoryUserDetailsManager(
     *                 User.withUsername("camilo")
     *                         .password(passwordEncoder().encode("camilo"))
     *                         .authorities("read", "ROLE_USER")
     *                         .build(),
     *                 User.withUsername("admin")
     *                         .password(passwordEncoder().encode("admin"))
     *                         .authorities("read", "write", "ROLE_ADMIN")
     *                         .build()
     *         );
     *     }
     */


    /**
     * Example 6:
     *  para este caso cambiamos a hasAuthority para los usuario que tengan read
     * @param httpSecurity
     * @return
     * @throws Exception
     *
     *    @Bean
     *     public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
     *         return httpSecurity.httpBasic().and()
     *                 .authorizeHttpRequests(
     *                         authorize -> authorize
     *                                 .anyRequest().hasAuthority("read")
     *                 )
     *                 .build();
     *     }
     *
     *
     *
     *
     *     @Bean
     *     public UserDetailsService userDetailsService() {
     *         return new InMemoryUserDetailsManager(
     *                 User.withUsername("camilo")
     *                         .password(passwordEncoder().encode("camilo"))
     *                         .authorities("read", "ROLE_USER")
     *                         .build(),
     *                 User.withUsername("admin")
     *                         .password(passwordEncoder().encode("admin"))
     *                         .authorities("read", "write", "ROLE_ADMIN")
     *                         .build()
     *         );
     *     }
     */


    /**
     * Example 7:
     *  para este caso damos acceso para los roles ADMIN y DBA
     *  por debajo el codigo le pone ROLE_ y completa con el nombre del rol hasRole('ADMIN')
     * @param httpSecurity
     * @return
     * @throws Exception
     *     @Bean
     *     public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
     *         return httpSecurity.httpBasic().and()
     *                 .authorizeHttpRequests(
     *                         authorize -> authorize
     *                                 .anyRequest().access(new WebExpressionAuthorizationManager("hasRole('ADMIN') or hasRole('DBA')"))
     *                 )
     *                 .build();
     *     }
     *
     *
     *
     *
     *     @Bean
     *     public UserDetailsService userDetailsService() {
     *         return new InMemoryUserDetailsManager(
     *                 User.withUsername("camilo")
     *                         .password(passwordEncoder().encode("camilo"))
     *                         .authorities("read", "ROLE_USER")
     *                         .build(),
     *                 User.withUsername("admin")
     *                         .password(passwordEncoder().encode("admin"))
     *                         .authorities("read", "write", "ROLE_ADMIN")
     *                         .build(),
     *                 User.withUsername("dba")
     *                         .password(passwordEncoder().encode("admin"))
     *                         .authorities("read", "ROLE_DBA")
     *                         .build()
     *         );
     *     }
     */


    /**
     * Example 8:
     * para este caso damos acceso para los roles ADMIN y DBA y con su path correspondiente
     * @param httpSecurity
     * @return
     * @throws Exception
     *     @Bean
     *     public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
     *         return httpSecurity.httpBasic().and()
     *                 .authorizeHttpRequests(
     *                         authorize -> authorize
     *                                 .requestMatchers("/demo").permitAll()
     *                                 .requestMatchers("/admin").hasRole("ADMIN")
     *                                 .requestMatchers("/dba").hasAnyRole("DBA", "ADMIN")
     *                 )
     *                 .build();
     *     }
     *
     *
     *     @Bean
     *     public UserDetailsService userDetailsService() {
     *         return new InMemoryUserDetailsManager(
     *                 User.withUsername("camilo")
     *                         .password(passwordEncoder().encode("camilo"))
     *                         .authorities("read", "ROLE_USER")
     *                         .build(),
     *                 User.withUsername("admin")
     *                         .password(passwordEncoder().encode("admin"))
     *                         .authorities("read", "write", "ROLE_ADMIN")
     *                         .build(),
     *                 User.withUsername("dba")
     *                         .password(passwordEncoder().encode("admin"))
     *                         .authorities("read", "ROLE_DBA")
     *                         .build()
     *         );
     *     }
     */


    /**
     * Example 9:
     *  ejemplo validando los métodos http
     * @param httpSecurity
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.httpBasic().and()
                .authorizeHttpRequests(
                        authorize -> authorize
                                .requestMatchers(HttpMethod.POST, "/demo").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/add").authenticated()
                )
                .csrf().disable()
                .build();
    }


    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername("camilo")
                        .password(passwordEncoder().encode("camilo"))
                        .authorities("read", "ROLE_USER")
                        .build(),
                User.withUsername("admin")
                        .password(passwordEncoder().encode("admin"))
                        .authorities("read", "write", "ROLE_ADMIN")
                        .build(),
                User.withUsername("dba")
                        .password(passwordEncoder().encode("admin"))
                        .authorities("read", "ROLE_DBA")
                        .build()
        );
    }


    /**
     * Quien maneja las contraseñas
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
