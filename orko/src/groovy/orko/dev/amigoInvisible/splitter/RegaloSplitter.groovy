package orko.dev.amigoInvisible.splitter

import org.springframework.stereotype.Component

import orko.dev.amigoInvisible.domain.Regalo

@Component
class RegaloSplitter {

	
	public List<Regalo> split(List<Regalo> regalo){
		return regalo;
	}
	
}
