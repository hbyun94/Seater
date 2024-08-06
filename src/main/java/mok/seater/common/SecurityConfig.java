package mok.seater.common;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable)
//                .cors(cors -> cors.disable())
//                .sessionManagement(configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(request ->
//                        request.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
//                                .anyRequest().authenticated()
//                )
//                .formLogin(login -> login
//                        .loginPage("/newLogin")
//                        .loginProcessingUrl("/login-process")
//                        .usernameParameter("userId")
//                        .passwordParameter("password")
//                        .defaultSuccessUrl("/main", true)
//                        .permitAll()
//                )
//                .logout(Customizer.withDefaults());
//        return http.build();
//    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception, java.lang.Exception {
//        http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/newLogin").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin(login -> login.disable());
//
//        return http.build();
//    }
}
