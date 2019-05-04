package com.au.anz.algo.test;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
public class ProblemData {

    private Integer target;

    private Integer[] elements;
}
