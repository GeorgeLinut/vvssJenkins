package repository;

import exceptions.MemberAlreadyExistsException;
import model.Member;
import org.junit.Test;

import static org.junit.Assert.*;

public class MemberRepositoryTest {
    private MemberRepository memberRepository = new MemberRepository("memTest.txt");

    @Test
    public void addMember() throws Exception {
        Member member = new Member("George",1);
        memberRepository.addMember(member);
        assertTrue(memberRepository.checkIfExists(1));
        Member member1 = new Member("Simona",2);
        memberRepository.addMember(member1);
        assertTrue(memberRepository.checkIfExists(2));
        Member member2 = new Member("Mihai",3);
        memberRepository.addMember(member2);
        assertTrue(memberRepository.checkIfExists(3));
        try {
            memberRepository.addMember(member);
            assertTrue(false);
        }
        catch (MemberAlreadyExistsException m){
            assertTrue(true);
        }


    }

    @Test
    public void checkIfExists() throws Exception {
        Member member = new Member("George",1);
        memberRepository.addMember(member);
        assertTrue(memberRepository.checkIfExists(1));
        Member member1 = new Member("Simona",2);
        assertFalse(memberRepository.checkIfExists(11));
        memberRepository.addMember(member1);
        assertTrue(memberRepository.checkIfExists(2));
        Member member2 = new Member("Mihai",3);
        memberRepository.addMember(member2);
        assertTrue(memberRepository.checkIfExists(3));
        assertFalse(memberRepository.checkIfExists(4));


    }

}