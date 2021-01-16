package library.repository;

import library.entities.FrameProfile;

import java.util.List;

public class Frame_profileRepository extends CrudRepository<FrameProfile> {

    private static final String HIBERNATE_SELECT_QUERY = "from FrameProfile";

    public FrameProfile findOne(Long id) {
        return super.findOne(id, FrameProfile.class);
    }

    public List<FrameProfile> findAll() {
        return super.findAll(HIBERNATE_SELECT_QUERY, FrameProfile.class);
    }
}
