package bcccp.tickets.adhoc;

import java.util.List;

public class AdhocTicketDAO  implements IAdhocTicketDAO  {

	private IAdhocTicketFactory factory;
	private int currentTicketNo;

	
	
	public AdhocTicketDAO(IAdhocTicketFactory factory) {
		//TODO Implement constructor
		this.factory = factory;
		currentTicketNo = 1;
	}



	@Override
	public IAdhocTicket createTicket(String carparkId) {
		// TODO Auto-generated method stub
		System.out.println("Creating an adhoc ticket!");
		return this.factory.make(carparkId, this.currentTicketNo++);
	}



	@Override
	public IAdhocTicket findTicketByBarcode(String barcode) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<IAdhocTicket> getCurrentTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
