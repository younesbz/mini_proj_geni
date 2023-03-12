import java.util.Dictionary;
import java.util.Scanner;

public class FileParser {
    Scanner  scanner ;

    public FileParser(Scanner scanner){
        this.scanner = scanner ;
    }
    public Dictionaryy creaDictionary(){
        Dictionaryy dictionary = new Dictionaryy(scanner.nextLine());
        String table[] = new String[2];
        while (scanner.hasNextLine()) {
            table = scanner.nextLine().split(";");
            dictionary.addTranslation(table[0],table[1]);
        }
        return dictionary;
    }

}
