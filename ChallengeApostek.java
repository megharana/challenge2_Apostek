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
		for (int i=0;i<N;i++){
			A[i] = s1.nextInt();
		}
		ca.special_sum(A,N);
		s1.close();
	}
	public void special_sum(int A[], int N){                   //to calculate the special sum
		int j=0,sum1,sum2=0;
		List<Integer> specialSum = new ArrayList<Integer>();   //list to add up all special sum of each index
		for(int index = 0; index < N; index++){					//INDEX provided
			for (int i=index,k=1;i<N;i++,k++){					//loop that breaks it in modules (A[1])+(A[2]+A[3]) 
				if(i>index)										//'i' takes the updated 'j' value after completion of inner loop
					i=j;
				if(i+k<=N){										//checks the possibility of breaking it in module
					sum1=0;
					for(j=i;j<i+k;j++ ){						//loop for each module
						sum1+=A[j];								//sum of each module i.e. (A[2]+A[3])
						System.out.print(A[j]+"\t");
					}
					System.out.println("The SUM "+sum1);		
					sum2+=sum1;									//takes the sum of each modules 
				}
				System.out.print("\n");
			}
			System.out.println("The total Sum "+sum2);			// printing the sum of each index
			specialSum.add(sum2);								//adding up all the sum of indexes in list 
			System.out.println(sum2);
		}
	}
}
