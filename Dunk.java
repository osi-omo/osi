package dunk;
import java.util.Scanner;
public class Dunk{
  public static int dunk(int reach, int heightOfRim, int vert){
    Scanner grade1 = new Scanner(System.in);
    System.out.print("what do you want to do :  ");
    String[] typeDunk ={"1.regular", "2.windmill", "3.Eastbay", "4.360", "5.360 windmill", 
      "6.behind back", "7.tomahawk"};
    int[] typeDunkVert ={ 6, 11, 14, 11, 14, 13, 8};
    int needVert;
    System.out.println("");
    for (int x = 0; x < typeDunk.length; x++){
      System.out.println(typeDunk[x]);
    }
    int Typedunk = grade1.nextInt();
    needVert = heightOfRim - reach + typeDunkVert[Typedunk - 1];
    if (needVert <= vert){
      System.out.println("you can dunk just work on technique");
    }
    else{
      System.out.println("you need a " + needVert + " inch vert to dunk   "
          + "increase your vertical by " + (needVert - vert) + " inches to dunk");
    }
    return vert;
  }
  public static void main(String[] args){
    int Hf, reachf, reachi, vert, hi, Hi, h, str;
    Scanner grade1 = new Scanner(System.in);
    Scanner grade2 = new Scanner(System.in);
    System.out.print("can you dunk:  ");
    String dunk = grade1.nextLine();
    if (dunk.equalsIgnoreCase("yes")){
      System.out.println("good job");
    } else{
      System.out.print("Standing reach in inches: ");
      reachi = grade1.nextInt();
      System.out.print("current vertical(inches) : ");
      vert = grade1.nextInt();
      System.out.println("Height of rim foot: ");
      Hf = grade1.nextInt();
      h = (Hf * 12);
      str =  reachi;
      dunk(str, h, vert);
    }
  }
}
