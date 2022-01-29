# language: pt
Funcionalidade: Como usuário
  Quero montar um carro Fiat escolhendo versão, acessórios e opicionais
  Para que eu possa simular o preço pelo site

  Esquema do Cenario: Montar um carro e criar uma proposta
    Dado que eu esteja na tela inicial da FIAT
    Quando selecionar o carro "<carro>" que desejo realizar a proposta
    E acessar o opção de Monte o Seu carro
    E escolher a versão "<versao>", opcional "<opcional>", acessório "<acessorio>" e selecionar vamos negociar
    Entao deve ser exibida a tela de Resumo da Proposta com opcional "<opcional>" e acessório "<acessorio>" escolhido

    Exemplos:
      | carro | versao                         | opcional          | acessorio                                     |
      | Argo  | ARGO 1.0 FLEX 4P 2022          | Kit Plus          | COMBO CROMO                                   |
      | Mobi  | MOBI TREKKING 1.0 FLEX 4P 2022 | PACK STYLE        | FRISOS PORTAS LATERIAS (JOGO) - PETRO VULCANO |
      | Argo  | ARGO TREKKING 1.3 FLEX 4P 2022 | KIT TREKKING PLUS | BADGE MOPAR LATERAL                           |