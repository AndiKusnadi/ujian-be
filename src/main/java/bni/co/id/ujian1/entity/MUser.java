package bni.co.id.ujian1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "master_user_andi", schema = "ADMIN_BO")
public class MUser extends AbsBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "master_user_andi_seq", sequenceName = "master_user_andi_seq", allocationSize = 1)
    private Long id;

    @Column(name = "full_name", columnDefinition = "varchar2(255)")
    private String fullName;
}
