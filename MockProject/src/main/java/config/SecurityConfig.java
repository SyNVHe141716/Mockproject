package config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecurityConfig {
	public static final String ROLE_MANAGER = "MANAGER";
	public static final String ROLE_EMPLOYEE = "EMPLOYEE";

	// String: Role
	// List<String>: urlPatterns.
	private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

	static {
		init();
	}

	private static void init() {

		// Cấu hình cho vai trò "EMPLOYEE".
		List<String> urlPatterns1 = new ArrayList<String>();

		urlPatterns1.add("/parking-lot-list");
		urlPatterns1.add("/add-parking-lot");
		urlPatterns1.add("/parking-lot-search");
		urlPatterns1.add("/parking-lot-delete");
		urlPatterns1.add("/parking-lot-edit");
		urlPatterns1.add("/TicketListController");
		urlPatterns1.add("/EditTicketController");
		urlPatterns1.add("/DeleteTicketController");
		urlPatterns1.add("/TripAddController");
		urlPatterns1.add("/TripListController");
		urlPatterns1.add("/TripUpdateController");
		urlPatterns1.add("/TripDeleteController");
		urlPatterns1.add("/ListCarController");
		urlPatterns1.add("/AddCarController");
		urlPatterns1.add("/UpdateCarController");
		urlPatterns1.add("/SearchCarController");
		urlPatterns1.add("/DeleteController");
		urlPatterns1.add("/AddBookingController");
		urlPatterns1.add("/BookingListController");
		urlPatterns1.add("/search");
		urlPatterns1.add("/delete");
		urlPatterns1.add("/UpdateBookingController");

		mapConfig.put(ROLE_EMPLOYEE, urlPatterns1);

		// Cấu hình cho vai trò "MANAGER".
		List<String> urlPatterns2 = new ArrayList<String>();

		urlPatterns2.add("/ListEmployeeController");
		urlPatterns2.add("/AddEmployeeController");
		urlPatterns2.add("/DeleteEmployeeController");
		urlPatterns2.add("/ViewEmployeeController");

		mapConfig.put(ROLE_MANAGER, urlPatterns2);
	}

	public static Set<String> getAllAppRoles() {
		return mapConfig.keySet();
	}

	public static List<String> getUrlPatternsForRole(String role) {
		return mapConfig.get(role);
	}

}
