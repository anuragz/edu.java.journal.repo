package edu.java.journal.basic.collections;

import java.util.Objects;

/*
Following are the requirements for a key
1. The class must be declared as final so that child classes can’t be created.
2. Data members in the class must be declared private so that direct access is not allowed.
3. Data members in the class must be declared as final so that we can’t change the value of
	it after object creation.
4. A parameterized constructor should initialize all the fields 
	performing a deep copy so that data members can’t be modified with an object reference.
5. Deep Copy of objects should be performed in the getter methods to return a copy 
	rather than returning the actual object reference)
*/
public final class HashMapKey {
	private Integer icontent;
	private String scontent;
	
	public Integer getIcontent() {
		return icontent;
	}
	public void setIcontent(Integer icontent) {
		this.icontent = icontent;
	}
	public String getScontent() {
		return scontent;
	}
	public void setScontent(String scontent) {
		this.scontent = scontent;
	}
	public HashMapKey(Integer icontent, String scontent) {
		super();
		this.icontent = icontent;
		this.scontent = scontent;
	}
	@Override
	public int hashCode() {
		return Objects.hash(icontent, scontent);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashMapKey other = (HashMapKey) obj;
		return Objects.equals(icontent, other.icontent) && Objects.equals(scontent, other.scontent);
	}
	@Override
	public String toString() {
		return "HashMapKey [icontent=" + icontent + ", scontent=" + scontent + "]";
	}

}
