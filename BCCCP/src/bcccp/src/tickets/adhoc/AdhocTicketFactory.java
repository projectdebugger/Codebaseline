package tickets.adhoc;

public class AdhocTicketFactory implements IAdhocTicketFactory {	
	@Override
	public IAdhocTicket make(String carparkId, int ticketNo) {
		// TODO Auto-generated method stub
		/* Author: HOANG, Van Cuong - Project Debuggers
		 * 11613599
		 * Date: 23-08-2017
		 * */
		AdhocTicket ticket = new AdhocTicket(carparkId, ticketNo, getRandomBarCode());
		return ticket;
	}
	public String getRandomBarCode(){
		return Long.toHexString(Double.doubleToLongBits(Math.random())).substring(0,4).toUpperCase();
	}


}
