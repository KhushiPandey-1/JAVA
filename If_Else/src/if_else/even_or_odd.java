package if_else;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khushi pandey
 */
import java.util.Scanner;
public class even_or_odd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        System.out.println(4%7);
        System.out.println("Enter Any Number");
        int a=sc.nextInt();
        if(a%2==0)
        {
            System.out.println(a+" is an even number");
        }
        else{
            System.out.println(a+" is an odd number");
        }
        
    }
    
}
