package asyn;

public class ThreadTest extends Thread 
{ 
    public void run() 
    { 
        System.out.println("In run"); 
        yield(); 
        System.out.println("Leaving run"); 
    } 
    public static void main(String []argv) 
    { 
    	int x = 1, y = 6; 
    	while (y-->1) 
    	{
    	    x++; 
    	} 
    	System.out.println("x = " + x +" y = " + y);
    } 
}
