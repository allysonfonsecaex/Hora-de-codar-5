public class BichinhoVirtual {

    String nome;
    int nivelDeFome = 50;
    int nivelFelicidade = 50;

    public BichinhoVirtual(String nome) {
        this.nome = nome;
    }

    public void alimentar() {
        nivelDeFome -= 10;
        if (nivelDeFome < 0) nivelDeFome = 0;
        System.out.println(this.nome + " foi alimentado. O nivel de fome diminuiu.");
    }

    public void brincar() {
        nivelFelicidade += 10;
        if (nivelFelicidade > 100) nivelFelicidade = 100;
        System.out.println(this.nome + " esta brincando e se sentindo mais feliz.");
    }

    public void verificarStatus() {
        System.out.println("\nStatus atual de " + this.nome + ":");
        System.out.println("- Nivel de fome: " + this.nivelDeFome);
        System.out.println("- Nivel de felicidade: " + this.nivelFelicidade);
    }

    public void passarTempo() {
        nivelDeFome += 5;
        nivelFelicidade -= 3;
        System.out.println(this.nome + " esta ficando mais faminto com o passar do tempo.");
    }
}