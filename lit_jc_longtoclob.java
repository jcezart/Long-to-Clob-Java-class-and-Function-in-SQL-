create or replace and compile java source named lit_jc_longtoclob as
import java.sql.*;
import java.io.Writer;
import oracle.sql.CLOB;
import oracle.jdbc.OracleConnection;

public class LongToClob {

  public static CLOB fromQuery(String sql) throws Exception {
    Connection conn = DriverManager.getConnection("jdbc:default:connection:");
    Statement st = null;
    ResultSet rs = null;
    try {
      st = conn.createStatement();
      rs = st.executeQuery(sql);
      if (!rs.next()) return null;

      String longData = rs.getString(1);

      CLOB out = CLOB.createTemporary((OracleConnection) conn, true, CLOB.DURATION_SESSION);
      if (longData != null) {
        Writer w = out.getCharacterOutputStream();
        w.write(longData);
        w.flush();
        w.close();
      }
      return out;
    } finally {
      if (rs != null) try { rs.close(); } catch (Exception ignore) {}
      if (st != null) try { st.close(); } catch (Exception ignore) {}
    }
  }

  public static CLOB byRowId(String owner, String table, String column, String rowidChar) throws Exception {
    Connection conn = DriverManager.getConnection("jdbc:default:connection:");
    String sql = "SELECT " + column + " FROM " + owner + "." + table + " WHERE rowid = chartorowid(?)";
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      ps = conn.prepareStatement(sql);
      ps.setString(1, rowidChar);
      rs = ps.executeQuery();
      if (!rs.next()) return null;

      String longData = rs.getString(1);

      CLOB out = CLOB.createTemporary((OracleConnection) conn, true, CLOB.DURATION_SESSION);
      if (longData != null) {
        Writer w = out.getCharacterOutputStream();
        w.write(longData);
        w.flush();
        w.close();
      }
      return out;
    } finally {
      if (rs != null) try { rs.close(); } catch (Exception ignore) {}
      if (ps != null) try { ps.close(); } catch (Exception ignore) {}
    }
  }
}
/

