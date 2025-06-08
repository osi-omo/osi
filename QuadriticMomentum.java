/*Osilama Omo-Ikirodah
 * 12/1/24
Pseudocode
1 - ask the user if he wants to find quadratic or mass/ volume of momentum
QUADRATIC
2 - if user chose quadratic, show him quadrtic standard form
3 - ask user to input numbers for a b and c
4 - print formula for solving
6 - find b squared
7 - find 4 ac 
8 - minus 4 ac from b squared
9 - squareroot that
10 - if number is negative keep dividing until you can find a number within that that can be square rooted
11 - if no sqrt divisor of num make it 1 root 11
11 - eg. if number is sqrt of -12 then it will come out as 2 root 3 
12 - if this happens then we check if b has a common divisor of 2 a 
13 - check if the number outside sqrt has a common divisor of 2a and b
14 - if both true then num outside sqrt and b get simplified
16 - else leave as it is 
15 - print out answer as a fraction 
16 - print in this format eg.  12 + or -  2✓3                                     
                              ------------=-     becomes this when simplified     6 + or -1✓3 
                                  2        
17 - add i when printing satement to make  12 + or -  2i✓3                                     
                                          ------------=-     becomes this when simplified     6 + or -i✓3 
                                              2        
18 - go back to step num 10
19 - sqrt number
20 - then you see if it can be divided it has common factor with 2 a and b
21 - print out the num 

CONSERVATION OF MOMENTUM(elastic)
2  - show user the formula
3 - ask user what value theyre trying to find
4 - ask user for all the values except missing
5 - minus the other values from the side the value you dont know
6 - divide everything by the mass/velocity that corresponds to the value you didnt know
7 - print out value

BACK TO MAIN
2 - asks if user wants to redo it
3 - if no ask if the really want to exit
4 - if no then code asks again if yes code ends
5 - if no then the code runs again
 */
package quadriticmomentum;

import static java.lang.Math.sqrt;
import java.security.spec.MGF1ParameterSpec;
import java.util.Scanner;

/**
 *
 * @author osiom
 */
public class QuadriticMomentum
{

