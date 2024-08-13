
public class Main {

	
	public static void main(String[] args) {
		banco();
	}

	public static void banco() {
		
		Banco banco = new Banco("BancoMais");
		
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Cliente 1");
		
		banco.criarContaCorrente(cliente1);
		banco.criarContaPoupanca(cliente1);
		banco.obterConta(1, 1).depositar(100.0);
		
		banco.obterConta(1, 1).transferir(80.0, banco.obterConta(1, 2));
		banco.obterConta(1, 2).sacar(50d);
		banco.obterConta(1, 1).imprimirExtrato();
		banco.obterConta(1, 2).imprimirExtrato();
		
	}
}
