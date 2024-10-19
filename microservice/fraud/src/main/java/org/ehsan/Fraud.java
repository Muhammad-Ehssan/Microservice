package org.ehsan;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Fraud {
    @Id
    @SequenceGenerator(sequenceName = "fraud_id_sequence",name = "fraud_id_sequence")
    @GeneratedValue(generator = "fraud_id_sequence",strategy = GenerationType.SEQUENCE)
    Integer id;
    Integer customerId;
    Boolean fraudster;
    LocalDateTime createdOn;
}
