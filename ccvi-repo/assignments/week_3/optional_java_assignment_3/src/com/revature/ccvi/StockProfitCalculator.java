package com.revature.ccvi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StockProfitCalculator {
	
    public record TransactionResult(int buyDay, int sellDay, int profit) {}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter prices separated by spaces or commas (or type 'exit' to quit).");
        
        while (true) {
            System.out.print("> "); 
            if (!scanner.hasNextLine()) break;
            
            String inputLine = scanner.nextLine().trim();
            
            // Exit condition
            if (inputLine.equalsIgnoreCase("exit") || inputLine.equalsIgnoreCase("quit")) {
                System.out.println("Exiting program.");
                break;
            }
            
            // Clean up formatting
            if (inputLine.toLowerCase().startsWith("input:")) {
                inputLine = inputLine.substring(6).trim();
            }
            if (inputLine.startsWith("[")) inputLine = inputLine.substring(1);
            if (inputLine.endsWith("]")) inputLine = inputLine.substring(0, inputLine.length() - 1);
            
            List<Integer> pricesList = new ArrayList<>();
            if (!inputLine.isEmpty()) {
                // Split by comma or any whitespace character
                String[] parts = inputLine.split("[,\\s]+");
                try {
                    for (String part : parts) {
                        if (!part.isEmpty()) {
                            pricesList.add(Integer.parseInt(part.trim()));
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter integers only.\n");
                    continue;
                }
            }

            int[] prices = pricesList.stream().mapToInt(Integer::intValue).toArray();

            // Format output
            System.out.println("Input: " + Arrays.toString(prices));

            // 1. Core Requirement
            int maxProfit = calculateMaxProfit(prices);
            System.out.println("Output: " + maxProfit);

            // 2. Stretch Goal 1: Identify the Buy/Sell Days
            Object result = identifyBuySellDays(prices);
            
            // Utilizing instanceof deconstruction
            if (result instanceof TransactionResult(int b, int s, int p) && p > 0) {
                // Fetching the actual prices using the 1-based day indexes
                int buyPrice = prices[b - 1];
                int sellPrice = prices[s - 1];
                System.out.printf("(Buy on the day priced at %d, sell on the day priced at %d.)%n", buyPrice, sellPrice);
            }
            
            System.out.println();
        }
        
        scanner.close();
    }

    public static int calculateMaxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        int minPrice = prices[0];
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public static Object identifyBuySellDays(int[] prices) {
        if (prices == null || prices.length < 2) {
            return new TransactionResult(0, 0, 0);
        }

        int minPrice = prices[0];
        int minPriceDay = 1; // 1-indexed for reporting
        int bestBuyDay = 1;
        int bestSellDay = 1;
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                minPriceDay = i + 1; 
            } else {
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                    bestBuyDay = minPriceDay;
                    bestSellDay = i + 1;
                }
            }
        }
        return new TransactionResult(bestBuyDay, bestSellDay, maxProfit);
    }

    public static int calculateMaxProfitTwoPurchases(int[] prices) {
        if (prices == null || prices.length < 3) {
            return 0;
        }
        
        int maxProfit = 0;
        
        // Iterating to treat day 'k' as our single sell day
        for (int k = 2; k < prices.length; k++) {
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            
            // Find the two smallest values prior to day k
            for (int i = 0; i < k; i++) {
                if (prices[i] < min1) {
                    min2 = min1;
                    min1 = prices[i];
                } else if (prices[i] < min2) {
                    min2 = prices[i];
                }
            }
            
            int profit = (prices[k] * 2) - min1 - min2;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
