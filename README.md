## 🧩 [What is Advent of Code?](https://adventofcode.com/2025)

Advent of Code (AoC) is an annual set of daily programming puzzles created by Eric Wastl. Every year from December 1–25, a new two-part puzzle is released each day at midnight EST. The challenges start simple and steadily increase in difficulty, often requiring creative problem-solving, algorithmic thinking, and performance optimization.

AoC is language-agnostic. Participants can solve the puzzles in any programming language, and it’s popular among developers for improving coding skills, exploring new languages, and sharing clever solutions. Many people treat it like a daily coding workout or friendly competition with coworkers, friends, or online communities.

Typical benefits include:
- Practicing algorithms and data structures
- Learning a new language by applying it to real problems
- Comparing approaches with others
- Building up a neat repo of solutions over time

This Repo is my attempt at solving the challenges for the year 2025! I am using Kotlin for my attempts at this year's challenge and trying to use as little AI as possible. Also, I am attempting to follow TDD principles to flex that muscle as I don't use it often.

## ✅ Solutions

### [Day 1: Secret Entrance](https://adventofcode.com/2025/day/1)

For this challenge, you can imagine a combination lock. The lock has a dial that can be set to any number from 0 to 99. You are given a sequence of directions and number of clicks moved. For example, if the dial was set to 50 and you were given an instruction of R63, the dial would move right 63 "clicks", wrapping around to 13.

#### Part One

For this part, we need to determine how many times the dial was set to 0. My solution was initially very simple, I created a `Dial` class to handle the logic of rotating the dial, and to track its current setting. I also created a `Direction` enum to represent the direction of rotation. To the `Dial` I added a single function called `turn` which takes a `Direction` and an `amount` of clicks to move the dial. The function updates the dial's current setting and increments a counter if the dial is set to 0 after the clicks have been completed. If the dial ever went above 99 or below 0, I would use the modulo operator to bring it back down to a valid value.

#### Part Two

For this part, it turns out that we really needed to determine how many times the dial was ever clicked to 0. My solution was originally to update the `Dial` class to track the number of times the dial was clicked on 0. However, due to the nature of the modulo math I was using in part one and its interaction with negative numbers, I found that I was getting duplicate clicks on zero if the dial was set to a negative number. To fix this issue, I decided to simulate each click instead of relying on modulo math.

### [Day 2: Secret Entrance](https://adventofcode.com/2025/day/2)

For this challenge, due to a meddling kid, you need to determine if some product ids are "silly" and thus not real product ids. You're given ranges of ids like "11-55,12398-49404" and you must check each number in those ranges for silliness.

#### Part One

Part one defines silliness as a number that is two repeated numbers. For example, 11, 2424, and 1186611866 are silly. I split the logic of this problem into two separate problems. Problem one, parse the ranges and iterate the numbers, which is simple. Problem two is determine if the number is silly. This is also simple as you can split the number string in half and determine if both halves are the same. Note, due to this definition of silliness, we can exclude product ids with an odd number of digits (i.e. 12345).

#### Part Two

The twist here is that we really needed to define silliness as a number that is any number of repeated numbers. So this definition of silliness now includes the prior part's, but expands it to also include numbers like 151515, 743743743743, and 111. To solve this problem, I simply genericized the solution of part 1 and allowed you to specify the number of repeated digits to check for. Then I would check each number in the range of 1 to the id's number of digits divided by 2.

### [Day 3: Lobby](https://adventofcode.com/2025/day/3)

An Escalator that you need to use is missing power. You need to activate some batteries in order to give it the juice it needs. The batteries are arranged into battery banks, and each battery has a single-digit "joltage". You need to determine the maximum joltage of a battery bank by grouping the digits together in order. An example of a battery bank would be `3385328475928` where each digit corresponds to a single battery's joltage rating.

#### Part One

Initially you try to turn on only two of the batteries from each battery bank. For the above example, you'd expect a joltage of `98`. My solution to this was to loop backwards from 9 to 0, until I find the first largest digit that wasn't in the last index. Then once I found the first largest digit, I sliced the list of batteries to the last slice and grabbed the maximum from that sliced list. Then put the two together to get my answer.

#### Part Two

Turns out that only turning on two of the batteries didn't quite give it enough joltage. So, now we have to turn on 12 instead of two. I briefly side-tracked myself by trying to solve the problem by grabbing all the 9's and then all the 8's until I got 12 digits pulled out into a string. However, this is not a valid solution. 

Finally, I ended with a solution that uses recursion, and searches for the highest joltage that appears at an index that still allows for enough digits to come after it and reduces the search space by anything after that digit.

### [Day 4: Printing Department](https://adventofcode.com/2025/day/4)

We made our way to the printing department, and they seem to be having trouble organizing their giant rolls of paper such that the forklifts can get at them. Their paper storage is set up in a grid, and they have a map of where each roll of paper currently is located.

#### Part One

This challenge was rather simple, we simply had to find the rolls that the forklift could access. A forklift could access a roll of paper if it had fewer than 4 rolls occupying space directly adjacent to it. My solution checks each cell, first for a roll and if there is one it checks all the adjacent cells to see how many rolls are adjacent to it. If there are fewer than 4 rolls adjacent to it, then it is accessible by the forklift.

#### Part Two

This challenge was also rather simple. After finding the rolls that the forklifts could access, we then remove those rolls from the grid. Then we check if there are any rolls left that the forklifts can access. If there are, we repeat the process until there are no more rolls left that the forklifts can access. My solution uses the prior part's functionality to determine which grid spaces are accessible and removes them from the grid, then repeats the process until there are no more rolls left that the forklifts can access.
