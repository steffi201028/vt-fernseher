

public class Fernseher extends Subject { //konkretes subject, Objekt

	public Fernseher() {
		state =false;
	    
	}
    private boolean state; 

    public void setState(boolean state) {
    	//an und aus schalten
        this.state = state; 
        //Wenn das Subject die Aktualisierung selbst durchfÃ¼hren soll, 
        //alternativ kann die Methode auch vom Client aufgerufen werden. 
        notifyObservers(state); 
    } 

    public boolean getState() { 
        return state; 
    } 
    
    public static void main(String args[]) {
    	
    	System.out.println("hallo");
//    ServicePoint servicepointa = new ServicePoint();
//    Fernseher fernseher = new Fernseher();
//    
//    fernseher.register(servicepointa);
//    fernseher.setState(true);
    

} }
