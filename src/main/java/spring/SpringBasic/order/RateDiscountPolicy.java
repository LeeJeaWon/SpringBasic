package spring.SpringBasic.order;

import spring.SpringBasic.discount.DiscountPolicy;
import spring.SpringBasic.member.Grade;
import spring.SpringBasic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10; //10% 할인
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) { return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
