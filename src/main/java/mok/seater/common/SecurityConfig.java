package mok.seater.common;


import org.springframework.context.annotation.Configuration;

@Configuration
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
}
