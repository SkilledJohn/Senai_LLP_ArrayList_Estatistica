import java.util.Scanner;
import java.util.ArrayList;

public class media_lista
{
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
        
        ArrayList<Integer> num = new ArrayList<Integer>();
        num.add(10);
        num.add(15);
        num.add(20);
        num.add(25);

        for(int i : num){
            System.out.println(i);
        }
        
        float med = (num.get(0) + (num.get(1) + num.get(2) + num.get(3))) / 4;

        System.out.println("Média = " + med);

	}
}