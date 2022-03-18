package C09;

import java.util.Arrays;
import java.util.Objects;

public class Hotel {
    final int NPLANT=8;
    final int NHAB = 6;
    final String vacio="vacia";
    final int habitacion=1;
    final int suite=2;
    final int balcon=3;
    protected String [][] hotel =new String[NPLANT][NHAB] ;

    public Hotel(){
        int p,h;
        for(p=0;p<NPLANT;p++)
            for (h=0;h<NHAB;h++)
                hotel[p][h]=vacio;
    }



    public void VaciaHotel (Hotel hab)
    {
        int p,h;
        for(p=0;p<NPLANT;p++)
            for (h=0;h<NHAB;h++)
                hab.hotel[p][h]=vacio;
    }

    private void Anular(Hotel hab,Reserva reserva,int tip,MinInteger planta,MinInteger habit){
        int p,h;
        switch (tip){
            case 1:
                for (p=7;p>2;p--){
                    for (h=0;h<NHAB;h++){
                        if(hab.hotel[p][h].equals(vacio)){
                            planta.setA(-1);
                        }else if(hab.hotel[p][h].equals(getReserva(reserva,p,h))) {
                            planta.setA(p);
                            habit.setA(h);
                            return;
                        }
                    }
                }
                break;
            case 2:
                for (h = 0; h < NHAB; h++) {
                    if (hab.hotel[0][h].equals(vacio)) {
                        planta.setA(-1);
                    }else if(hab.hotel[0][h].equals(getReserva(reserva,0,h))){
                        planta.setA(0);
                        habit.setA(h);
                        return;
                    }
                }
                break;
            case 3:
                for (p = 2; p > 1; p--) {
                    for (h = 0; h < NHAB; h++) {
                        if (hab.hotel[p][h].equals(vacio)) {
                            planta.setA(-1);
                        }else if(hab.hotel[p][h].equals(getReserva(reserva,p,h))){
                            planta.setA(p);
                            habit.setA(h);
                            return;
                        }
                    }
                }
                break;
        }
    }

    private void BuscaHabitación(Hotel hab,int tip, MinInteger planta, MinInteger habit){
        int p,h;
        switch (tip) {
            case 1:

                    for (p = 7; p > 2; p--) {
                        for (h = 0; h < NHAB; h++) {
                            if (hab.hotel[p][h].equals(vacio)) {
                                planta.setA(p);
                                habit.setA(h);
                                return;
                            }
                            planta.setA(-1);
                        }
                    }
            break;
            case 2:

                        for (h = 0; h < NHAB; h++) {
                            if (hab.hotel[0][h].equals(vacio)) {
                                planta.setA(0);
                                habit.setA(h);
                                return;
                            }
                            planta.setA(-1);
                        }

                break;
            case 3:
                    for (p = 2; p > 1; p--) {
                        for (h = 0; h < NHAB; h++) {
                            if (hab.hotel[p][h].equals(vacio)) {
                                planta.setA(p);
                                habit.setA(h);
                                return;
                            }
                            planta.setA(-1);
                        }
                    }
                break;

        }
    }


    public int[] BuscaLibre(Hotel hab){
        int p,h;
        for (p=0; p<NPLANT -1;p--){
            for (h=0;h<NHAB;h++){
                if (hab.hotel[p][h].equals(vacio)){

                    return new int[]{p,h};
                }
                return new int[]{0};
            }
        }

        return new int[0];
    }

    public String getReserva(Reserva reserva,int pla, int hab){
        return "Habitación:"+hab+" Planta:"+(NPLANT-pla)+" DNI: "+reserva.DNI+" Nombre y apellidos: "+reserva.nombre+","+reserva.apellido;
    }

    public boolean HacerReserva(Hotel hab,Reserva res,int tipo,int cantidad){
        MinInteger p = new MinInteger(0);
        MinInteger h = new MinInteger(0);
        for (int i=0;i<cantidad;i++) {
            BuscaHabitación(hab,tipo, p, h);
            if (p.getA() != -1) {
                hab.hotel[p.a][h.a] = getReserva(res,p.a,h.a);

            } else return false;
        }
        return true;
    }

    public  boolean AnularReserva(Hotel hab,Reserva reserva,int tipo, int cantidad){
        MinInteger p = new MinInteger(0);
        MinInteger h = new MinInteger(0);
        for (int i=0;i<cantidad;i++){
            Anular(hab,reserva,tipo,p,h);
            if(p.getA()!=-1){
                hab.hotel[p.a][h.a]=vacio;
            }else return false;
        }
        return true;
    }

    public void toString (Hotel hab)
    {
        int p,h,aux;
        aux=NPLANT;
        System.out.print("   ");
        for (h=0;h<NHAB;h++)
            if (h<9) {
                System.out.printf("%d  ",h+1);
            } else   System.out.printf("%d ",h+1);
        System.out.print("\n");

        for(p=0;p<NPLANT;p++)
        {
            System.out.printf("%d  ", aux);
            for (h=0;h<NHAB;h++)
                if (hab.hotel[p][h].equals(vacio)) System.out.print("L  ");
                else System.out.print("R  ");
            System.out.print("\n");
            aux--;
        }
    }


}
