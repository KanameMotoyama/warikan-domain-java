package warikan.domain.model;

import java.util.List;
import java.util.stream.Collectors;
import warikan.domain.model.members.Member;
import warikan.domain.model.members.Members;

public class Cashier {
  public Money billingAmount;

  public Cashier(Money billingAmount) {
    this.billingAmount = billingAmount;
  }

  public List<Payment> warikan(Members members) {
    int totalWeight = members.calcTotalWeight();
    double paymentUnit = this.billingAmount.amount.intValue() / totalWeight;
    return members.calcPaymentList(paymentUnit);
  }
}
