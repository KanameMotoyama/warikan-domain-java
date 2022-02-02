package warikan.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import warikan.domain.model.members.Member;
import warikan.domain.model.members.MemberName;
import warikan.domain.model.members.SecretaryType;

class Main {
  public static void main(String[] args) {
    PaymentType paymentTypeLarge = new PaymentType(PaymentTypeName.LARGE, new PaymentWeight(10));
    PaymentType paymentTypeMidium = new PaymentType(PaymentTypeName.MEDIUM, new PaymentWeight(5));
    PaymentType paymentTypeSmall = new PaymentType(PaymentTypeName.SMALL, new PaymentWeight(2));
    List<PaymentType> paymentTypes = new ArrayList<>();
    paymentTypes.add(paymentTypeLarge);
    paymentTypes.add(paymentTypeMidium);
    paymentTypes.add(paymentTypeSmall);

    ArrayList<Member> members = new ArrayList<Member>();
    members.add(new Member(MemberName.of("Komatsu"), SecretaryType.Secretary, paymentTypeLarge));
    members.add(
        new Member(MemberName.of("Yoshimura"), SecretaryType.NonSecretary, paymentTypeLarge));
    members.add(
        new Member(MemberName.of("Motoyama"), SecretaryType.NonSecretary, paymentTypeLarge));
    members.add(
        new Member(MemberName.of("Ishibashi"), SecretaryType.NonSecretary, paymentTypeLarge));
    members.add(new Member(MemberName.of("Odori"), SecretaryType.NonSecretary, paymentTypeMidium));
    members.add(
        new Member(MemberName.of("Tokuyama"), SecretaryType.NonSecretary, paymentTypeSmall));
    members.add(new Member(MemberName.of("Ikeda"), SecretaryType.NonSecretary, paymentTypeSmall));
    members.add(new Member(MemberName.of("Abe"), SecretaryType.NonSecretary, paymentTypeSmall));

    Party party = new Party("本山さん30歳おめでとうパーティー", LocalDateTime.now(), members, paymentTypes);
    Cashier cashier = new Cashier(Money.of((long) 150000, Money.JPY));
    List<Payment> result = cashier.warikan(members);
    result
        .stream()
        .forEach(r -> System.out.println(r.member.name + ":" + +r.money.amount.intValue()));
  }
}
