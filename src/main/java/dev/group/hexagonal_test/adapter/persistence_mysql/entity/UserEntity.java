package dev.group.hexagonal_test.adapter.persistence_mysql.entity;

import dev.group.hexagonal_test.domain.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50)
    private String surname;

    @Column(length = 200)
    private String email;

    public static UserEntity fromDomain (User user) {
        var entity = new UserEntity();

        entity.id = user.getId();
        entity.name = user.getName();
        entity.surname = user.getSurname();
        entity.email = user.getEmail();

        return entity;
    }

    public User toDomain () {
        var user = new User();

        user.setId(this.id);
        user.setName(this.name);
        user.setSurname(this.surname);
        user.setEmail(this.email);

        return user;
    }
}
