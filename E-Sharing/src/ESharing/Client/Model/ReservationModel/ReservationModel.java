package ESharing.Client.Model.ReservationModel;

import ESharing.Shared.TransferedObject.Reservation;
import ESharing.Shared.Util.PropertyChangeSubject;

import java.time.LocalDate;
import java.util.List;

public interface ReservationModel extends PropertyChangeSubject {

    boolean makeNewReservation(Reservation reservation);
    boolean removeReservation(int advertisementID, int userID);
    List<Reservation> getUserReservations(int userID);
    List<Reservation> getReservationForAdvertisement(int advertisementID);
}
