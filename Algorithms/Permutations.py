class Test:

    def Permutations(self, array, mid, len_a):
        if mid == len_a:
            print(array)
        else:
            for i in range(mid, len_a):
                array[mid], array[i] = array[i],array[mid]
                self.Permutations(array,mid+1, len_a)
                array[mid], array[i] = array[i],array[mid]


array = [1,2,3]
len_a = len(array)
test = Test()
(test.Permutations(array,0, len_a))
