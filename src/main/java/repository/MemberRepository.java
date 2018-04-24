package repository;

import java.io.BufferedReader;

import model.*;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import exceptions.MemberAlreadyExistsException;

public class MemberRepository {
	private List<Member> members = new ArrayList<Member>();

	public int getCapacity() {
		return capacity;
	}

	private int capacity;

	public int getCurrentNumber() {
		return currentNumber;
	}

	public void setCurrentNumber(int currentNumber) {
		this.currentNumber = currentNumber;
	}

	int currentNumber;

	private String filename;

	public MemberRepository(String fileName) {
		this.filename = fileName;
		readFromFile();
		currentNumber = 0;
	}

	public MemberRepository(int capacity) {
		this.capacity = capacity;
		currentNumber = 0;
	}

	public void addMember(Member m) throws MemberAlreadyExistsException {
		if (checkIfExists(m.getId())) {
			throw new MemberAlreadyExistsException();
		} else {
			members.add(m);
			currentNumber++;
		}
	}

	public boolean checkIfExists(int idOfMember) {
		Optional<Member> tempMember = members.stream().filter(m -> m.getId() == idOfMember).findFirst();
		return tempMember.isPresent();
	}

	@SuppressWarnings("resource")
	private void readFromFile() {
		try {
			FileReader fileReader = null;
			BufferedReader bufferedReader = null;
			String currentLine = null;

			fileReader = new FileReader(this.filename);
			bufferedReader = new BufferedReader(fileReader);

			while ((currentLine = bufferedReader.readLine()) != null) {
				String line[] = currentLine.split(";");
				Member m = new Member(line[0], Integer.parseInt(line[1]));
				this.members.add(m);
			}
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

}
