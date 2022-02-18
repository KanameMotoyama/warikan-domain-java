package warikan.domain.model;

import java.util.List;
import java.util.stream.Collectors;
import warikan.domain.model.members.Member;

public class Cashier {
  public Money billingAmount;

  public Cashier(Money billingAmount) {
    this.billingAmount = billingAmount;
  }

  public List<Payment> warikan(List<Member> members) {
    // int smallNum = members.stream().filter(m -> m.paymentType.paymentTypeName ==
    // PaymentTypeName.SMALL).count();
    // int mediumNum = members.stream().filter(m -> m.paymentType.paymentTypeName ==
    // PaymentTypeName.MEDIUM).count();
    // int largeNum = members.stream().filter(m -> m.paymentType.paymentTypeName ==
    // PaymentTypeName.LARGE).count();
    // int moneyLarge = this.billingAmount / (smallNum + mediumNum + largeNum);

    int totalWeight = members.stream().mapToInt(m -> m.paymentType.paymentWeight.weight).sum();

    double paymentUnit = this.billingAmount.amount.intValue() / totalWeight;
    return members
        .stream()
        .map(
            m ->
                new Payment(
                    m,
                    Money.of((long) (m.paymentType.paymentWeight.weight * paymentUnit), Money.JPY)))
        .collect(Collectors.toList());
  }
}
