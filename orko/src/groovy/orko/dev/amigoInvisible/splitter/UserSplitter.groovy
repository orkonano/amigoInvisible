package orko.dev.amigoInvisible.splitter

import org.springframework.stereotype.Component
import orko.dev.amigoInvisible.helper.UserRegistrado

/**
 * Created by orko on 10/02/14.
 */
@Component
class UserSplitter {

    public List<UserRegistrado> split(List<UserRegistrado> userRegistrados){
        return userRegistrados;
    }
}
