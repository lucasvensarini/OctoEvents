package br.com.lcv.user

import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository
interface UserRepository : JpaRepository<User, Long> {
	
	fun findByLogin(login: String) : User?
	
}