# QUIZATRON 3000

App de quiz para Android desenvolvido em **Kotlin + Jetpack Compose**, seguindo o padrão **MVVM**.
Exercício da Lista 5 de Programação para Dispositivos Mobile — Desenvolvimento de Sistemas, SENAI.

## Funcionalidades

- **Tela inicial** com logo, título e campo para o nome do jogador
- **Tela de quiz** com 3 perguntas de múltipla escolha e contador de progresso ("Pergunta X de 3")
- **Feedback visual** ao responder: verde para a resposta correta e vermelho para a alternativa errada escolhida
- **Tela de resultado** com mensagem personalizada pelo nome e total de acertos
- Botão **Jogar novamente**, que reinicia a partida

## Arquitetura (MVVM)

```
com.example.exerccios_lista5
├── model/
│   └── Question.kt          # Modelo de dados da pergunta
├── viewmodel/
│   └── QuizViewModel.kt     # Estado do jogo (StateFlow) e regras: pontuação, avanço, reinício
├── ui/
│   ├── screens/
│   │   ├── HomeScreen.kt    # Tela inicial
│   │   ├── QuizScreen.kt    # Tela de perguntas
│   │   └── ResultScreen.kt  # Tela de resultado
│   └── theme/               # Tema do app
└── MainActivity.kt          # Ponto de entrada e navegação (NavHost)
```

As telas apenas exibem o estado e repassam as ações do usuário. Toda a lógica do jogo fica no `QuizViewModel`, que é compartilhado entre as três telas.

## Tecnologias

- Kotlin
- Jetpack Compose + Material 3
- Navigation Compose
- ViewModel + StateFlow + Coroutines

## Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/Daniele-SS/exercicio-lista-5.git
   ```
2. Abra a pasta no **Android Studio** e aguarde o Gradle Sync.
3. Selecione um emulador ou dispositivo físico e clique em **Run ▶**.

## Autora

[Daniele Silva Santos](https://www.linkedin.com/in/danielesilvasantos/?isSelfProfile=true)
