package 数组

func pivotIndex1(nums []int) int {
	left, right := 0, 0
	for i := 0; i < len(nums); i++ {
		right += nums[i]
	}

	for i := 0; i < len(nums); i++ {
		left += nums[i]
		if right == left {
			return i
		}
		right -= nums[i]
	}
	return -1
}

func pivotIndex(nums []int) int {
	left, total := 0, 0
	for i := 0; i < len(nums); i++ {
		total += nums[i]
	}

	for i := 0; i < len(nums); i++ {
		if total == 2*left+nums[i] {
			return i
		}
		left += nums[i]
	}
	return -1
}
