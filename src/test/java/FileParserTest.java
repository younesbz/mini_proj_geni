import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FileParserTest {
    private Dictionaryy dictionary ;
    private FileParser fileParser ;
    @Mock
    Scanner monMOvk ;
    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        fileParser = new FileParser(monMOvk);

        dictionary = new Dictionaryy("english");
    }
    @Test
    void filetestavecMOk() {

        when(monMOvk.nextLine()).thenReturn("name_de_Dec").thenReturn("bonjour;hallo");
        when(monMOvk.hasNext()).thenReturn(true).thenReturn(true).thenReturn(false);

        Dictionaryy dictionaryy = fileParser.creaDictionary();
        assertEquals(dictionaryy.getTranslation("bonjour"),"hallo");
    }




    //just pour verify
    @Test
    void filetest() {
        Scanner sc = null ;
        try {
            sc = new Scanner(new File("AA.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileParser fileParser = new FileParser(sc);
        Dictionaryy dictionaryy = fileParser.creaDictionary();
        assertEquals(dictionaryy.getTranslation("bonjour"),"hallo");
    }
}