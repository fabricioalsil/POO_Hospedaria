# POO_Hospedaria 
Repository created for solving the final paper for the OOP course: System of a hostel.

## Estudo de Caso: Hotel Modelo

### Objetivos da Tarefa

- Implementar as classes do domínio em Java, a partir do diagrama de classes em anexo;

- Implementar as classes da camada de visão (interface gráfica) e da camada de controle da aplicação;

- Implementar a persistência dos objetos da aplicação em arquivo binário.

### Requisitos para implementação do Modelo de Classes

O Hotel Modelo deseja que seja desenvolvido um sistema para automatizar o processo de hospedagem e atendimento dos hóspedes. Para isso, o sistema deverá atender os seguintes requisitos:

- Os hóspedes, no momento do check-in (registro para início da hospedagem), se apresentam na recepção do hotel e informam os seguintes dados: cpf (imutável), nome (obrigatório), telefone (obrigatório) e email.

- Após o cadastro, se houver acompanhante(s) para a hospedagem, o hóspede responsável informa os mesmos dados para acompanhantes e seleciona a acomodação (apartamento) que deseja ocupar. Os apartamentos possuem diferentes tipos de acomodação, de acordo com as comodidades oferecidas. Caso
haja disponibilidade de acomodação na categoria selecionada, o check-in é registrado e o apartamento alocado é colocado no estado de “ocupado”.

- Os hóspedes podem solicitar serviços e produtos oferecidos pelo hotel. Os itens oferecidos podem ser escolhidos em um menu, no qual os itens são divididos por categoria, e apresentam descrição e preço. Os itens consumidos são registrados na conta do hóspede.

- Para o checkout (término da hospedagem), o sistema deve emitir listagem com os dados da hospedagem:
informações do apartamento; período de hospedagem para cobrança das diárias (o valor da diária varia de acordo com a categoria de acomodação), quantidade de ocupantes, valor total das diárias (para cada acompanhante do hospede responsável será somado um adicional de tarifa), lista de itens consumidos com
totalização do consumo e valor total da conta (diárias + consumo).

- O cliente pode efetuar o pagamento divido em diferentes formas de pagamentos (diferentes cartões), bem como pagamentos parciais podem ser realizados em diferentes momentos durante a hospedagem. No momento do checkout, o cliente deverá realizar o pagamento do saldo devedor.

-  Após o checkout, o apartamento passa do estado de “ocupado” para o estado de “em manutenção”. Após limpeza e abastecimento, o apartamento retorna para o estado de “disponível”, de modo que possa ser atribuído a uma nova hospedagem.

### Implementar uma aplicação em Java com uso de Interfaces Gráficas conforme as seguintes convenções:

- MenuView: janela principal da aplicação com menu de opções para as acesso às demais janelas do sistema;

- ClasseView: as classes da camada de apresentação devem ter o sufixo View acrescido ao nome do domínio;

- ClasseController: as classes View devem utilizar um controlador Controller para instanciar os objetos do domínio (a partir dos dados fornecidos pela View) e armazenar a lista dos objetos de domínio instanciados;

- Distribuir as classes da aplicação nos pacotes main (inicialização), view, controller, model e persistence;

- Pacotes adicionais independentes podem ser criados para melhor organização do projeto, por exemplo: pacote para classes de exceção – exception – criadas especificamente para a aplicação; pacote para implementação de classes de utilidades – util – para tratamento de dados e serviços auxiliares ao modelo.
