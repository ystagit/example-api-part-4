package ua.share.exp.api.services;

import org.springframework.stereotype.Service;
import ua.share.exp.api.models.UserProfile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserProfileService {

    private static final AtomicLong ID = new AtomicLong();

    private static final Map<Long, UserProfile> FAKE_REPOSITORY = new HashMap<>();

    public UserProfile save(UserProfile model) {
        long modelId = ID.incrementAndGet();
        model.setId(modelId);
        FAKE_REPOSITORY.put(modelId, model);
        return model;
    }

    public UserProfile getById(long id) {
        return FAKE_REPOSITORY.get(id);
    }

    public List<UserProfile> getAll() {
        return new ArrayList<>(FAKE_REPOSITORY.values());
    }

    public boolean update(long id, UserProfile model) {

        if (FAKE_REPOSITORY.containsKey(id)) {
            model.setId(id);
            FAKE_REPOSITORY.put(id, model);
            return true;
        }

        return false;
    }

    public boolean remove(long id) {
        return FAKE_REPOSITORY.remove(id) != null;
    }
}
