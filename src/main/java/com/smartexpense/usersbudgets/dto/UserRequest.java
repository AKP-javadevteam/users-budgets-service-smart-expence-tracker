package com.smartexpense.usersbudgets.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * DTO representing the client request to create or update a user profile.
 *
 * <p>Contains fields such as email, optional display name,
 * and preferred default currency.</p>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Email should be valid")
    private String email;

    private String name;

    @NotBlank(message = "Currency must not be blank")
    @Size(min = 3, max = 3, message = "Currency must be a 3-letter ISO code")
    private String defaultCurrency;
}
