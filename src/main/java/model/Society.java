package model;

import exceptions.MemberAlreadyExistsException;
import exceptions.MemberDoesNotExistException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Society {
    private List<Member> members = new ArrayList<>();

    public Society() {
    }

    public void addMember(Member m) throws MemberAlreadyExistsException {
        if (checkIfExists(m.getId())) {
            throw new MemberAlreadyExistsException();
        } else {
            members.add(m);
        }
    }

    public boolean checkIfExists(int idOfMember) {
        Optional<Member> tempMember = members.stream().filter(m -> m.getId() == idOfMember).findFirst();
        return tempMember.isPresent();
    }

    public void deleteMember(int member) throws MemberDoesNotExistException {
        if (checkIfExists(member)){
            members.remove(new Member("this",member));
        }
        else{
            throw new MemberDoesNotExistException();
        }
    }

    public Society(List<Member> members) {
        this.members = members;
    }
}
