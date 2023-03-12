import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private HashMap<String, ArrayList<String> > tab_dicctionary ;
    private String name ;
    public Dictionary( String name){
        this.tab_dicctionary = new HashMap<String, ArrayList<String>>();
        this.name = name ;
    }

    public String getName() {
        return name;
    }
    public HashMap<String, ArrayList<String> > getTab_dicctionary() {
        return tab_dicctionary;
    }


    public void addTranslation(String fr,String en){
        if(this.tab_dicctionary.containsKey(fr)){
            this.tab_dicctionary.get(fr).add(en);
        }else {
            ArrayList<String> list_de_synonyme_fr = new ArrayList<String>();
            list_de_synonyme_fr.add(en);
            this.tab_dicctionary.put(fr,list_de_synonyme_fr);
        }
    }

    public String getTranslation(String word){
        if(this.tab_dicctionary.containsKey(word)){
            return this.tab_dicctionary.get(word).get(0);
        }
        return  "null" ;
    }
    public ArrayList<String> getMultipleTranslations(String word){
        if(this.tab_dicctionary.containsKey(word)){
           return this.tab_dicctionary.get(word);
        }
        return  null ;
    }
}
