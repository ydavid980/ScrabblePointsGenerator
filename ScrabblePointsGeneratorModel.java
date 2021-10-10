package assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ScrabblePointsGeneratorModel {

    //////////static values and lists/////////
    static HashMap<String, Integer> letterValue = new HashMap<String, Integer>();
    static ArrayList<Character> letters = new ArrayList<>(); //Array List of word Bank
    static ArrayList<String> wordHistory = new ArrayList<>();
    static int score = 0;
    static String scoreString = "";
    static String promptMessage = "";


    /////////Methods///////////

    public static int vowelCounter(String input)
    {
        int counter = 0;
        for (int i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) == 'A' || input.charAt(i) == 'E' || input.charAt(i) == 'I'
                    || input.charAt(i) == 'O' || input.charAt(i) == 'U' || input.charAt(i) == 'Y')
            {
                counter++;
                System.out.println(counter);
            }
        }
        return counter;
    }



    public static String letterValueMap(String letter) {

        letterValue.put("A", 1);
        letterValue.put("B", 3);
        letterValue.put("C", 3);
        letterValue.put("D", 2);
        letterValue.put("E", 1);
        letterValue.put("F", 4);
        letterValue.put("G", 2);
        letterValue.put("H", 4);
        letterValue.put("I", 1);
        letterValue.put("J", 8);
        letterValue.put("K", 5);
        letterValue.put("L", 1);
        letterValue.put("M", 3);
        letterValue.put("N", 1);
        letterValue.put("O", 1);
        letterValue.put("P", 3);
        letterValue.put("Q", 10);
        letterValue.put("R", 1);
        letterValue.put("S", 1);
        letterValue.put("T", 1);
        letterValue.put("U", 1);
        letterValue.put("V", 1);
        letterValue.put("W", 4);
        letterValue.put("X", 8);
        letterValue.put("Y", 4);
        letterValue.put("Z", 10);

        return letterValue.get(letter).toString();
    }


    public static void letterBag() {

        for (int count = 0; count < 9; count++)
            letters.add('A');
        for (int count = 0; count < 2; count++)
            letters.add('B');
        for (int count = 0; count < 2; count++)
            letters.add('C');
        for (int count = 0; count < 4; count++)
            letters.add('D');
        for (int count = 0; count < 12; count++)
            letters.add('E');
        for (int count = 0; count < 2; count++)
            letters.add('F');
        for (int count = 0; count < 3; count++)
            letters.add('G');
        for (int count = 0; count < 2; count++)
            letters.add('H');
        for (int count = 0; count < 8; count++)
            letters.add('I');
        for (int count = 0; count < 1; count++)
            letters.add('J');
        for (int count = 0; count < 1; count++)
            letters.add('K');
        for (int count = 0; count < 4; count++)
            letters.add('L');
        for (int count = 0; count < 2; count++)
            letters.add('M');
        for (int count = 0; count < 6; count++)
            letters.add('N');
        for (int count = 0; count < 8; count++)
            letters.add('O');
        for (int count = 0; count < 2; count++)
            letters.add('P');
        for (int count = 0; count < 1; count++)
            letters.add('Q');
        for (int count = 0; count < 6; count++)
            letters.add('R');
        for (int count = 0; count < 4; count++)
            letters.add('S');
        for (int count = 0; count < 6; count++)
            letters.add('T');
        for (int count = 0; count < 4; count++)
            letters.add('U');
        for (int count = 0; count < 2; count++)
            letters.add('V');
        for (int count = 0; count < 2; count++)
            letters.add('W');
        for (int count = 0; count < 1; count++)
            letters.add('X');
        for (int count = 0; count < 2; count++)
            letters.add('Y');
        for (int count = 0; count < 1; count++)
            letters.add('Z');

    }

    public static String getLettersLeft(Character letter) {
        int c = Collections.frequency(letters, letter);
        String numLetterLeft = Integer.toString(c); //turn to string
        return  numLetterLeft;

    }

    public static void gameStart(String userIn) {


        //Input validation
        if (userIn.length() ==1) {
            promptMessage = "Word too short";
        }

        else if (userIn.length() >8) {
            promptMessage = "Word too long, Max 8 letters";
        }
        else if (userIn.isEmpty()) {
            promptMessage = "Please input a word";
        }

        else if(vowelCounter(userIn) <1)  {
          promptMessage = "Need at least one vowel";
            System.out.println(vowelCounter(userIn));
        }



        else {
            //Test: show user input
        System.out.println(userIn);


        char[] charArray = new char[userIn.length()];  //user input to char array
        ArrayList<Character> word = new ArrayList<>(); //arrayList that will get the letter from char array

        //converting word to array and than to arrayList
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = userIn.charAt(i);
            word.add(charArray[i]); //adding to array list of words
        }

        //Testing:
        System.out.println("Word turn to arrayList" + word);    //Word entered to arrayList
        System.out.println("Letters in Beg at start " +letters); //Letter bag

        //Values if entire loop was successful
        int success = 0;
        int fail = 0;
        //Checking if entered word has all the letters is stock
        if (letters.containsAll(word) && !wordHistory.contains(userIn)) {

            for (int i = 0; i < word.size(); i++) {
                if (Collections.frequency(letters, word.get(i)) >= Collections.frequency(word, word.get(i))) {
                    //letters, word.get(i))+2 ...had to add 2, because index shifts to negative value
                    //letters.remove(word.get(i));
                    //score = letterValue.get(word.get(i).toString()) +score ;
                    success++;

                }
                else{
                    fail++;
                }
                //Testing: Letter count
                System.out.println("letter "+word.get(i)+" count" +Collections.frequency(letters, word.get(i)));
            }

            //Testing: Checking if word removed from bag:
            System.out.println("Letters left: "+letters);

        }

        if (success == word.size()) { //if no errors in loop, repeat previous loop, and remove items from bag + add score
            for (int i = 0; i < word.size(); i++) {
                if (Collections.frequency(letters, word.get(i))  >= Collections.frequency(word, word.get(i)))
                {
                    //letters, word.get(i))+2 ...had to add 2, because index shifts to negative value
                    letters.remove(word.get(i));
                    score = letterValue.get(word.get(i).toString()) + score;
                    success++;

                }
            }

            System.out.println("word added");//Test: show confirmation
            promptMessage = "Word added!";
            wordHistory.add(userIn);

        }else if (wordHistory.contains(userIn)) {
            promptMessage = "Word was already used, please try again";
        }

        else if (fail > 0) {
            promptMessage = "Try again, not enough letters";

        }
        else if (letters.isEmpty()) {
            promptMessage = "No letter left";

        }else {
            promptMessage = "Not enough letter left to use";
        }

        //Testing:
        System.out.println("Banked letters " + wordHistory);
        System.out.println(letters);
        System.out.println("Failed loops : "+fail);
        System.out.println("Passed Loops : "+success);
        System.out.println("Size of the entered word: " + word.size());
        System.out.println("score: " + score);


        scoreString = Integer.toString(score); //turn score integer to string






    }
    }
}



