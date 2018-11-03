package br.com.lcv.user

import javax.persistence.Id
import javax.persistence.GeneratedValue
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Entity

@Entity
data class User(@Id @GeneratedValue @JsonIgnore val id: Long? = null,
				val login: String)