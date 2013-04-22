
class Individual implements Comparable {

	Random random = new Random()
	def values
	def id
	def fitness
	/* Values for Nic's Evolved individual*/
	def enemy_energy
	def my_energy
	def angle_diff
	def distance
	/* Values for our evolved individual */
	double myEnergyFP
	double distanceFP
	double theirEnergyFP
	
	def calcFitness(){
		for(i in 0..<10){
		fitness += battleRunner.runBattle(id)
		}
		fitness/10
	}
	def setValue(){
		id = random.nextInt(1000000)
		
		enemy_energy = random.nextFloat() * 100
		my_energy = random.nextFloat() * 100
		angle_diff = random.nextFloat() * 100
		distance = random.nextFloat() * 100
		
		myEnergyFP = random.nextInt(33)+1
		distanceFP = random.nextInt(2000)+500
		theirEnergyFP = random.nextInt(33)+1
		values = ["id" : id, "enemy_energy" : enemy_energy, "my_energy" : my_energy,
			 "angle_diff" : angle_diff, "distance" : distance, "myEnergyFP" : myEnergyFP,
			 "distanceFP" : distanceFP, "theirEnergyFP": theirEnergyFP]
		/*values =["id" : id, "enemy_energy" : enemy_energy, "my_energy" : my_energy,
			 "angle_diff" : angle_diff, "distance" : distance]*/
		
	}
	
	public int compareTo(pair2) {
	if (this.fitness > pair2.fitness){
			-1
		} else if (this.fitness < pair2.fitness) {
			1
		} else {
			0
		}
	}

}
