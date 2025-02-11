class Flight:
    def __init__(self, flight_number, destination, capacity, booked_seats ):
        self.__flight_number = flight_number
        self.__destination = destination
        self.__capacity = capacity
        self.__booked_seats = booked_seats

    def get_flight_number(self):
        return self.__flight_number
    
    def get_destination(self):
        return self.__destination
    
    def get_capacity(self):
        return self.__capacity
    
    def get_booked_seats(self):
        return self.__booked_seats
        
    def set_capacity(self, capacity):
        if capacity >= self.__booked_seats:
             self.__capacity = capacity
        else:
            raise ValueError("Invalid capacity: must be at least the number of booked seats.")
    
    def book_seat(self):
        if self.__booked_seats < self.__capacity:
            self.__booked_seats += 1
        else:
            raise ValueError("No available seats.")

    def cancel_seat(self):
        if self.__booked_seats >= 1:
            self.__booked_seats -= 1
        else:
            raise ValueError("No bookings to cancel")


class Passenger:
    

    def __init__(self, passenger_id, name, _conatct_number, _flight_booked=None):
        self.__passenger_id = passenger_id
        self.__name = name
        self.__contact_number = _conatct_number
        self.__flight_booked = _flight_booked

    def get_passenger_id(self):
        return self.__passenger_id
    def get_name(self):
        return self.__name
    def get_contact_number(self):
        return self.__contact_number
    def get_flight_booked(self):
        return self.__flight_booked
    
    def set_contact_number(self, _contact_number):
        if len(_contact_number) == 10:
            self.__contact_number = _contact_number
        else:
            raise ValueError("Invalid contact number. Must be 10 digits.")

    def book_flight(self, flight: Flight) -> None:
        if self.__flight_booked == "":
            self.__flight_booked = flight
            flight.book_seat()
        else:
            raise ValueError("Passenger has already booked a flight.")

    def cancel_flight(self):
        if self.__flight_booked is None:
            raise ValueError("No booking exists to cancel.")
        self.__flight_booked.cancel_seat()
        self.__flight_booked = None

flight1 = Flight("AI101", "New York", 200, 150)
print(flight1)

passenger2 = Passenger("P123", "Sarah Connor", "9876543210")
print(passenger2)

passenger2.book_flight(flight1)
print(passenger2)
print(flight1)

passenger2.cancel_flight()
print(passenger2)
print(flight1)





