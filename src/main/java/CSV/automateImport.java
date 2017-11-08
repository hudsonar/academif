package CSV;

import java.sql.Connection;

public class automateImport
{
    public static void main(String[] args) 
    {
        DBase db = new DBase();
        Connection conn = db.connect("jdbc:mysql://localhost:3306/db_academif","root","");
        db.importData(conn,args[0]);
    }

}