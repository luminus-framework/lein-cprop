# lein-cprop

A Leiningen plugin for generating cprop configuration for Luminus.

## Usage

Add the plugin in your `project.clj` `:plugins` vector:

```clojure
:plugins [[lein-cprop "1.0.0"]]
```

The plugin will generate a `user.edn` configuration map based on the properties found in the profile that Leiningen is run with.


