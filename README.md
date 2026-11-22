# Plataforma de Cursos Online

Trabalho prático desenvolvido para a disciplina de **Programação Orientada a Objetos (POO)**, ministrada pelo **Prof. Mestre Marcos Roberto de Moraes (Maromo)** na **Fatec Mogi Mirim "Arthur de Azevedo"**.

## Identificação da Dupla
* **Lucas Wilk**
* **Flavia Donis**

---

## Tema Escolhido
**Tema 04 — Plataforma de Cursos Online**

O sistema gerencia matrículas de alunos em cursos online 100% em memória RAM, permitindo o cadastro nas modalidades Regular e Bolsista, pesquisa por número de matrícula, lançamento de notas finais, emissão polimórfica de certificados de conclusão e geração de relatório ordenado dos inscritos.

---

## Arquitetura das Classes

O projeto está organizado em pacotes conforme as boas práticas e restrições definidas nos materiais vistos em sala de aula:

```text
plataformaCursoOnlineP2/
└── src/
    ├── controller/
    │   └── Main.java
    ├── exceptions/
    │   └── LimiteVagasAtingidoException.java
    ├── interfaces/
    │   └── Certificavel.java
    ├── model/
    │   ├── Inscricao.java
    │   ├── InscricaoRegular.java
    │   └── InscricaoBolsa.java
    └── view/
        └── TelaPlataforma.java
```

## Histórico de Prompts de IA Utilizados

Em conformidade com as diretrizes de transparência do trabalho, registramos abaixo os prompts utilizados como apoio durante a estruturação, refinamento e documentação do projeto:

### Prompt 1 — Modelagem das Classes, Interface e Exceção Customizada
* **O que foi pedido:**
  > *"Com base na arquitetura de pacotes `interfaces`, `exceptions` e `model` em Java, crie a estrutura para uma Plataforma de Cursos Online. Preciso de uma interface `Certificavel` com o método `gerarCertificadoConclusao()` e um método `default` de verificação de aprovação, uma exceção verificada `LimiteVagasAtingidoException` estendendo `Exception`, e uma classe abstrata `Inscricao` que implemente `Comparable<Inscricao>` (ordenando por matrícula), `equals()`, `hashCode()`, além das subclasses `InscricaoRegular` e `InscricaoBolsa`."*
* **Resposta obtida:** A IA gerou a estrutura inicial das classes com encapsulamento dos atributos, construtores, sobrescrita de `toString()`, `equals()` e `hashCode()` baseados na matrícula, e a implementação polimórfica do certificado em cada subclasse.
* **Refinamento realizado:** Ajustamos os getters, setters e a formatação de concatenação de `String` no `toString()` para manter o mesmo padrão adotado nos exercícios anteriores da disciplina.

### Prompt 2 — Construção da Tela Swing (`TelaPlataforma`)
* **O que foi pedido:**
  > *"Crie uma tela `TelaPlataforma` estendendo `JFrame` com `setLayout(null)` e objetos `Dimension`, utilizando `JLabel`, `JTextField`, `JButton`, `JTextArea` com `JScrollPane`, e implementando `ActionListener` e `WindowListener`. A tela deve armazenar os inscritos em uma `List<Inscricao> = new ArrayList<>()` em memória e conter botões para Matricular, Pesquisar, Lançar Nota, Relatório Ordenado e Sair."*
* **Resposta obtida:** Foi gerado o layout completo da janela com posicionamento absoluto dos componentes, os 7 métodos obrigatórios do `WindowListener` e os métodos auxiliares para cada operação.
* **Refinamento realizado:** Calibramos as coordenadas (`x`, `y`) e larguras (`Dimension`) dos campos e botões para evitar sobreposição visual e definimos um limite de 5 vagas na constante `LIMITE_VAGAS` para facilitar a demonstração da exceção de turma lotada.

### Prompt 3 — Tratamento de Exceções e Validações de Entrada
* **O que foi pedido:**
  > *"Adicione o tratamento de `LimiteVagasAtingidoException`, `NumberFormatException` e `IllegalArgumentException` nos métodos de cadastro, pesquisa e lançamento de notas da `TelaPlataforma`, exibindo os avisos ao usuário por meio de `JOptionPane.showMessageDialog()`."*
* **Resposta obtida:** A IA envolveu as conversões (`Integer.parseInt` e `Double.parseDouble`) e regras de negócio em blocos `try-catch`, exibindo mensagens específicas para campos vazios, matrículas duplicadas, notas fora do intervalo de 0 a 10 e limite de vagas atingido.
* **Refinamento realizado:** Revisamos os títulos e ícones dos diálogos (`ERROR_MESSAGE`, `WARNING_MESSAGE` e `INFORMATION_MESSAGE`) e garantimos a limpeza automática dos campos após operações concluídas com sucesso.

### Prompt 4 — Revisão de Compatibilidade e Documentação
* **O que foi pedido:**
  > *"Revise a compatibilidade da sintaxe Java nas classes `Inscricao` e `TelaPlataforma` para evitar erros de compilação entre versões do JDK e organize a estrutura final de execução a partir de `controller.Principal`."*
* **Resposta obtida:** A IA padronizou o casting explícito no método `equals()` e validou as chamadas de `Collections.sort()` e do contrato polimórfico `Certificavel` no lançamento de notas.
* **Refinamento realizado:** Testamos todo o fluxo na IDE (cadastro fora de ordem, ordenação por matrícula, lançamento de nota com emissão de certificado e disparo da exceção de limite de vagas) antes da publicação no GitHub.

### Prompt 5 — Estruturação da Documentação (`README.md`)
* **O que foi pedido:**
  > *"Com base nas classes implementadas (`Certificavel`, `LimiteVagasAtingidoException`, `Inscricao`, `InscricaoRegular`, `InscricaoBolsa`, `TelaPlataforma` e `Main`) e nas diretrizes do trabalho prático, gere o arquivo `README.md` do repositório contendo a identificação da dupla, a descrição do Tema 04, a arquitetura dos pacotes, as instruções de execução no JDK 25 e o histórico organizado dos prompts utilizados."*
* **Resposta obtida:** A IA organizou as seções em Markdown com a árvore de diretórios do projeto, o resumo técnico de cada classe e os passos de compilação e execução via IntelliJ IDEA e terminal.
* **Refinamento realizado:** Conferimos os nomes dos integrantes da dupla, os caminhos dos pacotes em `src/` e o registro completo dos prompts antes de realizar o commit final no GitHub.
