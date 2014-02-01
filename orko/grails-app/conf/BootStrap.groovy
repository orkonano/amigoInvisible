import orko.dev.amigoInvisible.domain.Role
import orko.dev.amigoInvisible.domain.User
import orko.dev.amigoInvisible.domain.UserRole

class BootStrap {

    def init = { servletContext ->

        //Creo los roles en caso de no existir y además creo el usuario ADM
        //Sólo se tiene los roles ROLE_US y ROLE_ADM
        def roleAdm = Role.findByAuthority(Role.ROLE_ADM)
        if (!roleAdm){
            roleAdm = new Role(authority: Role.ROLE_ADM).save(flush: true)
        }
        Role.findOrSaveByAuthority(Role.ROLE_US)
        def superUser = User.findByUsername("nano")
        if (!superUser){
            superUser = new User(username:"nano",password:"nano2403").save(flush:true)
            UserRole.create(superUser,roleAdm,true)
        }
    }
    def destroy = {
    }
}
