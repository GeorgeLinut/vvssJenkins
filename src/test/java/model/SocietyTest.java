package model;

import exceptions.MemberAlreadyExistsException;
import org.junit.Test;
import repository.MemberRepository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SocietyTest {
    private Society society = new Society();

    @Test
    public void addMember() throws Exception {
        Member member = new Member("George", 1);
        society.addMember(member);
        assertTrue(society.checkIfExists(1));
        Member member1 = new Member("Simona", 2);
        society.addMember(member1);
        assertTrue(society.checkIfExists(2));
        assertFalse(society.checkIfExists(22));
        Member member2 = new Member("Mihai", 3);
        society.addMember(member2);
        assertTrue(society.checkIfExists(3));
        try {
            society.addMember(member);
            assertTrue(false);
        } catch (MemberAlreadyExistsException m) {
            assertTrue(true);
        }


    }

    @Test
    public void checkIfExists() throws Exception {
        Member member = new Member("George", 1);
        society.addMember(member);
        assertTrue(society.checkIfExists(1));
        Member member1 = new Member("Simona", 2);
        assertFalse(society.checkIfExists(22));
        assertFalse(society.checkIfExists(11));
        society.addMember(member1);
        assertTrue(society.checkIfExists(2));
        Member member2 = new Member("Mihai", 3);
        society.addMember(member2);
        assertTrue(society.checkIfExists(3));
        assertFalse(society.checkIfExists(4));
    }

    @Test
    public void deleteMember() throws Exception {
        Member member = new Member("George", 1);
        society.addMember(member);
        society.deleteMember(member.getId());
        assertTrue(society.checkIfExists(1));
    }

    @Test
    public void bigbangTesting() throws Exception {
        Member member = new Member("George", 1);
        society.addMember(member);
        assertTrue(society.checkIfExists(1));
        Member member1 = new Member("Simona", 2);
        society.addMember(member1);
        society.deleteMember(member1.getId());
        assertFalse(society.checkIfExists(22));
        Member member2 = new Member("Mihai", 3);
        society.addMember(member2);
        assertTrue(society.checkIfExists(3));
        try {
            society.addMember(member);
            assertTrue(false);
        } catch (MemberAlreadyExistsException m) {
            assertTrue(true);
        }
        society.deleteMember(member.getId());
        assertTrue(society.checkIfExists(1));
    }


}
