package com.ott.ott_server.dto.social;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSocialSignupRequestDto {
    private String accessToken;
}
