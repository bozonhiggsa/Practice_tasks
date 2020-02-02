package ua.examples.practice.practice6;

import java.util.ArrayList;
import java.util.List;

public class WordContainer<T> extends ArrayList<T> {

    private static final List<Word> LIST = new WordContainer<>();

    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            boolean mark = false;
            for(int k = 0; k < LIST.size(); k++){
                Word word = LIST.get(k);
                if(new Word(s).equals(word)){
                    word.setFrequency(word.getFrequency() + 1);
                    mark = true;
                }
            }
            if(!mark){
                LIST.add(new Word(s));
            }
        }

        LIST.stream()
                .sorted(Word::compareTo)
                .forEach((p) -> System.out.println(p.getContent() + " : " + p.getFrequency()));
    }

    @Override
    public boolean add(T t) {

        if(t == null) throw new IllegalArgumentException();
        return super.add(t);
    }
}
