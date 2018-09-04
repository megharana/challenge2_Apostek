import java.io.BufferedReader;
import java.io.InputStreamReader;
//for scanner
import java.util.*;

class challengeApostek3{
	public static void main(String[] args) throws Exception {
		
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter no.of chairs");
		int noOfChairs = s1.nextInt();
		int chair[] = new int[noOfChairs];
		for(int i=0;i<noOfChairs;i++){
			chair[i] = -1;
		}
		chair[3]=1;
		// System.out.println("Enter no.of person");
		// int noOfPerson = s1.nextInt();
		// char preferences[] = new char[noOfPerson];
		// System.out.println("Enter the preferences person wise from 1-"+noOfPerson);
		// int noOfPerson = s1.nextChar();
		//int tempIndexes[] = new int[noOfChairs];
		
		List<Integer> tempIndexes = new ArrayList<Integer>();
		int k=0,sum=0;
		for(int j=0;j<noOfChairs;j++){
			if(chair[j]== -1){				
				tempIndexes.add(j);				
			}			
		}
		System.out.println("Indexes have -1");
		System.out.println(tempIndexes);		
		HashMap<Integer, Integer> indexSum = new HashMap<>(); // hashmap for saving the last index and count of continuous vacant chairs
		k=tempIndexes.get(0);		
		for(int tempIndex : tempIndexes){		
			if(k!=tempIndex){
				indexSum.put(k-1,sum);
				k=tempIndex;
				sum=1;
			}
			else if(k==tempIndex){
				sum++;
			}
			if(k==(chair.length-1))
				indexSum.put(k,sum);
			k++;

		}	
		System.out.println(indexSum);
		Iterator<Map.Entry<Integer, Integer>> entries = indexSum.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<Integer, Integer> entry = entries.next();
			System.out.println("startIndex = "+((entry.getKey()+1)-entry.getValue())+", endIndex = " + entry.getKey() +", Count = " + entry.getValue()); //printing the starting index and last index of maximum continuous vacant sequence of chairs
		}
		
	}
}

