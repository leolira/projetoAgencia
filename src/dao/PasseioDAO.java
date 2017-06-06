package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pacote.TurismoPasseio;

public class PasseioDAO {
	
	public void adicionar(TurismoPasseio passeio) throws SQLException{
		
		Connection con = null;
		
		String sql = "insert into passeio (descPasseio,localPasseio)" 
		+ "values(?,?)";
		
		try{
			con = Conexao.getConexao();
			
			PreparedStatement smt = con.prepareStatement(sql);
			smt.setString(1, passeio.getDescPasseio());
			smt.setString(2, passeio.getLocal());
			
			
			smt.execute();
			smt.close();
						
		} catch (Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			con.close();
			
		}
		
	}
	
	public void removerPasseio(int idPacote) throws SQLException{
			
			Connection con = null;
			
			String sql = "DELETE from passeio where idPasseio = ?";
			
			try{
				con = Conexao.getConexao();
				
				PreparedStatement smt = con.prepareStatement(sql);
				
				smt.setInt(1, idPacote);
				
				smt.execute();
				smt.close();
							
			} catch (Exception e){
				
				e.printStackTrace();
				
			}finally{
				
				con.close();
				
			}
			
		}

}