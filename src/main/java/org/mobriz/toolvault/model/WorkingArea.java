package org.mobriz.toolvault.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

//@DynamoDbBean
@Data
@Builder
public class WorkingArea {
    private Float x_plane;
    private Float y_plane;
    private Float z_plane;

    public Float getX_plane() {
        return x_plane;
    }

    public void setX_plane(Float x_plane) {
        this.x_plane = x_plane;
    }

    public Float getY_plane() {
        return y_plane;
    }

    public void setY_plane(Float y_plane) {
        this.y_plane = y_plane;
    }

    public Float getZ_plane() {
        return z_plane;
    }

    public void setZ_plane(Float z_plane) {
        this.z_plane = z_plane;
    }
}
