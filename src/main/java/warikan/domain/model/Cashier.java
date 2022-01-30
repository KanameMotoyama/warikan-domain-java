public class Cashier {
  public Money billingAmount;

  public Cashier(Money billingAmount) {
    this.billingAmount = billingAmount;
  }

  public List<Payment> warikan(List<Member> members) {
    int smallNum = members.stream().filter(m -> m.paymentType.paymentTypeName == PaymentTypeName.SMALL).count();
    int mediumNum = members.stream().filter(m -> m.paymentType.paymentTypeName == PaymentTypeName.MEDIUM).count();
    int largeNum = members.stream().filter(m -> m.paymentType.paymentTypeName == PaymentTypeName.LARGE).count();
    int moneyLarge = this.billingAmount / (smallNum + mediumNum + largeNum)

    int totalWeight = members.stream().mapToInt(m -> m.paymentType.paymentWeight).sum();

    double paymentUnit = this.billingAmount / totalWeight
    List<Payment> resultPayments = new ArrayList<Payment>();
    for (member in members) {
        resultPayments.add()
    }

  }


}



