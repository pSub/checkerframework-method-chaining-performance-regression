Checker Framework Method-Chaining Performance Regression
========================================================

The bug was fixed in https://github.com/typetools/checker-framework/issues/2853.

This repository contains a code that demonstrates a performance regression in the [checker framework](https://checkerframework.org/). The
performance regression affects source code that uses long [method chains](https://en.wikipedia.org/wiki/Method_chaining). The performance
regression was introduced in versions 2.10.0 and 3.0.0. The performance in version 2.9.0 is OK.

The proof of concept in the repository might look constructed, however it is easy to come up with real-world examples that trigger the
performance regression. Some examples

* building large objects with the [fluid builder pattern](https://dzone.com/articles/fluent-builder-pattern)
* complex processing using [Java streams](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html)

The problem hit me when upgrading the checker framework for the DMN analysis tool [dmn-checker](https://github.com/red6/dmn-check/),
specifically at a method in [FeelParser](https://github.com/red6/dmn-check/blob/master/validators/src/main/java/de/redsix/dmncheck/feel/FeelParser.java#L82).

The [tracis-ci job](https://travis-ci.org/pSub/checker-framework-letexpr-crash) provides a demonstration. 
