package org.nackademin.guesthousecustomerservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Namn är obligatoriskt")
    private String name;

    @Email(message = "Ogiltig e-postadress")
    @NotBlank(message = "E-post är obligatorisk")
    private String email;

    @NotBlank(message = "Telefonnummer är obligatoriskt")
    private String phoneNumber;
}