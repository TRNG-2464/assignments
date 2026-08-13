ugh nums
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(target - nums[i]) == Math.abs(target - closest)) {
                closest = Math.min(closest, nums[i]);
            } else if (Math.abs(target - nums[i]) < Math.abs(target - closest))) {
                closest = nums[i];
            }
        }
        return closest;
    }
}