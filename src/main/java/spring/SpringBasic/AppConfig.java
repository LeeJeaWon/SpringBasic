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
        // 만든 MemberServiceImpl는 MemoryMemberRepository를 사용한다.
        return new MemberServiceImpl(memberRepository());

    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
