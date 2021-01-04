package spring.SpringBasic;

import spring.SpringBasic.discount.DiscountPolicy;
import spring.SpringBasic.discount.FixDiscountPolicy;
import spring.SpringBasic.member.MemberRepository;
import spring.SpringBasic.member.MemberService;
import spring.SpringBasic.member.MemberServiceImpl;
import spring.SpringBasic.member.MemoryMemberRepository;
import spring.SpringBasic.order.OrderService;
import spring.SpringBasic.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        // 만든 MemberServiceImpl는 MemoryMemberRepository를 사용한다.
        return new MemberServiceImpl(memberRepository());

    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }

}
