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
        String rec;
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
                String str = String.format("%-1sID#", ID);
                String str1 = String.format("%-6sFirstname",fName);
                String str2 = String.format("%-8sLastname", lName);
                String str3 = String.format("%-8sTitle", title);
                String str4 = String.format("%-6sYOB", yob);
                System.out.println(str + str1 + str2 + str3 + str4);
                System.out.println("===========================================================");
                while(reader.ready()){
                    rec = reader.readLine();
                    String[] data = rec.split(",");
                    String IDnum = String.format("%-10s" , data[0]);
                    String fNameData = String.format("%-16s" , data[1]);
                    String lNameData = String.format("%-17s" , data[2]);
                    String titleData = String.format("%-10s" , data[3]);
                    String yobData = String.format("%-6s" , data[4]);
                    System.out.printf(IDnum + fNameData + lNameData + titleData + yobData + "\n");
                }
                reader.close();
                System.out.println("\nData File read!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}