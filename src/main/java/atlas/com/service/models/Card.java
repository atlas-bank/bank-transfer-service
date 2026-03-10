package atlas.com.service.models;

import atlas.com.service.enums.CardLevelEnum;
import atlas.com.service.enums.CardStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.YearMonth;

@Entity
@Table(name = "cards")
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userCPF;

    private String PAN;
    private String CVV;
    private String PIN;
    private YearMonth expirationDate;

    private String brand;

    private String cardholderName;

    //dispositivo de origem da transação
    private String deviceId;

    //tentativas de senha inválida
    private int failedAttempts;

    @Enumerated(EnumType.STRING)
    private CardStatusEnum status;

    @Enumerated(EnumType.STRING)
    private CardLevelEnum level;

    private boolean international;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Card(Long id,
                String userCPF,
                String brand,
                String cardholderName,
                String deviceId,
                CardStatusEnum status,
                CardLevelEnum level,
                boolean international
    ) {
        this.id = id;
        this.userCPF = userCPF;
        this.expirationDate = YearMonth.now().plusMonths(30);
        this.brand = brand;
        this.cardholderName = cardholderName;
        this.deviceId = deviceId;
        this.failedAttempts = 0;
        this.status = status;
        this.level = level;
        this.international = international;

        LocalDateTime date = LocalDateTime.now();
        this.createdAt = date;
        this.updatedAt = date;
    }
}
