package Helpers;

import java.io.*;
import java.util.ArrayList;

public class FileHelper
{
  // Generic method to save a list of objects to a file
  public static <T> void saveToFile(String fileName, ArrayList<T> data)
      throws IOException {
    File file = new File(fileName);
    if (!file.exists()) {
      file.createNewFile(); // Create the file if it doesn't exist
    }

    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
      oos.writeObject(data);
    }
  }

  // Generic method to load a list of objects from a file
  @SuppressWarnings("unchecked")
  public static <T> ArrayList<T> loadFromFile(String fileName)
      throws IOException, ClassNotFoundException {
    File file = new File(fileName);

    // Check if the file exists
    if (!file.exists()) {
      // If the file does not exist, return an empty list
      return new ArrayList<>();
    }

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
      return (ArrayList<T>) ois.readObject();
    }
  }
}


