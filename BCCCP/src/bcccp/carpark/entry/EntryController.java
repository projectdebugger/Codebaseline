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
		/* Author: HOANG Van Cuong
		 * 
		 * */
		// User push button to requesting a new ad hoc ticket
		System.out.println("User pushed Issue ad hoc ticket button!");
		// Check if carpark is full
		System.out.println("Checking if the car park is full...");
		if(this.carpark.isFull()){
			this.ui.display("Car park is full!");
			System.out.println("Car park is full!");
		}else{
			System.out.println("Car park is not full");
			// Issuing an adhoc ticket
			System.out.println("Issueing an ad hoc ticket...");
			this.adhocTicket = this.carpark.issueAdhocTicket();
			System.out.println("An adhoc ticket has been issued!");
			//this.ui.printTicket(id, tNo, entryDatetime, );
			this.ui.display("Take ticket");
			System.out.println("Take ticket message displayed!");
			this.ui.printTicket(this.adhocTicket.getCarparkId(), this.adhocTicket.getTicketNo(), new Date().getTime(), this.adhocTicket.getBarcode());
			System.out.println("Ad hoc ticket printed!");
			this.adhocTicket.enter(new Date().getTime());
			System.out.println("Captured time in for ad hoc ticket");
		}	
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
		// Else the user has typed in the bar code of the season ticket
		System.out.println("The season ticket number entered is: " + barcode);
		System.out.println("Validating season ticket...");
		if(this.carpark.isSeasonTicketValid(barcode)){
			this.ui.display("Ticket accepted!");
			System.out.println("Season ticket has been accepted!");
		}else{
			this.ui.display("Invalid ticket!");
			System.out.println("Season ticket has been rejected!");
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
				System.out.println("A car has been detected by outside sensor...");
				// Display push button on LCD screen
				System.out.println("Display PUSH BUTTON message on UI...");
				this.ui.display("PUSH BUTTON");
				// Turn off the inside detector
				this.insideSensor.turnDetectorStutus(false);
				System.out.println("Changed outside sensor status to false");
			}else{
				this.ui.display("");
				System.out.println("Clear display screen done!");
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
