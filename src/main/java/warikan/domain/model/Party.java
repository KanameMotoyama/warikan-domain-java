package warikan.domain.model;

import java.time.LocalDateTime;
import java.util.List;
import warikan.domain.model.members.Members;

public class Party {
  public String partyName;
  public LocalDateTime partyDatetime;
  public Members members;
  public List<PaymentType> paymentTypes;

  public Party(
      String partyName,
      LocalDateTime partyDatetime,
      Members members,
      List<PaymentType> paymentTypes) {
    this.partyName = partyName;
    this.partyDatetime = partyDatetime;
    this.members = members;
    this.paymentTypes = paymentTypes;
  }

  // public DefinePaymentTypes(List<PaymentType> paymentTypes) {
  //   this.paymentTypes =  //
  // }
}
