package catalin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTimeInFile {

    public static void writeTimeToMakeTransaction(File fileName , String result) {
        try (FileWriter fileWriter = new FileWriter(fileName.getAbsoluteFile())) {

            fileWriter.write(result);

                fileWriter.write("\n");
                fileWriter.flush();

            } catch (IOException e) {
            e.printStackTrace();
        }

    }

}