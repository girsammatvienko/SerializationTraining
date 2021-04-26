package com.company;

import java.io.*;

public class LibraryDriver {
    public static void serialize(Library lib) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("serialized.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            System.out.println("Serialization...");
            objectOutputStream.writeObject(lib);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Successfully serialized!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Library deserialize() throws IOException {
        Library lib = null;
        try {
            FileInputStream f = new FileInputStream("serialized.bin");
            ObjectInputStream o = new ObjectInputStream(f);
            System.out.println("Deserealizing...");
            lib = (Library) o.readObject();
            f.close();
            o.close();
            System.out.println("Successfully deserialized!");
            return lib;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            return lib;
        }
    }
}
