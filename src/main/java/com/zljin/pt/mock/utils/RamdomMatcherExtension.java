package com.zljin.pt.mock.utils;

import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.matching.MatchResult;
import com.github.tomakehurst.wiremock.matching.RequestMatcherExtension;

import java.util.concurrent.ThreadLocalRandom;

public class RamdomMatcherExtension extends RequestMatcherExtension {

    @Override
    public String getName() {
        return "RamdomMatcher";
    }

    @Override
    public MatchResult match(Request request, Parameters parameters) {
        int weight = parameters.getInt("weight");
        int rand = ThreadLocalRandom.current().nextInt(0,100);
        return MatchResult.of(rand<weight);
    }
}
