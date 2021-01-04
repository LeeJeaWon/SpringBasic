package spring.SpringBasic;

import spring.SpringBasic.member.Grade;
import spring.SpringBasic.member.Member;
import spring.SpringBasic.member.MemberService;
import spring.SpringBasic.member.MemberServiceImpl;
import spring.SpringBasic.order.Order;
import spring.SpringBasic.order.OrderService;
import spring.SpringBasic.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}
