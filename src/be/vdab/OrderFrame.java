package be.vdab;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class OrderFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private static final Path PIZZAPAD = Paths.get("C:/data/files/pizza.csv");
    Stream<String> streamPizza;

    DefaultListModel<Pizza> pizzaDefaultListModel = new DefaultListModel<>();
    private JList jlPizzaList = new JList<>(pizzaDefaultListModel);

OrderFrame() {
    super("test titel");
    setSize(600,400);
    {
        try {
            streamPizza = Files.lines(PIZZAPAD);
            BufferedReader brPizzaReader = Files.newBufferedReader(PIZZAPAD);
            String sPizzaFileLine;
            while ((sPizzaFileLine = brPizzaReader.readLine()) != null) {
                String[] lineContent = sPizzaFileLine.split(";");
                System.out.println(lineContent[0] + "; " + lineContent[1] + "; " + lineContent[2]);
                Pizza pizza = new Pizza();
                pizza.setsProductNaam(lineContent[0]);
                pizza.setsPizzaOmschrijving(lineContent[1]);
                pizza.setBdProductPrijs(new BigDecimal(Long.parseLong(lineContent[2])));
//
//                Pizza p = new Pizza(sPizzaFileLine.substring(0, sPizzaFileLine.indexOf(";")),
//                        sPizzaFileLine.substring(sPizzaFileLine.indexOf(";") + 1, sPizzaFileLine.lastIndexOf(";")),
//                      new BigDecimal( sPizzaFileLine.substring(  sPizzaFileLine.lastIndexOf(";") + 1)  )    );
                pizzaDefaultListModel.addElement(pizza);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    add(jlPizzaList);
    pack();




}

    public static void main(String[] args) {
        new OrderFrame().setVisible(true);
    }

}

