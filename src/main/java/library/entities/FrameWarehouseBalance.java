package library.entities;

import javax.persistence.*;

@Entity
@Table(name = "frame_profile_warehouse_balance")
public class FrameWarehouseBalance {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String frame_bar_count;

    @Column
    private String frame_total_length;

    @ManyToOne
    @JoinColumn(name = "frame_id")
    private FrameProfile frameProfile;

    public FrameWarehouseBalance() {
    }

    public FrameWarehouseBalance(String frame_bar_count, String frame_total_length, FrameProfile frameProfile) {
        this.frame_bar_count = frame_bar_count;
        this.frame_total_length = frame_total_length;
        this.frameProfile = frameProfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrame_bar_count() {
        return frame_bar_count;
    }

    public void setFrame_bar_count(String frame_bar_count) {
        this.frame_bar_count = frame_bar_count;
    }

    public String getFrame_total_length() {
        return frame_total_length;
    }

    public void setFrame_total_length(String frame_total_length) {
        this.frame_total_length = frame_total_length;
    }

    public FrameProfile getFrameProfile() {
        return frameProfile;
    }

    public void setFrameProfile(FrameProfile frameProfile) {
        this.frameProfile = frameProfile;
    }

    public String getFrame_name(){
        return getFrameProfile().getFrame_name();
    }

    public Long getFrame_id(){
        return getFrameProfile().getFrame_id();
    }
}
