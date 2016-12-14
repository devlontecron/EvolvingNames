

/*Devin Durham
 * Spring 342 
 * Marriott
 */
public class Main {
	
	public static void main(String[] args) {
	
		long start = System.nanoTime();
		Population myMainPop = new Population();
		myMainPop.Population(100, .05);
		int generation = 0;
		
		while(myMainPop.mostFit.fitness() != 0){
			myMainPop.day();
			generation++;
			System.out.println("Generation: " +generation);
			System.out.println(myMainPop.mostFit.toString());
		}
		
		long stop = System.nanoTime();
		long timeN =(stop-start);
		double timeS = timeN/1000000000.0;
		
		
		System.out.println("FINAL: " + myMainPop.mostFit.toString());
		System.out.println("Number of Generation: " + generation);
		System.out.println("TIME: (in seconds): " + timeS);
		System.out.println("TIME: (in nano): " + timeN);
		
		//testGenome();
		//testPopulation();
	}
	
	static void testGenome(){
		Genome testGene = new Genome(.05);
		
		
		System.out.println(testGene.toString());
		
		Genome testGene2 = new Genome(testGene);
		System.out.println(testGene2.toString());
			
		testGene.mutate();
		System.out.println("Mutation: " + testGene.toString());
		
		System.out.println(testGene2.toString());
		System.out.println(testGene.toString());
		testGene.crossover(testGene2);
		System.out.println("Crossover: " + testGene);
		
		//testGene.fitness();
		System.out.println("Fitness: " + testGene.fitness());
		System.out.println("TARGET = CHRISTOPHER_PAUL_MARRIOTT");
		System.out.println("Current: " + testGene.toString());
	}
	
	static void testPopulation(){
		Population testPop = new Population();
		
		testPop.Population(100, .05);
		System.out.println(testPop.pop.size());
		System.out.println(testPop.pop.get(9).rate);
		
		testPop.day();
		System.out.println(testPop.mostFit);
		System.out.println(testPop.pop.size());
		
		int x =0;
		while(x<1000){
			testPop.day();
			x++;
			System.out.println(testPop.pop.toString());
			
		}
	
	}

}
