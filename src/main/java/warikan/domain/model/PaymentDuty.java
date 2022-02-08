package warikan.domain.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Map;

public enum PaymentDuty {
  SMALL,
  MIDDLE,
  LARGE;

  /**
   * generate PaymentDuty rate map from double values.
   * @param values rate array
   * @return rate map
   */
  public static Map<PaymentDuty, Double> rates(double... values) {
    var duties = values();
    if (values.length != duties.length) {
      return null;
    }
    Arrays.sort(values);

    if ( values[0] < 0 )  {
      throw new IllegalArgumentException("values must be > 0 ");
    }
    var rates = new EnumMap<PaymentDuty, Double>(PaymentDuty.class);
    for (int i=0; i<values.length; i++){
      rates.put(duties[i], values[i]);
    }
    return rates;
  }
}
