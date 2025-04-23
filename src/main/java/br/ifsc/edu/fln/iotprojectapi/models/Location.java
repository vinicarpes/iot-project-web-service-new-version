package br.ifsc.edu.fln.iotprojectapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_location")
@Data //generates getter, setters, toString, equals methods
@NoArgsConstructor // enables no args constructors
@AllArgsConstructor //enabels all args constructors
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private float latitude;
    @Column(nullable = false)
    private float longitude;
    @Column(name = "cep")
    private String postalCode; //postal code == cep
    private String city;
    private String district;
    @Column(name = "state_name")
    private String state;
    private String number;
    private String complement;

}
