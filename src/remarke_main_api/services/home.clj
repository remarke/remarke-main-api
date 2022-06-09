(ns remarke-main-api.services.home)

(defn initial-page [req]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body {:ok true}})
