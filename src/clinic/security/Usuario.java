/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinic.security;

// Usuario mínimo para validar acceso de admin.
// Sí, user/pass en duro porque es demo para la evidencia.
public class Usuario {
    private final String username;
    private final String password;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean valida(String u, String p) {
        return username.equals(u) && password.equals(p);
    }
}
