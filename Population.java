/*Devin Durham
 * Spring 342 
 * Marriott
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Population {
	
	Genome mostFit;
	List<Genome> pop = new ArrayList<Genome>();;
	int popCount;
	
	void Population(Integer numGenomes, Double mutationRate){
		popCount = numGenomes;
		for(int x = 0; x<numGenomes;x++){
			Genome myPop = new Genome(mutationRate);
			pop.add(myPop);
		}
		mostFit = pop.get(0);
	}
	
	void day(){
		//updates most fit
		for(int i = 0; i<pop.size();i++){
			if(pop.get(i).fitness()< mostFit.fitness()){
				mostFit = pop.get(i);
			}
		}
		//deletes least fit half
		int removing;
		int x = 0;
		while(x < (popCount)/2){
			removing = 0;
			for(int i = 0; i<pop.size();i++){
				Genome badGene = new Genome(pop.get(0));
				if(pop.get(i).fitness()>= badGene.fitness()){
					badGene = pop.get(i);
					removing = i;
				}
			}
			pop.remove(removing);
			x++;
		}
		
		//replenishes population count
		Random generator = new Random(); 
		
		while(pop.size()<=popCount){
		//for(int i = 0; i<popCount-1;i++){
			int r = generator.nextInt(pop.size());
			if(r%2 == 0){
				Genome nextGen = new Genome(pop.get(r));
				nextGen.mutate();
				pop.add(nextGen);
				
			} else{
				Genome nextGen = new Genome(pop.get(r));
				int q = generator.nextInt(pop.size());
				nextGen.crossover(pop.get(q));
				nextGen.mutate();
				pop.add(nextGen);
				
			}	
	
		}
		
	}
	
}
