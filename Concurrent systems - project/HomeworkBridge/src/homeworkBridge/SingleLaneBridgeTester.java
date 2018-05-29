package homeworkBridge;
import java.util.concurrent.*;

public class SingleLaneBridgeTester 
{
    public static void main(String[] args)
    {   //Constructs bridge calls semaphore from bridge
        int numberOfRightCars = 65;
        int numberOfLeftCars = 65;
    	final Bridge bridge = new Bridge(); 
        Thread Left = new Thread(new Runnable()  //constructs Left bound running thread
        {   
        	//*
        	//Method that is implemented in a Runnable interface
        	//*
        	@Override
            public void run()
            {
                while(true)
                {
                	//Constructs new vehicle from Vehicle class, sets to vehicle and uses bridge parameter
                	Vehicle vehicle = new Vehicle(bridge); 
                	//Vehicle object becomes thread object
                    Thread a = new Thread(vehicle);  
                    
                    //Sets vehicle name to Left Vehicle and gets the thread ID
                    vehicle.setName("Left Vehicle: "+a.getId());  
                    //Simulates for number of given cars
                    if(a.getId() < numberOfRightCars) {
                        a.start();  //Thread starts
                       }
                        else {
                      
                        	break;
                        }
                    //Try catch block
                    try  
                    {    //performs a Thread sleep for a given time
                        TimeUnit.SECONDS.sleep((long)(Math.random()*1));
                    }
                    catch(InterruptedException iex)
                    {  //prints the stack trace of the Exception to System.err.  Helps diagnose Exception.
                        iex.printStackTrace();
                    }
                }
            }
        });
        //*
        //Constructs Right bound running thread
        //*
        Thread Right = new Thread(new Runnable() 
        {
        	//Method that is implemented in a Runnable interface
            @Override
            public void run()
            {
                while(true)
                {   
                	//Constructs new vehicle from Vehicle class, sets to vehicle and uses bridge parameter
                    Vehicle vehicle = new Vehicle(bridge);  
                    //Vehicle object becomes thread object
                    Thread a = new Thread(vehicle);
                    //Sets vehicle name to Right Vehicle and gets the thread ID
                    vehicle.setName("Right Vehicle:  "+a.getId());  
                    //Simulates for number of given cars
                    if(a.getId() < numberOfRightCars) {
                        a.start();  //Thread starts
                       }
                        else {
                      
                        	break;
                        }
                   
                    try
                    {   //Performs a Thread sleep for a given time
                        TimeUnit.SECONDS.sleep((long)(Math.random()*1));
                    }
                    catch(InterruptedException iex)
                    {  //Prints the stack trace of the Exception to System.err.  Helps diagnose Exception.
                        iex.printStackTrace();        
                    }
                }
            }
        });
        Left.start();  //Starts Left thread
        Right.start();  //Starts Right thread
    }
}