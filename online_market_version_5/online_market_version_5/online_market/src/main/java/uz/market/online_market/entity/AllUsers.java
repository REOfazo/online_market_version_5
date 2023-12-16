package uz.market.online_market.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import uz.market.online_market.role.Role;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "all_users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AllUsers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "e_mail", nullable = false, unique = true)
    private String eMail;

    @Column(name = "passport_series", nullable = false, unique = true)
    private String passportSeries;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "user_password", nullable = false, unique = true)
    private String userPassword;

    @Column(name = "region",nullable = false)
    private String region;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "user_create_date")
    @CreationTimestamp
    private LocalDateTime userCreateDate;

    @Column(name = "user_update_date")
    @UpdateTimestamp
    private LocalDateTime userUpdateDate;

}
