package spring.SpringBasic.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.SpringBasic.member.Grade;
import spring.SpringBasic.member.Member;
import spring.SpringBasic.member.MemberService;
import spring.SpringBasic.member.MemberServiceImpl;

class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
