package rc.interview;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Extension {
    private String firstName;
    private String lastName;
    private String ext;
    private String extType;


}
