package com.au.anz.algo.test;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Builder
@ToString
@Getter
public class ProblemData {

    private boolean valid;

    private Integer target;

    private Set<Integer> elements;
}
