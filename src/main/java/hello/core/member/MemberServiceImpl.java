package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // ctl + shift + Enter하면 세미콜론까지 자동완성
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;// 직접 new 하는 것이 아닌 생성자를 통해 의존성 주입
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
