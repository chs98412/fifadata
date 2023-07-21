package com.fifadata.hyuk.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class shootDTO {
    private	Integer	shootTotal	;
    private	Integer	effectiveShootTotal	;

    private Integer shootOutScore;
    private	Integer	goalTotal	;

    private	Integer	goalTotalDisplay	;
    private	Integer	ownGoal	;
    private	Integer	shootHeading	;
    private	Integer	goalHeading	;
    private	Integer	shootFreekick	;
    private	Integer	goalFreekick	;
    private	Integer	shootInPenalty	;
    private	Integer	goalInPenalty	;
    private	Integer	shootOutPenalty	;
    private	Integer	goalOutPenalty	;
    private	Integer	shootPenaltyKick	;
    private	Integer	goalPenaltyKick	;
}