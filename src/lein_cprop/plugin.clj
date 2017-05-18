(ns lein-cprop.plugin
  (:use [robert.hooke :only (add-hook)])
  (:require [clojure.java.io :as io]
            [clojure.string :as string]
            [leiningen.core.main]))

(defn- as-edn [& args]
  (binding [*print-dup* false
            *print-meta* false
            *print-length* false
            *print-level* false]
    (apply prn-str args)))

(defn env-file [project]
  (io/file (:root project) (get-in project [:cprop :config-file] ".lein-env")))

(def generated-warning
  (string/join "\n"
               [";;        GENERATED FILE: DO NOT EDIT"
                ";;"
                ";; this file is generated using the environment"
                ";; found for the current the Leiningen profile"
                ";; edit the profile configuration instead\n\n"]))

(defn- write-env-to-file [func task-name project args]
  (spit (env-file project) (str generated-warning (as-edn (:env project {}))))
  (func task-name project args))

(defn hooks []
  (add-hook #'leiningen.core.main/apply-task #'write-env-to-file))
