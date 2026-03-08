package atlas.com.service.models;

import atlas.com.service.enums.CardLevelEnum;
import atlas.com.service.enums.CardStatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "card")
public class Card {
    @Id
    private Long id;

    private String PAN;
    private String CVV;
    private String PIN;
    private Date expirationDate;

    //dispositivo de origem da transação
    private String deviceId;

    //tentativas de senha inválida
    private int failedAttempts;

    private Enum<CardStatusEnum> status;
    private Enum<CardLevelEnum> level;

}
