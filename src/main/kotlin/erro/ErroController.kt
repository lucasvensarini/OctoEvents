package br.com.lcv.erro

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.http.ResponseEntity
import javax.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus

@ControllerAdvice
class ErroController : ResponseEntityExceptionHandler() {
	
	@ExceptionHandler(NaoEncontradoException::class)
    @ResponseBody
    fun handleNaoEncontradoException(request: HttpServletRequest, e: Throwable) : ResponseEntity<Erro> {
    	val erro = Erro(HttpStatus.NOT_FOUND, e.message)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro)
    }
	
}