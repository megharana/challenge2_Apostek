import java.io.BufferedReader;
import java.io.InputStreamReader;
//for scanner
import java.util.*;

class Test{
	public static void main(String[] args) throws Exception {
		
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter no.of chairs");
		int noOfChairs = s1.nextInt();
		int chair[] = new int[noOfChairs];
		for(int i=0;i<noOfChairs;i++){
			chair[i] = -1;
		}
		chair[2]=1;
		// System.out.println("Enter no.of person");
		// int noOfPerson = s1.nextInt();
		// char preferences[] = new char[noOfPerson];
		// System.out.println("Enter the preferences person wise from 1-"+noOfPerson);
		// int noOfPerson = s1.nextChar();
		int tempIndexes[] = new int[noOfChairs]; 
		int k=0,sum=1;
		for(int j=0;j<noOfChairs;j++){
			if(chair[j]==-1){
				tempIndexes[k]=j;
			}
			k++;
		}
		List<Integer> sums = new ArrayList<Integer>();
		k=tempIndexes[0];
		for(int j=1;j<tempIndexes.length;j++){		
			k++;
			System.out.println("The sum b4 if condition" + sum +" "+k +" "+tempIndexes[j]);
			if(k!=tempIndexes[j]){
				k=tempIndexes[j];
				sums.add(sum);
				sum=1;
			}
			else if(k==tempIndexes[j]){
				sum++;
			}
			
			System.out.println("The sum inside loop" + sum +" "+k +" "+tempIndexes[j]);

			if(k==tempIndexes.length-1)
				sums.add(sum);

		}

		System.out.println(sums);
		for(int i=0;i<noOfChairs;i++){
			System.out.println(chair[i]); 
		}

	}
}

