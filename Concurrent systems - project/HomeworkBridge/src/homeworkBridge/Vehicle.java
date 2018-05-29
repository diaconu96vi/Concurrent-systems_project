package homeworkBridge;
import java.util.concurrent.*;

public class Vehicle implements Runnable
{
    //Private variables
    private String name;
    private Bridge bridge;
    public Vehicle(Bridge bridge)
    {   
    	//Assigns value of parameter bridge to variable with same name
        this.bridge = bridge;  
    }
    //*
    //Method that is implemented when there is a Runnable interface
    //*
    public void run()
    {
        bridge.crossBridge(this);
    }
    // *
    //Get method for vehicle name
    // *
    public String getName()
    {
        return name;
    }
    
    // *
    //Set method for vehicle name
    // *
    public void setName(String name)
    {
            this.name = name;
    }
}