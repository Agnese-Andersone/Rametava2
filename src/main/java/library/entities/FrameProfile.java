package library.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "frame_profile")
public class FrameProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long frame_id;

    @Column(name = "frame_name")
    private String frame_name;

    @Column(name = "frame_bar_std_length")
    private int frame_bar_std_length;

    @OneToMany(mappedBy = "frame_profile")
    private Set<FrameWarehouseBalance> frameWarehouseBalances = new HashSet<>();

    public FrameProfile() {
    }

    public FrameProfile(String frameName) {
        this.frame_name = frameName;
    }

    public Long getFrame_id() {
        return frame_id;
    }

    public void setFrame_id(Long frame_id) {
        this.frame_id = frame_id;
    }

    public String getFrame_name() {
        return frame_name;
    }

    public void setFrame_Name(String frameName) {
        this.frame_name = frame_name;
    }

    public int getFrame_bar_std_length() {
        return frame_bar_std_length;
    }

    public void setFrame_bar_std_length(int frame_bar_std_length) {
        this.frame_bar_std_length = frame_bar_std_length;
    }

    public Set<FrameWarehouseBalance> getFrameWarehouseBalances() {
        return frameWarehouseBalances;
    }

    public void setFrameWarehouseBalances(Set<FrameWarehouseBalance> frameWarehouseBalances) {
        this.frameWarehouseBalances = frameWarehouseBalances;
    }
}
