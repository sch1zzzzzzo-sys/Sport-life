package org.example.Avatar;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Employee.Employee;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "avatar")
@NoArgsConstructor
@AllArgsConstructor
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "avatar", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Employee> employee=new ArrayList<>();

    public Avatar(String name) {
        this.name=name;
    }
}
