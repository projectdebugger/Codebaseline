package bcccp.carpark;

import java.util.List;

import bcccp.tickets.adhoc.IAdhocTicket;
import bcccp.tickets.adhoc.IAdhocTicketDAO;
import bcccp.tickets.season.ISeasonTicket;
import bcccp.tickets.season.ISeasonTicketDAO;

public class Carpark implements ICarpark {
	
	private List<ICarparkObserver> observers;
	private String carparkId;
	private int capacity;
	private int numberOfCarsParked;
	private IAdhocTicketDAO adhocTicketDAO;
	private ISeasonTicketDAO seasonTicketDAO;
	
	
	
	public Carpark(String name, int capacity, 
			IAdhocTicketDAO adhocTicketDAO, 
			ISeasonTicketDAO seasonTicketDAO) {
		//TODO Implement constructor
<<<<<<< HEAD
=======
		/* Author: HOANG, Van Cuong - Project Debugger
		 * 11613599
		 * Date: 23-08-2017
		 * */
		this.capacity = capacity;
		this.adhocTicketDAO = adhocTicketDAO;
		this.carparkId = name;
		this.seasonTicketDAO = seasonTicketDAO;
		numberOfCarsParked = 0;
>>>>>>> master
	}



	@Override
	public void register(ICarparkObserver observer) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deregister(ICarparkObserver observer) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public String getName() {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return null;
=======
		return this.carparkId;
>>>>>>> master
	}



	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return false;
=======
		if(numberOfCarsParked == capacity)
			return true;
		else
			return false;
>>>>>>> master
	}



	@Override
	public IAdhocTicket issueAdhocTicket() {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return null;
=======
		numberOfCarsParked++;
		return this.adhocTicketDAO.createTicket(this.carparkId);
>>>>>>> master
	}



	@Override
	public void recordAdhocTicketEntry() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public IAdhocTicket getAdhocTicket(String barcode) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return null;
=======
		return this.adhocTicketDAO.findTicketByBarcode(barcode);
>>>>>>> master
	}



	@Override
	public float calculateAddHocTicketCharge(long entryDateTime) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void recordAdhocTicketExit() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void registerSeasonTicket(ISeasonTicket seasonTicket) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deregisterSeasonTicket(ISeasonTicket seasonTicket) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean isSeasonTicketValid(String ticketId) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean isSeasonTicketInUse(String ticketId) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public void recordSeasonTicketEntry(String ticketId) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void recordSeasonTicketExit(String ticketId) {
		// TODO Auto-generated method stub
		
	}

	
	

}
