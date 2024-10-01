package WebScrape;
// Defines the package name for the class
// Import the necessary libraries to be used in the class
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import GUI.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.concurrent.Flow;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
public class WebScrape{
    //  Create variables to be used later
    //  URL of the website to be scraped
    //  String ticker, name, and price to be scraped from the website
    
                final String url = "https://www.slickcharts.com/sp500";
            String ticker = "";
            String name = "";               
            String price = "";
            String userinput = "";

            String namefromticker; 
            Double pricefromticker;
            int index;

            //JPanel listPanel = new JPanel();
            //listPanel.setPreferredSize(new Dimension(340, 600));


            ArrayList<String> tickersL = new ArrayList<String>();
            ArrayList<String> nameL = new ArrayList<String>();
            ArrayList<String> priceLS = new ArrayList<String>();               
            ArrayList<Double> priceLD = new ArrayList<Double>();

                //  Create new ArrayList to store tickersL for ease of access

        //  temp hardcode user input to test - will later be taken from GUI user inoput field
        //rmv    protected String userinput = "AAPL";
        //    String namefromticker = tickersL.get(tickersL.indexOf(userinput)); 
        //    Double pricefromticker = priceLD.get(tickersL.indexOf(userinput));
        //rmv    int index = tickersL.indexOf(userinput);


    // webOut() method scrapes the S&P 500 data from the website and stores it in ArrayLists for later use
    public void webOut() {

                try {
                    final Document scrape = Jsoup.connect(url).get();

                    for (Element row : scrape.select(
                        "table.table.table-hover.table-borderless.table-sm tr")) {
                        if (row.select("td:nth-of-type(3)").text().contains("1")) { //.col-lg-5
                            continue;
                        }
                        else if (row.select("td:nth-of-type(3)").text().contains("2")) { //.col-lg-5
                            continue;
                        }
                        else if (row.select("td:nth-of-type(3)").text().contains("3")) { //.col-lg-5
                            continue;
                        }
                        else if (row.select("td:nth-of-type(3)").text().contains("4")) { //.col-lg-5
                            continue;
                        }
                        else if (row.select("td:nth-of-type(3)").text().contains("5")) { //.col-lg-5
                            continue;
                        }
                        else if (row.select("td:nth-of-type(3)").text().contains("6")) { //.col-lg-5
                            continue;
                        }
                        else if (row.select("td:nth-of-type(3)").text().contains("7")) { //.col-lg-5
                            continue;
                        }
                        else if (row.select("td:nth-of-type(3)").text().contains("8")) { //.col-lg-5
                            continue;
                        }
                        else if (row.select("td:nth-of-type(3)").text().contains("9")) { //.col-lg-5
                            continue;
                        }
                        //else if (row.select("td:nth-of-type(3)").text().contains("")) { //.col-lg-5
                        //    continue;
                        //}
                    else {
                        ticker = 
                                row.select("td:nth-of-type(3)").text();
                            tickersL.add(ticker);
                        name = 
                                row.select("td:nth-of-type(2)").text();
                            nameL.add(name);
                        price = 
                                row.select("td:nth-of-type(5)").text();
                            priceLS.add(price);
                            double priceD = 0;
                                try {
                                    priceD = DecimalFormat.getNumberInstance().parse(price).doubleValue();
                                    priceLD.add(priceD);
                                } catch (ParseException e) {
                                    //e.printStackTrace();
                                }
                                
                                    //System.out.println(ticker + " " + name + " " + "$" + priceD);
                                    //JLabel label = new JLabel(ticker + " " + name + " " + "$" + priceD);
                                    //JLabel label = new JLabel("1"); 
                                    //listPanel.add(label);
                                    //listPanel.setPreferredSize(new Dimension(340, 600));
                        }
                    }
                                   //System.out.println(tickersL.get(idL.get(0)));
                                /*    for (int i = 0; i < tickersL.size(); i++) {
                                    System.out.println(tickersL.get(i));
                                   } */
                }
            catch (Exception ex) {
                ex.printStackTrace();
         }

    }
    // end of webOut() method

