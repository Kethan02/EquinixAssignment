package domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="cores")
    private String cores;

    @Column(name="created_date")
    private LocalDate createdDate;

    @OneToOne
    @JoinColumn(unique = true)
    private DeviceDetails deviceDetails;

    @OneToOne
    @JoinColumn(unique = true)
    private Location location;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    };

    public void setName(String name) {
        this.name = name;
    }

    public String getCores() {
        return this.cores;
    }

    public void setCores(String cores) {
        this.cores = cores;
    }

    public LocalDate getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public DeviceDetails getDeviceDetails() {
        return this.deviceDetails;
    }

    public void setDeviceDetails(DeviceDetails deviceDetails) {
        this.deviceDetails = deviceDetails;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Device) || id == null)
            return false;
        return this == o || id.equals(((Device) o).id);
    }

    @Override
    public String toString() {
        return "domain.Device{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", cores='" + getCores() + '\'' +
                ", createdDate=" + getCreatedDate() +
                ", deviceDetails=" + getDeviceDetails() +
                ", location=" + getLocation() +
                '}';
    }
}
