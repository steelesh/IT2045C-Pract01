import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;
import javax.swing.JFileChooser;

public class PersonReader{

    public static void main(String[] args){
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        String ID = "";
        String fName = "";
        String lName = "";
        String title = "";
        String yob = "";
        try{
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));
                String str = String.format("%sID#", ID);
                String str1 = String.format("%-3sFirstname",fName);
                String str2 = String.format("%-4sLastname", lName);
                String str3 = String.format("%-5sTitle", title);
                String str4 = String.format("%-6sYOB", yob);
                System.out.println(str + str1 + str2 + str3 + str4);
                System.out.println("================================================");
                while(reader.ready()){
                    rec = reader.readLine();
                    System.out.println("     " + rec);
                }
                reader.close();
                System.out.println("\n\nData File read!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}