package spring.SpringBasic;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.SpringBasic.member.Grade;
import spring.SpringBasic.member.Member;
import spring.SpringBasic.member.MemberService;
import spring.SpringBasic.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService(); // memberService에는 memberServiceImpl이 들어있다


        // getBean(이름, 타입)을 통해 AppConfig.class중에 memberService라는 이름의 클래스(타입은 MemberService)를 찾는다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }

}
