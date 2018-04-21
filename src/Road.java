import java.util.ArrayDeque;
import java.util.Iterator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
/**
 * 
 * @author evgeniy
 *
 */
public class Road {
	
	int strip;
	ArrayDeque<Car> cars = new ArrayDeque<>();
	/**
	 * 
	 * @return cars
	 */
	public ArrayDeque<Car> getCars(){
		return cars;
	}
	/**
	 * 
	 * @param car begin thread
	 * @param strips
	 */
	public void addCar(Car car, int strips){
		cars.add(car);
		car.start();
		strip = strips;
		
	}
	/**
	 * 
	 * @return strip
	 */
	public int getStrip(){
		return strip;
	}
	/**
	 * 
	 * @return result about cars
	 */
    public String setResult()
    {
       String result = "";
        Iterator value = this.cars.iterator();
        int count = 0;
        while(value.hasNext()) {
            Car car = (Car)value.next();
            count++;
            if(car.checkV()>50){
            	result += "Машина "+ count+ "  : " + car.checkV() + " км/ч, превысела скорость на полосе "+ getStrip() + "!\n";
            	car.disable();
            }
                	
        }

        return result;
    }
    /**
     * method interrupt
     */
    public void delThreadAll()
    {
    	 Iterator value = this.cars.iterator();
    	 while(value.hasNext()) {
             Car car = (Car)value.next();
             car.disable();
             }
    }
    
}
