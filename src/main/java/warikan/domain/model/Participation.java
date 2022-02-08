package warikan.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@AllArgsConstructor
@EqualsAndHashCode(of="member")
public class Participation {
  @NonNull
  private final Member member;
  @NonNull
  private PaymentDuty duty;
}
