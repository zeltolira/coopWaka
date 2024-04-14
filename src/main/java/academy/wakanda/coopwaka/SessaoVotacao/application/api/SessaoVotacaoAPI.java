package academy.wakanda.coopwaka.SessaoVotacao.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/sessao")
public interface SessaoVotacaoAPI {
    @PostMapping("/abertura")
    @ResponseStatus(value = HttpStatus.CREATED)
    SessaoAberturaResponse abreSessao(@RequestBody SessaoAberturaRequest sessaoAberturaRequest);

    @PostMapping("/{idSessao}/voto")
    @ResponseStatus(value = HttpStatus.CREATED)
    VotoResponse recebeVoto(@PathVariable UUID idSessao, @RequestBody VotoRequest novoVoto);
}
