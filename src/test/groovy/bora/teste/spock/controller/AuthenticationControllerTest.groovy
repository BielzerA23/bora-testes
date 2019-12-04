package bora.teste.spock.controller

import com.example.img.upload.demoigmupload.DemoDeDownloadEEnvioDeImgDaBaseDeDadosApplication
import com.example.img.upload.demoigmupload.controller.AuthenticationController
import com.example.img.upload.demoigmupload.dto.LoginForm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import spock.lang.Specification
import spock.lang.Stepwise

@SpringBootTest(classes = DemoDeDownloadEEnvioDeImgDaBaseDeDadosApplication)
@Stepwise
class AuthenticationControllerTest extends Specification {

    @Autowired
    AuthenticationController authenticationController


    def 'deveria retornar status 200 que representa que o usuario se logou com sucesso'() {
        given:
        def usuario = new LoginForm("senha-secreta","Gesuvs")

        when:
        def resposta = authenticationController.login(usuario)

        then:
        resposta.statusCode == HttpStatus.OK
    }

    def 'deveria retornar status 401 que representa que o usuario não se logou com sucesso'() {
        given:
        def usuario = new LoginForm("senha-secreta-errada","Gesuvs")

        when:
        def resposta = authenticationController.login(usuario)

        then:
        resposta.statusCode == HttpStatus.UNAUTHORIZED
    }

}
