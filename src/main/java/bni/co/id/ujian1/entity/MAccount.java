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
@Table(name = "master_account_andi", schema = "backoffice")
public class MAccount extends AbsBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "master_account_andi_seq", sequenceName = "master_account_andi_seq", allocationSize = 1)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private MUser userId;

    @Column(name = "balance")
    private Double balance;
}
