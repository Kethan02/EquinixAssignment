package domain;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name="device details")
public class DeviceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "deviceID")
    private Long deviceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVendor() {
        return this.vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Long getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeviceDetails)) return false;
        DeviceDetails that = (DeviceDetails) o;
        return id.equals(((DeviceDetails) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, vendor, deviceId);
    }

    @Override
    public String toString() {
        return "domain.DeviceDetails{" +
                "id=" + getId() +
                ", type='" + getType() + '\'' +
                ", vendor='" + getVendor() + '\'' +
                ", deviceId=" + getDeviceId() +
                '}';
    }
}
