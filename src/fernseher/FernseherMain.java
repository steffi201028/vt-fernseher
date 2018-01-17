package fernseher;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.htw.fiw.vs.IBinder;
import org.htw.fiw.vs.fernseher.IFernseherRemote;
import org.htw.fiw.vs.heartbeat.IPlayer;


public class FernseherMain extends UnicastRemoteObject implements IFernseherRemote,IPlayer{

	private FernseherFrame fernseherFrame;
	IPlayer player;
	Clip clip;

	public FernseherMain(FernseherFrame fernseherFrame) throws RemoteException {
		super();
		this.fernseherFrame = fernseherFrame;
	}

	public static void main(String[] args) throws IOException, RemoteException, MalformedURLException{

		if(args.length == 3){
			try {
				String ip = args[0];
				int port = Integer.parseInt(args[1]);
				String componentId = args[2];
				String protokoll = "rmi://";
				String url = protokoll + ip + ":" + port + "/binder";

				try {


					System.setProperty("java.rmi.server.hostname","141.45.208.212");
					FernseherMain fernseherMain = new FernseherMain(new FernseherFrame());
					System.out.println("Fernseher gestartet");


					//den registrierer holen

					IBinder binder = (IBinder) Naming.lookup(url);

					binder.bind("Fernseher_" + componentId, fernseherMain);

					System.out.println("Fernseher-RMI-Binding war erfolgreich");

				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (NumberFormatException nfe) {
				System.out.println("Kein gueltiger Port");
			}

		} else {
			System.out.println("Bitte IP-Adresse, Port und ID als Programmparameter uebergeben");
		}
	}

	@Override
	public void turnOn() throws RemoteException {
		fernseherFrame.turnOn();
		this.startMusic();
	}

	@Override
	public void turnOff() throws RemoteException {
		fernseherFrame.turnOff();
		this.killMusic();

	}

	@Override
	public void turnVolumeDownTo(int volume) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void killMusic() throws RemoteException {
		try {
			clip = AudioSystem.getClip();
			clip.close();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public void startMusic() throws RemoteException {
		try {
			URL url1= this.getClass().getResource("/images/Sparrow.WAV");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url1);              
			clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}


	}

	@Override
	public void playTone(int value) throws RemoteException {
		// TODO Auto-generated method stub

	}








}
