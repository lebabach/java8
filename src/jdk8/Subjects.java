package jdk8;

public class Subjects {
	public String name;
	int mark;
	String rank;
	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public Subjects(String name,int mark,String rank){
		this.name=name;
		this.mark=mark;
		this.rank=rank;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        //result = (name.hashCode() + mark) ^ rank.hashCode();
        result = (name.hashCode() + mark);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        final Subjects other = (Subjects) obj;
        /*if((name.equals(other.name) && mark==other.mark)||rank.equals(other.rank)){
        	return true;
        }*/
        if((name.equals(other.name) && mark==other.mark)){
        	return true;
        }
        return false;
    }
}
