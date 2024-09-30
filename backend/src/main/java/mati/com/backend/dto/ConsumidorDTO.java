package mati.com.backend.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumidorDTO {

    private String name;
    private String email;

    private String address;

    private String phone;

    private String gender;

       private Date registration_date;
}
