package mp;

import mp.exceptions.EmailIncorrecto;
import mp.exceptions.EmailPreviamenteRegistrado;
import mp.exceptions.RegistroCorrecto;
import mp.exceptions.NickYaExistente;
import mp.users.Alumno;
import mp.users.MiembroURJC;
import mp.users.Profesor;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sistema {
	private HashMap<Integer, MiembroURJC> usuarios;

	public Sistema() {
		this.usuarios=new HashMap<>();
	}

	/**
	 * 
	 * @param nick
	 * @param cont
	 */
	public boolean login(String nick, String cont) {
		// TODO - implement Sistema.login
		throw new UnsupportedOperationException();
	}

	/**
	 *  @param nombre
	 * @param apellidos
	 * @param nick
	 * @param contrasena
	 * @param email
	 */
	public void registrarUsuario(String nombre, String  apellidos, String nick, String contrasena, String email) throws NickYaExistente, EmailIncorrecto, RegistroCorrecto, EmailPreviamenteRegistrado {
		// TODO - implement Sistema.registro
		int tipo = validarEmail(email);
		MiembroURJC nuevoUsuario;
		if (tipo==0){
			throw new EmailIncorrecto(email);
		}else{
			for (MiembroURJC usuario : usuarios.values()) {
				if (usuario.getEmail().equals(email)){
					throw new EmailPreviamenteRegistrado(email);
				}
			}
			if (tipo==1){
				nuevoUsuario = new Profesor(nombre,apellidos,nick,contrasena,email);
			}else{
				nuevoUsuario = new Alumno(nombre,apellidos,nick,contrasena,email);
			}
			this.registrarUsuario(nuevoUsuario);
		}
	}

	private boolean registrarUsuario(MiembroURJC nuevoUsuario) throws NickYaExistente, RegistroCorrecto {
		if (nuevoUsuario!=null) {
			if (!usuarios.containsValue(nuevoUsuario)){
				this.usuarios.put(nuevoUsuario.getId(),nuevoUsuario);
				throw new RegistroCorrecto(nuevoUsuario);
			}else{
				throw new NickYaExistente(nuevoUsuario);
			}
		}
		return false;
	}

	/**
	 * 1->Profesor 2->Alumno 0->Email invalido
	 * @param email
	 */
	public int validarEmail(String email) {
		// TODO - implement Sistema.validarEmail
		// Patrón para validar el email
		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher mather = pattern.matcher(email);

		if (mather.find() == true) {
			String[] partes = email.split("@");
			String dominio = partes[1];
			if (partes[1].equals("urjc.es")){
				return 1;
			}else{
				return 2;
			}
		} else {
			return 0;
		}
	}

}