package warikan.domain.model;

import warikan.domain.model.members.Member;

public class Payment {
  public Member member;
  public Money money;

  public Payment(Member member, Money money) {
    this.member = member;
    this.money = money;
  }
  
}
