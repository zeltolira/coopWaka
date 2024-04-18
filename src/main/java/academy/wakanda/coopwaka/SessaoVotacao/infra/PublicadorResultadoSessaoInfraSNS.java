package academy.wakanda.coopwaka.SessaoVotacao.infra;

import academy.wakanda.coopwaka.SessaoVotacao.application.api.ResultadoSessaoResponse;
import academy.wakanda.coopwaka.SessaoVotacao.domain.PublicadorResultadoSessao;
import academy.wakanda.coopwaka.config.AwsConfigProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Log4j2
public class PublicadorResultadoSessaoInfraSNS implements PublicadorResultadoSessao {
    private final NotificationMessagingTemplate publicadorResultadoSNS;
    private final AwsConfigProperties awsSnsProperties;

    @Override
    public void publica(ResultadoSessaoResponse resultadoSessaoResponse) {
        log.debug("[start] PublicadorResultadoSessaoInfraSNS - publica");
        publicadorResultadoSNS.sendNotification(awsSnsProperties.getResultadoSessaoTopic(), resultadoSessaoResponse, resultadoSessaoResponse.getIdPauta().toString());
        log.debug("[finish] PublicadorResultadoSessaoInfraSNS - publica");

    }
}
