
package trading;




//RealTimeData.java    
//Version 1.0
//20141028
//R. Holowczak

//Import Java utilities and Interactive Brokers API
import java.util.Vector;
import com.ib.client.Contract;
import com.ib.client.ContractDetails;
import com.ib.client.EClientSocket;
import com.ib.client.EWrapper;
import com.ib.client.Execution;
import com.ib.client.Order;
import com.ib.client.OrderState;
import com.ib.client.TagValue;
import com.ib.client.CommissionReport;
import com.ib.client.UnderComp;






//RealTimeData Class is an implementation of the 
//IB API EWrapper class
public class RealTimeData implements EWrapper
{
	// Keep track of the next Order ID
	private int nextOrderID = 0;
	// The IB API Client Socket object
	private EClientSocket client = null;

	
	
	//Main for testing
    public static void main (String args[])
    {
        try
        {
		// Create an instance
		// At this time a connection will be made
		// and the request for market data will happen
		RealTimeData myData = new RealTimeData();
        }
        catch (Exception e)
        {
            e.printStackTrace ();
        }
    } // end main
    

	//TWS Instance must be running on Local Machine
	public RealTimeData ()
	{
		// Create a new EClientSocket object
		client = new EClientSocket (this);
		// Connect to the TWS or IB Gateway application
		// Leave null for localhost
		// Port Number (should match TWS/IB Gateway configuration
		client.eConnect (null, 7496, 0);
		// Pause here for connection to complete
		try 
		{
			while (! (client.isConnected()));
		} 
		catch (Exception e) 
		{
		}

		// Create a new contract
		Contract contract = new Contract ();
		contract.m_symbol = "EUR";
		contract.m_exchange = "IDEALPRO";
		contract.m_secType = "CASH";
		contract.m_currency = "USD";
		// Create a TagValue list
		Vector<TagValue> mktDataOptions = new Vector<TagValue>();
		// Make a call to reqMktData to start off data retrieval with parameters:
		// ConID    - Connection Identifier.
		// Contract - The financial instrument we are requesting data on
		// Ticks    - Any custom tick values we are looking for (null in this case)
		// Snapshot - false give us streaming data, true gives one data snapshot
		// MarketDataOptions - tagValue list of additional options (API 9.71 and newer)
		client.reqMktData(0, contract, null, false, mktDataOptions);
		// At this point call is done and any market data events
		// will be returned via the tickPrice method
		
		System.out.println(client.isConnected());
	}




	public void error(Exception e)
    {
	// Print out a stack trace for the exception
        e.printStackTrace ();
    }

	
	
    public void error(String str)
    {
	// Print out the error message
        System.err.println (str);
    }
    
    

    public void error(int id, int errorCode, String errorMsg)
    {
	// Overloaded error event (from IB) with their own error 
	// codes and messages
        System.err.println ("error: " + id + "," + errorCode + "," + errorMsg);
    }
    
    
    
    public void nextValidId (int orderId)
    {
	// Return the next valid OrderID
        nextOrderID = orderId;
    }


    //UNIMPLEMENTED METHODS//
    
	@Override
	public void connectionClosed() {
		// TODO Auto-generated method stub
		
	}




	@Override
    public void tickPrice(int orderId, int field, double price,
            int canAutoExecute)
    {
	try 
	{
		// Print out the current price.
		// field will provide the price type:
		// 1 = bid,  2 = ask, 4 = last
		// 6 = high, 7 = low, 9 = close
		//System.out.println("tickPrice: " + orderId + "," + field + "," + price);
	} 
	catch (Exception e)
        {
		e.printStackTrace ();
        }
     } // end tickPrice




	@Override
	public void tickSize(int tickerId, int field, int size) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void tickOptionComputation(int tickerId, int field, double impliedVol, double delta, double optPrice,
			double pvDividend, double gamma, double vega, double theta, double undPrice) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void tickGeneric(int tickerId, int tickType, double value) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void tickString(int tickerId, int tickType, String value) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void tickEFP(int tickerId, int tickType, double basisPoints, String formattedBasisPoints,
			double impliedFuture, int holdDays, String futureExpiry, double dividendImpact, double dividendsToExpiry) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void orderStatus(int orderId, String status, int filled, int remaining, double avgFillPrice, int permId,
			int parentId, double lastFillPrice, int clientId, String whyHeld) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void openOrder(int orderId, Contract contract, Order order, OrderState orderState) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void openOrderEnd() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void updateAccountValue(String key, String value, String currency, String accountName) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void updatePortfolio(Contract contract, int position, double marketPrice, double marketValue,
			double averageCost, double unrealizedPNL, double realizedPNL, String accountName) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void updateAccountTime(String timeStamp) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void accountDownloadEnd(String accountName) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void contractDetails(int reqId, ContractDetails contractDetails) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void bondContractDetails(int reqId, ContractDetails contractDetails) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void contractDetailsEnd(int reqId) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void execDetails(int reqId, Contract contract, Execution execution) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void execDetailsEnd(int reqId) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void updateMktDepth(int tickerId, int position, int operation, int side, double price, int size) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void updateMktDepthL2(int tickerId, int position, String marketMaker, int operation, int side, double price,
			int size) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void updateNewsBulletin(int msgId, int msgType, String message, String origExchange) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void managedAccounts(String accountsList) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void receiveFA(int faDataType, String xml) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void historicalData(int reqId, String date, double open, double high, double low, double close, int volume,
			int count, double WAP, boolean hasGaps) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void scannerParameters(String xml) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void scannerData(int reqId, int rank, ContractDetails contractDetails, String distance, String benchmark,
			String projection, String legsStr) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void scannerDataEnd(int reqId) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void realtimeBar(int reqId, long time, double open, double high, double low, double close, long volume,
			double wap, int count) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void currentTime(long time) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void fundamentalData(int reqId, String data) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void deltaNeutralValidation(int reqId, UnderComp underComp) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void tickSnapshotEnd(int reqId) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void marketDataType(int reqId, int marketDataType) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void commissionReport(CommissionReport commissionReport) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void position(String account, Contract contract, int pos, double avgCost) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void positionEnd() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void accountSummary(int reqId, String account, String tag, String value, String currency) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void accountSummaryEnd(int reqId) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void verifyMessageAPI(String apiData) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void verifyCompleted(boolean isSuccessful, String errorText) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void displayGroupList(int reqId, String groups) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void displayGroupUpdated(int reqId, String contractInfo) {
		// TODO Auto-generated method stub
		
	} // end RealTimeData
}
