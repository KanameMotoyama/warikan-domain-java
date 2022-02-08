package warikan.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.OffsetDateTime;
import java.util.stream.Collectors;

import org.junit.Test;

public class PartyTest {
  Member ishibashi = new Member("石橋");
  Member motoyama = new Member("本山");


  @Test
  public void testParitipations() {
    var party = new Party( "歓迎会", ishibashi,  OffsetDateTime.now());
    assertTrue(party.participate(ishibashi, PaymentDuty.LARGE));
    assertTrue(party.participate(motoyama, PaymentDuty.MIDDLE));
    assertTrue(party.participate(motoyama, PaymentDuty.SMALL));

    var members = party.getParticipations().stream()
        .collect(Collectors.toMap(p -> p.getMember(), p -> p.getDuty()));

    assertEquals(2, members.size());
    assertEquals(PaymentDuty.LARGE, members.get(ishibashi) );
    assertEquals(PaymentDuty.SMALL, members.get(motoyama) );

  }

  @Test
  public void testWarikan() {
    var party = new Party( "歓迎会", ishibashi,  OffsetDateTime.now());
    party.rates(10.0, 8.0, 5.0);
    party.participate(ishibashi, PaymentDuty.LARGE);
    party.participate(motoyama, PaymentDuty.MIDDLE);

    var fees = party.warikan(Money.of(100000, Money.JPY));

    assertEquals(Money.of(55556, Money.JPY), fees.get(ishibashi));
    assertEquals(Money.of(44445, Money.JPY), fees.get(motoyama));
  }

  @Test(expected=IllegalStateException.class)
  public void testMembersNotSet() {
    var party = new Party( "歓迎会", ishibashi,  OffsetDateTime.now());
    party.rates(10.0, 8.0, 5.0);
    party.warikan(Money.of(100000, Money.JPY));
  }
  @Test(expected=IllegalStateException.class)
  public void testRatesNotSet() {
    var party = new Party( "歓迎会", ishibashi,  OffsetDateTime.now());
    party.participate(ishibashi, PaymentDuty.LARGE);
    party.warikan(Money.of(100000, Money.JPY));
  }
}
