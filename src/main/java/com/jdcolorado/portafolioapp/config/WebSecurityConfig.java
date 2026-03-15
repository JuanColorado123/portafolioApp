package com.jdcolorado.portafolioapp.config;

import com.jdcolorado.portafolioapp.service.IUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private IUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http){
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/education",
                                "/experiences",
                                "/personal-info",
                                "/projects",
                                "/skills"
                        ).authenticated()
                        .requestMatchers(
                                "/education/new", "/education/save", "/education/delete/**", "/education/edit/**"
                        ).authenticated()
                        .requestMatchers(
                                "/experiences/new", "/experiences/save", "/experiences/delete/**", "/experiences/edit/**"
                        ).authenticated()
                        .requestMatchers(
                                "/personal-info/new", "/personal-info/save", "/personal-info/delete/**", "/personal-info/edit/**")
                        .authenticated()
                        .requestMatchers(
                                "/projects/new-project", "/projects/save", "/projects/delete/**", "/projects/edit/**"
                        ).authenticated()
                        .requestMatchers(
                                "/skills/new", "/skills/save", "/skills/delete/**", "/skills/edit/**"
                        ).authenticated()
                        .anyRequest().permitAll()
                )
                .formLogin(form->
                        form.loginPage("/login").permitAll())
                .logout(logout-> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                );

        return http.build();
    }

    protected void configure(AuthenticationManagerBuilder auth){
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }














//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
//        UserDetails user = User.withUsername("admin")
//                .password(passwordEncoder.encode("1234"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }
}
