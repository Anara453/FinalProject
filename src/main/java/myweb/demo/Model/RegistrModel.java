package myweb.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrModel {
    private String name;
    private String email;
    private String password;
    private String isActive;
    private String phoneNum;
}
