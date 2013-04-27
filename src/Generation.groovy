/* Chris Thomas & Miles Taylor */
/* Evolved RoboCode Implementation */

class Generation {
	/* What will this class do?
	 * 		- Calculates fitness of individuals
	 * 		- Sort individuals in the population based on fitness
	 * 		- Mutate fit individuals (top 25% of sorted population)
	 * 		- Combine fit individuals (optional for now)
	 * 		- Generate an ending population of combined individuals
	 *  */
	
	def bestIndividual = new Individual()
	def community = [] /* Array that all individuals will be placed into */
	
	def popCreator(popSize) { /* popSize is the size of the population, should be divisible by 4. WHOAMAN. */
		for(int i in 0..< popSize) {
			def individual = new Individual()
			individual.setValue()
			individual.calcFitness()
			community.putAt(i, individual)
		}
		community.sort()
		bestIndividual.fitness = 0
	}
	/* Runs a generation */
	def runGeneration() {
		mutation()
		determineFitness()
		community.sort()
		//deleteJar()
		if (bestIndividual.fitness < community[0].fitness){
			bestIndividual = community[0]
		}
	}
	
	/* Individuals without a fitness score have that calculated here */
	def determineFitness() {
		for (i in community) {
			if (i.fitness == null) {
				i.calcFitness()
			} 
		}
	}
	
	
	/* Delete jar files of all individuals 
	def deleteJar() {
		def id
		for (i in 0..< community.size()) { 
			id = i.id
			new File("evolved_robots/evolved/Individual_${id}.java").delete()
		}
	} */
	/* Mutates the our most promising robots*/
	def mutation() {
		/* Generates population we want to mutate */
		int fourthSize = community.size()/4
		for (i in 0..< fourthSize) {
			for (j in 1..3){
				community[fourthSize*j+i] = community[i].clone()
			}
		}
		for (i in fourthSize..<community.size()){
			community[i].mutateIndividual()
		}
		
	}
	
}