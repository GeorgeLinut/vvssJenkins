package controller;

import exceptions.IncompleteFamilyException;
import exceptions.MemberAlreadyExistsException;
import exceptions.RepoFullException;
import model.Member;
import org.junit.Test;
import repository.MemberRepository;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MemberControllerTest {
    private MemberRepository memberRepository = new MemberRepository(3);
    private MemberRepository memberRepository1 = new MemberRepository(3);
    private MemberController memberController = new MemberController(memberRepository);
    private MemberController memberController1 = new MemberController(memberRepository);

    @Test
    public void addFamily1() throws Exception {
        memberRepository.setCurrentNumber(0);
        ArrayList<Integer> family = new ArrayList<>();
        family.add(1);
        family.add(2);
        family.add(2);
        try {
            memberController.addFamily(family);
            assertTrue(false);
        } catch (IncompleteFamilyException e) {
            assertTrue(true);
        }

    }

    @Test
    public void addFamily2() throws Exception {

        Member member = new Member("George", 1);
        memberRepository1.addMember(member);
        Member member1 = new Member("Simona", 2);
        memberRepository1.addMember(member1);
        Member member2 = new Member("Mihai", 3);
        memberRepository1.addMember(member2);
        ArrayList<Integer> family = new ArrayList<>();
        family.add(1);
        family.add(2);
        family.add(3);
        assertEquals(memberController1.addFamily(family), 3);
    }

    @Test
    public void addFamily3() throws Exception {

        ArrayList<Integer> family = new ArrayList<>();
        assertEquals(memberController1.addFamily(family), 0);
    }

    @Test
    public void addFamily4() throws Exception {

        Member member = new Member("George", 1);
        memberRepository1.addMember(member);
        Member member1 = new Member("Simona", 2);
        memberRepository1.addMember(member1);
        Member member2 = new Member("Mihai", 3);
        memberRepository1.addMember(member2);
        ArrayList<Integer> family = new ArrayList<>();
        family.add(1);
        family.add(2);
        family.add(3);
        try {
            assertEquals(memberController1.addFamily(family), 3);
        }
        catch (RepoFullException r){
            assertTrue(true);
        }
    }


}


