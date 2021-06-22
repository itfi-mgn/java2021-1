package lesson15;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class SQLTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		try(final Connection	conn = DriverManager.getConnection(
									"jdbc:postgresql://localhost:5432/postgres", 
									"postgres", 
									"")) {
			conn.setAutoCommit(false);
			
			System.err.println("Connected...");
			try(final Statement	stmt = conn.createStatement()) {
			
				try(final ResultSet	rs = stmt.executeQuery("select 10 union all select 20")) {
					final ResultSetMetaData	rsmd = rs.getMetaData();
					
					
					while (rs.next()) {
						//System.err.println("VAlue="+rs.getInt("vassya"));
						for (int index = 1; index <= rsmd.getColumnCount(); index++) {
							System.err.println(rsmd.getColumnName(index)
									+"="
									+rs.getObject(index));
						}
					}
				}
				
				try(final PreparedStatement	ps = conn.prepareStatement("insert into abcde(x,y)"+
						" values(?,?)")) {
					
					ps.setInt(1, 123);
					ps.setString(2, "v'assya");
					ps.executeUpdate();

					ps.setInt(1, 456);
					ps.setString(2, "petya");
					ps.executeUpdate();
				}
				
				try(final CallableStatement	cs = conn.prepareCall("{?= call minus(?)}")) {
					cs.registerOutParameter(1, Types.INTEGER);
					cs.setInt(2, 25);
					cs.execute();
					System.err.println("result: "+cs.getInt(1));
				}
				
				DatabaseMetaData	dbmd = conn.getMetaData();
				
				try(final ResultSet	rs = dbmd.getTables(null, null, "a%", null)) {
					final ResultSetMetaData	rsmd = rs.getMetaData();
					
					
					while (rs.next()) {
						//System.err.println("VAlue="+rs.getInt("vassya"));
						for (int index = 1; index <= rsmd.getColumnCount(); index++) {
							System.err.println(rsmd.getColumnName(index)
									+"="
									+rs.getObject(index));
						}
						System.err.println("---------------------------");
					}
				}
				
		//		stmt.executeUpdate("insert into abcde (x,y) values (20,'a  ssa')");
				conn.commit();
			}
		}
		
	}

}
