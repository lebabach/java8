package jdk8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Developer {
	
	private String name;
	private int id;
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}
	List<Subjects> subjects;
	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}
	private List<String> languages;

    public Developer(String name) {
        this.languages = new ArrayList<>();
        this.name = name;
    }

    public void add(String language) {
        this.languages.add(language);
    }

    public List<String> getLanguages() {
        return languages;
    }
}
class GroupDeveloper {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfLanguage() {
		return numberOfLanguage;
	}
	public void setNumberOfLanguage(int numberOfLanguage) {
		this.numberOfLanguage = numberOfLanguage;
	}
	public String name;
    public int numberOfLanguage;
}
class GroupNameId{
	String keyName;
	int keyId;
	public GroupNameId(String name,int id){
		this.keyName=name;
		this.keyId=id;
	}
	@Override
    public int hashCode() {
        int result = keyId  + keyName.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
       /* if (this == obj)
            return true;*/
        if (obj == null)
            return false;
        /*if (getClass() != obj.getClass())
            return false;*/
        final GroupNameId other = (GroupNameId) obj;
        /*if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;*/
        if(keyId==other.keyId && keyName.equals(other.keyName)){
        	return true;
        }
        return false;
    }
}