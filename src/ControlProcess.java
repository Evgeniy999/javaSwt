import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.*;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
/**
 * 
 * @author evgeniy
 *
 */

public class ControlProcess {
	/**
	 * default constructor
	 * 
	 */
	int count1;
	int count2;
	int count3;
	int count4;
	int count5;
	List list;
	Road strit1;
	Road strit2;
	Road strit3;
	Road strit4;
	Road strit5;
	
	ControlProcess(){
		Display display = new Display();
		final  Shell shell = new Shell(display);
	    shell.setSize(488, 580);
	    shell.setText("Ограничение по скопрости, 50 км/ч");

	    RowLayout layout = new RowLayout(SWT.VERTICAL);
	    layout.spacing = 10;
	    layout.marginHeight = 10;
	    layout.marginWidth = 10;
	    shell.setLayout(layout);
	    list = new List(shell, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
	    list.setLayoutData(new RowData(440, 300));
	    /**
	    *  initialization button
	    */
	    Button btn1 = new Button(shell, SWT.NONE);
	    Button btn2 = new Button(shell, SWT.NONE);
	    Button btn3 = new Button(shell, SWT.NONE);
	    Button btn4 = new Button(shell, SWT.NONE);
	    Button btn5 = new Button(shell, SWT.NONE);
	    Button btn11 = new Button(shell, SWT.NONE);
	    
	    btn1.setText("Добавить машину на первую полосу");
	    btn2.setText("Добавить машину на вторую полосу");
	    btn3.setText("Добавить машину на третию полосу");
	    btn4.setText("Добавить машину на четвертую полосу");
	    btn5.setText("Добавить машину на пятую полосу");
	    btn11.setText("Завершить все потоки");
	    /**
	     * initialization Road
	     */
	    strit1 = new Road();
	    strit2 = new Road();
	    strit3 = new Road();
	    strit4 = new Road();
	    strit5 = new Road();
	    
	    btn1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				count1++;
				strit1.addCar(new Car("Первая полоса, машина " + count1+ " "), 1);
			}
		});
	    
	    btn2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				count2++;
				strit2.addCar(new Car("Вторая полоса, машина " + count2+ " "), 2);
			}
		});
	    
	    btn3.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				count3++;
				strit3.addCar(new Car("Третья полоса, машина " + count2+ " "), 3);
			}
		});
	    
	    btn4.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				count4++;
				strit4.addCar(new Car("Четвертая полоса, машина " + count2+ " "), 4);
			}
		});
	   
	    btn5.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				count5++;
				strit5.addCar(new Car("Пятая полоса, машина " + count2+ " "), 5);
			}
		});
	    
	    btn11.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				 strit1.delThreadAll();
				 strit2.delThreadAll();
				 strit3.delThreadAll();
				 strit4.delThreadAll();
				 strit5.delThreadAll();
			}
		});
	     /**
	      * works in an infinite loop and updates
	      */
	    shell.open();
	    while (!shell.isDisposed()) {
	    	check();
	      if (!display.readAndDispatch())
	        display.sleep();
	    }
	    display.dispose();
	   
	}
	public void check(){
    	list.removeAll();
		list.add(strit1.setResult());
		list.add(strit2.setResult());
		list.add(strit3.setResult());
		list.add(strit4.setResult());
		list.add(strit5.setResult());
	}
	public static void main(String arg[]){
		new ControlProcess();
	}
}
