class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> list = new ArrayList<>();
        for (int j = left; j <= right; j++) {
            boolean isSelfDeviding = true;
            if (j < 10) { // if number is less than 10 it's automatically self deviding
                list.add(j);
            } else {
                int i = j;
                if (i % 10 != 0) { //ignore any number divisible by 10
                    while (i % 10 != 0) { 
                        if (j % (i % 10) == 0) { //check the divisibility with reminder 
                            i = i / 10; //delete right most digit so that we can access the next digit with reminder
                            if (i % 10 == 0 && i != 0) { 
                                isSelfDeviding = false;
                                break;
                            }
                        } else {
                            isSelfDeviding = false;
                            break;
                        }
                    }
                    if (isSelfDeviding)
                        list.add(j);
                }
            }
        }

        return list;        
    }
}