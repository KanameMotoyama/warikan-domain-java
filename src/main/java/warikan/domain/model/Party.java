package warikan.domain.model;

@Getter
public class Party {
  public String partyName;
  public LocalDatetime partyDatetime;
  public List<Member> members;
  public List<PaymentType> paymentTypes;

  public Party(String partyName, LocalDatetime partyDatetime, List<Member> members, List<PaymentType> paymentTypes) {
    this.partyName = partyName;
    this.partyDatetime = partyDatetime;
    this.members = members;
    this.paymentTypes = paymentTypes;
  }



  // public DefinePaymentTypes(List<PaymentType> paymentTypes) {
  //   this.paymentTypes =  //
  // }
}
