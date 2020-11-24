/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailgenerator;

/**
 *
 * @author Marco
 */
public class MailGenerator {

    /**
     Habilitar Acesso a app menos seguro
     Conta Gmail > Configurações > Segurança > Acesso a app menos seguro
     */
    public static void main(String[] args) {
        Email.enviarEmail("Isso é um teste de disparo", "Teste Java MailGenerator", "luiz123jfmg@gmail.com");
    }

}
