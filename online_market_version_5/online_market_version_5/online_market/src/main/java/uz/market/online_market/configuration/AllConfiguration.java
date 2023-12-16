package uz.market.online_market.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import uz.market.online_market.entity.AllUsers;
import uz.market.online_market.service.AllUsersService;

import java.util.List;

@EnableWebSecurity
@Configuration
public class AllConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security
                .csrf().disable()
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers("/api/get").permitAll().anyRequest().authenticated()
                )
                .httpBasic();
        return security.build();
    }
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {

        UserDetails superAdmin = User.builder()
                .username("SUPERADMIN")
                .password(passwordEncoder.encode("SUPERADMINPASSWORDFORSUPERADMIN"))
                .roles("SUPERADMIN")
                .build();
        UserDetails user =User.builder()
                .username("USER")
                .password(passwordEncoder.encode("USERPASSWORDFORUSER"))
                .roles("USER")
                .build();
        UserDetails user4 = User.builder()
                .username("USER4")
                .password(passwordEncoder.encode("USERPASSWORDFORUSER4"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("ADMIN")
                .password(passwordEncoder.encode("ADMINPASSWORDFORADMIN"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, user4, admin, superAdmin);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
