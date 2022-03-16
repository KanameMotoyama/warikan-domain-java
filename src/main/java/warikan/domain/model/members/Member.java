package warikan.domain.model.members;

import java.util.Objects;
import javax.annotation.Nonnull;

import warikan.domain.model.Money;
import warikan.domain.model.Payment;
import warikan.domain.model.PaymentType;

/** 参加者。 */
public final class Member {
  public final MemberName name;
  public final SecretaryType secretaryType;
  public final PaymentType paymentType;

  public Member(
      @Nonnull MemberName name,
      @Nonnull SecretaryType secretaryType,
      @Nonnull PaymentType paymentType) {
    this.name = name;
    this.secretaryType = secretaryType;
    this.paymentType = paymentType;
  }

  // /**
  //  * ファクトリメソッド。
  //  *
  //  * @param name {@link MemberName}
  //  * @param secretaryType {@link SecretaryType}
  //  * @return {@link Member}
  //  */
  // @Nonnull
  // public static Member of(@Nonnull MemberName name, @Nonnull SecretaryType secretaryType) {
  //   return new Member(name, secretaryType);
  // }

  // /**
  //  * ファクトリメソッド。
  //  *
  //  * @param name {@link MemberName}
  //  * @return {@link Member}
  //  */
  // @Nonnull
  // public static Member of(@Nonnull MemberName name) {
  //   return new Member(name, SecretaryType.NonSecretary);
  // }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Member member = (Member) o;
    return Objects.equals(name, member.name) && secretaryType == member.secretaryType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, secretaryType);
  }

  @Override
  public String toString() {
    return "Member{" + "name=" + name + ", secretaryType=" + secretaryType + '}';
  }

  @Nonnull
  MemberName name() {
    return name;
  }

  @Nonnull
  SecretaryType secretaryType() {
    return secretaryType;
  }

  public boolean isSecretary() {
    return secretaryType.equals(SecretaryType.Secretary);
  }

  public boolean nonSecretary() {
    return !isSecretary();
  }
  
  public int calcWeight() {
	  return paymentType.paymentWeight.weight;
  }
  
  public Payment calcPayment(double paymentUnit) {
	  return new Payment(this, Money.of((long) (calcWeight() * paymentUnit), Money.JPY));
  }
}
