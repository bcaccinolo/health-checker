(ns health-checker.core
  (:use [clojure.java.shell :only [sh]])
  (:require [clojure.tools.cli  :refer [parse-opts]]
            [org.httpkit.client :as http])
  (:gen-class)
)

(def cli-options
  [["-u URL" "--url URL" "URL to healtcheck"]
   ["-h" "--help"]])

(defn -main [& args]
  (let [
        opts (parse-opts args cli-options)
        url (:url (:options opts))
        error false
        {:keys [status headers body error] :as resp} @(http/get url)
        ]

    (if (or error (< 299 status))
      (sh "/usr/bin/notify-send" (str url " - ko - " status)))

   (System/exit 0) ; exit from notify-send
))
