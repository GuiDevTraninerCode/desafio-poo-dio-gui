
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static List<Dev> listaDevs = new LinkedList<>();
    static List<Conteudo> listaCursoMentoria = new LinkedList<>();
    static List<Bootcamp> listaBootCamps = new LinkedList<>();

    public static void main(String[] args) {
          
       telaInicial();



        /*System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);*/
/*
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        devCamila.progredir();
        devCamila.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Camila:" + devCamila.getConteudosConcluidos());
        System.out.println("XP:" + devCamila.calcularTotalXp());

        System.out.println("-------");

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos João:" + devJoao.getConteudosConcluidos());
        System.out.println("XP:" + devJoao.calcularTotalXp());
*/
    }
    private static void telaInicial(){

         while(true){

            System.out.println("==|| Tela Inicial - Escolha a ação ||==");
            System.out.println("1.Tela de curso e mentoria.");
            System.out.println("2.Tela de bootCamp."); 
            System.out.println("3.Tela de Dev.");    
            System.out.println("4.Sair");
            
            int select = 0;
            try{ 
              select = sc.nextInt();
            }catch(InputMismatchException e){
              sc.nextLine();  
              msgRetorno();
              continue; 
            }    

            switch (select) {
                case 1:                 
                    telaCursoMentoria();
                    break;
                case 2:
                    telaBootCamp();
                    break; 
                case 3:
                    telaDev();
                    break; 
                case 4:
                    break;          
                default:
                    msgRetorno();
                    continue;
            } 


        }  

    }

    private static Conteudo telaCursoMentoria() {
        
        while(true){

            System.out.println("==|| Tela de criação de curso e mentoria. ||==");
            System.out.println("1.Crie um curso");
            System.out.println("2.Crie uma mentoria."); 
            System.out.println("3.Lista dos Cursos criados."); 
            System.out.println("4.Lista das Mnetorias criadas."); 
            System.out.println("5.Voltar."); 

            int select = 0;
            try{ 
              select = sc.nextInt();
            }catch(InputMismatchException e){
              sc.nextLine();    
              msgRetorno();
              continue; 
            }   
                         
            switch (select) {
                case 1:                 
                   criarCurso();
                   break;
                case 2:
                    criarMentoria();
                    break; 
                case 3:  
                    verCursos();                  
                    break;    
                case 4:
                    verMentorias();
                    break; 
                case 5:  
                    telaInicial();                  
                    break; 
                default:
                    msgRetorno();
                    continue;
            } 


        }
        
      
    }

    private static void telaBootCamp() {

       if(listaCursoMentoria.size()!=0){ 

        while(true){

            System.out.println("==|| Tela de criação de BootCamp. ||==");
            System.out.println("1.Crie um BootCamp");
            System.out.println("2.Adicione conteudo no BootCamp");
            System.out.println("3.Lista de BootCamps criados.");
            System.out.println("4.Voltar."); 

            int select = 0;
            try{ 
              select = sc.nextInt();
            }catch(InputMismatchException e){
              sc.nextLine();  
              msgRetorno();
              continue; 
            }   
                         
            switch (select) {
                case 1:                 
                    criarBootCamp();
                   break;
                case 2:
                    addCursoMentoria();
                    break;   
                case 3:
                    verBootCamp();
                    break; 
                case 4:  
                    telaInicial();                  
                    break; 
                default:
                    msgRetorno();
                    continue;
            } 
        
        }
      }else{
        System.out.println("============================================");
        System.out.println("Não há curso ou mentoria para criar BootCamp");
        System.out.println("============================================");
        System.out.println("Aperte qualquer letra e depois enter para sair");
        sc.next();
        telaInicial();
         
      } 


       // bootcamp.getConteudos().add(curso1);
        //bootcamp.getConteudos().add(curso2);
        //bootcamp.getConteudos().add(mentoria);
    
    }

    private static void addCursoMentoria() {

        System.out.println("Selecione o BootCamp.");
        int d = 1;
        for(Bootcamp bt : listaBootCamps){

            System.out.println(d+"-BootCamp: "+bt.getNome());         
            d++;
        }

        int selectBoot = 0;
        try{ 
              selectBoot = sc.nextInt();
         }catch(InputMismatchException e){
              sc.nextLine();  
              msgRetorno();         
        }        

        System.out.println("Selecione o Curso ou Mentoria.");        
        int i = 1;
        String mentCur = "Mentoria";
        for (Conteudo cm : listaCursoMentoria){
                 
                if(cm instanceof Curso){
                    mentCur = "Curso";
                }
                System.out.println(i+"-"+mentCur+":"+cm.getTitulo());         
          i++;
        }
        int selectConteudo = sc.nextInt();

        Bootcamp boot = listaBootCamps.get(selectBoot-1); 
        Conteudo conte = listaCursoMentoria.get(selectConteudo-1);
        
        boot.getConteudos().add(conte);

    }
    private static void telaDev() {

        if(listaCursoMentoria.size()!=0 && listaBootCamps.size()!=0){ 

            while(true){

                System.out.println("==|| Tela de criação de desenvolvedor. ||==");
                System.out.println("1.Crie um desenvolvedor.");
                System.out.println("2.Adicionar desenvolvedor no BootCamp.");
                System.out.println("3.Lista de desenvolvedores.");
                System.out.println("4.Progredir Dev.");
                System.out.println("5.Voltar."); 
            
                int select = 0;
                try{ 
                    select = sc.nextInt();
                }catch(InputMismatchException e){
                    sc.nextLine();  
                    msgRetorno();         
                } 

                switch (select) {
                    case 1:                 
                        criarDev();
                    break;
                    case 2:
                        adicionarDevCamp();
                    break; 
                    case 3:  
                        verDevs();                  
                    break; 
                    case 4:  
                        progredirDev();                  
                    break; 
                    case 5:  
                        telaDev();                  
                    break; 
                    default:
                        msgRetorno();
                    continue;
            } 
        
        }
      }else{

        if(listaCursoMentoria.size()==0){
            System.out.println("============================================");
            System.out.println("Não há curso ou mentoria para criar Dev");
            System.out.println("============================================");
            System.out.println("Aperte qualquer letra e depois enter para sair");
            sc.next();
            telaInicial();
        }

        if(listaBootCamps.size()==0){
            System.out.println("============================================");
            System.out.println("Não há BootCamp para criar Dev");
            System.out.println("============================================");
            System.out.println("Aperte qualquer letra e depois enter para sair");
            sc.next();
            telaInicial();
        }
         
      } 

        
    
    }
    private static void progredirDev() {

        if(listaDevs.size()!=0){  

            System.out.println("Selecione o desenvolvedor que vai progredir."); 
            int d = 1;
            for(Dev bt : listaDevs){

                System.out.println(d+"-Dev: "+bt.getNome());         
                d++;
            } 
            int selectDev = 0;
            try{ 
                selectDev = sc.nextInt();
            }catch(InputMismatchException e){
                sc.nextLine();  
                msgRetorno();         
            }       
            Dev dev = listaDevs.get(selectDev-1);
            dev.progredir();
            System.out.println("==============================================");
            System.out.println("Dev: "+dev.getNome()+" progrediu! XP:"+dev.calcularTotalXp());
            System.out.println("==============================================");
            System.out.println("Aperte qualquer letra e depois enter para sair");
            sc.next();
            telaDev();
        }else{

            System.out.println("============================================");
            System.out.println("Não existe Dev para progredir!");
            System.out.println("============================================");
            System.out.println("Aperte qualquer letra e depois enter para sair");
            sc.next();
            telaDev();

        }    

    }
    private static void criarDev() {

        Dev desenv = new Dev();
        sc.nextLine();
        System.out.println("Digite o nome do desenvolvedor");
        String nome = sc.nextLine();
        desenv.setNome(nome);
        listaDevs.add(desenv);
        System.out.println("Criou: "+desenv.getNome());
        telaDev();

    }
    private static void verDevs() {
       
        if(listaDevs.size()!=0){  

            System.out.println("==| Devs Cadastrados |==");
            int i = 1;
            for(Dev dv : listaDevs){
            
                System.out.println(i+"-Dev: "+dv.getNome()+" XP: "+dv.calcularTotalXp()); 
                System.out.println("Conteúdos Inscritos");
                int j = 1;
                String mentCur = "Mentoria";
                for (Conteudo cm : dv.getConteudosInscritos()){
                 
                    if(cm instanceof Curso){
                        mentCur = "Curso";
                    }
                    System.out.println(" "+j+"-"+mentCur+":"+cm.getTitulo());               
                    j++;
                }
                System.out.println("----------------------------");
                System.out.println("Conteúdos Concluídos");
                String mentCur2 = "Mentoria";
                int l = 1;            
                for (Conteudo cm : dv.getConteudosConcluidos()){
                 
                    if(cm instanceof Curso){
                        mentCur2 = "Curso";
                    }
                    System.out.println(" "+l+"-"+mentCur2+":"+cm.getTitulo());                
                    l++;
                }
                System.out.println("----------------------------");
                i++;
            }
            System.out.println("=============================");
            System.out.println("Aperte qualquer letra e depois enter para sair");
            sc.next();
            telaDev();
        }else{
            System.out.println("============================================");
            System.out.println("Não existe Dev para ver!");
            System.out.println("============================================");
            System.out.println("Aperte qualquer letra e depois enter para sair");
            sc.next();
            telaDev();
        }    

    }
    private static void adicionarDevCamp() {
        
        if(listaDevs.size()!=0){

            System.out.println("Selecione um desenvolvedor."); 
            int d = 1;
            for(Dev bt : listaDevs){

                System.out.println(d+"-Dev: "+bt.getNome());         
                d++;
            } 
            int selectDev = 0;
            try{ 
                selectDev = sc.nextInt();
            }catch(InputMismatchException e){
                sc.nextLine();  
                msgRetorno();         
            }       
   
            System.out.println("Selecione um BootCamp.");        
            int i = 1;
            for(Bootcamp bt : listaBootCamps){

                System.out.println(i+"-BootCamp: "+bt.getNome());         
                i++;
            }
        
            int selectCamp = 0;
            try{ 
                selectCamp = sc.nextInt();
            }catch(InputMismatchException e){
                sc.nextLine();  
                msgRetorno();         
            }  
        
            Dev dev = listaDevs.get(selectDev-1);
            Bootcamp boot = listaBootCamps.get(selectCamp-1);
            dev.inscreverBootcamp(boot);

        }else{

            System.out.println("============================================");
            System.out.println("Não existe Dev para adicionar no bootcamp!");
            System.out.println("============================================");
            System.out.println("Aperte qualquer letra e depois enter para sair");
            sc.next();
            telaDev();

        } 
    
    }    
    private static void msgRetorno() {
        System.out.println("========================");
        System.out.println("Digite um número válido!");
        System.out.println("========================");
    
    }

    private static void criarMentoria() {

        sc.nextLine(); 
        System.out.println("Adicione um título a mentoria:");    
        String tituloMentoria = sc.nextLine();
        
        System.out.println("Adicione uma descrição:");
        String descricaoMentoria = sc.nextLine(); 
              
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo(tituloMentoria);
        mentoria.setDescricao(descricaoMentoria);
        mentoria.setData(LocalDate.now());

        System.out.println("");
        System.out.println("Mentoria Criada!!!");
        System.out.println(mentoria.getTitulo());
        System.out.println("");
       
        listaCursoMentoria.add(mentoria);  
    
    }

    private static void criarCurso() {

        sc.nextLine(); 
        System.out.println("Adicione um título ao curso");
        String tituloCurso = sc.nextLine();
        
        System.out.println("Adicione uma descrição:");
        String descricaoCurso = sc.nextLine();
        
        System.out.println("Qual será a carga horária:");
        int cargaHorariaCurso = sc.nextInt();

        System.out.println(tituloCurso+" - "+descricaoCurso+" - "+cargaHorariaCurso);

        Curso curso = new Curso();
        curso.setTitulo(tituloCurso);
        curso.setDescricao(descricaoCurso);
        curso.setCargaHoraria(cargaHorariaCurso); 

        System.out.println("");
        System.out.println("Curso Criado!!!");
        System.out.println(curso.getTitulo());
        System.out.println("");

        listaCursoMentoria.add(curso);  
   
    }

    private static void verMentorias() {
       
        System.out.println("==| Mentorias Cadastradas |==");
        int i = 1;
        for(Conteudo mt : listaCursoMentoria){

            if(mt instanceof Mentoria){
                System.out.println(i+"-"+mt.getTitulo());
            }
            i++;
        }
        System.out.println("==========================");
        System.out.println("Aperte qualquer letra e depois enter para sair");
        sc.next();
        telaCursoMentoria();
    }
    private static void verCursos() {

        System.out.println("==| Cursos Cadastrados |==");
        int i = 1;
        for(Conteudo cs : listaCursoMentoria){
            
            if(cs instanceof Curso){
                System.out.println(i+"-"+cs.getTitulo());                
            }
            i++;
        }
        System.out.println("==========================");
        System.out.println("Aperte qualquer letra e depois enter para sair");
        sc.next();
        telaCursoMentoria();

    }

    private static void verBootCamp() {
        
        System.out.println("==| BootCamps Cadastrados |==");
        int i = 1;
        for(Bootcamp bt : listaBootCamps){
            
            System.out.println(i+"-BootCamp:"+bt.getNome()); 
            
            int j = 1;
            String mentCur = "Mentoria";
            for (Conteudo cm : bt.getConteudos()){
                 
                if(cm instanceof Curso){
                    mentCur = "Curso";
                }
                System.out.println(" "+j+"-"+mentCur+":"+cm.getTitulo());
                j++;
            }

            System.out.println("----------------------------");
            i++;
        }
        System.out.println("=============================");
        System.out.println("Aperte qualquer letra e depois enter para sair");
        sc.next();
        telaBootCamp();


    }
    private static void criarBootCamp() {
        
        sc.nextLine();
        System.out.println("Qual será o nome do BootCamp:");
        String nomeBootCamp = sc.nextLine();
        System.out.println("Adicione uma descrição:");
        String descricaoBootCamp = sc.nextLine(); 

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome(nomeBootCamp);
        bootcamp.setDescricao(descricaoBootCamp);
   
        while(true){

            System.out.println("Selecione o Curso ou Mentoria a adicionar no BootCamp");
            int i = 1;
            String mentCur = "Mentoria";
            for (Conteudo cm : listaCursoMentoria){
                 
                if(cm instanceof Curso){
                    mentCur = "Curso";
                }
                System.out.println(i+"-"+mentCur+":"+cm.getTitulo());
                i++;
            }

            int selec = 0;
            try{ 
                selec = sc.nextInt();
            }catch(InputMismatchException e){
                sc.nextLine();  
                msgRetorno();         
            } 
         
            bootcamp.getConteudos().add(listaCursoMentoria.get(selec-1));
            break;

        } 
       listaBootCamps.add(bootcamp);

    }

}
