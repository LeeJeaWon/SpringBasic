package spring.SpringBasic;


import spring.SpringBasic.member.Grade;
import spring.SpringBasic.member.Member;
import spring.SpringBasic.member.MemberService;
import spring.SpringBasic.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService(); // memberService에는 memberServiceImpl이 들어있다

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }

}
