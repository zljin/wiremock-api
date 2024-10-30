package com.zljin.pt.mock.utils;

import com.github.tomakehurst.wiremock.common.ClasspathFileSource;
import com.github.tomakehurst.wiremock.common.FileSource;

public class ClasspathFileSourceWithoutLeadingSlash extends ClasspathFileSource {

    public ClasspathFileSourceWithoutLeadingSlash() {
        super("");
    }

    @Override
    public FileSource child(String subDirectoryName) {
        return new ClasspathFileSource(subDirectoryName);
    }
}
