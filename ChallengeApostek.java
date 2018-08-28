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
	public void special_sum(int A[], int N){
		int j=0,sum1,sum2=0;
		List<Integer> specialSum = new ArrayList<Integer>();
		for(int index = 0; index < N; index++){
			for (int i=index,k=1;i<N;i++,k++){
				if(i>index)
					i=j;
				if(i+k<=N){
					sum1=0;
					for(j=i;j<i+k;j++ ){
						sum1+=A[j];
						System.out.print(A[j]+"\t");
					}
					System.out.println("The SUM "+sum1);
					sum2+=sum1;
				}
				System.out.print("\n");
			}
			System.out.println("The total Sum "+sum2);
			specialSum.add(sum2);
			System.out.println(sum2);
		}
	}
}
