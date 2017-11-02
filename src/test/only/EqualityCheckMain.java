package test.only;
import java.util.HashMap;
import java.util.Iterator;
public class EqualityCheckMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Country,String> countryCapitalMap=new HashMap<Country,String>(); 
        Country india1=new Country();
        india1.setName("India");
        Country india2=new Country();
        india2.setName("India");
 
        countryCapitalMap.put(india1, "Delhi");
        countryCapitalMap.put(india2, "Delhi");
 
        Iterator countryCapitalIter=countryCapitalMap.keySet().iterator();
        while(countryCapitalIter.hasNext())
        {
            Country countryObj=(Country) countryCapitalIter.next();
            String capital=countryCapitalMap.get(countryObj);
            System.out.println("Capital of "+ countryObj.getName()+"----"+capital);
 
        }
        
        System.out.println("city1 == city 2: "+(india1.equals(india2)));
        System.out.println("hascode city1: "+india1.hashCode()+" and city 2: "+india2.hashCode());
        
        
	}

}
