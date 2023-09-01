package com.example.githubgame;

public class VocabTerm {
    private final String word;
    private final String definition;
    private String[] wordChoices;

    public VocabTerm(String word, String definition) {
        this.word = word;
        this.definition = definition;
        wordChoices = null;
    }

    public VocabTerm(String word, String definition, String choiceOne, String choiceTwo, String choiceThree){
        this.word = word;
        this.definition = definition;
        String[] in = new String[3];
        in[0] = choiceOne;
        in[1] = choiceTwo;
        in[2] = choiceThree;
        wordChoices = new String[4];
        inputPositions(in);
    }

    public String getWord() {
        return word;
    }

    public String getDefinition() {
        return definition;
    }

    public String[] getWordChoices() {
        return wordChoices;
    }

    public boolean contains(String in){
        if (word.equals(in))
            return true;
        if (wordChoices == null){
            return false;
        }
        for (int i = 0; i < GameLogic.NUM_CHOICES_EASY - 1; i++){
            if (wordChoices[i].equals(in))
                return true;
        }
        return false;
    }
    public void inputPositions(String[] choices) {
        int correctPlace = (int) (Math.random() * GameLogic.NUM_CHOICES_EASY);
        int place = 0;
        int i = 0;
        boolean skip = false;
        while (i < GameLogic.NUM_CHOICES_EASY - 1) {
            if (!skip && i == correctPlace) {
                wordChoices[place] = word;
                skip = true;
                place++;
            } else {
                wordChoices[place] = choices[i];
                place++;
                i++;
            }
        }
        if (correctPlace == GameLogic.NUM_CHOICES_EASY - 1)
            wordChoices[4] = word;
    }
}
