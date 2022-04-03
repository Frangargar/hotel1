package C09;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Reserva reserva = new Reserva(5656565,"Fran","garcia",4554654,8454575,12/11/23,21/11/23,"platano");
        Reserva reserva1 = new Reserva(5656565,"Sergio","garcia",4554654,8454575,12/11/23,21/11/23,"platano");

        hotel.HacerReserva(reserva,1,15);
        hotel.HacerReserva(reserva1,3,2);
        hotel.HacerReserva(reserva,2,2);
        hotel.HacerReserva(reserva1,1,2);
        //hotel.AnularReserva(hotel,reserva,1,3);
        hotel.AnularReserva(reserva1,1,1);

        System.out.println(hotel.toString());

        hotel.VaciaHotel();



    }
}
