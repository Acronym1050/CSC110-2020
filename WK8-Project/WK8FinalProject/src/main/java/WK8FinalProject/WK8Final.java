package WK8FinalProject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.TreeSet;
import java.util.Arrays;

public class WK8Final {

    public static void main(String... args) throws IOException{

        var fileName = "WK8FinalProject/src/main/java/WK8FinalProject/Sample500.csv";
            var filePath = Paths.get(fileName);

        var goodFile = "WK8FinalProject/src/main/java/WK8FinalProject/GoodData.txt";
            var goodPath = Paths.get(goodFile);

        var badFile = "WK8FinalProject/src/main/java/WK8FinalProject/BadData.txt";
            var badPath = Paths.get(badFile);

            if(!Files.exists(filePath)){
                System.out.println("The File " + filePath + " Could Not Be Found!");
            }

            if(!Files.exists(goodPath)){
                System.out.println("The File " + goodPath + " Could Not Be Found!");
            }

            if(!Files.exists(badPath)){
                System.out.println("The File " + badPath + " Could Not Be Found!");
            }
        
        var userInfos = new TreeSet<UserInfo>();

        var dataElementCount = 1;
        var readStream = Files.newBufferedReader(filePath);
        var data = readStream.readLine();

        var writeStreamGood = Files.newBufferedWriter(goodPath);
        var writeStreamBad = Files.newBufferedWriter(badPath);

        data = readStream.readLine();

        while(data != null){
            
            var elements = data.split(",", 8);

            var user = new UserInfo();
            
            user.serialNumber = elements[0];
            user.companyName = elements[1];
            user.name = elements[2];
            user.description = elements[3];
            user.leave = elements[4];
            user.phone = elements[5];
            user.address = elements[6];
            user.time = elements[7];

            if(Arrays.asList(elements).contains("") || Arrays.asList(elements).contains(null)){
                writeStreamBad.write("Line " + dataElementCount + ".");
                writeStreamBad.newLine();
            }
            else{
                userInfos.add(user);
            }

            dataElementCount += 1;

            data = readStream.readLine();

        }

        for(var userTree : userInfos){
            writeStreamGood.write(
                userTree.serialNumber + "|" +
                userTree.companyName + "|" +
                userTree.name.toUpperCase() + "|" +
                userTree.description + "|" +
                userTree.leave + "|" +
                userTree.phone + "|" +
                userTree.address.toUpperCase() + "|" +
                userTree.time + "|"
            );
            
            writeStreamGood.newLine();

        }
        readStream.close();
        writeStreamBad.close();
        writeStreamGood.close();

    }
}