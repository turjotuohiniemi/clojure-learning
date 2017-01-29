(use 'looping-is-recursion)

(power 2 0)
(power 2 1)
(power 2 2)
(power 2 8)
(power 2 -2)
(power 2 2)  ;=> 4
(power 5 3)  ;=> 125
(power 7 0)  ;=> 1
(power 0 10) ;=> 0

(last-element [])      ;=> nil
(last-element [1 2 3]) ;=> 3
(last-element [2 5])   ;=> 5

(seq= [1 2 4] '(1 2 4))  ;=> true
(seq= [1 2 3] [1 2 3 4]) ;=> false
(seq= [1 3 5] [])        ;=> false

(find-first-index zero? [1 1 1 0 3 7 0 2])                    ;=> 3
(find-first-index zero? [1 1 3 7 2])                          ;=> nil
(find-first-index (fn [n] (= n 6)) [:cat :dog :six :blorg 6]) ;=> 4
(find-first-index nil? [])                                    ;=> nil
(find-first-index nil? nil)

(avg [1 2 3])   ;=> 2
(avg [0 0 0 4]) ;=> 1
(avg [1 0 0 1]) ;=> 1/2 ;; or 0.5

(parity [:a :b :c])           ;=> #{:a :b :c}
(parity [:a :b :c :a])        ;=> #{:b :c}
(parity [1 1 2 1 2 3 1 2 3 4]) ;=> #{2 4}

(fast-fibo 0) ;=> 0
(fast-fibo 1) ;=> 1
(fast-fibo 2) ;=> 1
(fast-fibo 3) ;=> 2
(fast-fibo 4) ;=> 3
(fast-fibo 5) ;=> 5
(fast-fibo 6) ;=> 8

(cut-at-repetition [1 1 1 1 1])
;=> [1] doesn't have to be a vector, a sequence is fine too
(cut-at-repetition [:cat :dog :house :milk 1 :cat :dog])
;=> [:cat :dog :house :milk 1]
(cut-at-repetition [0 1 2 3 4 5])
;=> [0 1 2 3 4 5]

(cut-at-repetition-v2 [1 1 1 1 1])
;=> [1] doesn't have to be a vector, a sequence is fine too
(cut-at-repetition-v2 [:cat :dog :house :milk 1 :cat :dog])
;=> [:cat :dog :house :milk 1]
(cut-at-repetition-v2 [0 1 2 3 4 5])
;=> [0 1 2 3 4 5]

(def rep-test-set (conj (apply vector (range 5000000)) 0))
(time (cut-at-repetition-v2 rep-test-set))

