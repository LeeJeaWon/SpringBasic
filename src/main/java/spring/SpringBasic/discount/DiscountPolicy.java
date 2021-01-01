package spring.SpringBasic.discount;

import spring.SpringBasic.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
