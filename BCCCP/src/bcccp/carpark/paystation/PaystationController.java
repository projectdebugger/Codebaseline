package carpark.paystation;

import carpark.ICarpark;
import tickets.adhoc.IAdhocTicket;

public class PaystationController 
		implements IPaystationController {
	
	private IPaystationUI ui;	
	private ICarpark carpark;

	private IAdhocTicket  adhocTicket = null;
	private float charge;
	
	

	public PaystationController(ICarpark carpark, IPaystationUI ui) {
		//TODO Implement constructor
		/*
Author: Santosh

		*/
this.carpark = carpark;
this.ui = ui;
	}
public IPaystationUI getui(){
return ui;
}
public void setui (IPaystationUI ui) {
	this.ui=ui;
}
public ICarpark getcarpark() {
	return carpark;
}
public void setcarpark (ICarpark ui) {
this.carpark=carpark;
}
public String toString()
{
return (ui + " " + carpark);
}
	@Override
	public void ticketInserted(String barcode) {
		// TODO Auto-generated method stub
		this.ui.display("Ticket Inserted");
	}

public static void public static void main(String[] args) {
	
}



	@Override
	public void ticketPaid() {
		// TODO Auto-generated method stub
		/*
			Author: Santosh
		*/
			if(!this.carpark.isPaid()){
			this.charge();
		}else {
			return "Thank you for your Payment. Have a Nice Day";
		}
		
	}



	@Override
	public void ticketTaken() {
		// TODO Auto-generated method stub
		/*
			Author: Santosh
		*/

		if(!this.carpark.isPaid()){
			this.ui.receiveDetections();
		}else {
			this.exitGate.raise();
			this.ui.display("");
		}
		}
	}
	}

	
	
}
