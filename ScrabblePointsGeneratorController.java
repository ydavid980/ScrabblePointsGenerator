package assignment3;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Locale;

public class ScrabblePointsGeneratorController {


    ///////Labels///////
    @FXML
    Label warning, scoreLabel, wordBank;

    @FXML //Letter point value
    Label pA, pB, pC, pD, pE, pF,pG, pH, pI, pJ, pK,pL, pM, pN, pO, pP, pQ, pR, pS, pT, pU, pV,pW,pX, pY, pZ;

    @FXML //Letter left in bag
    Label qtyA, qtyB, qtyC,qtyyD, qtyE, qtyF, qtyG,  qtyH,  qtyI,  qtyJ,  qtyK, qtyL,  qtyM,  qtyN, qtyO, qtyP,  qtyQ,  qtyR, qtyS, qtyT,  qtyU,  qtyV, qtyW, qtyX,  qtyY, qtyZ;

    @FXML
    Label points;


    ///////TextFields///////

    @FXML
    TextField textBox;


    ///////Buttons///////


    @FXML //Use button output based on button name and store in string
    public void btnLetter(ActionEvent event) {
        String wordIn = ((Button) event.getSource()).getText();
        textBox.setText(textBox.getText() + wordIn);
    }

    @FXML
    public void onSubmit(ActionEvent submitEvent) {

        String submitWord = textBox.getText().toString().toUpperCase(Locale.ROOT);

            ScrabblePointsGeneratorModel.gameStart(submitWord); //start game
            warning.setText(ScrabblePointsGeneratorModel.promptMessage);
            scoreLabel.setText(ScrabblePointsGeneratorModel.scoreString);
            textBox.setText("");

            //Stripping arrayList.toString off brackets when shown in wordBank label:
            wordBank.setText(ScrabblePointsGeneratorModel.wordHistory.toString().replaceAll("\\[", "").replaceAll("\\]", ", "));

            //Letter Quantity in a bag (continuously updated)
            qtyA.setText(ScrabblePointsGeneratorModel.getLettersLeft('A'));
            qtyB.setText(ScrabblePointsGeneratorModel.getLettersLeft('B'));
            qtyC.setText(ScrabblePointsGeneratorModel.getLettersLeft('C'));
            qtyyD.setText(ScrabblePointsGeneratorModel.getLettersLeft('D'));
            qtyE.setText(ScrabblePointsGeneratorModel.getLettersLeft('E'));
            qtyF.setText(ScrabblePointsGeneratorModel.getLettersLeft('F'));
            qtyG.setText(ScrabblePointsGeneratorModel.getLettersLeft('G'));
            qtyH.setText(ScrabblePointsGeneratorModel.getLettersLeft('H'));
            qtyI.setText(ScrabblePointsGeneratorModel.getLettersLeft('I'));
            qtyJ.setText(ScrabblePointsGeneratorModel.getLettersLeft('J'));
            qtyK.setText(ScrabblePointsGeneratorModel.getLettersLeft('K'));
            qtyL.setText(ScrabblePointsGeneratorModel.getLettersLeft('L'));
            qtyM.setText(ScrabblePointsGeneratorModel.getLettersLeft('M'));
            qtyN.setText(ScrabblePointsGeneratorModel.getLettersLeft('N'));
            qtyO.setText(ScrabblePointsGeneratorModel.getLettersLeft('O'));
            qtyP.setText(ScrabblePointsGeneratorModel.getLettersLeft('P'));
            qtyQ.setText(ScrabblePointsGeneratorModel.getLettersLeft('Q'));
            qtyR.setText(ScrabblePointsGeneratorModel.getLettersLeft('R'));
            qtyS.setText(ScrabblePointsGeneratorModel.getLettersLeft('S'));
            qtyT.setText(ScrabblePointsGeneratorModel.getLettersLeft('T'));
            qtyU.setText(ScrabblePointsGeneratorModel.getLettersLeft('U'));
            qtyV.setText(ScrabblePointsGeneratorModel.getLettersLeft('V'));
            qtyW.setText(ScrabblePointsGeneratorModel.getLettersLeft('W'));
            qtyX.setText(ScrabblePointsGeneratorModel.getLettersLeft('X'));
            qtyY.setText(ScrabblePointsGeneratorModel.getLettersLeft('Y'));
            qtyZ.setText(ScrabblePointsGeneratorModel.getLettersLeft('Z'));


    }


    @FXML
    private void initialize() {
        System.out.println("loaded");

        //Resetting Values

        textBox.setText("");
        scoreLabel.setText("");
        wordBank.setText("");
        warning.setText("");


        //Points for each latter
        pA.setText(ScrabblePointsGeneratorModel.letterValueMap("A"));
        pB.setText(ScrabblePointsGeneratorModel.letterValueMap("B"));
        pC.setText(ScrabblePointsGeneratorModel.letterValueMap("C"));
        pD.setText(ScrabblePointsGeneratorModel.letterValueMap("D"));
        pE.setText(ScrabblePointsGeneratorModel.letterValueMap("E"));
        pF.setText(ScrabblePointsGeneratorModel.letterValueMap("F"));
        pG.setText(ScrabblePointsGeneratorModel.letterValueMap("G"));
        pH.setText(ScrabblePointsGeneratorModel.letterValueMap("H"));
        pI.setText(ScrabblePointsGeneratorModel.letterValueMap("I"));
        pJ.setText(ScrabblePointsGeneratorModel.letterValueMap("J"));
        pK.setText(ScrabblePointsGeneratorModel.letterValueMap("K"));
        pL.setText(ScrabblePointsGeneratorModel.letterValueMap("L"));
        pM.setText(ScrabblePointsGeneratorModel.letterValueMap("M"));
        pN.setText(ScrabblePointsGeneratorModel.letterValueMap("N"));
        pO.setText(ScrabblePointsGeneratorModel.letterValueMap("O"));
        pP.setText(ScrabblePointsGeneratorModel.letterValueMap("P"));
        pQ.setText(ScrabblePointsGeneratorModel.letterValueMap("Q"));
        pR.setText(ScrabblePointsGeneratorModel.letterValueMap("R"));
        pS.setText(ScrabblePointsGeneratorModel.letterValueMap("S"));
        pT.setText(ScrabblePointsGeneratorModel.letterValueMap("T"));
        pU.setText(ScrabblePointsGeneratorModel.letterValueMap("U"));
        pV.setText(ScrabblePointsGeneratorModel.letterValueMap("V"));
        pW.setText(ScrabblePointsGeneratorModel.letterValueMap("W"));
        pX.setText(ScrabblePointsGeneratorModel.letterValueMap("X"));
        pY.setText(ScrabblePointsGeneratorModel.letterValueMap("Y"));
        pZ.setText(ScrabblePointsGeneratorModel.letterValueMap("Z"));

        ScrabblePointsGeneratorModel.letterBag();//Letter Bag at start


            }
}
