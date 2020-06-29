package myweb.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Column(name = "format",nullable = false)
    private String format;
    @Column(name = "url",nullable = false)
    private String url;
    @Column(name = "name",nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "cars_id",nullable = false)
    private Cars cars;
}
