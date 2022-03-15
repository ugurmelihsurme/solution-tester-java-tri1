/**
* @param {number[]} nums
* @param {number} k
* @return {number[]}
*/
var maxSlidingWindow = function (nums, k) {
        if (k == 1) {
            return nums;
        }
        let queue = [];
        const push = (element) => {
            while (queue.length > 0 && element > queue[queue.length - 1]) {
                queue.pop();
            }
            queue.push(element);
        }

        let resultArray = [];

        for (var i = 0; i <= nums.length - 1; i++) {
            push(nums[i]);
            if (i >= (k - 1)) {
                resultArray.push(queue[0]);
                if (nums[i - k + 1] === queue[0]) {
                    queue.shift();
                }
            }
        }
        return resultArray;
    }