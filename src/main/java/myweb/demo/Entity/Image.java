package myweb.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "format",nullable = false)
    private String format;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "url",nullable = false)
    private String url;
    @ManyToOne
    @JoinColumn(name = "cars_id",nullable = false)
    private Cars cars;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
