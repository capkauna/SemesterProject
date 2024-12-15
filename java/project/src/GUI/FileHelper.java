package GUI;

import java.io.*;
import java.util.ArrayList;

public class FileHelper
{

  // Generic method to save a list of objects to a file
  public static <T> void saveToFile(String fileName, ArrayList<T> data)
      throws IOException
  {
    try (ObjectOutputStream oos = new ObjectOutputStream(
        new FileOutputStream(fileName)))
    {
      oos.writeObject(data);
    }
  }

  // Generic method to load a list of objects from a file
  @SuppressWarnings("unchecked") public static <T> ArrayList<T> loadFromFile(
      String fileName) throws IOException, ClassNotFoundException
  {
    try (ObjectInputStream ois = new ObjectInputStream(
        new FileInputStream(fileName)))
    {
      return (ArrayList<T>) ois.readObject();
    }
  }
}


