package bcccp.carpark.entry;
import java.util.Date;
import bcccp.carpark.Carpark;
import bcccp.carpark.ICarSensor;
import bcccp.carpark.ICarSensorResponder;
import bcccp.carpark.ICarpark;
import bcccp.carpark.ICarparkObserver;
import bcccp.carpark.IGate;
import bcccp.tickets.adhoc.IAdhocTicket;

public class EntryController 
		implements ICarSensorResponder,
				   ICarparkObserver,
		           IEntryController {
	private static EntryController instance;
	public static EntryController getInstance() {
		return instance;
	}
	private IGate entryGate;
	private ICarSensor outsideSensor; 
	private ICarSensor insideSensor;
	private IEntryUI ui;
	
	private ICarpark carpark;
	private IAdhocTicket  adhocTicket = null;
	private long entryTime;
	private String seasonTicketId = null;
	
	

	public EntryController(Carpark carpark, IGate entryGate, 
			ICarSensor os, 
			ICarSensor is,
			IEntryUI ui) {
		this.insideSensor = is;
		this.outsideSensor = os;
		this.ui = ui;
		this.carpark = carpark;
		this.entryGate = entryGate;
		this.ui.registerController(this);
		this.instance = this;
	}



	@Override
	public void buttonPushed() {
		System.out.println("button pushed");
		/* Author: HOANG Van Cuong
		 * 
		 * */
		// Check if carpark is full
		if(this.carpark.isFull()){
			this.ui.display("Car park is full!");
		}else{
			this.adhocTicket = this.carpark.issueAdhocTicket();
			//this.ui.printTicket(id, tNo, entryDatetime, );
			this.ui.display("Take ticket");
			this.ui.printTicket(this.adhocTicket.getCarparkId(), this.adhocTicket.getTicketNo(), new Date().getTime(), this.adhocTicket.getBarcode());
			this.adhocTicket.enter(new Date().getTime());
		}
		System.out.println("Issuing adhoc ticket");		
	}



	@Override
	public void ticketInserted(String barcode) {
		// TODO Auto-generated method stub
		// Author: HOANG, Van Cuong - 11613599
		// If the outside sensor detects no car, this method does nothing
		if(!this.outsideSensor.carIsDetected())
		{
			// Display no car detected
			this.ui.display("No car detected!");
			return;
		}
		// Else the user has typed in the barcode of the season ticket
		System.out.println("The season ticket number entered is: " + barcode);
		if(this.carpark.isSeasonTicketValid(barcode)){
			this.ui.display("Season ticket accepted!");
		}else{
			this.ui.display("Season ticket is not available!");
		}
	}



	@Override
	public void ticketTaken() {
		// TODO Auto-generated method stub
		/* Author: HOANG, Van Cuong - Project Debuggers
		 * Adhoc customer takes adhoc ticket. Now raise the barrier
		 * 
		 * */
		if(!this.carpark.isFull()){
			this.entryGate.raise();
			this.ui.display("");
			this.ui.beep();
		}
	}

	@Override
	public void notifyCarparkEvent() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void carEventDetected(String detectorId, boolean detected) {
		/* Author: HOANG, Van Cuong - project DEbuggers
		 * 11613699
		 * 23-08-2017
		 * */
		// Both 2 inside and outside sensors call this method when detecting a car
		// If the outside detects, show PUSH BUTTON. Otherwise, lower the barrier
		if(detectorId == this.outsideSensor.getId()){
			if(detected){
				// Display push button on LCD screen
				this.ui.display("PUSH BUTTON");
				// Turn off the inside detector
				this.insideSensor.turnDetectorStutus(false);
				
			}else{
				this.ui.display("");
			}
		}else{
			// This is the inside sensor, when detecting a car, lower the barrier and reset
			// the LCD screen
			this.entryGate.lower();
			// Start counting time
			entryTime = new Date().getTime();
			//Switch the outside sensor to non detected
			this.outsideSensor.turnDetectorStutus(false);
			// TO DO
		}
	}
}
