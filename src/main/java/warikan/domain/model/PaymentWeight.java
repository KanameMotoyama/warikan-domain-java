package warikan.domain.model;

/** memo: 少ない人は0円のこともある */
public class PaymentWeight {
  public int weight;

  public PaymentWeight(int weight) {
    check(weight);
    this.weight = weight;
  }

  private void check(int weight) {
    if (weight < 0) {
      throw new IllegalArgumentException("0以上の整数");
    }
  }
}
