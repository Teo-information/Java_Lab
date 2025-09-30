package dev.group.hexagonal_test.domain.model;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Nonnull
    private Long id;
    @Nonnull
    private String name;
    private String surname;
    @Nonnull
    private String email;
}
