package C09;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Reserva reserva = new Reserva(5656565,"Fran","garcia",4554654,8454575,12/11/23,21/11/23,"platano");
        Reserva reserva1 = new Reserva(5656565,"Fran","garcia",4554654,8454575,12/11/23,21/11/23,"platano");
        int[] resul = hotel.BuscaLibre(hotel);

        hotel.HacerReserva(hotel,reserva);
        hotel.HacerReserva(hotel,reserva1);
        hotel.AnularReserva(hotel,0,0);
        hotel.toString(hotel);

        System.out.println(resul[0]+resul[1]);
        System.out.print("\n"+hotel.hotel[0][0]);
        System.out.print("\n"+hotel.hotel[0][1]);

    }
}
