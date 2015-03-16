/**
 * Created by gongxingfa on 15/3/15.
 */


val tradeProcessor = new TradeProcessor
tradeProcessor.processTransaction(Sell("GOOG", 500))
tradeProcessor.processTransaction(Buy("GOOG", 700))
tradeProcessor.processTransaction(Sell("GOOG", 1000))
tradeProcessor.processTransaction(Buy("GOOG", 3000))
