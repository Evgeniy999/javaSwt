import java.util.Random;
/**
 * 
 * @author evgeniy
 *
 */

public class Car extends Thread {

	String name;
	int V;
	/**
	 * @param threadName
	 */
	private boolean isActive;
    
    void disable(){
        isActive=false;
    }
     
	Car(String threadName){
		name = threadName;
		isActive = true;
	}
	Random randNumber = new Random();
	/**
	 * The thread will finish executing when its run () method is completed
	 */
   	public void run(){
   		V = randNumber.nextInt(70);
   		while(isActive){ 
   			try{
				V++;
				System.out.println(name + "cкорость:"+ V );
				Thread.sleep(1000);
			}catch(InterruptedException e){
				System.out.println(name + "прерван");
				}
   		}
   }
   	public int checkV(){
   		return V;
   		}
		
}
