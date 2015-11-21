package orko.dev.amigoInvisible.service.security

import grails.plugin.springsecurity.SpringSecurityService
import grails.transaction.Transactional
import orko.dev.amigoInvisible.domain.Partida
import orko.dev.amigoInvisible.domain.Role
import orko.dev.amigoInvisible.domain.User
import orko.dev.amigoInvisible.domain.UserRole
import orko.dev.amigoInvisible.helper.UserRegistrado

@Transactional
class CustomSecurityService extends SpringSecurityService{

    def stringUtils

    def saveUser(Partida partida) {
        List<UserRegistrado> userRegistrados = new ArrayList<UserRegistrado>()
        partida.participantes.each {amigo ->
            if (!amigo.user){
                def user = User.findByUsername(amigo.email)
                if (!user){
                    def roleUser = Role.findByAuthority(Role.ROLE_US)
                    def password = stringUtils.generator((('A'..'Z')+('0'..'9')).join(), 9 )
                    user = new User(username: amigo.email,password: password)
                    user.save()
                    UserRole.create(user,roleUser,true)
                    userRegistrados.add(new UserRegistrado(usuarioRegistrado: user,uncodePassword: password))
                    amigo.user = user
                    amigo.save()
                }
            }
        }
        return userRegistrados
    }
}
