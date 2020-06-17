import java.util.*;
import java.util.Scanner;
import java.util.Arrays;
import javax.swing.JOptionPane;
public class ColaNum 
{///////PUBLIC CLASS COLANUM
private int MAX,FRENTE,FINAL;
public int[]COLANUM;

public ColaNum()
{////ARREGLO
    this.MAX=0;
    this.FRENTE=0;
    this.FINAL=0;
    this.COLANUM=new int[this.MAX+1];
    
}////ARREGLO
public ColaNum(int MAX)
{
    this.MAX=100;
    this.FRENTE=0;
    this.FINAL=0;
    this.COLANUM=new int[this.MAX+1];
}

public boolean ColaLlena()
{//COLA LLENA
     if(this.FINAL==this.MAX)
     {
         return true;
     }
     else
     {
         return false;
     }
}//COLA LLENA
public boolean ColaVacia()
    {///////COLA VACIA
        if(this.FRENTE==this.FINAL)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }/////COLA VAcI
    
   public void Llenar()
   {////LLENAR
       if(this.ColaLlena())
       {
  JOptionPane.showMessageDialog(null,"LA COLA ESTÁ LLENA");
       }
       else
       {
           int NumDATOS;
            NumDATOS = Integer.parseInt(JOptionPane.showInputDialog(null,"INGRESE EL NUMERO DE DATOS"));
           int empieza=1,termina=100;
           
           int[]numeros=new int[NumDATOS];
           Random rnd = new Random();
           int n;
           for(int i=0;i<numeros.length;i++)
           {
               do
               {
                   n=rnd.nextInt(termina-empieza+1)+empieza;
               }
               while(Contieneono(numeros,i,n));
               numeros[i]=n;
               int DATOS=n;
               if(DATOS>101)
               {
       JOptionPane.showMessageDialog(null,"EXCEDE EL LIMITE DE LA COLA");
               }
               else
               {
                   this.FINAL++;
                   this.COLANUM[FINAL]=DATOS;  
               }
               
                   
           }
           
            
       }
       
   }////LLENAR
   public static boolean Contieneono(int[] numeros,int in,int valor)
   {
      
       for(int i=0;i<in;i++)
       {
           if(numeros[i]==valor)
           {
               return true;
           }
       }
       return false;
   }
   
    public void  MOSTRAR()
    {///MOSTRAR
        if(this.ColaVacia()) 
    {
        JOptionPane.showMessageDialog(null,"LA COLA ESTÁ VACIA\n NO HAY DATOS QUE MOSTRAR","MOSTRAR NOMBRES",JOptionPane.WARNING_MESSAGE);
    }
    else
    {
        String MOSTRAR="";
        for(int i=FRENTE+1;i<=FINAL;i++)
        {
            MOSTRAR =MOSTRAR+COLANUM[i]+"\n";
        }
        JOptionPane.showMessageDialog(null,"SE TIENEN ESTOS DATOS EN LA COLA ACTUALMENTE: "+this.FINAL+"\n"+"LOS NUMEROS SON: \n"+MOSTRAR,"NUMEROS",JOptionPane.INFORMATION_MESSAGE);
       
    }
    }////MOSTRAR
    
    public void ELIMINAR()
    
    {/////////ELIMINAR
    if(this.FRENTE==this.FINAL)
    {
        JOptionPane.showMessageDialog(null,"LA COLA ESTA VACIA");
    }
    else
    
    {
     for(int i=FRENTE;i<FINAL-1;i++)
     
     {
      COLANUM[i]=COLANUM[i];   
     }
     FINAL--;
    }
    }///////ELIMINAR
    
    public void VACIAR()
    {
        FRENTE=0;
        FINAL=0;
    } 

public  static int[] ordenar(int[]COLANUM)

{
    int auxiliar;
    int[]arregloordenado;
    for(int i=0;i<COLANUM.length-1;i++)
    {
        for(int j=0;j<COLANUM.length-1;j++)
        {
            if(COLANUM[j]>COLANUM[j+1])
            {
                auxiliar=COLANUM[j+1];
                COLANUM[j+1]=COLANUM[j];
                COLANUM[j]=auxiliar;
            }
        }
    }
    
            arregloordenado=COLANUM;
            return arregloordenado;
            
}

public void Burbuja()
{
    
       
            
            int arregloordenado[]=ordenar(COLANUM);
            for(int i=0;i<arregloordenado.length;i++)
            {
                String ORDEN="";
                for(int h=FRENTE+1;h<=FINAL;h++)
                {
                    ORDEN=ORDEN+COLANUM[i]+"\n";
                }
              JOptionPane.showMessageDialog(null,"SE TIENEN ESTOS DATOS EN LA COLA ACTUALMENTE: "+this.FINAL+"\n"+"LOS NUMEROS SON: \n"+ORDEN ,"NUMEROS",JOptionPane.INFORMATION_MESSAGE);
            }
  
}










    
    public static ColaNum COLNUM;
    public static void main(String[] args) 
    {//////MAIN MENU
      int MAX;
        MAX= Integer.parseInt(JOptionPane.showInputDialog(null,"INGRESE EL TAMAÑO DE LA COLA"));
        COLNUM=new ColaNum(MAX);
        if(MAX>100||MAX<=0)
        {
              JOptionPane.showMessageDialog(null,"LA COLA SOLO ADMITE 100 DATOS");
        }
        
        else
        {
        MENUCOLA();
        }
    }//////MAIN MENU
    public static void MENUCOLA()
    {
         int opcion;
        do
        {
            opcion=Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1. INGRESAR NOMBRES \n"+
                    "2. MOSTRAR NOMBRES\n"+
                    "3. ELIMINAR NOMBRES\n"+
                    "4. ORDENAR NOMBRES\n"+
                    "5. VACIAR PILA\n"+
                    "6. SALIR\n"+
                    "****************************************\n"+
                    "ESCOJA UNA OPCION","MENU COLA",JOptionPane.QUESTION_MESSAGE));
            switch(opcion)
            {
                
                case 1:COLNUM.Llenar();break;
                case 2: COLNUM.MOSTRAR();break;
               
                case 3: COLNUM.ELIMINAR();break;
                
                case 4: COLNUM.Burbuja();break;
                
                case 5:COLNUM.VACIAR(); ;break;
                
                case 6: System.exit(0);break;
                
                default: JOptionPane.showMessageDialog(null,"INGRESE UNA OPCION VALIDA \n","ERROR OPCION",JOptionPane.WARNING_MESSAGE);break;
            }
        }
        while(true);
    }
    
   
}/////////PUBLIC CLASS COLANUM
