/* Chris Thomas & Miles Taylor */
/* Evolved RoboCode Implementation */

class Population {
	def community = [] /* Arraylist that all individuals will be placed into */
	
	def popCreator(popSize) { /* popSize will be the size of the population. WHOAMAN. */
		for(i in 0..< popSize) {
			def individual = new Individual()
			community.putAt(i, 'individual') /* This might be a problem - will each object in the array be called 'individual' - how do we fix that? */
		}
	}
}