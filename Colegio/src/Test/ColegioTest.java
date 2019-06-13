package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import com.company.Conexiones.conexionesBaseDatos;


class ColegioTest {

	@Test
	void iniciarConexion() {
		conexionesBaseDatos bbdd = new conexionesBaseDatos();
		Connection conexion;
		
		//Prueba Erronea
		conexion = bbdd.iniciarConexion("hola", "admin");
		assertTrue(conexion == null);
		
		//Prueba Acertada
		conexion = bbdd.iniciarConexion("administrador", "1234");
		assertTrue(conexion != null);
		
		//Prueba Erronea
		conexion = bbdd.iniciarConexion("rafa", "wtf");
		assertTrue(conexion == null);
	}
}
