package mini_twitter.follow_service.webclient;

import mini_twitter.follow_service.dto.ApiResponseWrapper;
import mini_twitter.follow_service.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class UserServiceClient {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceClient.class);

    @Autowired
    private RestTemplate restTemplate;

    public String getUserIdFromToken(String token) {
        String url = "http://localhost:8081/api/users/me";

        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            logger.error("Error fetching user ID from token: {}", token, e);
            throw new RuntimeException("Failed to get user ID from token");
        }
    }

    // Fetch user details by ID
    public UserResponseDto getUserById(String userId) {
        String url = "http://localhost:8081/api/users/" + userId;

        try {
            ApiResponseWrapper response = restTemplate.getForObject(url, ApiResponseWrapper.class);

            if (response != null) {
                return response.getData();
            } else {
                logger.error("No response received for user ID: {}", userId);
                return null;
            }
        } catch (Exception e) {
            logger.error("Error fetching user with ID: {}", userId, e);
            throw new RuntimeException("Failed to get user details");
        }
    }
}
