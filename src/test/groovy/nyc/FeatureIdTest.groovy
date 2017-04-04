package nyc

import spock.lang.*

import geoscript.feature.*
import geoscript.layer.Layer
import geoscript.geom.*

class ProximityTest extends Specification {

	def 'test that feature ids persist'(){
		given:
			Schema schema = new Schema('mySchema', [['geom', 'Point'], ['name', 'string'], ['address', 'string']])
			def attrs = [geom: new Point(1, 10), name: 'myName', address: 'myAddress']
			Feature inFeature = new Feature(attrs, 'myFID', schema)
			Layer layer = new Layer('myLayer', schema)
			layer.add(inFeature)
		when:
			Feature outFeature = layer.getFeatures()[0]
		then:
			inFeature.getId() == 'myFID' 
			inFeature.getId() == outFeature.getId() 
	}
}
