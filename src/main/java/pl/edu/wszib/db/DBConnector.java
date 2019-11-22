package pl.edu.wszib.db;

        import pl.edu.wszib.model.Pytanie;

        import java.sql.*;

public class DBConnector {

    public static Connection connection = null;

    public static void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DBConnector.connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/test1?user=root&password=");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();

            System.exit(1);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("bład z logowaniem sie bazy");
            System.exit(1);
        }

    }

    public static void addQuestion(Pytanie pytanie) {

        String sql = "INSERT INTO milionerzy (idPytania, Nagroda, Pytanie, Odpowiedzi, PrawidlowaOdpowiedz) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = DBConnector.connection.prepareStatement(sql);
            preparedStatement.setInt(1, pytanie.getIdPytania());
            preparedStatement.setInt(2, pytanie.getNagroda());
            preparedStatement.setString(3, pytanie.getPytanie());
            preparedStatement.setString(4, pytanie.getOdpowiedzi());
            preparedStatement.setString(5, pytanie.getPrawidlowaOdpowiedz());
            //preparedStatement.clearParameters();
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static Pytanie getPytanie(int idPytania) {
        String sqlSelect = "SELECT * FROM milionerzy WHERE idPytania = ?";

        try {
            PreparedStatement preparedStatement = DBConnector.connection.prepareStatement(sqlSelect);
            preparedStatement.setInt(1, idPytania);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Pytanie pytanieFromDB = new Pytanie();
                pytanieFromDB.setIdPytania(resultSet.getInt("idPytania"));
                pytanieFromDB.setNagroda(resultSet.getInt("Nagroda"));
                pytanieFromDB.setPytanie(resultSet.getString("Pytanie"));
                pytanieFromDB.setOdpowiedzi(resultSet.getString("Odpowiedzi"));
                pytanieFromDB.setPrawidlowaOdpowiedz(resultSet.getString("PrawidlowaOdpowiedz"));


                return pytanieFromDB;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static Pytanie removeQuestion(int idPytania) {
        String sqlSelect = "DELETE FROM milionerzy WHERE idPytania = ?";
        try {
            PreparedStatement preparedStatement = DBConnector.connection.prepareStatement(sqlSelect);
            preparedStatement.setInt(1, idPytania);

           preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    public static Pytanie updateQuestion(int idPytania, Pytanie pytanie) {
        String sql = "UPDATE  milionerzy SET Nagroda = ?, Pytanie = ?, Odpowiedzi = ?, PrawidlowaOdpowiedz = ? where idPytania = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = DBConnector.connection.prepareStatement(sql);
            preparedStatement.setInt(1, pytanie.getNagroda());
            preparedStatement.setString(2, pytanie.getPytanie());
            preparedStatement.setString(3, pytanie.getOdpowiedzi());
            preparedStatement.setString(4, pytanie.getPrawidlowaOdpowiedz());
            preparedStatement.setInt(5, idPytania);
            //preparedStatement.clearParameters();
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
