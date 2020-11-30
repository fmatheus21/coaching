package com.firecode.app.controller.rule;

import com.firecode.app.controller.dto.CoacheeDto;
import com.firecode.app.controller.util.FormatLocalDatetUtil;
import com.firecode.app.model.entity.CoacheeEntity;
import com.firecode.app.model.entity.ContactEntity;
import com.firecode.app.model.entity.GenderEntity;
import com.firecode.app.model.entity.PersonEntity;
import com.firecode.app.model.entity.PersonTypeEntity;
import com.firecode.app.model.entity.UserEntity;
import com.firecode.app.model.service.PersonService;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TesteRule {

    @Autowired
    private PersonService personService;
    private final ArrayList<Integer> listaAleatoria;
    private ArrayList<Integer> listaNumMultiplicados = null;

    public TesteRule() {
        this.listaAleatoria = new ArrayList<>();
    }

    public void createCoachee() {

        for (int i = 0; i < 1000; i++) {
            PersonEntity person = new PersonEntity();
            CoacheeEntity coachee = new CoacheeEntity();
            ContactEntity contact = new ContactEntity();

            String name = this.generateName();
            String cpf = String.valueOf(i);

            person.setIdPersonType(new PersonTypeEntity(1));
            person.setNameCompanyname(name);
            person.setCpfCnpj(cpf);

            coachee.setIdPerson(person);
            coachee.setIdGender(new GenderEntity(1));
            coachee.setCasualName(name);
            coachee.setDateBirth(FormatLocalDatetUtil.currentDate());
            coachee.setCreatedAt(FormatLocalDatetUtil.currentDateTime());
            coachee.setUpdatedAt(FormatLocalDatetUtil.currentDateTime());
            coachee.setIdCreatedUser(new UserEntity(1));
            coachee.setIdUpdatedUser(new UserEntity(1));
            coachee.setImage(FormatLocalDatetUtil.returnsMillisecondsOfDateTime() + ".png");
            coachee.setSearch(
                    CoacheeDto.converterJson(
                            name,
                            cpf,
                            cpf + "@domain.com",
                            "21981964019"
                    )
            );
            person.setCoacheeEntity(coachee);

            contact.setIdPerson(person);
            contact.setEmail(cpf + "@domain.com");
            contact.setPhone("21981964019");
            /*contact.setFacebook(dto.getFacebook());
            contact.setInstagram(dto.getInstagram());
            contact.setTwitter(dto.getTwitter());*/
            person.setContactEntity(contact);

            personService.create(person);

        }
    }

    private String generateName() {
        // letras maisculas 65 - 90
        // letras minúsculas 97 - 122

        ThreadLocalRandom gerador = ThreadLocalRandom.current();

        int tamanhoNome = gerador.nextInt(3, 10);
        int tamanhoSobrenome = gerador.nextInt(3, 10);

        char primeiraLetraNome = (char) gerador.nextInt(65, 90);
        char primeiraLetraSobreNome = (char) gerador.nextInt(65, 90);

        StringBuilder nome = new StringBuilder().append(primeiraLetraNome);
        StringBuilder sobreNome = new StringBuilder().append(primeiraLetraNome);

        for (int i = 1; i < tamanhoNome; i++) {
            char letra = (char) gerador.nextInt(97, 122);
            nome.append(letra);
        }

        for (int i = 1; i < tamanhoSobrenome; i++) {
            char letra = (char) gerador.nextInt(97, 122);
            sobreNome.append(letra);
        }

        System.out.println(nome + " " + sobreNome);

        return nome + " " + sobreNome;
    }

    //Metodo para geracao de um numero aleatorio entre 0 e 9
    public int geraNumAleatorio() {
        //Note que foi preciso fazer um cast para int, ja que Math.random() retorna um double
        int numero = (int) (Math.random() * 10);

        return numero;
    }

    //Metodo para geracao de parte do nosso CPF (aqui geramos apenas os 9 primeiros digitos)
    public ArrayList<Integer> geraCPFParcial() {
        for (int i = 0; i < 9; i++) {
            listaAleatoria.add(geraNumAleatorio());
        }

        return listaAleatoria;
    }

    //Metodo para geracao do primeiro digito verificador (para isso nos baseamos nos 9 digitos aleatorios gerados anteriormente)
    public ArrayList<Integer> geraPrimeiroDigito() {
        listaNumMultiplicados = new ArrayList<>();
        int primeiroDigito;
        int totalSomatoria = 0;
        int restoDivisao;
        int peso = 10;

        //Para cada item na lista multiplicamos seu valor pelo seu peso
        for (int item : listaAleatoria) {
            listaNumMultiplicados.add(item * peso);

            peso--;
        }

        //Agora somamos todos os itens que foram multiplicados
        totalSomatoria = listaNumMultiplicados.stream().map(item -> item).reduce(totalSomatoria, Integer::sum);

        restoDivisao = (totalSomatoria % 11);

        //Se o resto da divisao for menor que 2 o primeiro digito sera 0, senao subtraimos o numero 11 pelo resto da divisao
        if (restoDivisao < 2) {
            primeiroDigito = 0;
        } else {
            primeiroDigito = 11 - restoDivisao;
        }

        //Apos gerar o primeiro digito o adicionamos a lista
        listaAleatoria.add(primeiroDigito);

        return listaAleatoria;
    }

    //Metodo para geracao do segundo digito verificador (para isso nos baseamos nos 9 digitos aleatorios + o primeiro digito verificador)
    public ArrayList<Integer> geraSegundoDigito() {
        listaNumMultiplicados = new ArrayList<>();
        int segundoDigito;
        int totalSomatoria = 0;
        int restoDivisao;
        int peso = 11;

        //Para cada item na lista multiplicamos seu valor pelo seu peso (observe que com o aumento da lista o peso tambem aumenta)
        for (int item : listaAleatoria) {
            listaNumMultiplicados.add(item * peso);

            peso--;
        }

        //Agora somamos todos os itens que foram multiplicados
        totalSomatoria = listaNumMultiplicados.stream().map(item -> item).reduce(totalSomatoria, Integer::sum);

        restoDivisao = (totalSomatoria % 11);

        //Se o resto da divisao for menor que 2 o segundo digito sera 0, senao subtraimos o numero 11 pelo resto da divisao
        if (restoDivisao < 2) {
            segundoDigito = 0;
        } else {
            segundoDigito = 11 - restoDivisao;
        }

        //Apos gerar o segundo digito o adicionamos a lista
        listaAleatoria.add(segundoDigito);

        return listaAleatoria;
    }

    //Agora que temos nossa lista com todos os digitos que precisamos vamos formatar os valores de acordo com a mascara do CPF
    public String geraCPF() {
        //Primeiro executamos os metodos de geracao
        geraCPFParcial();
        geraPrimeiroDigito();
        geraSegundoDigito();

        String cpf = "";
        String texto = "";

        /*Aqui vamos concatenar todos os valores da lista em uma string
        Por que isso? Porque a formatacao que o ArrayList gera me impossibilitaria de usar a mascara,
        pois junto com os numeros gerados ele tambem gera caracteres especias. Ex.: lista com inteiros (de 1 a 5)
        [1 , 2 , 3 , 4 , 5]
        Dessa forma o sistema geraria a excecao ParseException*/
        texto = listaAleatoria.stream().map(item -> Integer.toString(item)).reduce(texto, String::concat);

        //Dentro do bloco try.. catch.. tentaremos adicionar uma mascara ao nosso CPF
        try {
            /*MaskFormatter mf = new MaskFormatter("###.###.###-##");  
            mf.setValueContainsLiteralCharacters(false);
            cpf = mf.valueToString(texto);*/
            cpf = texto;
            System.out.println("cpf: " + cpf);
        } catch (Exception ex) {
        }
        return cpf;
    }

}
