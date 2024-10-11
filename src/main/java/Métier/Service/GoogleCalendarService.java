package Métier.Service;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class GoogleCalendarService {
    private Calendar calendarService;

    public GoogleCalendarService(Calendar calendarService) {
        this.calendarService = calendarService;
    }

    public List<Event> getTasks(String userEmail, Date startDate, Date endDate) throws IOException {
        // Construire l'identifiant du calendrier de l'utilisateur à partir de son adresse e-mail
        String calendarId = "primary"; // Par défaut, l'identifiant du calendrier principal de l'utilisateur
        if (!userEmail.equals("primary")) {
            calendarId = "calendars/" + userEmail;
        }

        // Convertir les dates en objets DateTime
        DateTime startTime = new DateTime(startDate);
        DateTime endTime = new DateTime(endDate);

        // Récupérer les événements (tâches) du calendrier de l'utilisateur entre les dates spécifiées
        List<Event> tasks = calendarService.events().list(calendarId)
                .setOrderBy("startTime")
                .setSingleEvents(true)
                .setTimeMin(startTime)
                .setTimeMax(endTime)
                .execute()
                .getItems();
        return tasks;
    }
}