package orko.dev.amigoInvisible.service.security

import grails.plugin.springsecurity.SpringSecurityService
import grails.transaction.Transactional
import orko.dev.amigoInvisible.domain.Role
import orko.dev.amigoInvisible.domain.User
import orko.dev.amigoInvisible.domain.UserRole

@Transactional
class CustomSecurityService extends SpringSecurityService{

    def findOrSaveUserByUserName(String userName) {
        def user = User.findByUsername(userName)
        if (!user){
            def roleUser = Role.findByAuthority(Role.ROLE_US)
            user = new User(username: userName,password: "1234")
            user.save()
            UserRole.create(user,roleUser,true)
        }
        return user
    }
}
