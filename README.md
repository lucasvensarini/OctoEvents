O projeto foi feito utilizando Intellij, spring boot, gradle, spring data e h2. Foram criados dois endpoints: 
  - POST /issues/events -> responsável por armazenar as informações do webhook quando uma issue é criada, deletada ou modificada em um         repository do github.
  - GET /issues/{number}/events -> responsável por buscar os IssueEvents pelo número da issue.
 
 Para utilizar a API:
  - importe a aplicação no intellij e execute a classe OctoEventsMain ou baixe a aplicação e utilize o comando bootRun do gradle para           executá-la como uma aplicação do spring boot.
  - use o bgrok para expor o localhost como url externa.
  - crie um webhook em algum repository do github com as seguintes configurações: 
    - Payload URL: <url_ngrok>/issues/events
    - Content type: application/json
    - Events: issues
  
Assim que uma issue é criada, deletada ou modificada a API salvará as informações do event no h2. Para buscá-las, basta utilizar o endpoint GET <url_ngrok>/issues/{number}/events. Para efeito de teste, o h2 esta configurado para criar as tabelas assim qua a aplicação é executada, por isso os dados serão apagados sempre que a aplicação for parada.
