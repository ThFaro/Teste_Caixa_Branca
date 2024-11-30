
# **ERROS ENCONTRADOS NO CÓDIGO**

---

## **1. INJEÇÃO DE SQL**
- Concatenação direta de valores do usuário na consulta SQL, permitindo ataques de injeção.

---

## **2. CONEXÃO NÃO FECHADA**
- **`Connection`**, **`Statement`** e **`ResultSet`** não são fechados.

---

## **3. CREDENCIAIS HARD-CODED**
- As credenciais do banco de dados estão embutidas no código, comprometendo a segurança.

---

## **4. POSSÍVEL NullPointerException**
- Se a conexão falhar, o código pode gerar um **`NullPointerException`** ao tentar usar um objeto `null`.

---

## **5. EXPOSIÇÃO DE ERROS**
- O uso de **`e.printStackTrace()`** expõe informações sensíveis.
.

---

## **6. VALIDAÇÃO DE ENTRADA AUSENTE**
- Não há validação nos para **`login`** e **`senha`**.

---

## **7. SENHAS EM TEXTO PURO**
- O código assume que as senhas no banco de dados estão armazenadas em texto puro.

---

## **8. MENSAGENS DE ERRO GENÉRICAS**
- Os erros apresentados são genéricos, ou seja, falta clareza.

---



