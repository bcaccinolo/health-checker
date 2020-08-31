# health-checker

Some lines of code to test if my dev server is up or not.
If not, it launches a notification with `notify-send`.

## Installation

`lein uberjar`

## Usage

    $ java -jar clj-notifier-0.1.0-standalone.jar --url https://url.to-healtcheck.com

## Example

### Website is up -> No notification

    $ java -jar clj-notifier-0.1.0-standalone.jar --url http://httpstat.us/200

### Website returns a 404 ->  No notification

    $ java -jar clj-notifier-0.1.0-standalone.jar --url http://httpstat.us/404
