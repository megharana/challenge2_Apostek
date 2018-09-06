import java.io.BufferedReader;
import java.io.InputStreamReader;
//for scanner
import java.util.*;

class challengeApostek3{
	public static void main(String[] args) throws Exception {
		challengeApostek3 ca = new challengeApostek3();
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter no.of chairs");
		int noOfChairs = s1.nextInt();
		int chair[] = new int[noOfChairs];
		for(int i=0;i<noOfChairs;i++){
			chair[i] = -1;
		}
		
		System.out.println("Enter no.of person");
		int noOfPerson = s1.nextInt();
		char preferences[] = new char[noOfPerson];
		System.out.println("Enter the preferences person wise from 1-"+noOfPerson);
		
		for(int i=0;i<noOfPerson;i++){
			 preferences[i] = s1.next().charAt(0);
		}

		List<Integer> maxVacantIndex = new ArrayList<Integer>();
		for(int j=0;j<noOfPerson;j++){			
			maxVacantIndex = ca.getVacantSequence(chair,noOfChairs);	
			System.out.println("startIndex = "+((maxVacantIndex.get(1)+1)-maxVacantIndex.get(0))+", endIndex = " + maxVacantIndex.get(1) +", Count = " + maxVacantIndex.get(0)); //printing the starting index and last index of maximum continuous vacant sequence of chairs
			int maxVacantCount = maxVacantIndex.get(0);
			int startIndex = ((maxVacantIndex.get(1)+1)-maxVacantIndex.get(0));
			int endIndex = maxVacantIndex.get(1);
			//checking whether the maximum vacant sequence is odd/even.
			if(maxVacantCount%2==0){
				if(maxVacantCount==2){
					if(preferences[j]=='L')
						chair[startIndex] = j+1;
					else
						chair[endIndex] = j+1;
				}
				else if(maxVacantCount>2){
					//divide the count, get quotient and based preference left=(startIndex+quotient-1)  or if right = (startIndex+quotient)
					int quotient=maxVacantCount/2;
					if(preferences[j]=='L')
						chair[startIndex+quotient-1] = j+1;
					else
						chair[startIndex+quotient] = j+1;			
				}
			}
			else{
				if(maxVacantCount == 1){
					chair[endIndex] = j+1;
				}
				else if(maxVacantCount>1){
					int quotient=maxVacantCount/2;
					chair[quotient+startIndex]=j+1;
				}
			}
		}
		for(int i=0;i<noOfChairs;i++){
			System.out.println(chair[i]);
		}
	}
	public List<Integer> getVacantSequence(int chair[],int noOfChairs){
		List<Integer> tempIndexes = new ArrayList<Integer>();
		HashMap<Integer, Integer> indexSum = new HashMap<>(); // hashmap for saving the last index and count of continuous vacant chairs
		List<Integer> maxVacantIndex = new ArrayList<Integer>();
		
		int k=0,sum=0;
		for(int j=0;j<noOfChairs;j++){
			if(chair[j]== -1){				
				tempIndexes.add(j);				
			}			
		}
		System.out.println("Indexes have -1");
		System.out.println(tempIndexes);
		if(tempIndexes.size()>1){     //checking whether more than 
			
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
			
			int maxVacantSeqCount=(Collections.max(indexSum.values()));
			maxVacantIndex.add(maxVacantSeqCount);
			for (Map.Entry<Integer, Integer> entry : indexSum.entrySet()) {  // Itrate through hashmap
				if (entry.getValue()==maxVacantSeqCount) {
					maxVacantIndex.add(entry.getKey());     // Print the key with max value
				}
			}
		}
		else{
			maxVacantIndex.add(tempIndexes.size());
			maxVacantIndex.add(tempIndexes.get(0));
		}
		
		return maxVacantIndex;
	}
}

