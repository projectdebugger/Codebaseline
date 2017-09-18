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
		/* Author: HOANG, Van Cuong - Project Debugger
		 * 11613599
		 * Date: 23-08-2017
		 * */
		this.capacity = capacity;
		this.adhocTicketDAO = adhocTicketDAO;
		this.carparkId = name;
		this.seasonTicketDAO = seasonTicketDAO;
		numberOfCarsParked = 0;
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
		return this.carparkId;
	}



	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		if(numberOfCarsParked == capacity)
			return true;
		else
			return false;
	}



	@Override
	public IAdhocTicket issueAdhocTicket() {
		// TODO Auto-generated method stub
		numberOfCarsParked++;
		return this.adhocTicketDAO.createTicket(this.carparkId);
	}



	@Override
	public void recordAdhocTicketEntry() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public IAdhocTicket getAdhocTicket(String barcode) {
		// TODO Auto-generated method stub
		return this.adhocTicketDAO.findTicketByBarcode(barcode);
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
		this.seasonTicketDAO.registerTicket(seasonTicket);
	}



	@Override
	public void deregisterSeasonTicket(ISeasonTicket seasonTicket) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean isSeasonTicketValid(String ticketId) {
		// TODO Auto-generated method stub
		// Using season ticket DAO to check if this ticketID is Valid
		// If we can find a ticket with the given id, return true
		if(this.seasonTicketDAO.findTicketById(ticketId) != null)
			return true;
		// else, return false
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
