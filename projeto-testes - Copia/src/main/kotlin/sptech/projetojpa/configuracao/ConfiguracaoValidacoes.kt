package sptech.projetojpa.configuracao

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.validation.Validator
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean

/*
Criamos essa classe de configuração para que as anotações de validação
sejam executadas nos EndPoint de CRUD criados pelo Data REST e o status seja 400 em caso de erro de validação
Basta ela, não importando quantas entidades teremos
 */
@Configuration
class  ConfiguracaoValidacoes : RepositoryRestConfigurer {

    @Bean
    fun validator(): Validator? {
        return LocalValidatorFactoryBean()
    }

    override fun configureValidatingRepositoryEventListener(validatingListener: ValidatingRepositoryEventListener) {
        validatingListener.addValidator("beforeCreate", validator())
        validatingListener.addValidator("beforeSave", validator())
    }

}