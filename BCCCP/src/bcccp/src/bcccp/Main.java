package bcccp;



import java.awt.EventQueue;

import bcccp.carpark.CarSensor;
import bcccp.carpark.Carpark;
import bcccp.carpark.Gate;
import carpark.entry.EntryController;
import carpark.entry.EntryUI;
import carpark.exit.ExitController;
import carpark.exit.ExitUI;
import carpark.paystation.PaystationController;
import carpark.paystation.PaystationUI;
import tickets.adhoc.AdhocTicketFactory;
import tickets.adhoc.AdhocTicketDAO;
import tickets.adhoc.IAdhocTicketDAO;
import tickets.season.ISeasonTicket;
import tickets.season.ISeasonTicketDAO;
import tickets.season.SeasonTicket;
import tickets.season.SeasonTicketDAO;
import tickets.season.UsageRecordFactory;

public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarSensor eos = new CarSensor("Entry Outside Sensor", 20, 100);
					Gate egate = new Gate(20, 320);
					CarSensor eis = new CarSensor("Entry Inside Sensor", 20, 440);
					EntryUI eui = new EntryUI(320, 100);	
					
					PaystationUI pui = new PaystationUI(660, 100);
					
					ExitUI xui = new ExitUI(1000, 100);	
					CarSensor xis = new CarSensor("Exit Inside Sensor", 1330, 100);
					Gate xgate = new Gate(1330, 320);
					CarSensor xos = new CarSensor("Exit Outside Sensor", 1330, 440);
					
					IAdhocTicketDAO adhocTicketDAO = new AdhocTicketDAO(new AdhocTicketFactory());
					ISeasonTicketDAO seasonTicketDAO = new SeasonTicketDAO(new UsageRecordFactory());
					
					Carpark carpark = new Carpark("Bathurst Chase", 3, adhocTicketDAO, seasonTicketDAO);
					
					ISeasonTicket t1 = new SeasonTicket("S1111","Bathurst Chase", 0L, 0L);
					ISeasonTicket t2 = new SeasonTicket("S2222","Bathurst Chase", 0L, 0L);
					
					carpark.registerSeasonTicket((bcccp.tickets.season.ISeasonTicket) t1);
					carpark.registerSeasonTicket((bcccp.tickets.season.ISeasonTicket) t2);
					
					@SuppressWarnings("unused")
					EntryController entryController = 
							new EntryController(carpark, egate, eos, eis, eui);
					@SuppressWarnings("unused")
					PaystationController payController = 
							new PaystationController(carpark, pui);
					
					@SuppressWarnings("unused")
					ExitController exitController = 
					new ExitController(carpark, xgate, xis, xos, xui);
					
					eos.setVisible(true);
					egate.setVisible(true);
					eis.setVisible(true);
					eui.setVisible(true);
					
					pui.setVisible(true);
					
					xui.setVisible(true);
					xis.setVisible(true);
					xgate.setVisible(true);
					xos.setVisible(true);
					
					
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
