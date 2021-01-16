package library.repository;

import library.entities.FrameWarehouseBalance;

import java.util.List;

public class Frame_profile_warehouse_balanceRepository extends CrudRepository<FrameWarehouseBalance> {

    private static final String HIBERNATE_SELECT_QUERY = "from FrameWarehouseBalance";

    private static final String ID_PARAM = "frame_profile_warehouse_balanceId";
    private static final String DELETE_QUERY = "delete from FrameWarehouseBalance b where b.id = :" + ID_PARAM;

    public void delete(Long id) {
        runInTransaction((session) ->
                session.createQuery(DELETE_QUERY)
                        .setParameter(ID_PARAM, id)
                        .executeUpdate());
    }

    public FrameWarehouseBalance findOne(Long id) {
        return super.findOne(id, FrameWarehouseBalance.class);
    }

    public List<FrameWarehouseBalance> findAll() {
        return super.findAll(HIBERNATE_SELECT_QUERY, FrameWarehouseBalance.class);
    }
}
