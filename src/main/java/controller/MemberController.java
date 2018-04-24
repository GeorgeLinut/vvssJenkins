package controller;

import exceptions.IncompleteFamilyException;
import exceptions.RepoFullException;
import repository.MemberRepository;
import exceptions.MemberAlreadyExistsException;
import model.Member;

import java.lang.annotation.IncompleteAnnotationException;
import java.util.List;


public class MemberController {

	private MemberRepository memberRepository;

	public MemberController(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public void addMember(Member newMember) throws MemberAlreadyExistsException {
		memberRepository.addMember(newMember);
	}

	public int addFamily(List<Integer> familyIds) throws RepoFullException, IncompleteFamilyException {
		int added =0;
		if (familyIds.size()==0)
			return added;
		if (memberRepository.getCapacity()<memberRepository.getCurrentNumber()+familyIds.size())
			throw new RepoFullException();
		while (familyIds.size()>0){
			Integer id = familyIds.get(0);
			Member member = new Member("member"+id,id);
			try {
				memberRepository.addMember(member);
			}
			catch ( MemberAlreadyExistsException e){
				throw  new IncompleteFamilyException();
			}

			familyIds.remove(0);
			added++;
		}
		return added;
	}

}