;; Anything you type in here will be executed
;; immediately with the results shown on the
;; right.
(defn recur-sum [n]
  (if (zero? n)
    0
    (+ n (recur-sum (dec n)))))
(defn tail-sum [n]
  (let [calculator (fn [acc n]
                     (if (zero? n)
                       acc
                       (recur (+ acc n) (dec n))))]
    (calculator 0 n)))
(recur-sum 0)
(tail-sum 0)
(recur-sum 1)
(tail-sum 1)
(recur-sum 3)
(tail-sum 3)
