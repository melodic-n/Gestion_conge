/*
 * package com.example.demospring.config;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.http.HttpMethod; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.http.SessionCreationPolicy; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.web.authentication.
 * UsernamePasswordAuthenticationFilter; import
 * com.example.demospring.config.AppConfig;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig {
 * 
 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
 * throws Exception { auth .inMemoryAuthentication()
 * .withUser("user").password(AppConfig.passwordEncoder().encode("password")).
 * roles("USER"); }
 * 
 * 
 * protected void configure(HttpSecurity http) throws Exception {
 * http.authorizeRequests() .requestMatchers("/**").permitAll()
 * .anyRequest().authenticated() .and().csrf().disable()
 * .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
 * }
 * 
 * }
 */