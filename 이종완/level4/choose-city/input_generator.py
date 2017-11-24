import random
import sys

start = int(sys.argv[1])
end = int(sys.argv[2])

for i in range(start, end+1):
    print('{0} {1}'.format(i, random.randrange(1, 10)))

print('q')
