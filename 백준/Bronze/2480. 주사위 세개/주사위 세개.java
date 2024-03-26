import java.util.Scanner;

public class Main{
	public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int dice1 = scan.nextInt();
        int dice2 = scan.nextInt();
        int dice3 = scan.nextInt();
        int sum = dice1 + dice2 + dice3;
        
        int rewardTriple = 10000 + dice1*1000;
        int rewardDouble = 1000 + dice1*100;
        int rewardDouble2 = 1000 + dice2*100;
        int rewardSingle = dice1*100;
        int rewardSingle2 = dice2*100;
        int rewardSingle3 = dice3*100;
        
        if(dice1+dice2+dice3 == dice1*3) {
            System.out.println(rewardTriple);
        } else if(dice1 == dice2) {
            System.out.println(rewardDouble);
        } else if(dice1 == dice3) {
            System.out.println(rewardDouble);
        } else if(dice2 == dice3) {
            System.out.println(rewardDouble2);
        } else if(dice1 > dice2 && dice1 > dice3) {
            System.out.println(rewardSingle);
        } else if(dice2 > dice1 && dice2 > dice3) {
            System.out.println(rewardSingle2);
        } else if(dice3 > dice1 && dice3 > dice2) {
            System.out.println(rewardSingle3);
        }
    }
}