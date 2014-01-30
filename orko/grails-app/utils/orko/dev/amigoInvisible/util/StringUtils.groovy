package orko.dev.amigoInvisible.util

import org.springframework.stereotype.Component

/**
 * Created by orko on 28/01/14.
 */
@Component
class StringUtils {

    def generator = { String alphabet, int n ->
        new Random().with {
            (1..n).collect { alphabet[ nextInt( alphabet.length() ) ] }.join()
        }
    }
}
