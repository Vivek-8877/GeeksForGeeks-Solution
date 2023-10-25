
def computeLPS(string):
    n=len(string)
    lps=[0]*n
    length=0
    i=1
    while(i<n):
        if(string[i]==string[length]):
            length+=1
            lps[i]=length
            i+=1
        else:
            if(length!=0):
                length=lps[length-1]
            else:
                i+=1
    return lps

def getMinimumCharacter(string):
    n=len(string)
    concat=string+"$"+string[::-1]
    lps=computeLPS(concat)
    print(n-lps[-1])

getMinimumCharacter("AACECAAAA")
