(ns remarke-main-api.core
  (:require [org.httpkit.server :as server]
            [ring.middleware.defaults :refer :all]
            [ring.middleware.json :as middleware]
            [clojure.pprint :as pp]
            [clojure.string :as str]
            [remarke-main-api.routes :as routes])
  (:gen-class))

(def app (-> routes/app-routes
             (middleware/wrap-json-body {:keywords? true :bigdecimals? true})
             (middleware/wrap-json-response)
             (wrap-defaults api-defaults)))

(defn start-server []
  (let [port (Integer/parseInt (or (System/getenv "PORT") "3000"))]
    ; Run the server with Ring.defaults middleware
    (server/run-server app {:port port})
    (println (str "Running webserver at http://127.0.0.1:" port "/"))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (start-server))
