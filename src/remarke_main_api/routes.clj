(ns remarke-main-api.routes
  (:require [compojure.core :refer [GET defroutes]]
            [compojure.route :as route]
            [remarke-main-api.services.home :refer [initial-page]]))

(defroutes app-routes
  (GET "/" [] initial-page)
  (route/not-found "Error, page not found!"))
