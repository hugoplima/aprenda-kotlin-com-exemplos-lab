enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(
    val nome: String,
    val nivel: Nivel,
    val conteudosEducacionais: List<ConteudoEducacional>,
    val alunosInscritos: MutableList<String> = mutableListOf()
) {
    fun matricular(nomeAluno: String) {
        alunosInscritos.add(nomeAluno)
    }
}

fun main() {
    // Criando alguns conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 120)
    val conteudo2 = ConteudoEducacional("Estruturas de Dados", 180)
    
    // Criando uma formação e matriculando alguns alunos
    val formacao = Formacao(
        "Desenvolvimento Web",
        Nivel.INTERMEDIARIO,
        listOf(conteudo1, conteudo2)
    )
    formacao.matricular("João")
    formacao.matricular("Maria")
    
    // Exibindo informações da formação e dos inscritos
    println("Formação: ${formacao.nome}")
    println("Nível: ${formacao.nivel}")
    println("Conteúdos Educacionais:")
    formacao.conteudosEducacionais.forEach { conteudo ->
        println("${conteudo.nome} - Duração: ${conteudo.duracao} minutos")
    }
    println("Alunos Inscritos:")
    formacao.alunosInscritos.forEachIndexed { index, aluno ->
        println("Aluno ${index + 1}: $aluno")
    }
}
