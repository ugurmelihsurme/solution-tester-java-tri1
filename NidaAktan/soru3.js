/**
* @param {number} x
* @return {number}
*/
  
  var mySqrt = function (x) {

        if (x === 0 || x === 1) {
            return x;
        }
        let start = 2;
        while (start * start <= x) {

            start++;
        }

        return start - 1;
    };
