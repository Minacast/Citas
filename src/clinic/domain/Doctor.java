/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinic.domain;


// Clase simple para doctor: id + nombre + especialidad.
// Sin drama: solo datos y toString para imprimir bonito.
public class Doctor {
    private final int id;
    private final String nombre;
    private final String especialidad;

    public Doctor(int id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }

    @Override
    public String toString() {
        return "Doctor{id=" + id + ", nombre='" + nombre + "', esp='" + especialidad + "'}";
    }
}
