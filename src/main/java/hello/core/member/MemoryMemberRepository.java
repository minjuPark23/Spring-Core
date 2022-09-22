package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component // 빈 등록 네임은 memoryMemberRepository
public class MemoryMemberRepository implements MemberRepository{

    // 현업에서는 동시성 이슈때문에 concurrent Hash Map을 사용해야 한다.
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
