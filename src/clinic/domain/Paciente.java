/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinic.domain;

// Paciente con sus datos básicos. Minimalista para esta entrega.
public class Paciente {
    private final int id;
    private final String nombre;
    private final String telefono;
    private final String email;

    public Paciente(int id, String nombre, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "Paciente{id=" + id + ", nombre='" + nombre + "', tel='" + telefono + "', email='" + email + "'}";
    }
}
