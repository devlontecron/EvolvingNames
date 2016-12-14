/*Devin Durham
 * Spring 342 
 * Marriott
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Genome {
	
	String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_-";
	char[] arr = alph.toCharArray();
	
	String target = "CHRISTOPHER_PAUL_MARRIOTT";
	//String targetd = "DEVIN_DURHAM";
	char[] tar = target.toCharArray();
	
	//List<String> target = new ArrayList<String>(Arrays.asList(tar));
	
	List<Character> DNA = new ArrayList<Character>();
	
	double rate;
	Random generator = new Random(); 

	
	Genome(double mutationRate){
		DNA.add('A');
		rate = mutationRate;	 
	}
	
	Genome(Genome gene){
		rate = gene.rate;
		DNA.addAll(gene.DNA);
	}
	
	
	void mutate(){
		
		int randSpot = generator.nextInt(DNA.size());
		int randChar = generator.nextInt(28);
		//Double randRate = generator.nextDouble();
		
	
		if(generator.nextDouble()<=rate){
			DNA.add(randSpot, arr[randChar]);
		}

		if(generator.nextDouble()<=rate){	
			if(DNA.size() >= 2){
				randSpot = generator.nextInt(DNA.size());
				DNA.remove(randSpot);
			}
		}
			
		for(int i = 0; i<DNA.size(); i++){
			if(generator.nextDouble()<=rate){
				DNA.set(i, arr[ generator.nextInt(28)]);
				}
			}
		}
	
	void crossover(Genome other){
		Boolean isEnd = false;
		int maxlength = Math.max(other.DNA.size(), DNA.size());
		
		for(int x=0; isEnd==false; x++ ){
			if(generator.nextInt(2)==0){
				if(x < other.DNA.size()){
					DNA.add(x, other.DNA.get(x));					
				} else{
					isEnd = true;
					
				}
			}else{
				if(x < DNA.size()){
					//Do Nothing
				}else{
					isEnd = true;
					
				}
			}			
		}
		
	}
	
	Integer fitness(){
		int m = target.length();
		int n = DNA.size();
		int i = Math.min(n,m);
		int f = Math.abs(m-n);
		
		for(int x = 0; x<i; x++){
			if(DNA.get(x) != tar[x]){
				f++;
			}
		}
		f=f+Math.abs(m-n);
		return f;
	}	
	
	@Override
	 public String toString(){
		final StringBuilder sb = new StringBuilder();
		int l = DNA.size();
		for(int x = 0; x<l; x++){
			sb.append(DNA.get(x));
		}
		
        return sb.toString();

	}
	

}
