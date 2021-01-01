package spring.SpringBasic.order;

import spring.SpringBasic.discount.DiscountPolicy;
import spring.SpringBasic.discount.FixDiscountPolicy;
import spring.SpringBasic.member.Member;
import spring.SpringBasic.member.MemberRepository;
import spring.SpringBasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new
            MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) { Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
