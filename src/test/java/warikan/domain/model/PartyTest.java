package warikan.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import warikan.domain.model.members.Member;
import warikan.domain.model.members.MemberName;
import warikan.domain.model.members.Members;
import warikan.domain.model.members.SecretaryType;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PartyTest {

    @Test
    public void testWarikan() {
        PaymentType paymentTypeLarge = new PaymentType(PaymentTypeName.LARGE, new PaymentWeight(10));
        PaymentType paymentTypeMidium = new PaymentType(PaymentTypeName.MEDIUM, new PaymentWeight(5));
        PaymentType paymentTypeSmall = new PaymentType(PaymentTypeName.SMALL, new PaymentWeight(2));
        List<PaymentType> paymentTypes = new ArrayList<>();
        paymentTypes.add(paymentTypeLarge);
        paymentTypes.add(paymentTypeMidium);
        paymentTypes.add(paymentTypeSmall);

        var members = Members.of(
          new Member(MemberName.of("Komatsu"), SecretaryType.Secretary, paymentTypeLarge),
          new Member(MemberName.of("Yoshimura"), SecretaryType.NonSecretary, paymentTypeLarge),
          new Member(MemberName.of("Motoyama"), SecretaryType.NonSecretary, paymentTypeLarge),
          new Member(MemberName.of("Ishibashi"), SecretaryType.NonSecretary, paymentTypeLarge),
          new Member(MemberName.of("Odori"), SecretaryType.NonSecretary, paymentTypeMidium),
          new Member(MemberName.of("Tokuyama"), SecretaryType.NonSecretary, paymentTypeSmall),
          new Member(MemberName.of("Ikeda"), SecretaryType.NonSecretary, paymentTypeSmall),
          new Member(MemberName.of("Abe"), SecretaryType.NonSecretary, paymentTypeSmall));

        Party party = new Party("本山さん30歳おめでとうパーティー", LocalDateTime.now(), members, paymentTypes); // TODO members 変数は不要
        Cashier cashier = new Cashier(Money.of((long) 150000, Money.JPY));
        List<Payment> result = cashier.warikan(members);
        assertThat(result, is(equalTo(List.of(
                new Payment(new Member(MemberName.of("Komatsu"), SecretaryType.Secretary, paymentTypeLarge), Money.of(29410, Money.JPY)),
                new Payment(new Member(MemberName.of("Yoshimura"), SecretaryType.NonSecretary, paymentTypeLarge), Money.of(29410, Money.JPY)),
                new Payment(new Member(MemberName.of("Motoyama"), SecretaryType.NonSecretary, paymentTypeLarge), Money.of(29410, Money.JPY)),
                new Payment(new Member(MemberName.of("Ishibashi"), SecretaryType.NonSecretary, paymentTypeLarge), Money.of(29410, Money.JPY)),
                new Payment(new Member(MemberName.of("Odori"), SecretaryType.NonSecretary, paymentTypeMidium), Money.of(14705, Money.JPY)),
                new Payment(new Member(MemberName.of("Tokuyama"), SecretaryType.NonSecretary, paymentTypeSmall), Money.of(5882, Money.JPY)),
                new Payment(new Member(MemberName.of("Ikeda"), SecretaryType.NonSecretary, paymentTypeSmall), Money.of(5882, Money.JPY)),
                new Payment(new Member(MemberName.of("Abe"), SecretaryType.NonSecretary, paymentTypeSmall), Money.of(5882, Money.JPY))))));
    }
}
