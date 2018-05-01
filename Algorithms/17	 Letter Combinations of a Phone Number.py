    digit_voc = {'2': ['a','b','c'],
                 '3': ['d','e','f'],
                 '4': ['g','h','i'],
                 '5': ['j','k','l'],
                 '6': ['j','k','l'],
                 '7': ['p','q','r','s'],
                 '8': ['t','u','v'],
                 '9': ['w','x','y','z']}
    
    def Call(self,str):
        str_new = ''
        matrix = []
        result = []
        for i in str:
           #str_new = ''.join(self.digit_voc[i])
           #print(self.digit_voc[i])
           if len(self.digit_voc[i]) == 3:
               matrix.append(self.digit_voc[i] + [''])
           else:
               matrix.append(self.digit_voc[i])

        #print(matrix)

        for i in range(0,len(matrix)):
            for j in range(0,4):
                if i > 0 and j > 0:
                    if len(matrix[0][0]+matrix[i][j]) > 1:
                        result.append(matrix[0][0]+matrix[i][j])
                if i > 0 and j == 0:
                    result.append(matrix[0][0] + matrix[i][j])
                if i > 0 and j > 0:
                    if len(matrix[0][1] + matrix[i][j]) > 1:
                        result.append(matrix[0][1] + matrix[i][j])
                if i > 0 and j == 0:
                    result.append(matrix[0][1] + matrix[i][j])
                if i > 0 and j > 0:
                    if len(matrix[0][2] + matrix[i][j]) > 1:
                        result.append(matrix[0][2] + matrix[i][j])
                if i > 0 and j == 0:
                    result.append(matrix[0][2] + matrix[i][j])
                if i > 0 and j > 0:
                    if len(matrix[0][3] + matrix[i][j]) > 1:
                        result.append(matrix[0][3] + matrix[i][j])
                if i > 0 and j == 0:
                    if len(matrix[0][3] + matrix[i][j]) > 1:
                        result.append(matrix[0][3] + matrix[i][j])

                #print(matrix[i][j])
        print(result)
