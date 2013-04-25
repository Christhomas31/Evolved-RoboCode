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
	
	def populationSize
	def startingPop = new Population().popCreator(populationSize)
	def bestIndividual
	def endingPop = [populationSize]
	
	/* Run a generation */
	def runGeneration() {
		startingPop.determinedFitness()
		startingPop.popSort()
		startingPop.mutation()
	}
	
	/* Individuals without a fitness score have that calculated here */
	def determinedFitness() {
		for (i in startingPop) {
			if (i.fitness == null) {
				i.calcFitness()
			} 
		}
	}
	
	/* Sorts individuals in the population based upon fitness */
	def popSort() { 
		startingPop.sort()
	}
	
	/* Delete jar files of all individuals */
	def deleteJar() {
		def id
		for (i in 0..< startingPop.size()) { 
			id = i.id
			new File("evolved_robots/evolved/Individual_${id}.java").delete()
		}
	}
	
	/* Top percentage of startingPop */
	def topIndividuals
	
	/* Mutates the  */
	def mutation() {
		/* Generates population we want to mutate */
		def fourthSize = startingPop.size()/4
		for (i in 0..< fourthSize) {
			for (j in 1..3){
				startingPop.putAt(fourthSize*j+i, startingPop(i).clone())
			}
		}
		
		/* Mutates */
		
	}
	
	
	
//	/* Combines the top 50% of fit individuals */
//	def reproduction() { 
//		/* Take topIndividuals of startingPop and combine
//		 * What do we combine from each individual?
//		 * Which individuals do we pair? */
//		
//		/* Place children in endingPop */
//
//	}
	
}