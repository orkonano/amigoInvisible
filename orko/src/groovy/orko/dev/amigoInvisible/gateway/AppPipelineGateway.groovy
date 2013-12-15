package orko.dev.amigoInvisible.gateway

import java.util.concurrent.Future

import orko.dev.amigoInvisible.domain.Regalo

public interface AppPipelineGateway {

	Future<List<Regalo>>  request(request)
}
