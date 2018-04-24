package repository;

import model.Entry;
import model.Member;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntryRepositoryTest {
    private EntryRepository entryRepository = new EntryRepository("entryTest.txt");
    private MemberRepository memberRepository = new MemberRepository("memTest.txt");


    @Test
    public void addEntry() throws Exception {
        Member member = new Member("George",1);
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
    public void checkIfExists() throws Exception {
        Member member = new Member("George",1);
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