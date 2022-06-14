
        function squareRoot(n) {
        var sqr = 1,
          i = 0;

        while (true) {
          i = i + 1;
          sqr = (n / sqr + sqr) / 2;

          if (i == n + 1) {
            break;
          }
        }
    // float türünden elde edilen sonuç bitwise NOT operatörünü kullanarak tamsayı türüne dönüştürülmüştür.
        return ~~sqr;
      }

      let number = 8;
      let result = squareRoot(number);
      
      document.write(result);
