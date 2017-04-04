package demo.adapter;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.cache.annotation.Cacheable;

@Service
public class UserAdapter {

    @Cacheable("users")
    public User getUserDetail(long userId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9001/user/" + userId;
        User user = restTemplate.getForObject(url, User.class);
        return  user;
    }

}


