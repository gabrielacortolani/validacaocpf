public class Cliente {
    private String nome;
    private String cpf;
    private String endereco;
    private int idade;

    // Fazer os metodos de consulta - GET
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    // E os metodos modificadores -SET
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        // Esta atribuição não vamos permitir
        // Vamos verificar
        if (validarCPF(cpf)) {
            this.cpf = cpf;
        }else{
            System.out.println("CPF Inválido");
        }
    }
    

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean validarCPF(String cpf){
        cpf = cpf.replace("-", ""); // substitui
        cpf = cpf.replace(".", "");
        // Se tamanho for diferente de 11 retorna falso
        if (cpf.length()!= 11){
            return false;
        }
        // Se cpf estive entre esses valores, retorna falso;
        if (cpf.equals("00000000000")||
            cpf.equals("11111111111")||
            cpf.equals("22222222222")||
            cpf.equals("33333333333")||
            cpf.equals("44444444444")||
            cpf.equals("55555555555")||
            cpf.equals("66666666666")||
            cpf.equals("77777777777")||
            cpf.equals("88888888888")||
            cpf.equals("99999999999") ){
                return false;
            }
        
        //Buscando primeiro digito validador
        int peso = 10;
        int soma = 0;
        for (int i = 0; i <= 8; i++){
            soma = soma + Integer.parseInt(cpf.substring(i, i+1)) * peso;
            peso = peso -1;
        }
        int resultado = 11 - (soma%11);
        int digito1;
        if ((resultado == 10) || (resultado == 11)){
            digito1 = 0;
        }else{
            digito1 = resultado;
        }
        
        //Buscando segundo digito validador
        peso = 11;
        soma = 0;
        for (int i = 0; i <= 9; i++){
            soma = soma + Integer.parseInt(cpf.substring(i, i+1)) * peso;
            peso = peso -1;
        }
        resultado = 11 - (soma%11);
        int digito2;
        if ((resultado == 10) || (resultado == 11)){
            digito2 = 0;
        }else{
            digito2 = resultado;
        }
        
        if ((Integer.parseInt(cpf.substring(9, 10)) != digito1) || (Integer.parseInt(cpf.substring(10, 11)) != digito2)){
            return false;
        }

        return true;
    }

}