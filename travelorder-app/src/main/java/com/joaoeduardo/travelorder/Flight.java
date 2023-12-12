package com.joaoeduardo.travelorder;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Flight {


    private Long id;
    @NonNull
    private Long travelOrderId;
    @NonNull
    private String fromAirport;
    @NonNull
    private String toAirport;

}
