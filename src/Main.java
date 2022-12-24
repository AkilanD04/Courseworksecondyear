import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();
        words.add("elephant");
        words.add("camel");
        words.add("all");
        words.add("bus");
        ArrayList<String> word = new ArrayList<>(List.copyOf(words));
        Collections.sort(words);
        System.out.println(word);
        for (int i = 0;i<words.size();i++){
            String name = words.get(i);
            for (int j = 0;j<words.size();j++){
                if (name.equals(word.get(j))){
                    pos.add(j);
                    break;
                }
            }
        }
        word.clear();
        for (int i: pos){
            System.out.println(i);
        }
    }
}