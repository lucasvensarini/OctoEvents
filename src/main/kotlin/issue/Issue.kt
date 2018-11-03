package br.com.lcv.issue

import br.com.lcv.user.User
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
data class Issue(@Id @GeneratedValue @JsonIgnore val id: Long? = null,
                 val url: String,
                 val number: Int,
                 val title: String,
                 val state: String,
                 @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id")
                 @JsonIgnoreProperties("hibernateLazyInitializer", "handler") var user: User,
                 @JsonProperty(value = "created_at") val createdAt: String,
                 val body: String)