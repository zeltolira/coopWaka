package academy.wakanda.coopwaka.associado.application.service;

import academy.wakanda.coopwaka.associado.infra.client.ConsultaCpfResponse;
import academy.wakanda.coopwaka.associado.infra.client.SerproClientFeing;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class AssociadoApplicationService implements AssociadoService {
    private final SerproClientFeing serproClientFeing;
    public void validaAssociadoAptoVoto(String cpfAssosciado) {
        log.debug("[start]AssociadoApplicationService - validaAssociadoAptoVoto");
        ConsultaCpfResponse consultaCpfResponse =  serproClientFeing.consultaCPF(TOKEN, cpfAssosciado);
        valida(consultaCpfResponse);
        log.debug("[finish]AssociadoApplicationService - validaAssociadoAptoVoto");
    }

    private void valida(ConsultaCpfResponse consultaCpfResponse) {
        if(consultaCpfResponse.isInvalid()){
            throw new RuntimeException("CPF Invalido");
        }
    }
    private static final String TOKEN = "Bearer 06aef429-a981-3ec5-a1f8-71d38d86481e";
}
