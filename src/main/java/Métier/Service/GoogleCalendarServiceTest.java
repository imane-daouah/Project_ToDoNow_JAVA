package Métier.Service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.api.services.calendar.model.Event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Date;
import java.util.List;


import java.util.GregorianCalendar;

public class GoogleCalendarServiceTest {

    private static final String APPLICATION_NAME = "gestiontaches";
    @SuppressWarnings("deprecation")
	private static final JsonFactory JSON_FACTORY = new JacksonFactory();
    private static final List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR_READONLY);
    private static final String SERVICE_ACCOUNT_FILE_PATH = "src/main/resources/gestiontaches-422615-32c4af698297.json";

    public static void main(String[] args) throws ParseException {
        try {
            // Initialize Google Calendar service
            HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
            GoogleCredentials credentials = ServiceAccountCredentials
                    .fromStream(GoogleCalendarServiceTest.class.getResourceAsStream(SERVICE_ACCOUNT_FILE_PATH))
                    .createScoped(SCOPES);
            Calendar calendarService = new Calendar.Builder(httpTransport, JSON_FACTORY, new HttpCredentialsAdapter(credentials))
                    .setApplicationName(APPLICATION_NAME)
                    .build();

            // Create GoogleCalendarService instance
            GoogleCalendarService googleCalendarService = new GoogleCalendarService(calendarService);

            // Specify the user email and dates
            String userEmail = "smaildamouh47@gmail.com"; // Replace with the user's email
         // Création d'un format de date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Parsing d'une chaîne de date en objet Date
            Date startDate = dateFormat.parse("2024-05-06");
            Date endDate = dateFormat.parse("2024-05-09");

            // Retrieve tasks
            List<Event> tasks = googleCalendarService.getTasks(userEmail, startDate, endDate);

            // Print tasks
            System.out.println("Tasks:");
            for (Event task : tasks) {
                System.out.println(task.getSummary());
            }
        } catch (IOException | GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}