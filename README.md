# lein-cprop

A Leiningen plugin for generating cprop configuration for Luminus.


[![Clojars Project](https://clojars.org/lein-cprop/latest-version.svg)](https://clojars.org/lein-cprop)


## Usage

Add the plugin in your `project.clj` `:plugins` vector:

```clojure
:plugins [[lein-cprop "latest-version"]]
```

The plugin will generate a `user.edn` configuration map based on the properties found in the profile that Leiningen is run with.


