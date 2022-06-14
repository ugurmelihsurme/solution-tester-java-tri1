var maxSlidingWindow = function (nums, k) {
  var Maxvalues = new Array(nums.length - k + 1);
  var max;
  var index = 0;
  // nums icin for
  for (var i = 0; i < nums.length - k + 1; i++) {
    max = nums[i];
    for (var j = i + 1; j < i + k; j++) {
      // k boyutlu pencere icin for
      if (max < nums[j])
        // pencere icindeki en buyuk deger
        max = nums[j];
    }
    Maxvalues[index++] = max;
  }
  return Maxvalues;
};
var nums = [1, 3, -1, -3, 5, 3, 6, 7];
var k = 3;
console.log("Input: nums = [" + nums + "]");

console.log("Output: [" + maxSlidingWindow(nums, k) + "]");

nums = [1];
k = 1;
console.log("Input: nums = [" + nums + "]");

console.log("Output: [" + maxSlidingWindow(nums, k) + "]");
