package homeworkBridge;
import java.util.concurrent.*;

public class Bridge 
{   // *
	//Calls Semaphore from Java.lang.*.  Semaphore guards against entry by more than N threads at a time.  Sends signals between two threads.
    // *
	private final Semaphore sema;  
    
	
	// *
	//Constructs the semaphore. The semaphore controls access.  Allows
    // *
	public Bridge()
    {
        sema = new Semaphore(1);  
    }
    
    public void crossBridge(Vehicle vehicle)
    {
        try
        {   
        	//Takes next argument and prints to string
            System.out.printf("%s is WAITING to cross the bridge.\n",vehicle.getName());  
            //Acquire is ued when sending signals between two threads.  It acquires a permit and blocks until permit is released.
            sema.acquire(); 
            //Takes next argument and prints to string
            System.out.printf("%s is CROSSING the bridge.\n",vehicle.getName()); 
            long duration = (long)(Math.random()*1);
            TimeUnit.SECONDS.sleep(duration);
        }
        // *
        //Prints the stack trace of the Exception to System.err.  Helps diagnose Exception.
        // *
        catch(InterruptedException iex)
        {   
            iex.printStackTrace();
        }
        finally
        {   
        	//Takes next argument and prints to string
            System.out.printf("%s has FINISHED CROSSING the bridge.\n",vehicle.getName());  
            
            //Permit is released
            sema.release();  
        }
    }

  
}