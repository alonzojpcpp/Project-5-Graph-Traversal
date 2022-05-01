@SuppressWarnings("serial")
public class EmptyQueueException extends java.lang.Exception 
{
    public EmptyQueueException()
    {
        System.out.println("The queue is empty.");
    }
    
    public EmptyQueueException(java.lang.String message)
    {
        System.out.println(message);
    }

    
}