package CSV;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import br.com.academif.repository.entity.SubEventoEntity;

class DBase
{
    public DBase()
    {
    }

    public Connection connect(String db_connect_str, String db_userid, String db_password)
    {
        Connection conn;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            conn = (Connection) DriverManager.getConnection(db_connect_str, db_userid, db_password);

        }
        catch(Exception e)
        {
            e.printStackTrace();
            conn = null;
        }

        return conn;    
    }
    public void importData(Connection conn,String filename)
    {
        Statement stmt;
        String query;

        try
        {
            stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
    ResultSet.CONCUR_UPDATABLE);

            query = "LOAD DATA INFILE '"+filename+"' INTO TABLE tb_usuario  FIELDS TERMINATED BY ',' (idUsuario, matricula, nome, cpf, dataNasc, curso, periodo, statusMatricula, subEventosConfirmados)";

            stmt.executeUpdate(query);
                
        }
        catch(Exception e)
        {
            e.printStackTrace();
            stmt = null;
        }
    }
}