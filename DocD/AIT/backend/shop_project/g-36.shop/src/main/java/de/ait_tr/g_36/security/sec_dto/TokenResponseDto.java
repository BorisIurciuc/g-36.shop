package de.ait_tr.g_36.security.sec_dto;

import java.util.Objects;

/**
 * 20/08/2024 g-36.shop
 *
 * @author Boris Iurciuc (cohort36)
 */
public class TokenResponseDto {

  // fields
  private String accessToken;
  private String refreshToken;

  // constructor
  public TokenResponseDto(String accessToken, String refreshToken) {
    this.accessToken = accessToken;
    this.refreshToken = refreshToken;
  }

  // getters
  public String getAccessToken() {
    return accessToken;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof TokenResponseDto that)) return false;
    return Objects.equals(accessToken, that.accessToken) && Objects.equals(refreshToken, that.refreshToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessToken, refreshToken);
  }

  @Override
  public String toString() {
    return String.format("Token response: access token - %s, refresh token - %s",
        accessToken, refreshToken);
  }
}
