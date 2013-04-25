/* Chris Thomas & Miles Taylor */
/* Evolved RoboCode Implementation */

class Population {
	def community = [] /* Array that all individuals will be placed into */
	
	def popCreator(popSize) { /* popSize will be the size of the population. WHOAMAN. */
		for(i in 0..< popSize) {
			def individual = new Individual()
			individual.setValue()
			community.putAt(i, individual) 
		}
		return community
	}
}