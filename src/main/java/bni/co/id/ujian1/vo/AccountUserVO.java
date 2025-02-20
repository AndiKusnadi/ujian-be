package bni.co.id.ujian1.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class AccountUserVO implements Serializable {
    private String fullName;
    private Double totalAmount;
}
