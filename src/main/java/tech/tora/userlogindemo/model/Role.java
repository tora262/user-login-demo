package tech.tora.userlogindemo.model;

import lombok.Getter;
import lombok.Setter;
import tech.tora.userlogindemo.common.ERole;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private ERole name;
}
