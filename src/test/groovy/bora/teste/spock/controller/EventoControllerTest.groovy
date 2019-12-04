package bora.teste.spock.controller

import com.example.img.upload.demoigmupload.DemoDeDownloadEEnvioDeImgDaBaseDeDadosApplication
import com.example.img.upload.demoigmupload.controller.EventoController
import com.example.img.upload.demoigmupload.dto.CadastrarEvento
import com.example.img.upload.demoigmupload.model.Evento
import com.example.img.upload.demoigmupload.repository.EventoRepositorio
import com.example.img.upload.demoigmupload.services.EventoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException
import spock.lang.Specification
import spock.lang.Stepwise

@SpringBootTest(classes = DemoDeDownloadEEnvioDeImgDaBaseDeDadosApplication)
@Stepwise
class EventoControllerTest extends Specification {

    @Autowired
    Evento evento

    @Autowired
    EventoController controller

    @Autowired
    EventoService service

    @Autowired
    EventoRepositorio repositorio


    def 'deveria retornar status 400 e mensagem esperada quando falha em criar Evento'() {
        when:
        def resposta = controller.cadastrarEvento(new Evento())

        then:
        resposta.statusCode == HttpStatus.BAD_REQUEST
        resposta.body == 'falha'
    }


    def 'deveria retornar 204 quando não existir o evento'(){
        when:
        def resposta = controller.buscarEventoPeloId(1)

        then:
        thrown HttpStatus.OK

    }

       def 'deveria retornar 201 para evento criado'(){
        given:
        def evento =  new Evento("Rolê do fim de semana","festa","rua Mario Caserini","36","04458-170","Jardim Sônia",-23.6863175,-46.6663134,"06/12/2019","06/12/2019","18:00","23:00",1,1)

        when:
        def resposta= controller.cadastrarEvento(evento)

        then:
        resposta.statusCode == HttpStatus.CREATED
    }



}
