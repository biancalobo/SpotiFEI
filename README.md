# Spotifei
Projeto de Arquitetura de Software e Programação Orientada a Objetos

# Sobre o projeto Spotifei

Spotifei é uma aplicação desktop desenvolvida em Java, utilizando o padrão MVC (Model-View-Controller), com interface gráfica via Java Swing e persistência de dados em PostgreSQL.

O projeto foi desenvolvido como atividade prática para a disciplina de Banco de Dados e Programação Orientada a Objetos, com o objetivo de consolidar os conhecimentos em:

Modelagem de banco de dados relacional

Programação orientada a objetos

Desenvolvimento de interfaces gráficas com Swing

Manipulação de banco de dados via JDBC

# Tecnologias utilizadas
- Java 8+

- Java Swing

- PostgreSQL

- Supabase para o database

- JDBC

- IDE NetBeans

- Git e GitHub

# Funcionalidades implementadas
- Cadastro e Autenticação
  Registro de novos usuários com: nome, nome de usuário, email e senha.

  Autenticação via tela de login.

  Verificação de credenciais no banco de dados.

- Gerenciamento de Músicas
  Busca de músicas por nome, gênero ou artista.

  Visualização de detalhes das músicas.

  Curtir e descurtir músicas com histórico armazenado no banco.

- Playlists
  Criação de playlists personalizadas.

  Edição de playlists: adição ou remoção de músicas.

  Exclusão de playlists.

  Associação de músicas a playlists via tabela playlist_musica.

- Histórico
  Visualização das últimas 10 músicas buscadas.

  Visualização das músicas curtidas e descurtidas.

  Armazenamento automático de histórico no banco de dados.

- Modelagem do Banco de Dados
  Tabelas:

  usuario

  musica

  artista

  musica_artista (relacionamento N:N)

  curtidas

  historico_busca

  playlist

  playlist_musica

  Relacionamentos com chaves estrangeiras garantindo a integridade referencial.

# Estrutura do Projeto
# Model
Representação das entidades: Usuario, Musicas, Artista, Playlist, Historico.

# DAO (Data Access Object)
UsuarioDAO → cadastro e autenticação.

MusicasDAO → busca e manipulação de músicas.

HistoricoDAO → manipulação de histórico e curtidas.

PlaylistDAO → gerenciamento de playlists.

# Controller
ControllerLogin → autenticação de usuário.

ControllerCadastro → cadastro de novos usuários.

ControllerMusicas → busca, curtir e descurtir músicas.

ControllerPlaylist → gerenciar playlists.

ControllerHistorico → visualizar histórico.

# View
Interfaces gráficas desenvolvidas em Java Swing:

PaginaLogin

PaginaCadastro

PaginaMusica

PaginaPlaylist

PaginaHistorico

Todas com design padronizado: cores escuras e destaque em rosa.

# Como executar o projeto
# Pré-requisitos
Java 8+

- PostgreSQL instalado e configurado

- IDE NetBeans (recomendado)

- Driver JDBC para PostgreSQL adicionado ao projeto

# Passos
1. Clone o repositório utilizando git clone <nome do repositório>

2. Configure o banco de dados:

3. Execute os scripts SQL fornecidos na pasta database/ para criar as tabelas e popular com dados iniciais.

4. Abra o projeto no NetBeans.

5. Ajuste as configurações de conexão no arquivo Conexao.java

String url = "jdbc:postgresql://localhost:5432/spotifei";
String user = "seu_usuario";
String password = "sua_senha";

6. Compile e execute:

Dê um Run.

# Exemplo de dados cadastrados
- Aurora → Runaway, Cure For Me

- The Boyz → Reveal, Thrill Ride

- Seventeen → Left & Right, Ready to Love

Todas associadas a artistas via musica_artista.

# Autora

Bianca Lobo Nascimento


