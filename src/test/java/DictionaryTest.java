import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {

     private Dictionary dictionary ;
    @BeforeEach
    public void setUp() throws Exception {
        dictionary = new Dictionary("english");
    }


    //1)String getName()
    @Test
    void getNameTest() {
        assertEquals(dictionary.getName(),"english");
    }

    //1)Testez que votre dictionnaire est bien vide
    @Test
    void dictionnaireIsEmtyTest() {
        assertTrue(dictionary.getTab_dicctionary().isEmpty());
    }


    @Test
    void addTranslation() {
        dictionary.addTranslation("bonjour","hallo");
        assertEquals(dictionary.getTranslation("bonjour"),"hallo");

    }

    @Test
    void getTranslation() {
        dictionary.addTranslation("bonjour","hallo");
        assertEquals(dictionary.getTranslation("bonjour"),"hallo");
    }

    @Test
    void getMultipleTranslations() {
        dictionary.addTranslation("bonjour","hi");
        dictionary.addTranslation("bonjour","olla");

        ArrayList<String> test = new ArrayList<>();
        test.add("hi");
        test.add("olla");
        assertEquals(dictionary.getMultipleTranslations("bonjour"),test);

    }
    @Test
    void bidirectionnellestest() {
        dictionary.addTranslation("bonjour","hi");
        dictionary.addTranslation("bonjour","olla");

        assertEquals(dictionary.getTranslation("olla"),"bonjour");
    }

    @Test
    void multibidirectionnellestest() {
        dictionary.addTranslation("bonjour","hi");
        dictionary.addTranslation("olla","hi");
        ArrayList<String> test = new ArrayList<>();
        test.add("olla");
        test.add("bonjour");
        assertEquals(dictionary.getMultipleTranslations("hi"),test);
    }
}