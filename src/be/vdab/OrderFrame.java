package be.vdab;

import org.apache.commons.io.input.BOMInputStream;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class OrderFrame extends JFrame {
    // JFrame is serializable
    private static final long serialVersionUID = 1L;

    // create JLIST & listmodel to showing products
    DefaultListModel<Pizza> pizzaDefaultListModel = new DefaultListModel<>();
    private JList jlPizzaList = new JList<>(pizzaDefaultListModel);

    // constructor
    OrderFrame() {
        super("Pizza Pappi");
        setSize(600, 400);
        setLayout(new GridLayout(2,3));

        {
            try {
                // create a (BOM) reader to import the product data from a csv file on the hard disk
                BOMInputStream bomPizzaReader = new BOMInputStream(new DataInputStream(new FileInputStream("C:/data/files/pizza.csv")));
                //skim BOM if
                if (bomPizzaReader.hasBOM()) {
                    bomPizzaReader.skip(0);
                }
                BufferedReader brPizzaReader = new BufferedReader(new InputStreamReader(bomPizzaReader));

                String sPizzaFileLine;
                while ((sPizzaFileLine = brPizzaReader.readLine()) != null) {
                    String[] lineContent = sPizzaFileLine.split(";");
                    Pizza pizza = new Pizza();
                    pizza.setProductNaam(lineContent[0]);
                    pizza.setPizzaOmschrijving(lineContent[1]);
                    pizza.setBdProductPrijs(new BigDecimal(lineContent[2]));
                    pizzaDefaultListModel.addElement(pizza);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
            add(jlPizzaList);
            pack();
        }
    }

    public static void main(String[] args) {
        new OrderFrame().setVisible(true);
    }

}