  public static void main(String[] args)
  {
    //all variables
    String reallyExit;
    String missing;
    String testMissing;
    int loopEnd = 1;
    double bFinalIrrational;
    double iValue;
    double inSqrtAfterI;
    //variable checking for what can be divided in the sqrt to find I 
    double inSqrtDivisorForI;
    double possibleI;
    double possibleIchecker;
    double simplifier;
    double m1iValue;
    double v1iValue;
    double m2iValue;
    double v2iValue;
    double m1fValue;
    double v1fValue;
    double m2fValue;
    double v2fValue;
    double missingValue;
    double aValue;
    double bValue;
    double cValue;
    double firstSolutionForQuadratic;
    double secondSolutionForQuadratic;
    double OutSqrtForQuadratic;
    double bSquare;
    double FourAC;
    double inSqrtBeforeI;
    boolean isnosolution = false;
    boolean is1solution = false;
    boolean is2solution = false;
    boolean isMissingValid;
    int index = 0;
    Scanner firstAskForWhatToCalculate = new Scanner(System.in);
    Scanner getValuesForQuadratics = new Scanner(System.in);
    Scanner askForImaginary = new Scanner(System.in);
    Scanner repeatedAskForWhatToCalculate = new Scanner(System.in);
    Scanner askToReallyExit = new Scanner(System.in);
    Scanner getDetailsForMomentum = new Scanner(System.in);
    Scanner getValuesForMomentum = new Scanner(System.in);
    String[] choices = new String[100];
    String[] valuesEntered = new String[100];
    String[] answers = new String[100];

    System.out.println("do you want to use quadratic formula to solve quadratics (type quadratics)");
    System.out.println("or");
    System.out.println("solve for a value using conservation of momentum (type momentum)");
    System.out.println("write anything else to end code");
    System.out.println(":  ");
    String quadraticOrMomentum = firstAskForWhatToCalculate.nextLine();
    //main loop
    while (loopEnd == 1)
    {
      //if choice momentum
      if (quadraticOrMomentum.equalsIgnoreCase("momentum"))
      {
        //adds this choice to choices to be displayed
        choices[index] = "momentum";

        //shows user formula
        System.out.println("this is the formula for conservation of momentum:  (m1i*v1i) + (m2i*v2i) = (m1f*v1f) + (m2f*v2f).");

        //asks if user want mass or volume
        System.out.print("which value do you want to find:  ");
        missing = getDetailsForMomentum.nextLine();

        
        //checks if they entered valid missing value
        if (missing.equalsIgnoreCase("m1i") || missing.equalsIgnoreCase("v1i") || missing.equalsIgnoreCase("m2i") || missing.equalsIgnoreCase("v2i") || missing.equalsIgnoreCase("m1v") || missing.equalsIgnoreCase("v1f") || missing.equalsIgnoreCase("m2f") || missing.equalsIgnoreCase("v2f"))
        {
          isMissingValid = true;
        }

        else
        {
          isMissingValid = false;
        }
        testMissing = "";
        //if value not valid
        if (isMissingValid == false)
        {
          for (int x = 0; x < 100; x++)
          {
            if (isMissingValid == false)
            {
              System.out.print("which value do you want to find, eg.v2i or m1f:  ");
              testMissing = getDetailsForMomentum.nextLine();
            }
            if (testMissing.equalsIgnoreCase("m1i") || testMissing.equalsIgnoreCase("v1i") || testMissing.equalsIgnoreCase("m2i") || testMissing.equalsIgnoreCase("v2i") || testMissing.equalsIgnoreCase("m1v") || testMissing.equalsIgnoreCase("v1f") || testMissing.equalsIgnoreCase("m2f") || testMissing.equalsIgnoreCase("v2f"))
            {//if value is valid
              isMissingValid = true;

            }
          }//there value is accepted
          missing = testMissing;
        }

        if (isMissingValid == true)
        {
          //if m1i
          if (missing.equalsIgnoreCase("m1i"))
          {
            isMissingValid = true;

            //inputing values
            System.out.print("v1i value(m/s): ");
            v1iValue = getValuesForMomentum.nextDouble();
            System.out.print("m2i value(kg): ");
            m2iValue = getValuesForMomentum.nextDouble();
            System.out.print("v2i value(m/s): ");
            v2iValue = getValuesForMomentum.nextDouble();
            System.out.print("m1f value(kg): ");
            m1fValue = getValuesForMomentum.nextDouble();
            System.out.print("v1f value(m/s): ");
            v1fValue = getValuesForMomentum.nextDouble();
            System.out.print("m2f value(kg: )");
            m2fValue = getValuesForMomentum.nextDouble();
            System.out.print("v2f value(m/s): ");
            v2fValue = getValuesForMomentum.nextDouble();

            //math
            missingValue = ((m1fValue * v1fValue) + (m2fValue * v2fValue) - (m2iValue * v2iValue)) / v1iValue;

            //print out final amt
            System.out.println("this is your desired value: " + missingValue);
            //stores values and answers for array
            valuesEntered[index] = "v1i = " + v1iValue + "    m2i = " + m2iValue + "    v2i = " + v2iValue + "    m1f = " + m1fValue + "    v1f = " + v1fValue + "    m2f = " + m2fValue + "    v2f = " + v2fValue;
            answers[index] = "" + missingValue;
            index++;
          }

          //m2i
          else if (missing.equalsIgnoreCase("m2i"))
          {
            isMissingValid = true;
            //inputing values
            System.out.print("m1i value(kg): ");
            m1iValue = getValuesForMomentum.nextDouble();
            System.out.print("v1i value(m/s): ");
            v1iValue = getValuesForMomentum.nextDouble();
            System.out.print("v2i value(m/s): ");
            v2iValue = getValuesForMomentum.nextDouble();
            System.out.print("m1f value(kg): ");
            m1fValue = getValuesForMomentum.nextDouble();
            System.out.print("v1f value(m/s): ");
            v1fValue = getValuesForMomentum.nextDouble();
            System.out.print("m2f value(kg: )");
            m2fValue = getValuesForMomentum.nextDouble();
            System.out.print("v2f value(m/s): ");
            v2fValue = getValuesForMomentum.nextDouble();

            //math
            missingValue = ((m1fValue * v1fValue) + (m2fValue * v2fValue) - (m1iValue * v1iValue)) / v2iValue;

            //print out final amt
            System.out.println("this is your desired value: " + missingValue);
            //stores values and answers for array
            valuesEntered[index] = "m1i = " + m1iValue + "    v1i = " + v1iValue + "    v2i = " + v2iValue + "    m1f = " + m1fValue + "    v1f = " + v1fValue + "    m2f = " + m2fValue + "    v2f = " + v2fValue;
            answers[index] = "" + missingValue;
            index++;
          }

          //final
          //m1f
          else if (missing.equalsIgnoreCase("m1f"))
          {
            isMissingValid = true;
            //inputing values
            System.out.print("m1i value(kg): ");
            m1iValue = getValuesForMomentum.nextDouble();
            System.out.print("v1i value(m/s): ");
            v1iValue = getValuesForMomentum.nextDouble();
            System.out.print("m2i value(kg: )");
            m2iValue = getValuesForMomentum.nextDouble();
            System.out.print("v2i value(m/s): ");
            v2iValue = getValuesForMomentum.nextDouble();
            System.out.print("v1f value(m/s): ");
            v1fValue = getValuesForMomentum.nextDouble();
            System.out.print("m2f value(kg): ");
            m2fValue = getValuesForMomentum.nextDouble();
            System.out.print("v2f value(m/s): ");
            v2fValue = getValuesForMomentum.nextDouble();

            //math
            missingValue = ((m1iValue * v1iValue) + (m2iValue * v2iValue) - (m2fValue * v2fValue)) / v1fValue;

            //print out final amt
            System.out.println("this is your desired value: " + missingValue);
            //stores values and answers for array
            valuesEntered[index] = "m1i = " + m1iValue + "    m2i = " + m2iValue + "    v1i = " + v1iValue + "    v2i = " + v2iValue + "    v1f = " + v1fValue + "    m2f = " + m2fValue + "    v2f = " + v2fValue;
            answers[index] = "" + missingValue;
            index++;
          }

          //m2f
          else if (missing.equalsIgnoreCase("m2f"))
          {
            isMissingValid = true;
            //inputing values
            System.out.print("m1i value(kg): ");
            m1iValue = getValuesForMomentum.nextDouble();
            System.out.print("v1i value(m/s): ");
            v1iValue = getValuesForMomentum.nextDouble();
            System.out.print("m2i value(kg: )");
            m2iValue = getValuesForMomentum.nextDouble();
            System.out.print("v2i value(m/s): ");
            v2iValue = getValuesForMomentum.nextDouble();
            System.out.print("m1f value(kg): ");
            m1fValue = getValuesForMomentum.nextDouble();
            System.out.print("v1f value(m/s): ");
            v1fValue = getValuesForMomentum.nextDouble();
            System.out.print("v2f value(m/s): ");
            v2fValue = getValuesForMomentum.nextDouble();

            //math
            missingValue = ((m1iValue * v1iValue) + (m2iValue * v2iValue) - (m1fValue * v1fValue)) / v2fValue;

            //print out final amt
            System.out.println("this is your desired value: " + missingValue);
            //stores values and answers for array
            valuesEntered[index] = "m1i = " + m1iValue + "    m2i = " + m2iValue + "    v1i = " + v1iValue + "    v2i = " + v2iValue + "    m1f = " + m1fValue + "    v1f = " + v1fValue + "    v2f = " + v2fValue;
            answers[index] = "" + missingValue;
            index++;
          }

          //v1i
          else if (missing.equalsIgnoreCase("v1i"))
          {
            isMissingValid = true;
            //inputing values
            System.out.print("m1i value(m/s): ");
            m1iValue = getValuesForMomentum.nextDouble();
            System.out.print("m2i value(kg): ");
            m2iValue = getValuesForMomentum.nextDouble();
            System.out.print("v2i value(m/s): ");
            v2iValue = getValuesForMomentum.nextDouble();
            System.out.print("m1f value(kg): ");
            m1fValue = getValuesForMomentum.nextDouble();
            System.out.print("v1f value(m/s): ");
            v1fValue = getValuesForMomentum.nextDouble();
            System.out.print("m2f value(kg: )");
            m2fValue = getValuesForMomentum.nextDouble();
            System.out.print("v2f value(m/s): ");
            v2fValue = getValuesForMomentum.nextDouble();

            //math
            missingValue = ((m1fValue * v1fValue) + (m2fValue * v2fValue) - (m2iValue * v2iValue)) / m1iValue;

            //print out final amt
            System.out.println("this is your desired value: " + missingValue);
            
          //stores values and answers for array
            valuesEntered[index] = "m1i = " + m1iValue + "    m2i = " + m2iValue + "    v2i = " + v2iValue + "    m1f = " + m1fValue + "    v1f = " + v1fValue + "    m2f = " + m2fValue + "    v2f = " + v2fValue;
            answers[index] = "" + missingValue;
            index++;
          }

          //v2i
          else if (missing.equalsIgnoreCase("v2i"))
          {
            isMissingValid = true;
            //inputing values
            System.out.print("m1i value(kg): ");
            m1iValue = getValuesForMomentum.nextDouble();
            System.out.print("v1i value(m/s): ");
            v1iValue = getValuesForMomentum.nextDouble();
            System.out.print("m2i value(m/s): ");
            m2iValue = getValuesForMomentum.nextDouble();
            System.out.print("m1f value(kg): ");
            m1fValue = getValuesForMomentum.nextDouble();
            System.out.print("v1f value(m/s): ");
            v1fValue = getValuesForMomentum.nextDouble();
            System.out.print("m2f value(kg: )");
            m2fValue = getValuesForMomentum.nextDouble();
            System.out.print("v2f value(m/s): ");
            v2fValue = getValuesForMomentum.nextDouble();

            //math
            missingValue = ((m1fValue * v1fValue) + (m2fValue * v2fValue) - (m1iValue * v1iValue)) / m2iValue;

            //print out final amt
            System.out.println("this is your desired value: " + missingValue);
            //stores values and answers for array
            valuesEntered[index] = "m1i = " + m1iValue + "    m2i = " + m2iValue + "    v1i = " + v1iValue + "    m1f = " + m1fValue + "    v1f = " + v1fValue + "    m2f = " + m2fValue + "    v2f = " + v2fValue;
            answers[index] = "" + missingValue;
            index++;
          }

          //final
          //v1f
          else if (missing.equalsIgnoreCase("v1f"))
          {
            isMissingValid = true;
            //inputing values
            System.out.print("m1i value(kg): ");
            m1iValue = getValuesForMomentum.nextDouble();
            System.out.print("v1i value(m/s): ");
            v1iValue = getValuesForMomentum.nextDouble();
            System.out.print("m2i value(kg: )");
            m2iValue = getValuesForMomentum.nextDouble();
            System.out.print("v2i value(m/s): ");
            v2iValue = getValuesForMomentum.nextDouble();
            System.out.print("m1f value(m/s): ");
            m1fValue = getValuesForMomentum.nextDouble();
            System.out.print("m2f value(kg): ");
            m2fValue = getValuesForMomentum.nextDouble();
            System.out.print("v2f value(m/s): ");
            v2fValue = getValuesForMomentum.nextDouble();

            //math
            missingValue = ((m1iValue * v1iValue) + (m2iValue * v2iValue) - (m2fValue * v2fValue)) / m1fValue;

            //print out final amt
            System.out.println("this is your desired value: " + missingValue);
            //stores values and answers for array
            valuesEntered[index] = "m1i = " + m1iValue + "    m2i = " + m2iValue + "    v1i = " + v1iValue + "    v2i = " + v2iValue + "    m1f = " + m1fValue + "    m2f = " + m2fValue + "    v2f = " + v2fValue;
            answers[index] = "" + missingValue;
            index++;
          }

          //v2f
          else if (missing.equalsIgnoreCase("v2f"))
          {
            isMissingValid = true;
            //inputing values
            System.out.print("m1i value(kg): ");
            m1iValue = getValuesForMomentum.nextDouble();
            System.out.print("v1i value(m/s): ");
            v1iValue = getValuesForMomentum.nextDouble();
            System.out.print("m2i value(kg: )");
            m2iValue = getValuesForMomentum.nextDouble();
            System.out.print("v2i value(m/s): ");
            v2iValue = getValuesForMomentum.nextDouble();
            System.out.print("m1f value(kg): ");
            m1fValue = getValuesForMomentum.nextDouble();
            System.out.print("v1f value(m/s): ");
            v1fValue = getValuesForMomentum.nextDouble();
            System.out.print("m2f value(m/s): ");
            m2fValue = getValuesForMomentum.nextDouble();

            //math
            missingValue = ((m1iValue * v1iValue) + (m2iValue * v2iValue) - (m1fValue * v1fValue)) / m2fValue;

            //print out final amt
            System.out.println("this is your desired value: " + missingValue);
            //stores values and answers for array
            valuesEntered[index] = "m1i = " + m1iValue + "    m2i = " + m2iValue + "    v1i = " + v1iValue + "    v2i = " + v2iValue + "    v1f = " + v1fValue + "    m1f = " + m1fValue + "    m2f = " + m2fValue;
            answers[index] = "" + missingValue;
            index++;
          }
        }
        //asks again when finished solving
        System.out.println("do you want to use quadratic formula to solve quadratics (type quadratics)");
        System.out.println("or");
        System.out.println("solve for a value using conservation of momentum (type momentum)");
        System.out.println("write anything else to end code");
        System.out.println(":  ");
        quadraticOrMomentum = repeatedAskForWhatToCalculate.nextLine();
      }

      else if (quadraticOrMomentum.equalsIgnoreCase("quadratics"))
      {
        choices[index] = "quadratic";
        //shows user formula
        System.out.println("this is the standard form of an equation: ax^2 + bx + c = 0");
        System.out.println("this is the formula for solving quadratics: x = (b ± √(b2 - 4ac))/2a");

        //asks user for values
        System.out.print("a value:  ");
        aValue = getValuesForQuadratics.nextInt();
        System.out.print("b value:  ");
        bValue = getValuesForQuadratics.nextInt();
        System.out.print("c value:  ");
        cValue = getValuesForQuadratics.nextInt();
        
        //stores values for array
        valuesEntered[index] = "a = " + aValue + "    b = " + bValue + "   c = " + cValue;

        // makes major values
        bSquare = bValue * bValue;
        FourAC = 4 * aValue * cValue;
        inSqrtBeforeI = bSquare - FourAC;

        //checks if it has no, one or 2 solutions
        if (inSqrtBeforeI < 0)
        {
          isnosolution = true;
        }
        if (inSqrtBeforeI == 0)
        {
          is1solution = true;
        }
        if (inSqrtBeforeI > 0)
        {
          is2solution = true;
        }
        //if 2 solutions
        if (is2solution)
        {
          //varibales in sqrt when all operations done
          OutSqrtForQuadratic = sqrt(inSqrtBeforeI);
          //formula
          firstSolutionForQuadratic = ((-1 * bValue) + OutSqrtForQuadratic) / (2 * aValue);
          secondSolutionForQuadratic = ((-1 * bValue) - OutSqrtForQuadratic) / (2 * aValue);
          //stores answers for array
          System.out.println("These are your solutions: " + firstSolutionForQuadratic + ", " + secondSolutionForQuadratic);
          answers[index] = "" + firstSolutionForQuadratic + "    and   " + secondSolutionForQuadratic;
          index++;
        }

        //if 1 solution
        else if (is1solution)
        {
          //formula
          firstSolutionForQuadratic = (-1 * bValue) / (2 * aValue);
          System.out.println("This is your only solution: " + firstSolutionForQuadratic);
          answers[index] = "" + firstSolutionForQuadratic;
          index++;
        }

        //if no solution
        if (isnosolution)
        {
          //finding imaginary
          inSqrtBeforeI = inSqrtBeforeI * -1;
          iValue = inSqrtBeforeI;
          for (int ir = 1; ir <= inSqrtBeforeI; ir++)
          {

            if ((inSqrtBeforeI % ir) == 0)
            {
              inSqrtDivisorForI = ir;
              possibleI = sqrt(inSqrtDivisorForI);
              possibleIchecker = Math.ceil(possibleI);
              if (possibleI % possibleIchecker == 0)
              {
                iValue = sqrt(ir);
              }

            }

          }
          //values after imaginary found
          inSqrtAfterI = inSqrtBeforeI / (iValue * iValue);
          bFinalIrrational = bValue * -1;
          simplifier = 1;
          
          //simplifies
          for (int div = 1; div <= (2 * aValue); div++)
          {
            if (iValue % div == 0)
            {
              if (bFinalIrrational % div == 0)
              {
                if ((2 * aValue) % div == 0)
                {
                  simplifier = div;
                }
              }
            }
          }
          //finalizes values
          iValue = iValue / simplifier;
          bFinalIrrational = bFinalIrrational / simplifier;
          aValue = aValue / simplifier;
          
          //prints out what happens for different scenerios
          if ((2 * aValue) == 1)
          {
            if (iValue == 1)
            {
              if (inSqrtAfterI == 1)
              {
                System.out.println("");
                System.out.println("This is your first value with imaginary numbers: ");
                System.out.println(bFinalIrrational + " + i");
                System.out.println("");
                System.out.println("This is your second value with imaginary numbers: ");
                System.out.println(bFinalIrrational + " - i");
                answers[index] = bFinalIrrational + " - i    and   " + bFinalIrrational + " + i";
              }
              else
              {
                System.out.println("");
                System.out.println("This is your first value with imaginary numbers: ");
                System.out.println(bFinalIrrational + " + i✓" + inSqrtAfterI);
                System.out.println("");
                System.out.println("This is your second value with imaginary numbers: ");
                System.out.println(bFinalIrrational + " - i✓" + inSqrtAfterI);
                answers[index] = bFinalIrrational + " - i✓" + inSqrtAfterI + " and    " + bFinalIrrational + " + i✓" + inSqrtAfterI;
              }

            }
            else
            {//more scenerios
              if (inSqrtAfterI == 1)
              {
                System.out.println("");
                System.out.println("This is your first value with imaginary numbers: ");
                System.out.println(bFinalIrrational + " + " + iValue + "i");
                System.out.println("");
                System.out.println("This is your second value with imaginary numbers: ");
                System.out.println(bFinalIrrational + " - " + iValue + "i");
                answers[index] = bFinalIrrational + " - " + iValue + "i     and   " + bFinalIrrational + " - " + iValue + "i";
              }
              else
              {
                System.out.println("");
                System.out.println("This is your first value with imaginary numbers: ");
                System.out.println(bFinalIrrational + " + " + iValue + "i✓" + inSqrtAfterI);
                System.out.println("");
                System.out.println("This is your second value with imaginary numbers: ");
                System.out.println(bFinalIrrational + " - " + iValue + "i✓" + inSqrtAfterI);
                answers[index] = bFinalIrrational + " - " + iValue + "i✓" + inSqrtAfterI + "   and   " + bFinalIrrational + " + " + iValue + "i✓" + inSqrtAfterI;
              }

            }
          }
          else
          {
            if (iValue == 1)
            {
              if (inSqrtAfterI == 1)
              {//more scenerios
                System.out.println("");
                System.out.println("This is your first value with imaginary numbers: ");
                System.out.println(bFinalIrrational + " + i");
                System.out.println("-----------");
                System.out.println("  " + (2 * aValue));
                System.out.println("");
                System.out.println("This is your second value with imaginary numbers: ");
                System.out.println(bFinalIrrational + " - i");
                System.out.println("-----------");
                System.out.println("  " + (2 * aValue));
                answers[index] = "(" + bFinalIrrational + " - i)/ " + (2 * aValue) + "(" + bFinalIrrational + " + i)/ " + (2 * aValue);
              }
              else
              {
                System.out.println("");
                System.out.println("This is your first value with imaginary numbers: ");
                System.out.println(bFinalIrrational + " + i✓" + inSqrtAfterI);
                System.out.println("-----------");
                System.out.println("  " + (2 * aValue));
                System.out.println("");
                System.out.println("This is your second value with imaginary numbers: ");
                System.out.println(bFinalIrrational + " - i✓" + inSqrtAfterI);
                System.out.println("-----------");
                System.out.println("  " + (2 * aValue));
                answers[index] = "(" + bFinalIrrational + " - i✓" + inSqrtAfterI + ")/ " + (2 * aValue) + "(" + bFinalIrrational + " - i✓" + inSqrtAfterI + ")/ " + (2 * aValue);
              }

            }
            else
            {
              if (inSqrtAfterI == 1)
              {//more scenerios
                System.out.println("");
                System.out.println("This is your first value with imaginary numbers: ");
                System.out.println(bFinalIrrational + " + " + iValue + "i");
                System.out.println("-----------");
                System.out.println("  " + (2 * aValue));
                System.out.println("");
                System.out.println("This is your second value with imaginary numbers: ");
                System.out.println(bFinalIrrational + " - " + iValue + "i");
                System.out.println("-----------");
                System.out.println("  " + (2 * aValue));
                answers[index] = "(" + bFinalIrrational + " + " + iValue + "i" + inSqrtAfterI + ")/ " + (2 * aValue) + "(" + bFinalIrrational + " + " + iValue + "i" + inSqrtAfterI + ")/ " + (2 * aValue);
              }
              else
              {
                System.out.println("");
                System.out.println("This is your first value with imaginary numbers: ");
                System.out.println(bFinalIrrational + " + " + iValue + "i✓" + inSqrtAfterI);
                System.out.println("-----------");
                System.out.println("  " + (2 * aValue));
                System.out.println("");
                System.out.println("This is your second value with imaginary numbers: ");
                System.out.println(bFinalIrrational + " - " + iValue + "i✓" + inSqrtAfterI);
                System.out.println("-----------");
                System.out.println("  " + (2 * aValue));
                answers[index] = "(" + bFinalIrrational + " + " + iValue + "i✓" + inSqrtAfterI + ")/ " + (2 * aValue) + "(" + bFinalIrrational + " + " + iValue + "i✓" + inSqrtAfterI + ")/ " + (2 * aValue);
              }

            }
          }
          //increases index for array
          index++;
        }

        //finished
        System.out.println("Thats it");
        System.out.println("");

        //asks to do it again
        System.out.println("do you want to use quadratic formula to solve quadratics (type quadratics)");
        System.out.println("or");
        System.out.println("solve for a value using conservation of momentum (type momentum)");
        System.out.println("write anything else to end code");
        System.out.println(":  ");
        quadraticOrMomentum = repeatedAskForWhatToCalculate.nextLine();
      }

      else
      {
        //ask if user wants to really exit
        System.out.println("do you really want to exit, yes for yes, anything else to continue:  ");
        reallyExit = askToReallyExit.nextLine();
        if (reallyExit.equalsIgnoreCase("yes"))
        {
          //exit
          System.out.println("thanks for using this");
          loopEnd = 0;
        }
        else
        {
          //asks main question again
          System.out.println("do you want to use quadratic formula to solve quadratics (type quadratics)");
          System.out.println("or");
          System.out.println("solve for a value using conservation of momentum (type momentum)");
          System.out.println("write anything else to end code");
          System.out.println(":  ");
          quadraticOrMomentum = repeatedAskForWhatToCalculate.nextLine();
        }
      }
    }
    //prints out summary
    System.out.println("These were the formulas you chose in order");
    for (int x = 0; x < index; x++)
    {
      System.out.println("");
      System.out.println((x + 1) + ". " + choices[x]);
      System.out.println("Values: " + valuesEntered[x]);
      System.out.println("Answers: " + answers[x]);
    }

  }
}
