# Solução para Problemas de Criação de Tabelas no PostgreSQL

## Problemas Identificados e Soluções Aplicadas:

### 1. Configuração do application.properties
- **Problema**: Faltavam configurações essenciais do Hibernate
- **Solução**: Adicionadas as seguintes configurações:
  ```properties
  spring.jpa.hibernate.ddl-auto=create-drop
  spring.jpa.show-sql=true
  spring.jpa.properties.hibernate.format_sql=true
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
  spring.jpa.properties.hibernate.hbm2ddl.auto=create-drop
  ```

### 2. Nome da Tabela "adocao"
- **Problema**: "adocao" é uma palavra reservada no PostgreSQL
- **Solução**: Alterado para "adocoes"

### 3. Configuração do Spring Boot
- **Problema**: Faltavam anotações para scan de entidades e repositórios
- **Solução**: Adicionadas as anotações:
  ```java
  @EntityScan("projeto_adocao.projeto.de.adocao.model")
  @EnableJpaRepositories("projeto_adocao.projeto.de.adocao.repository")
  ```

## Como Verificar se as Tabelas Foram Criadas:

### 1. Verificar no PostgreSQL:
```sql
-- Conectar ao banco de dados
\c meubanco

-- Listar todas as tabelas
\dt

-- Verificar tabelas específicas
SELECT table_name FROM information_schema.tables 
WHERE table_schema = 'public' 
AND table_type = 'BASE TABLE';
```

### 2. Verificar via Aplicação:
- Acesse: `http://localhost:8080/test/status`
- Se retornar "Aplicação está funcionando! Repositórios carregados com sucesso.", significa que as entidades foram carregadas

### 3. Verificar Logs:
- Com `spring.jpa.show-sql=true`, você verá no console os comandos SQL sendo executados
- Procure por mensagens como "Hibernate: create table..."

## Tabelas Esperadas:
- `usuarios`
- `pets`
- `adocoes`
- `avaliacoes`

## Se as Tabelas Ainda Não Forem Criadas:

1. **Verifique se o PostgreSQL está rodando**
2. **Verifique se o banco 'meubanco' existe**
3. **Verifique as credenciais (usuário: postgres, senha: root)**
4. **Reinicie a aplicação após as mudanças**

## Para Criar o Banco de Dados Manualmente:
```sql
CREATE DATABASE meubanco;
```

## Configuração Final Recomendada:
Após confirmar que as tabelas foram criadas, altere no `application.properties`:
```properties
spring.jpa.hibernate.ddl-auto=update
```
Isso evitará que as tabelas sejam recriadas a cada reinicialização da aplicação. 