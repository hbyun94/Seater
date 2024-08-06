package mok.seater.login.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "T_USER")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String password;

}
