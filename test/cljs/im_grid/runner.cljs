(ns im-grid.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [im-grid.core-test]))

(doo-tests 'im-grid.core-test)
