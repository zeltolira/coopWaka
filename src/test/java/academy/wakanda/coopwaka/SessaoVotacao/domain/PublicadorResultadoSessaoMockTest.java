package academy.wakanda.coopwaka.SessaoVotacao.domain;

import academy.wakanda.coopwaka.SessaoVotacao.application.api.ResultadoSessaoResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PublicadorResultadoSessaoMockTest implements PublicadorResultadoSessao {
    @Override
    public void publica(ResultadoSessaoResponse resultadoSessaoResponse) {
        log.info("[start] PublicadorResultadoSessaoMockTest - publica");
        log.info("[finish] PublicadorResultadoSessaoMockTest - publica");
    }
}
