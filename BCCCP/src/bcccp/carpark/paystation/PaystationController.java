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



	@Override
	public void ticketInserted(String barcode) {
		// TODO Auto-generated method stub
		
	}
	public void receiveDetections(Detector.Detections<Barcode> barcode) {
                final SparseArray<Barcode> barcodes = detections.getDetectedItems();
                if (barcodes.size() != 0) {
                    String data = barcodes.valueAt(0).displayValue;

                    Log.d(TAG, "Barcode detected: " + data);
                    this.ui.beep();

                    returnData(data);
                }
            }
        });

        if (!mBarcodeDetector.isOperational())
            Log.w(TAG, "Detector dependencies are not yet available.");
    }




	@Override
	public void ticketPaid() {
		// TODO Auto-generated method stub
		/*
			Author: Santosh
		*/
			if(!this.carpark.isPaid()){
			this.exitGate.raise();
			this.ui.display("");
			this.charge();
		}
		
	}



	@Override
	public void ticketTaken() {
		// TODO Auto-generated method stub
		/*
			Author: Santosh
		*/
		if(!this.carpark.isPaid()){
			this.exitGate.raise();
			this.ui.display("");
			this.ui.beep();
		}
	}
	}

	
	
}
