import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dictionaryy {
    private HashMap<String, ArrayList<String> > tab_dicctionary ;
    private String name ;
    public Dictionaryy(String name){
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
        for(Map.Entry<String, ArrayList<String>> y : this.tab_dicctionary.entrySet()){
            for (String s:y.getValue()) {
                if(word.equals(word)){
                    return y.getKey();
                }
            }
        }
        return  "null" ;
    }
    public ArrayList<String> getMultipleTranslations(String word){
        if(this.tab_dicctionary.containsKey(word)){
           return this.tab_dicctionary.get(word);
        }
        ArrayList<String> resulta = new ArrayList<String>();
        for(Map.Entry<String, ArrayList<String>> y : this.tab_dicctionary.entrySet()){
            for (String s:y.getValue()) {
                if(word.equals(word)){
                    resulta.add(y.getKey());
                }
            }
        }
        return  resulta ;
    }
}
