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
		//this.adhocTicket.entry(new Date().getTime());
		if (hours >= 24) {
    price = (hours / 24)*30;
    int h = hours%24;
    int h4 = Math.min(h, 3)*2;
    price += h4 +((hours)%24);

} else if (hours < 24 && hours > 3) {
    price = 9;
    price += (hours - 3) * 1;
} else {
    price = hours * 3;
}
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
