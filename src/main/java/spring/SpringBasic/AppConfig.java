package spring.SpringBasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.SpringBasic.discount.DiscountPolicy;
import spring.SpringBasic.discount.FixDiscountPolicy;
import spring.SpringBasic.member.MemberRepository;
import spring.SpringBasic.member.MemberService;
import spring.SpringBasic.member.MemberServiceImpl;
import spring.SpringBasic.member.MemoryMemberRepository;
import spring.SpringBasic.order.OrderService;
import spring.SpringBasic.order.OrderServiceImpl;
import spring.SpringBasic.order.RateDiscountPolicy;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
