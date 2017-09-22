package bcccp.tickets.season;

import java.util.ArrayList;
import java.util.List;

import bcccp.tickets.season.ISeasonTicket;
import bcccp.tickets.season.IUsageRecordFactory;

public class SeasonTicketDAO implements ISeasonTicketDAO {

	private IUsageRecordFactory factory;
	private List<ISeasonTicket> seasonTickets = new ArrayList<ISeasonTicket>();
	
	
	public SeasonTicketDAO(IUsageRecordFactory factory) {
		//TOD Implement constructor
	}



	@Override
	public void registerTicket(ISeasonTicket ticket) {
		// Author: HOANG, Van Cuong
		// Adding ticket to an array list
		this.seasonTickets.add(ticket);
		System.out.println("Season ticket number: " + ticket.getId() + " has been stored!");
		//System.out.println();
		
	}



	@Override
	public void deregisterTicket(ISeasonTicket ticket) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public int getNumberOfTickets() {
		// TODO Auto-generated method stub
		return this.seasonTickets.size();
	}



	@Override
	public ISeasonTicket findTicketById(String ticketId) {
		// TODO Auto-generated method stub
		System.out.println("Looping all season tickets stored in list...");
		for(ISeasonTicket s : seasonTickets){
			//System.out.println(s.getId());
			if(s.getId().equalsIgnoreCase(ticketId)){
				// Found ticket
				System.out.println("Season ticket number: " + ticketId + " found!");
				return s;
			}
		}
		// Ticket not found
		System.out.println("Season ticket number: " + ticketId + " not found!");
		return null;
	}



	@Override
	public void recordTicketEntry(String ticketId) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void recordTicketExit(String ticketId) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
