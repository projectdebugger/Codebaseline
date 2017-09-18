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
		// TODO Auto-generated method stub
		this.seasonTickets.add(ticket);
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
		for(ISeasonTicket s : seasonTickets){
			System.out.println(s.getId());
			if(s.getId().equalsIgnoreCase(ticketId)){
				return s;
			}
		}
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
