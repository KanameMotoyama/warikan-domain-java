package warikan.domain.model;

import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Party {
  @NonNull private final String name;
  @NonNull private final Member secretary;
  @NonNull private final OffsetDateTime holdAt;
  private Map<PaymentDuty, Double> rates;
  private Set<Participation> participations = new HashSet<>();

  public boolean participate(@NonNull Member member, @NonNull PaymentDuty duty) {
    var p = new Participation(member, duty);
    if (participations.contains(p)) {
      participations.remove(p);
    }
    return participations.add(p);
  }
  public void rates(double... values) {
    this.rates = PaymentDuty.rates(values);
  }

  public Map<Member, Money> warikan(Money total) {
    if (rates==null || rates.isEmpty()|| participations==null || participations.isEmpty()) {
      throw new IllegalStateException("rates or participations is not set");
    }
    double totalWeight = this.participations.stream()
        .map(m -> m.getDuty())
        .mapToDouble(d -> rates.get(d))
        .sum();
    return this.participations.stream()
        .collect(Collectors.toMap(
          m -> m.getMember(),
          m -> total.times(rates.get(m.getDuty())/ totalWeight, RoundingMode.CEILING)
        ));
  }
}
