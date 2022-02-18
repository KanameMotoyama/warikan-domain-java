package warikan.domain.model;

public class PaymentType {
  public PaymentTypeName paymentTypeName;
  public PaymentWeight paymentWeight;

  public PaymentType(PaymentTypeName paymentTypeName, PaymentWeight paymentWeight) {
    this.paymentTypeName = paymentTypeName;
    this.paymentWeight = paymentWeight;
  }
}
