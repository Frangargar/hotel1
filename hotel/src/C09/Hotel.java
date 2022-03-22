package C09;

import java.util.Arrays;
import java.util.Objects;

public class Hotel {
    final int NPLANT=8;
    final int NHAB = 6;
    final int habitacion=1;
    final int suite=2;
    final int balcon=3;
    protected Reserva [][] hotel =new Reserva[NPLANT][NHAB] ;

    public Hotel(){
        int p,h;
        for(p=0;p<NPLANT;p++)
            for (h=0;h<NHAB;h++)
                hotel[p][h]=null;
    }



    public void VaciaHotel (Hotel hab)
    {
        int p,h;
        for(p=0;p<NPLANT;p++)
            for (h=0;h<NHAB;h++)
                hab.hotel[p][h]=null;
    }

    private void Anular(Reserva reserva,int tip,MinInteger planta,MinInteger habit){
        int p,h;
        switch (tip){
            case 1:
                for (p=7;p>2;p--){
                    for (h=0;h<NHAB;h++){
                        if(hotel[p][h]==null){
                            planta.setA(-1);
                        }else if(hotel[p][h]==reserva) {
                            planta.setA(p);
                            habit.setA(h);
                            return;
                        }
                    }
                }
                break;
            case 2:
                for (h = 0; h < NHAB; h++) {
                    if (hotel[0][h]==null) {
                        planta.setA(-1);
                    }else if(hotel[0][h]==reserva){
                        planta.setA(0);
                        habit.setA(h);
                        return;
                    }
                }
                break;
            case 3:
                for (p = 2; p > 1; p--) {
                    for (h = 0; h < NHAB; h++) {
                        if (hotel[p][h]==null) {
                            planta.setA(-1);
                        }else if(hotel[p][h]==reserva){
                            planta.setA(p);
                            habit.setA(h);
                            return;
                        }
                    }
                }
                break;
        }
    }

    private void BuscaHabitación(int tip, MinInteger planta, MinInteger habit){
        int p,h;
        switch (tip) {
            case 1:

                    for (p = 7; p > 2; p--) {
                        for (h = 0; h < NHAB; h++) {
                            if (hotel[p][h]==null) {
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
                            if (hotel[0][h]==null) {
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
                            if (hotel[p][h]==null) {
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


    public int[] BuscaLibre(){
        int p,h;
        for (p=0; p<NPLANT ;p++){
            for (h=0;h<NHAB;h++){
                if (hotel[p][h]==null){
                    return new int[]{p,h};
                }
            }
        }

        return new int[0];
    }

    public String getReserva(Reserva reserva,int pla, int hab){
        return "Habitación:"+hab+" Planta:"+(NPLANT-pla)+" DNI: "+reserva.DNI+" Nombre y apellidos: "+reserva.nombre+","+reserva.apellido;
    }

    public boolean HacerReserva(Reserva res,int tipo,int cantidad){
        MinInteger p = new MinInteger(0);
        MinInteger h = new MinInteger(0);
        for (int i=0;i<cantidad;i++) {
            BuscaHabitación(tipo, p, h);
            if (p.getA() != -1) {
                hotel[p.a][h.a] = res;

            } else return false;
        }
        return true;
    }

    public  boolean AnularReserva(Reserva reserva,int tipo, int cantidad){
        MinInteger p = new MinInteger(0);
        MinInteger h = new MinInteger(0);
        for (int i=0;i<cantidad;i++){
            Anular(reserva,tipo,p,h);
            if(p.getA()!=-1){
                hotel[p.a][h.a]=null;
            }else return false;
        }
        return true;
    }

    public String toString ()
    {
        int p,h,aux;
        aux=NPLANT;
        String str="a";
        for (h=0;h<NHAB;h++)
            if (h<9) {
                str= (h+1)+" ";
            } else   str= (h+1)+" ";
        str="\n";

        for(p=0;p<NPLANT;p++)
        {
            str= (aux)+"";
            for (h=0;h<NHAB;h++)
                if (hotel[p][h]==null) str= "L ";
                else str= "L ";
            str="\n";
            aux--;
        }
        return str;
    }


}
