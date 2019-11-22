package pl.edu.wszib;

import pl.edu.wszib.db.DBConnector;
import pl.edu.wszib.db.gui.GUI;
import pl.edu.wszib.model.Pytanie;

public class Main {
    public static void main(String[] args) {
        DBConnector.connect();
        GUI.Menu();

    }
}
