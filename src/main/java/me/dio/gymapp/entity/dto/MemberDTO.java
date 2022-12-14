package me.dio.gymapp.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

    @NotEmpty(message = "This attribute is required.")
    @Size(min = 3, max =50, message = "'${validatedValue}' has to contain between {min} and {max} characteres.")
    private String name;

    @NotEmpty(message = "This attribute is required.")
    @CPF(message = "'${validatedValue}' is invalid!")
    private String cpf;

    @NotEmpty(message = "This attribute is required.")
    @Size(min = 3, max =50, message = "'${validatedValue}' has to contain between {min} and {max} caracteres.")
    private String neighborhood;

    @NotNull(message = "This attribute is required.")
    @Past(message = "Date '${validatedValue}' is invalid.")
    private LocalDate birthDate;

}
