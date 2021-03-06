package ru.itmo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itmo.model.enums.OrganizationType;

import javax.persistence.*;
import javax.validation.constraints.Min;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "organization")
public class Organization {
    @Id
    //@SequenceGenerator(name="ORGANIZATION_SEQUENCE", sequenceName="SQ_ORGANIZATION_SEQUENCE")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @Column(name = "name", nullable = false)
    private String name; //Поле не может быть null, Строка не может быть пустой
    @Column(name = "fullName", nullable = false)
    private String fullName; //Длина строки не должна быть больше 1599, Поле не может быть
    @Min(0)
    @Column(name = "employeesCount")
    private Long employeesCount; //Значение поля должно быть больше 0
    @Column(name = "type", nullable = false)
//    @Enumerated(EnumType.STRING)
    private OrganizationType type; //Поле не может быть
}
