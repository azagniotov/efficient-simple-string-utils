[![CircleCI build master branch][circleci-badge]][circleci-link]

# Efficient Simple String Utils
Efficient simple string utils that meant to perform few basic operations on string in an efficient manner

## Available API

* `char[] trim(final String target)`
* `String trimAsString(final String target)`

* `char[] firstToken(final String target)`
* `String firstTokenAsString(final String target)`
* `long firstTokenAsLong(final String target)`

* `char[] lastToken(final String target)`
* `String lastTokenAsString(final String target)`
* `long lastTokenAsLong(final String target)`

* `String inject(final String source, final int startIndex, final String injectable)`

## Testing

* Command `./gradlew test` runs unit tests

## Code Coverage

A code coverage report will be generated under `build/reports/jacoco/html/`. You need to open `index.html` in a browser. 

* Command `./gradlew clean jacocoTestReport`


## License
MIT. See LICENSE for details


<!-- references -->

[circleci-badge]: https://circleci.com/gh/azagniotov/efficient-simple-string-utils.svg?style=shield
[circleci-link]: https://circleci.com/gh/azagniotov/efficient-simple-string-utils
