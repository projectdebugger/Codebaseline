package bcccp.tickets.adhoc;

import java.util.Date;

public class AdhocTicket implements IAdhocTicket {
	
	private String carparkId;
	private int ticketNo;
	private long entryDateTime;
	private long paidDateTime;
	private long exitDateTime;
	private float charge;
	private String barcode;

	
	
	public AdhocTicket(String carparkId, int ticketNo, String barcode) {
		//TDO Implement constructor
<<<<<<< HEAD
=======
		this.carparkId = carparkId;
		this.ticketNo = ticketNo;
		this.barcode = barcode;
>>>>>>> master
	}


	@Override
	public int getTicketNo() {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return 0;
=======
		return ticketNo;
>>>>>>> master
	}


	@Override
	public String getBarcode() {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return null;
=======
		return barcode;
>>>>>>> master
	}


	@Override
	public String getCarparkId() {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return null;
=======
		return carparkId;
>>>>>>> master
	}


	@Override
	public void enter(long dateTime) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		
=======
		this.entryDateTime = dateTime;
>>>>>>> master
	}


	@Override
	public long getEntryDateTime() {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return 0;
=======
		return this.entryDateTime;
>>>>>>> master
	}


	@Override
	public boolean isCurrent() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void pay(long dateTime, float charge) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public long getPaidDateTime() {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return 0;
=======
		return this.paidDateTime;
>>>>>>> master
	}


	@Override
	public boolean isPaid() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public float getCharge() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void exit(long dateTime) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public long getExitDateTime() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean hasExited() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
