package QuatroPilares;

public abstract class Bicho {

    private String nome;
    private int nivelDeFome;
    private int nivelFelicidade;
    private int nivelCansaco;
    private int idade;
    private int vontadeBanheiro;
    private int nivelSujeira;

    public Bicho(String nome) {
        setNome(nome);
        this.nivelDeFome = 50;
        this.nivelFelicidade = 50;
        this.nivelCansaco = 0;
        this.idade = 0;
        this.vontadeBanheiro = 0;
        this.nivelSujeira = 0;
    }

    public final String getNome() {
        return nome;
    }

    public final int getNivelDeFome() {
        return nivelDeFome;
    }

    public final int getNivelFelicidade() {
        return nivelFelicidade;
    }

    public final int getNivelCansaco() {
        return nivelCansaco;
    }

    public final int getIdade() {
        return idade;
    }

    public final void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do bicho não pode ser vazio.");
        }
        this.nome = nome.trim();
    }

    public void alimentar() {
        alterarFome(-15);
        vontadeBanheiro = limitarEntre0e100(vontadeBanheiro + 20);
        System.out.println(nome + " foi alimentado! A fome diminuiu e a vontade de ir ao banheiro aumentou.");
    }

    public void brincar() {
        alterarFelicidade(15);
        alterarCansaco(15);
        nivelSujeira = limitarEntre0e100(nivelSujeira + 15);
        System.out.println(nome + " brincou bastante! Ficou mais feliz, mas aumentou o cansaço e a sujeira.");
    }

    public void descansar(int horas) {
        if (horas >= 8) {
            nivelCansaco = 0;
            System.out.println(nome + " dormiu por " + horas + " horas e está totalmente descansado!");
        } else {
            int reducao = horas * 12;
            alterarCansaco(-reducao);
            System.out.println(nome + " descansou por " + horas + " horas. O cansaço diminuiu.");
        }
    }

    public void irAoBanheiro() {
        vontadeBanheiro = 0;
        System.out.println(nome + " foi ao banheiro e se sente aliviado!");
    }

    public void tomarBanho() {
        nivelSujeira = 0;
        System.out.println(nome + " tomou um banho e está limpinho!");
    }

    public void verificarStatus() {
        System.out.println("\n--- STATUS DE " + nome.toUpperCase() + " ---");
        System.out.println("🎂 Idade: " + idade + " / 50");
        System.out.println("🍖 Fome: " + nivelDeFome + " / 100");
        System.out.println("😊 Felicidade: " + nivelFelicidade + " / 100");
        System.out.println("💤 Cansaço: " + nivelCansaco + " / 100");
        System.out.println("🚽 Vontade de ir ao banheiro: " + vontadeBanheiro + " / 100");
        System.out.println("🧼 Sujeira: " + nivelSujeira + " / 100");
    }

    public void passarTempo() {
        alterarFome(3);
        alterarFelicidade(-3);
        alterarCansaco(10);
        idade += 1;
        System.out.println("⏰ O tempo passou... (" + nome + " envelheceu 1 ciclo)");
    }

    public boolean verificarDerrota() {
        if (nivelDeFome >= 100) {
            System.out.println("\n☠️ GAME OVER: " + nome + " faminto demais!");
            return true;
        }
        if (nivelCansaco >= 100) {
            System.out.println("\n☠️ GAME OVER: " + nome + " desmaiou de exaustão!");
            return true;
        }
        if (nivelFelicidade <= 0) {
            System.out.println("\n☠️ GAME OVER: " + nome + " ficou extremamente triste e foi embora!");
            return true;
        }
        if (vontadeBanheiro >= 100) {
            System.out.println("\n☠️ GAME OVER: " + nome + " teve um acidente grave por não ir ao banheiro a tempo!");
            return true;
        }
        if (nivelSujeira >= 100) {
            System.out.println("\n☠️ GAME OVER: " + nome + " ficou muito sujo e adoeceu!");
            return true;
        }
        return false;
    }

    public boolean verificarVitoria() {
        if (idade >= 50) {
            System.out.println("\n🎉 PARABÉNS! Você cuidou muito bem de " + nome + " e ele atingiu a idade de 50 anos com sucesso!");
            return true;
        }
        return false;
    }

    protected final void alterarFome(int delta) {
        nivelDeFome = limitarEntre0e100(nivelDeFome + delta);
    }

    protected final void alterarFelicidade(int delta) {
        nivelFelicidade = limitarEntre0e100(nivelFelicidade + delta);
    }

    protected final void alterarCansaco(int delta) {
        nivelCansaco = limitarEntre0e100(nivelCansaco + delta);
    }

    private int limitarEntre0e100(int valor) {
        return Math.max(0, Math.min(100, valor));
    }

    public abstract String emitirSom();
    public abstract void habilidadeEspecial();

    public void interagir() {
        System.out.println(nome + " diz: " + emitirSom());
    }
}