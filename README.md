
# 🍕 Bella Napolli - App para controle de conta em uma pizzaria

Este é um aplicativo Android nativo desenvolvido para a disciplina de **Desenvolvimento Mobile**. O projeto simula o fluxo completo de uma pizzaria, desde a seleção de produtos até a geração de um cupom fiscal detalhado.

---

## 🚀 Funcionalidades Principais

* **Cardápio Interativo:** Interface moderna baseada em `CardView` para exibição de produtos com imagens e descrições.
* **Controle de Quantidade Dinâmico:** * Sistema de incremento (`+`) e decremento (`-`).
    * **Validação de Estado:** O botão de remover é desabilitado e fica cinza quando a quantidade chega a zero, evitando pedidos negativos.
* **Cálculo Automático de Valores:** Processamento lógico de preços unitários e soma total da conta com precisão decimal.
* **Fluxo de Dados (Intents):** Transporte de dados complexos (extrato formatado e valores) entre Activities usando `Intent.putExtra`.
* **Design Consistente:** Bloqueio programático de Dark Mode para garantir a identidade visual (Cores Vinho e Branco) em qualquer dispositivo.

---

## 🛠️ Tecnologias e Conceitos de ADS

* **Linguagem:** Java (JDK 11+)
* **Layout:** XML (ConstraintLayout, CardView, LinearLayout).
* **UI/UX:** Material Design 3 (M3).
* **Padrões de Código:**
    * **DRY (Don't Repeat Yourself):** Centralização da lógica de interface em métodos auxiliares.
    * **Manipulação de Strings:** Uso de `String.format` para garantir a exibição de 2 casas decimais (R$ 0,00).
    * **Operadores Ternários:** Utilizados para construção dinâmica do extrato.

---
## 📱 Telas do Sistema

| Tela | Responsabilidade |
| :--- | :--- |
| **Cardápio** | Seleção de pizzas e controle de quantidades. |
| **Cálculo** | Processamento de valores e geração do cupom em String. |
| **Resumo** | Exibição final do extrato e valor total da conta. |
