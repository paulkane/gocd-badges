package gocd.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConnectionDetails {
    private String host;
    private String userName;
    private String password;
}
