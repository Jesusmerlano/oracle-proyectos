package com.example.crud;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        UserDAO dao = new UserDAO();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- CRUD Usuarios ---");
            System.out.println("1) Listar");
            System.out.println("2) Crear");
            System.out.println("3) Consultar por id");
            System.out.println("4) Actualizar");
            System.out.println("5) Eliminar");
            System.out.println("0) Salir");
            System.out.print("Elige: ");
            String opt = sc.nextLine();
            try {
                switch (opt) {
                    case "1":
                        List<User> list = dao.listUsers();
                        list.forEach(System.out::println);
                        break;
                    case "2":
                        System.out.print("Nombre: "); String nombre = sc.nextLine();
                        System.out.print("Correo: "); String correo = sc.nextLine();
                        User u = new User(null, nombre, correo);
                        dao.createUser(u);
                        System.out.println("Creado: " + u);
                        break;
                    case "3":
                        System.out.print("ID: "); int id = Integer.parseInt(sc.nextLine());
                        System.out.println(dao.getUserById(id));
                        break;
                    case "4":
                        System.out.print("ID a actualizar: "); int uid = Integer.parseInt(sc.nextLine());
                        User up = dao.getUserById(uid);
                        if (up == null) { System.out.println("No existe"); break; }
                        System.out.print("Nuevo nombre (enter para mantener): "); String nn = sc.nextLine();
                        if (!nn.isBlank()) up.setNombre(nn);
                        System.out.print("Nuevo correo (enter para mantener): "); String nc = sc.nextLine();
                        if (!nc.isBlank()) up.setCorreo(nc);
                        boolean ok = dao.updateUser(up);
                        System.out.println(ok ? "Actualizado" : "No actualizado");
                        break;
                    case "5":
                        System.out.print("ID a eliminar: "); int did = Integer.parseInt(sc.nextLine());
                        boolean del = dao.deleteUser(did);
                        System.out.println(del ? "Eliminado" : "No eliminado");
                        break;
                    case "0": System.exit(0);
                    default: System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
                e.printStackTrace(System.err);
            }
        }
    }
}
