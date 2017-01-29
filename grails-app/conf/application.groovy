grails {
    plugin {
        springsecurity {
            rest {
                oauth {
                    frontendCallbackUrl = { String tokenValue -> "http://requestb.in/z0mtwoz0?token=${tokenValue}" }
                    facebook {
                        client = org.pac4j.oauth.client.FacebookClient
                        key = '247357032373109'
                        secret = '37332ea09efa9e4be3e4374da66f1be1'
                        scope = 'email,user_location'
                        fields = 'id,name,first_name,middle_name,last_name'
                        defaultRoles = ['ROLE_USER', 'ROLE_FACEBOOK']
                    }
                }
            }
        }
    }
}

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'mdb.Person'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'mdb.PersonRole'
grails.plugin.springsecurity.authority.className = 'mdb.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/',               access: ['permitAll']],
        [pattern: '/error',          access: ['permitAll']],
        [pattern: '/index',          access: ['permitAll']],
        [pattern: '/index.gsp',      access: ['permitAll']],
        [pattern: '/shutdown',       access: ['permitAll']],
        [pattern: '/assets/**',      access: ['permitAll']],
        [pattern: '/**/js/**',       access: ['permitAll']],
        [pattern: '/**/css/**',      access: ['permitAll']],
        [pattern: '/**/images/**',   access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
        //Stateless chain
        [ pattern: '/api/**', filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'],

        //Traditional chain
        //[ pattern: '/**', filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter']
]

grails.plugin.springsecurity.rest.token.storage.useGorm = false
//grails.plugin.springsecurity.rest.token.storage.gorm.tokenDomainClassName = 'mdb.security.AuthenticationToken'
