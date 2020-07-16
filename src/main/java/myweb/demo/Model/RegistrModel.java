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
    private Integer isActive;
    private String phoneNum;
}
