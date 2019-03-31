package jdk8;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonTest p1 = new PersonTest(0, "Bob");
		PersonTest p2 = new PersonTest(1, "Sue");
		PersonTest p3 = new PersonTest(2, "Mike");
		PersonTest p4 = new PersonTest(1, "Sue");
        
        Map<PersonTest, Integer> map = new LinkedHashMap<PersonTest, Integer>();
        List<PersonTest> li=new ArrayList<>();
        li.stream().collect(Collectors.toMap(PersonTest::getPersonId, p->p));
        map.put(p1, 1);
        map.put(p2, 2);
        map.put(p3, 3);
        map.put(p4, 1);
        
        /*for(PersonTest key: map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }*/
        
        //http://stackoverflow.com/questions/521171/a-java-collection-of-value-pairs-tuples
        //The ^ operator in Java: More simply, you can also think of xor as "this or that, but not both!".
       /* Set<PersonTest> set = new LinkedHashSet<PersonTest>();
        
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        
        System.out.println(set);*/
	}

}

class PersonId{
	public int id;
    public String name;
}

class PersonTest {
    public int id;
    public String name;
    PersonId personId;
    
    
    public PersonId getPersonId() {
		return personId;
	}

	public void setPersonId(PersonId personId) {
		this.personId = personId;
	}

	public PersonTest(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public String toString() {
        return "{ID is: " + id + "; name is: " + name + "}";
    }

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

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        //int result = id  + name.hashCode();
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
        final PersonTest other = (PersonTest) obj;
        /*if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;*/
        if(id==other.id && name.equals(other.name)){
        	return true;
        }
        return false;
    }
    
    
}
