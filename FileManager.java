import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileManager {
    
    private String filename;
    private List<String> file;

    public FileManager(String filename){
        this.filename = filename;
        this.file = new ArrayList<String>();
    }

    /**
     *  Reads the file and saves it to the ArrayList instance variable "file".
     *
     */
    public void readFile() {
        this.file = new ArrayList<String>();

        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String next = null;
            while((next = br.readLine()) != null){
                file.add(next.toUpperCase());
            }

            br.close();
            fr.close();

        } catch (Exception e) {
            e.printStackTrace();

        }


        
    }

    /**
     * Sorts the words in the file for quicker read access later on.
     */
    public void sortFile(){
        Collections.sort(file);
    }

    /**
     *  Looks for the word inside of the text file.
     * @param word The word we are looking for.
     */
    public boolean legal(String word){
        //IF the String is found with
        int index = Arrays.binarySearch(file.toArray(), word);
        if(index >= 0)
            return true;
        return false;
    }

}
