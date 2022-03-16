package warikan.domain.model;

import lombok.EqualsAndHashCode;
import warikan.domain.model.members.Member;

@EqualsAndHashCode
public class Payment {
  public Member member;
  public Money money;

  public Payment(Member member, Money money) {
    this.member = member;
    this.money = money;
  }
}

