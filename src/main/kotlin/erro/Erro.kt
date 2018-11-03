package br.com.lcv.erro

import org.springframework.http.HttpStatus

data class Erro(val httpStatus: HttpStatus, val mensagem: String?)