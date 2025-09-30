package dev.group.hexagonal_test.domain.model;

import jakarta.annotation.Nonnull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Nonnull
    private Long id;
    @Nonnull
    private String name;
    private String surname;
    @Nonnull
    private String email;
}
