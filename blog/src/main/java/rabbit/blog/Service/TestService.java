package rabbit.blog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rabbit.blog.entity.Member;
import rabbit.blog.repository.MemberRepository;

import java.util.List;

@Service
public class TestService {
    @Autowired
    MemberRepository memberRepository;

    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }
}
