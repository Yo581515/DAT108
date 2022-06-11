import java.sql.*;

public class DataBase {
    //CREATE SCHEMA `newdatabase` ;

    public String DATA_BASE;
    public String USER;
    public String PASSWORD;
    public String URL;


    public DataBase() {
        this.USER = data.USER;
        this.PASSWORD = data.PASSWORD;
        this.URL = data.URL;
    }


    Connection connection;

    public boolean doesDBExist(String databasename) {
        boolean found = false;
        try {
            connection = DriverManager.getConnection(getURL(), getUSER(), getPASSWORD());
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSet = connection.getMetaData().getCatalogs();

            while (!found && resultSet.next()) {
                //System.out.println("Schema Name - " + resultSet.getString("TABLE_CAT"));
                String dataBase = resultSet.getString("TABLE_CAT");
                if (dataBase.equals(databasename)) {
                    found = true;
                }
            }
            if (!found) {
                //System.out.println(databasename + " data base does not exists");
            } else {
                //System.out.println(databasename + " data base already exists");
            }

        } catch (Exception e) {
            System.out.println("Exception i doesDBExist() metode");
            e.printStackTrace();
        }

        return found;
    }


    //CREATE DATABASE db_name;
    public void createNewDataBase(String newdatabase) {
        try {

            connection = DriverManager.getConnection(getURL(), getUSER(), getPASSWORD());
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE SCHEMA `" + newdatabase + "`;");
            //System.out.println(newdatabase+" data base created");


        } catch (Exception e) {
            System.out.println("Exception i createNewDataBase() metode");
            e.printStackTrace();
        }
    }

    //DROP DATABASE `newdatabase`;
    public void dropDataBase(String databasename) {
        try {

            if (doesDBExist(databasename)) {
                connection = DriverManager.getConnection(getURL(), getUSER(), getPASSWORD());
                Statement statement = connection.createStatement();
                String sql = "DROP DATABASE " + databasename;
                statement.execute(sql);
                //System.out.println(databasename + " deleted");
            } else {
                //System.out.println("didnt delete beacause not found");

            }
        } catch (SQLException e) {
            System.out.println("Exception i dropDataBase() metode EX");
            throw new RuntimeException(e);
        }

    }


    public boolean doesTableExist(String tableName) {
        boolean found = false;
        try {
            connection = DriverManager.getConnection(getURL() + getDATA_BASE(), getUSER(), getPASSWORD());

            ResultSet resultSet = connection.getMetaData().getTables(null, null, tableName,
                    new String[]{"TABLE"});

            while (!found && resultSet.next()) {
                /*
                System.out.println(resultSet.getString("TABLE_CAT")
                        + ", " + resultSet.getString("TABLE_SCHEM")
                        + ", " + resultSet.getString("TABLE_NAME")
                        + ", " + resultSet.getString("TABLE_TYPE")
                        + ", " + resultSet.getString("REMARKS"));
                 */

                String tableInDataBase = resultSet.getString("TABLE_NAME");

                if (tableInDataBase.equals(tableName)) {
                    found = true;
                }
            }

            if (!found) {
                //System.out.println("\n"+tableName + " table does not exists in the data base");
            } else {
                //System.out.println("\n"+tableName + " table already exists in the data base");
            }

        } catch (SQLException e) {
            System.out.println("Exception i doesTableExist() metode EX");
            throw new RuntimeException(e);
        }

        return found;
    }


    //CREATE TABLE `databasefromjava`.`new_table` ();

    /**
     * @param tableName
     * @param primary        i format  `primaryValue` DATA_TYPE
     * @param restOfvalues   i format   `restOfvalues` DATA_TYPE,
     * @param auto_increment skriv true for auto_increment
     */
    public void createNewTable(String tableName, String primary, String primaryDataType, String restOfvalues, boolean auto_increment) {
        try {
            connection = DriverManager.getConnection(getURL() + getDATA_BASE(), getUSER(), getPASSWORD());
            Statement statement = connection.createStatement();


            String sql = "";
            if (auto_increment) {
                sql = "CREATE TABLE " + "`" + DATA_BASE + "`." + "`" + tableName + "`" +
                        "(" + primary + " " + primaryDataType + " NOT NULL auto_increment," +
                        restOfvalues +
                        "PRIMARY KEY (" + primary + "));";
            } else {
                sql = "CREATE TABLE " + "`" + DATA_BASE + "`." + "`" + tableName + "`" +
                        "(\n" + primary + " " + primaryDataType + " NOT NULL ," +
                        restOfvalues +
                        "\nPRIMARY KEY (" + primary + "));";
            }
            //System.out.println(sql);
            statement.executeUpdate(sql);
            //System.out.println(tableName+" table created");
        } catch (SQLException e) {
            System.out.println("Exception i createNewTable() metode");
            throw new RuntimeException(e);
        }
    }

    public void dropTable(String tableName) {
        try {
            connection = DriverManager.getConnection(getURL() + getDATA_BASE(), getUSER(), getPASSWORD());
            Statement statement = connection.createStatement();
            String sql = "DROP TABLE " + tableName;
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Exception i dropTable() metode");
            throw new RuntimeException(e);
        }
    }


    public DataBase(String DATA_BASE, String USER, String PASSWORD) {
        this.DATA_BASE = DATA_BASE;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
        this.URL = data.URL;
    }

    public DataBase(String db) {
        this.DATA_BASE = db;
        this.USER = data.USER;
        this.PASSWORD = data.PASSWORD;
        this.URL = data.URL;

    }

    public void setDATA_BASE(String DATA_BASE) {
        this.DATA_BASE = DATA_BASE;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getDATA_BASE() {
        return DATA_BASE;
    }

    public String getURL() {
        return URL;
    }

    public String getUSER() {
        return USER;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

}
