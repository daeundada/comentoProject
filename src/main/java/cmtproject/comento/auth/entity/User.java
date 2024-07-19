package cmtproject.comento.auth.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Setter
    @Column(nullable = false, unique = true)
    private String username;

    @Setter
    @Column(nullable = false)
    private String password;
}
