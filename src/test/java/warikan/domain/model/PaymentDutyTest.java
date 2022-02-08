package warikan.domain.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PaymentDutyTest {

  @Test
  public void testAsc() {
    var map = PaymentDuty.rates(1.0,2.0,3.0);
    assertEquals(Double.valueOf(3), map.get(PaymentDuty.LARGE));
    assertEquals(Double.valueOf(2), map.get(PaymentDuty.MIDDLE));
    assertEquals(Double.valueOf(1), map.get(PaymentDuty.SMALL));
  }
  @Test
  public void testDesc() {
    var map = PaymentDuty.rates(3.0,2.0,1.0);
    assertEquals(Double.valueOf(3), map.get(PaymentDuty.LARGE));
    assertEquals(Double.valueOf(2), map.get(PaymentDuty.MIDDLE));
    assertEquals(Double.valueOf(1), map.get(PaymentDuty.SMALL));
  }
  @Test
  public void testRandom() {
    var map = PaymentDuty.rates(2.0,0.0,5.0);
    assertEquals(Double.valueOf(5), map.get(PaymentDuty.LARGE));
    assertEquals(Double.valueOf(2), map.get(PaymentDuty.MIDDLE));
    assertEquals(Double.valueOf(0), map.get(PaymentDuty.SMALL));
  }

  @Test
  public void testRatesSize_EQ_3() {
    PaymentDuty.rates(0.0,5.0);
  }

  @Test(expected=IllegalArgumentException.class)
  public void testRatesMustBe_LT_0() {
    PaymentDuty.rates(-2.0,0.0,5.0);
  }


}
