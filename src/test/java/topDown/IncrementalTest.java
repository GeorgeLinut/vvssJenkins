package topDown;

import exceptions.MemberAlreadyExistsException;
import model.Entry;
import model.Member;
import org.junit.Test;
import repository.EntryRepository;
import repository.MemberRepository;

import static org.junit.Assert.assertTrue;

public class IncrementalTest {
    private EntryRepository entryRepository = new EntryRepository("entryTest.txt");
    private MemberRepository memberRepository = new MemberRepository("memTest.txt");


    @Test
    public void testFunctionA() throws Exception {
        Member member = new Member("Geor1ge",1);
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
    public void testFunctionAPlusB() throws Exception {
        Member member = new Member("Georg1e",1);
        memberRepository.addMember(member);
        Member member1 = new Member("Simona",2);
        memberRepository.addMember(member1);
        Member member2 = new Member("Mihai",3);
        memberRepository.addMember(member2);
        Entry entry = new Entry(1,"EntryGeorge",10,1);
        entryRepository.addEntry(entry);
        Entry entry1 = new Entry(2,"EntrySimona",10,2);
        entryRepository.addEntry(entry1);
        Entry entry2 = new Entry(3,"EntryMihai",4,3);
        entryRepository.addEntry(entry2);
        assertTrue(entryRepository.getAllEntries().size()==3);
    }

    @Test
    public void testFunctionAPlusBPlusC() throws Exception {
        Member member = new Member("Geo1rge",1);
        memberRepository.addMember(member);
        Member member1 = new Member("Simona",2);
        memberRepository.addMember(member1);
        Member member2 = new Member("Mihai",3);
        memberRepository.addMember(member2);
        Entry entry = new Entry(1,"EntryGeorge",10,1);
        entryRepository.addEntry(entry);
        Entry entry1 = new Entry(2,"EntryGeorge2",10,2);
        entryRepository.addEntry(entry1);
        Entry entry2 = new Entry(3,"EntryGeorge3",4,1);
        entryRepository.addEntry(entry2);
        assertTrue(entryRepository.findByIdMember(1).size()==2);
        assertTrue(entryRepository.findByIdMember(2).size()==1);
        assertTrue(entryRepository.findByIdMember(3).size()==0);


    }

}