package br.ifsc.edu.fln.iotprojectapi.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationDTO {

    private Long id;

    @NotNull //bean validation
    private float latitude;

    @NotNull
    private float longitude;

    @NotBlank
    @Size(max = 10)
    private String postalCode;

    @NotBlank
    @Size(max = 100)
    private String address;

    @NotBlank
    @Size(max = 60)
    private String city;

    @NotBlank
    @Size(max = 60)
    private String district;

    @NotBlank
    @Size(max = 30)
    private String state;

    @NotBlank
    @Size(max = 10)
    private String number;

    @NotBlank
    @Size(max = 60)
    private String complement;
}
