package royalstacks.app.model.fakeDataGenerator;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public abstract class Gen {

    public static char generateRandomChar(char maxChar){
        return (char)('A' + Math.random() * (maxChar - 'A' + 1));
    }
    public static boolean generateRandomTrueFalse(int percentageTrue) {
        int MAX = 100;
        return (Math.random() * MAX < percentageTrue);
    }
    public static int generateRandomInt(int min, int max){
        return (int)((Math.random()*(max-min+1))+min);
    }
    public static JSONArray createJsonArrayFromFile(String filePath) {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader;
        try {
            fileReader = new FileReader(filePath);
            JSONArray jsonArray = (org.json.simple.JSONArray) jsonParser.parse(fileReader);
            return jsonArray;
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public static BigDecimal amountGenerator(int min, int maxCommon, int maxUncommon, int percentageCommon){
        final int MIN = 0;
        final int MAX_UNCOMMON = 10000000;
        final int MAX_COMMON = 5000;
        final int PERCENTAGE_COMMON = 85;
        if(Gen.generateRandomTrueFalse(PERCENTAGE_COMMON)){
            double randomBalance =(Gen.generateRandomInt(MIN, MAX_COMMON*100))/100.0;
            return BigDecimal.valueOf(randomBalance);
        }
        else {
            double randomBalance = (Gen.generateRandomInt(MIN, MAX_UNCOMMON * 100)) / 100.0;
            return BigDecimal.valueOf(randomBalance);
        }
    }


}
