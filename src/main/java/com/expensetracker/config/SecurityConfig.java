package com.expensetracker.config;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {

//	public class SecurityConfig extends WebSecurityConfigurerAdapter{

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/api/register").permitAll() // Permit access to the registration endpoint
//                .anyRequest().authenticated() // Require authentication for all other endpoints
//            .and()
//            .csrf().disable(); // Disable CSRF protection for simplicity (customize as needed)
//    }
}
