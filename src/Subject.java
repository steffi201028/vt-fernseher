import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public abstract class Subject {

	private final List<Observer> observerList = new ArrayList<Observer>(); 

	public void register(Observer newObserver){ 
		observerList.add(newObserver); 
	} 

	public void unregister(Observer newObserver){ 
		observerList.remove(newObserver); 
	} 

	protected void notifyObservers(int state){ 
		for (Observer observer : observerList) { 
			observer.update(null, state); 
		} 
	} 	
}
