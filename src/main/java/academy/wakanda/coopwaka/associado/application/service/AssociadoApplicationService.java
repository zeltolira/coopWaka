package academy.wakanda.coopwaka.associado.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class AssociadoApplicationService implements AssociadoService {
    public void validaAssociadoAptoVoto(String cpfAssosciado) {
        log.info("[start]AssociadoApplicationService - validaAssociadoAptoVoto");
//        ConsultaCpfResponse consultaCpfResponse =  serproClientFeing.consultaCPF(TOKEN, cpfAssosciado);
//        valida(consultaCpfResponse);
        log.info("[finish]AssociadoApplicationService - validaAssociadoAptoVoto");
    }
}
