package br.edu.ifsp.scl.ads.pdm.cadastro

data class Formulario(
    val nomeCompleto: String,
    val telefone: String,
    val email: String,
    val ingressarListaEmails: Boolean,
    val sexo: String,
    val cidade: String,
    val uf: String
) {
    override fun toString(): String {
        return "Nome Completo: $nomeCompleto, Telefone: $telefone, Email: $email, " +
                "Ingressar na Lista de Emails: ${if (ingressarListaEmails) "Sim" else "Não"}, " +
                "Sexo: $sexo, Cidade: $cidade, UF: $uf"
    }
}
