package C09;

public class Hotel {
    final int NPLANT=8;
    final int NHAB = 6;
    final String vacio="vacia";
    protected String [][] hotel = new String[NPLANT][NHAB];

    public Hotel(){
        int p,h;
        for(p=0;p<NPLANT;p++)
            for (h=0;h<NHAB;h++)
                this.hotel[p][h]=vacio;
    }



    public void VaciaHotel (Hotel hab)
    {
        int p,h;
        for(p=0;p<NPLANT;p++)
            for (h=0;h<NHAB;h++)
                hab.hotel[p][h]=vacio;
    }

    public void BuscaHabitación(Hotel hab, MinInteger planta, MinInteger habit){
        int p,h;
        for (p=0; p<NPLANT -1;p--){
            for (h=0;h<NHAB;h++){
                if (hab.hotel[p][h].equals(vacio)){
                    planta.setA(p);
                    habit.setA(h);
                    return;
                }
                planta.setA(-1);
            }
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
        return "Habitación:"+hab+" Planta:"+pla+" DNI: "+reserva.DNI+" Nombre y apellidos: "+reserva.nombre+","+reserva.apellido;
    }

    public void HacerReserva(Hotel hab,Reserva res){
        MinInteger p = new MinInteger(0);
        MinInteger h = new MinInteger(0);
        BuscaHabitación(hab,p,h);
        if (p.getA()!=-1) {
            hab.hotel[p.a][h.a]=getReserva(res,p.a,h.a);

        }else System.out.printf("Hotel lleno");

    }

    public  void AnularReserva(Hotel hab, int pl, int ha){
        hotel[pl][ha]=vacio;
    }

    public void toString (Hotel hab)
    {
        int p,h;
        System.out.print("   ");
        for (h=0;h<NHAB;h++)
            if (h<9) {
                System.out.printf("%d  ",h+1);
            } else   System.out.printf("%d ",h+1);
        System.out.print("\n");

        for(p=0;p<NPLANT;p++)
        {
            System.out.printf("%d  ", p+1);
            for (h=0;h<NHAB;h++)
                if (hab.hotel[p][h].equals(vacio)) System.out.print("L  ");
                else System.out.print("R  ");
            System.out.print("\n");
        }
    }


}
