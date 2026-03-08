package atlas.com.service.models;

import atlas.com.service.enums.CardLevelEnum;
import atlas.com.service.enums.CardStatusEnum;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userCPF;

    private String PAN;
    private String CVV;
    private String PIN;
    private LocalDate expirationDate;
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


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private boolean international;
}
