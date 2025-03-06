package 数组

func twoSum(nums []int, target int) []int {
	res := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		v, ok := res[target-nums[i]]
		if ok {
			return []int{v, i}
		}
		res[nums[i]] = i
	}
	return nil
}
