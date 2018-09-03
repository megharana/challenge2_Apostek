import java.io.BufferedReader;
import java.io.InputStreamReader;
//for scanner
import java.util.*;

class ChallengeApostek{
	public static void main(String[] args) throws Exception {
		ChallengeApostek ca= new ChallengeApostek();
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter the size");
		int N = s1.nextInt();
		int A[]=new int[N];
		System.out.println("Enter the array element");
		ArrayList<Integer> specialSums = new ArrayList<Integer>();
		for (int i=0;i<N;i++){
			A[i] = s1.nextInt();
		}
		for (int i=0;i<N;i++){
			int sp_sum = ca.indexSum(A,i);
			specialSums.add(sp_sum);
		}
		int bestIndex=ca.findBestIndex(specialSums);
		System.out.println("The best index for this array is "+bestIndex);
		s1.close();
	}
	public int indexSum(int A[],int index){     //for calculating special sum of each index
		int returnSum=0;
		int termsToAdd = 1;   
		while(index+termsToAdd-1<A.length){    
			for(int i =0;i<termsToAdd;i++){
				returnSum+=A[index];
				index++;
			}
			termsToAdd++;
		}
		return returnSum;
	}
	public int findBestIndex(ArrayList<Integer> specialSums){    //for finding the best index among special sums 
		return  Collections.max(specialSums);
	}
}
