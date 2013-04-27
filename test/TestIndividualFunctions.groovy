import spock.lang.Specification

class TestIndividualFunctions extends Specification {
	def "confirm that our values array is not null"() {
		when:
		Individual indiv = new Individual()
		indiv.setValue()
		
		then:
		indiv.id != null
	}
	def "confirm that our fitness function works for Individual"() {
		when:
		Individual indiv = new Individual()
		indiv.setValue()
		indiv.calcFitness()
		
		then:
		indiv.fitness != null
	}
	
	def "Check that clone works"(){
		when:
		Individual indiv = new Individual()
		indiv.setValues()
		def clone = indiv.clone()
		
		then:
		clone.distanceFP == indiv.distanceFP
	}
}
