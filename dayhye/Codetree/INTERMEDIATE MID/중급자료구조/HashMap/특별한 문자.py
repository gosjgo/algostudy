letters = list(input())
hs = {}

for letter in letters:
    if letter in hs:
        hs[letter] += 1
    else:
        hs[letter] = 1

check  = -1
for idx, enum in enumerate(hs):
    if hs[enum] == 1:
        print(enum)
        check = 0
        break

if check == -1:
    print('None')