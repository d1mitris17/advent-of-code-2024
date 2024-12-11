def readFile(filename):
    l1 = []
    l2 = []
    with open(filename, "r") as f:
        for line in f:
            l1.append(int(line.split()[0]))
            l2.append(int(line.split()[1]))
    return l1, l2


def quickSort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[len(arr) // 2]
    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]
    return quickSort(left) + middle + quickSort(right)


def countDiff(s1, s2):
    count = 0
    for i in range(len(s1)):
        count += abs(s1[i] - s2[i])
    return count


def main():
    l1, l2 = readFile("day1.txt")
    l1 = quickSort(l1)
    l2 = quickSort(l2)
    print(countDiff(l1, l2))


if __name__ == "__main__":
    main()
