package orko.dev.amigoInvisible.service.security

import grails.plugin.springsecurity.SpringSecurityService
import grails.transaction.Transactional
import orko.dev.amigoInvisible.domain.Partida
import orko.dev.amigoInvisible.domain.Role
import orko.dev.amigoInvisible.domain.User
import orko.dev.amigoInvisible.domain.UserRole

@Transactional
class CustomSecurityService extends SpringSecurityService{

    def saveUser(Partida partida) {
        partida.participantes.each {amigo ->
            if (!amigo.user){
                def user = User.findByUsername(amigo.email)
                if (!user){
                    def roleUser = Role.findByAuthority(Role.ROLE_US)
                    user = new User(username: amigo.email,password: "1234")
                    user.save()
                    UserRole.create(user,roleUser,true)
                    amigo.user = user
                    amigo.save()
                }
            }
        }
        return partida
    }
}
