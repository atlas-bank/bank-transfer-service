package atlas.com.service.dtos;

import atlas.com.service.enums.CardLevelEnum;
import atlas.com.service.enums.CardStatusEnum;

public record CreateCardDTO(
        String userCPF,
        String pin,
        String userFullName,
        String deviceId,
        String brand,
        CardStatusEnum status,
        CardLevelEnum level
) {
}
