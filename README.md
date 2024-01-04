# Exercício
Obter as informações de um pedido contendo N itens, sendo N uma entrada fornecida pelo usuário. Em seguida, apresentar um resumo detalhado do pedido. As regras do exercício são:

1. **Seguir o seguinte diagrama de classe:**
   
   ![Diagrama de classe](https://github.com/LucasFrancoBN/exercicio_composicao/blob/master/img/diagrama_classe.png)
    

## Exemplo
```plaintext
Enter cliente data:
Name: Alex Green
Email: alex@gmail.com
Birth date (DD/MM/YYYY): 15/03/1985
Enter order data:
Status: PROCESSING
How many items to this order? 2
Enter #1 item data:
Product name: TV
Product price: 1000.00
Quantity: 1
Enter #2 item data:
Product name: Mouse
Product price: 40.00
Quantity: 2

ORDER SUMMARY:
Order moment: 20/04/2018 11:25:09
Order status: PROCESSING
Client: Alex Green (15/03/1985) - alex@gmail.com

Order items:
TV, $1000.00, Quantity: 1, Subtotal: $1000.00
Mouse, $40.00, Quantity: 2, Subtotal: $80.00
Total price: $1080.00
```

## Ferramentas
Desafio desenvolvido utilizando a linguagem Java e a IDE Intellij Community.


## Instruções de Uso
Antes de prosseguir com as instruções de uso, é requerido que você tenha em sua máquina o Java 20 e o git.

### Instalação
Antes de tudo, recomendo que você, pelo terminal, navegue até o diretório Desktop e rode o comando
```bash
# Clone o repositório
git clone https://github.com/LucasFrancoBN/exercicio_fixacao_composicao.git

# Acesse o diretório da classe Program
cd exercicio_fixacao_composicao/src/application
```
Agora basta você digitar no seu terminal
```bash
# Compile o projeto
javac Program.java ../entities/enums/OrderStatus.java ../entities/Product.java ../entities/OrderItem.java ../entities/Client.java ../entities/Order.java
```
Retroceda ao diretório src e compile o programa
```
# Retroceda ao diretório src
cd ../

# Execute o programa
java application.Program
```
