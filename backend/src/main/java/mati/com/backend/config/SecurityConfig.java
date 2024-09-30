// package mati.com.backend.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//                 .csrf(csrf -> csrf.disable()) // Desabilita a proteção CSRF (não recomendado em produção)
//                 .authorizeHttpRequests((requests) -> requests
//                                 .requestMatchers("/public/**").permitAll() // Rotas públicas
//                                 .anyRequest().authenticated()// Qualquer outra requisição precisa de autenticação
//                 );
//                 // .httpBasic(); // Usa autenticação básica

//         return http.build();
//     }

//     // Define usuários em memória (para fins de teste)
// //     @Bean
// //     public UserDetailsService userDetailsService() {
// //         @SuppressWarnings("deprecation")
// //         UserDetails user = User.withDefaultPasswordEncoder()
// //             .username("user")
// //             .password("password")
// //             .roles("USER")
// //             .build();

// //         return new InMemoryUserDetailsManager(user);
// // }
// }