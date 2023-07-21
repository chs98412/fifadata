package com.fifadata.hyuk.DTO;

import lombok.Data;

@Data
public class shootDetailDTO {

    private	Integer	goalTime	;
    private	Double	x	;
    private	Double	y	;
    private	Integer	type	;
    private	Integer	result	;
    private	Integer	spId	;
    private	Integer	spGrade	;
    private	Integer	spLevel	;
    private	Boolean	spIdType	;
    private	Boolean	assist	;
    private	Integer	assistSpId	;
    private	Double	assistX	;
    private	Double	assistY	;
    private	Boolean	hitPost	;
    private	Boolean	inPenalty	;

}
