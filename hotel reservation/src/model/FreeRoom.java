package model;

public class FreeRoom extends Room{

    public FreeRoom(String roomNumber, Double roomPrice, RoomType roomType){
        super(roomNumber, (double)0, roomType);
    }

    @Override
    public String toString(){
        return "Room number: " + this.roomNumber + " " + this.roomType + " bed, the price is Free! ";
    }

}
