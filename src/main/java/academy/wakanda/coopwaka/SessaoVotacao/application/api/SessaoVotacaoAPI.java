package academy.wakanda.coopwaka.SessaoVotacao.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessao")
public interface SessaoVotacaoAPI {
    @PostMapping("/abertura")
    @ResponseStatus(value = HttpStatus.CREATED)
    SessaoAberturaResponse abreSessao(@RequestBody SessaoAberturaRequest sessaoAberturaRequest);
}
