package com.joaoeduardo.travelorder;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Hotel {


    private Long id;
    @NonNull
    private Long travelOrderId;
    @NonNull
    private Integer nights;

}
