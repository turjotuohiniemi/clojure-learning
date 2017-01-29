(ns looping-is-recursion)

(defn power [base exp]
  (let [helper (fn [acc n]
                 (if (zero? n)
                   acc
                   (recur (* acc base) (dec n))))]
    (if (>= exp 0)
      (helper 1 exp)
      (/ 1 (helper 1 (- exp))))))

(defn last-element [a-seq]
  (let [helper (fn [acc a-seq]
                 (if (empty? a-seq)
                   acc
                   (recur (first a-seq) (rest a-seq))))]
    (helper (first a-seq) (rest a-seq))))

(defn seq= [seq1 seq2]
  (cond
   (and (empty? seq1) (empty? seq2))
     true
   (or (empty? seq1) (empty? seq2))
     false
   (= (first seq1) (first seq2))
     (recur (rest seq1) (rest seq2))
   :else
     false))

(defn find-first-index [pred a-seq]
  (loop [i 0
         sq a-seq]
    (cond
     (empty? sq)
       nil
     (pred (first sq))
       i
     :else
       (recur (inc i) (rest sq)))))

(defn avg [a-seq]
  (loop [i 0
         sum 0
         aseq a-seq]
    (if (empty? aseq)
      (if (zero? i)
        nil
        (/ sum i))
      (recur (inc i) (+ sum (first aseq)) (rest aseq)))))

(defn toggle [a-set elem]
  (if (contains? a-set elem) (disj a-set elem) (conj a-set elem)))

(defn parity [a-seq]
  (loop [result #{}
         aseq a-seq]
    (if (empty? aseq)
      result
      (recur (toggle result (first aseq)) (rest aseq)))))

(defn fast-fibo [n]
  (if (= n 0)
    0
    (loop [Fn 1
           Fn-1 0
           i 1]
      (if (= i n)
        Fn
        (recur (+ Fn Fn-1) Fn (inc i))))))

(defn cut-at-repetition [a-seq]
  (loop [seen-elems #{}
         a-seq a-seq
         result (vector)]
    (if (or (empty? a-seq) (contains? seen-elems (first a-seq)))
      result
      (recur (conj seen-elems (first a-seq)) (rest a-seq) (conj result (first a-seq))))))

(defn cut-at-repetition-v2 [a-seq]
  (loop [seen-elems #{}
         asq a-seq
         n 0]
    (if (or (empty? asq) (contains? seen-elems (first asq)))
      (take n a-seq)
      (recur (conj seen-elems (first asq)) (rest asq) (inc n)))))

