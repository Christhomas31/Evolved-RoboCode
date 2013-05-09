
class EvoChamber {
	
	
	def static main(args){
		//main evolution occurs here
		def population = new Generation()
		population.popCreator(40)
		for (i in 0..<150){
			println "generation " + i
			population.runGeneration()
			println "best " + population.bestIndividual.fitness
		}
		println population.community.size
		for (i in 0..<population.community.size()/4){
			population.community[i].createJar()
		}
	}
	
}