    // getfrmTickers() method takes user input and returns the name and price of the stock, price in Double format to be used later
    public String getfrmTickersN(String userinput) {
    //  Create new webout object and initiate webout() to give getTickers access to the tickersL ArrayList
        WebScrape webout = new WebScrape();
        webout.webOut();
    //  Create new ArrayList to store tickersL for ease of access
        ArrayList<String> tickersLook = new ArrayList<String>();
        tickersLook = webout.tickersL;
        ArrayList<String> nameLook = new ArrayList<String>();
        nameLook = webout.nameL;

        namefromticker = nameLook.get(tickersLook.indexOf(userinput)); 

        return namefromticker;
    //    System.out.println("The name of stock: " + userinput + " is " + namefromticker + " and price of " + namefromticker + " is " + pricefromticker + "$");      
    } 
    public Double getfrmTickersP(String userinput) {
        //  Create new webout object and initiate webout() to give getTickers access to the tickersL ArrayList
            WebScrape webout = new WebScrape();
            webout.webOut();
        //  Create new ArrayList to store tickersL for ease of access
            ArrayList<String> tickersLook = new ArrayList<String>();
            tickersLook = webout.tickersL;

            ArrayList<Double> priceLook = new ArrayList<Double>();
            priceLook = webout.priceLD;
 
            pricefromticker = priceLook.get(tickersLook.indexOf(userinput));
    
            return pricefromticker;
        //    System.out.println("The name of stock: " + userinput + " is " + namefromticker + " and price of " + namefromticker + " is " + pricefromticker + "$");           
    } 
    public int getfrmTickersI(String userinput) {
        //  Create new webout object and initiate webout() to give getTickers access to the tickersL ArrayList
            WebScrape webout = new WebScrape();
            webout.webOut();
        //  Create new ArrayList to store tickersL for ease of access
            ArrayList<String> tickersLook = new ArrayList<String>();
            tickersLook = webout.tickersL;

            String userinputtest = userinput;

            index = tickersLook.indexOf(userinputtest); 
        
            return index;    
            //    System.out.println("The name of stock: " + userinput + " is " + namefromticker + " and price of " + namefromticker + " is " + pricefromticker + "$");               
    } 
    // end of getfrmTickers() method

    // fileWriter() method creates a new file and writes the stock data to it
    public void fileWriter() {
        // Create new webout object and initiate webout() to give fileWriter access to the tickersL, nameL, and priceLD ArrayLists
        WebScrape webout = new WebScrape();
        webout.webOut();
        // Create new variables to store the stock data, currently gets 1st one, will be updated to get all
        String ticker = webout.tickersL.get(0);
        String name = webout.nameL.get(0);
        Double price = webout.priceLD.get(0);
        // Try cartch block to create a new file and write the stock data to it
        try {
            // Create a new file stockdata to be accessed later
            File file = new File("stockdata.txt");
            if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
        }
        //write stock data to the file
        try {
            FileWriter writer = new FileWriter("stockdata.txt");
                writer.write("Stock Data: \n");
                writer.write("Ticker: " + ticker + "\n");
                writer.write("Name: " + name + "\n");
                writer.write("Price: " + price + "\n");
                writer.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
        }
    }
    // end of fileWriter() method

    public ArrayList<String> gettickersL() {
        webOut();
        return tickersL;
    } 
    public ArrayList<String> getnameL() {
        webOut();
        return nameL;
    } 
    public ArrayList<String> getpriceL() {
        webOut();
        return priceLS;
    } 

    /*public String getnamefromticker() {
        getfrmTickers(userinput);
        return namefromticker;
    }*/


    //main method initiates webOut() and getfrmTickers() for testing purpouses only
/*     public static void main(String[] args) {
        WebScrape webout = new WebScrape();
        webout.webOut();
        //WebScrape gettickers = new WebScrape();
        //gettickers.getfrmTickers();
        //WebScrape filewrite = new WebScrape();
        //filewrite.fileWriter();

        } */
//end of class webscrape
}

