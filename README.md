# IB_trading


Interactive Brokers Trading Model 

This is a personal project of mine. Broadly speaking, this program interfaces with Interactive Brokers' Trader Workstation Application to supply the logic behind a quantitative portfolio management strategy, designed and implemented by me. This should not be confused with a high frequency trading program - rather, the program analyzes fundamental data pulled from IB's TWS interface, and determines the breakdown of the portfolio as detailed in the algorithm. 

The primary focus of the algorithm is the PEG ratio (PE ratio/estimated earnings growth). Using this, as well as a small number of other fundamental data points, is how the algorithm determines which stocks, and what weightings of those stocks, should be bought, sold, held, etc.
