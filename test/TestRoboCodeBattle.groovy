

import spock.lang.Specification


/*
 * This assumes that there is a copy of Robocode in your home directory,
 * and that it has been configured (via the GUI) to be able to load robot
 * files from the evolved_robots directory in this project.
 */
class TestRoboCodeBattle extends Specification {
	/*
	 * id : an id used in the generation of the name of the class.
	 * enemy_energy : the coefficient for the enemy's energy
	 * my_energy : the coefficient for our energy
	 * angle_diff : the coefficient for the different in angles between us and the point and then and the point
	 * distance : the coefficient for the distance between the point and the enemy
	 */
	/* def id
	def enemy_energy
	def my_energy
	def angle_diff
	def distance
	def robotBuilder
	def battleRunner
	def myEnergyFP
	def distanceFP
	def theirEnergyFP

	def setup() {
		Random random = new Random()
		id = random.nextInt(1000000)
		enemy_energy = random.nextFloat() * 100
		my_energy = random.nextFloat() * 100
		angle_diff = random.nextFloat() * 100
		distance = random.nextFloat() * 100
		myEnergyFP = random.nextInt(33)+1
		distanceFP = random.nextInt(2000)+500
		theirEnergyFP = random.nextInt(33)+1
        def values = ["id" : id, "enemy_energy" : enemy_energy, "my_energy" : my_energy, "angle_diff" : angle_diff, "distance" : distance,
			"myEnergyFP": myEnergyFP, "distanceFP": distanceFP, "theirEnergyFP": theirEnergyFP] */
	def id
	def values
	def testbot
	def battleRunner
	def robotBuilder
	def enemy_energy
	def my_energy
	def angle_diff
	def distance
	def myEnergyFP
	def distanceFP
	def theirEnergyFP
	
	
	def setup(){
		Individual indiv = new Individual()
		indiv.setValue()
		testbot = indiv
		id = testbot.id
		enemy_energy = testbot.enemy_energy
		my_energy = testbot.my_energy
		angle_diff = testbot.angle_diff
		distance = testbot.distance
		def values = testbot.values

		robotBuilder = new RobotBuilder("templates/HawkOnFireOS.template")
		robotBuilder.buildJarFile(values)
		
		battleRunner = new BattleRunner("templates/battle.template")
	}
	
	def "Check that the battle file is correctly constructed"() {
		when:
		battleRunner.buildBattleFile(id)
		
		then:
		confirmBattleFile()
	}
	
	def "Check that we can run a battle and extract the scores"() {
		given:
		battleRunner.buildBattleFile(id)
		
        when:
		def score = battleRunner.runBattle(id)
		
        then:
		score >= 0
	}
	
	def confirmBattleFile() {
		File file = new File("evolved_robots/evolve.battle")
        def contents = file.readLines()
        def interestingLines = contents.findAll { line ->
            (line.indexOf("robocode.battle.selectedRobots") >= 0)
        }
        assert interestingLines.size() == 1
		assert interestingLines[0].indexOf("sample.Walls") >= 0
        assert interestingLines[0].indexOf("evolved.Individual_${id}") >= 0
        return true
	}
}