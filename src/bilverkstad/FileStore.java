package bilverkstad;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Read and write Lists to a files.
 *
 * @author Tomas Perers
 * @version 2017-01-09
 */
public class FileStore
{

    private String filePath;
    private List vehicles;
    private ObjectInputStream listInputStream = null;
    private FileInputStream fileIntput = null;
    private File file;
    private FileOutputStream fileOut;
    private ObjectOutputStream listOutStream;

    /**
     * Constructor for the object.
     *
     * @param filePath filename where the objects will be stored
     * @throws FileNotFoundException
     * @throws IOException
     */
    public FileStore(String filePath) throws FileNotFoundException, IOException
    {
        this.filePath = filePath;
        file = new File(filePath);
        if (!file.exists())
        {
            file.createNewFile();
        }
        vehicles = new ArrayList<>();

    }

    /**
     * Read list objects from a file.
     *
     * @return a List with vehicles
     */
    public List readVehiclesFromFile()
    {
        try
        {
            fileIntput = new FileInputStream(file);
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(FileStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        try
        {
            listInputStream = new ObjectInputStream(fileIntput);
        }
        catch (EOFException ex)
        {
            return vehicles;
        }
        catch (IOException ex)
        {
            System.out.println("IO Exception " + ex);
        }
        try
        {
            vehicles = (List<Vehicle>) listInputStream.readObject();
        }
        catch (IOException | ClassNotFoundException ex)
        {
            return vehicles;
        }
        return vehicles;
    }

    /**
     * Writes lists to a file.
     *
     * @param List vehicles that will be written to file.
     */
    public void writeVehicleToFile(List vehicles)
    {
        try
        {
            fileOut = new FileOutputStream(filePath, false);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found " + filePath);
        }
        try
        {
            listOutStream = new ObjectOutputStream(fileOut);
        }
        catch (IOException ex)
        {
            Logger.getLogger(FileStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        try
        {
            listOutStream.writeObject(vehicles);
        }
        catch (IOException ex)
        {
            Logger.getLogger(FileStore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
