import observer.ConcreteObserverA;

public class Fernseher extends Subject{

	private int state; 

    public void setState(int state) { 
        this.state = state; 
        //Wenn das Subject die Aktualisierung selbst durchführen soll, 
        //alternativ kann die Methode auch vom Client aufgerufen werden. 
        notifyObservers(state); 
    } 

    public int getState() { 
        return state; 
    }

	public void register(ConcreteObserverA newObserver) {
		// TODO Auto-generated method stub
		
	} 

}
