package org.nackademin.guesthousecustomerservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private Long id;

    @NotBlank(message = "Namn är obligatoriskt")
    private String name;

    @Email(message = "Ogiltig e-postadress")
    @NotBlank(message = "E-post är obligatorisk")
    private String email;

    @NotBlank(message = "Telefonnummer är obligatoriskt")
    private String phoneNumber;
}