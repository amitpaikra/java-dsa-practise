# https://www.codechef.com/problems/KCON


# Pre-Requiste
    Kadane's Alogrithm


## 📚 Basic Terms

### 🔹 Prefix Sum Array
Imagine you have a list of numbers. A **prefix sum array** is just a new list where each number tells you the total sum from the beginning of the list **up to that point**.

🧠 **Think of it like:**  
You're walking on a path collecting coins. The number at each step in the prefix sum array tells you how many coins you've collected so far.

📌 **Example:**
```
Original:     [2, 4, -1, 3]  
Prefix Sums:  [2, 6, 5, 8]   <- (2), (2+4), (2+4-1), (2+4-1+3)
```

---

### 🔸 Max Prefix Sum
This is the **highest value** in the prefix sum array.

🧠 **Why it matters:**  
It shows the most coins you've had in your bag **at any point starting from the beginning**.

📌 **In our example:**
```
Max Prefix Sum = 8
```

---

### 🔹 Suffix Sum Array
Same idea, but in reverse. A **suffix sum array** tells you the total sum from that point **to the end** of the list.

🧠 **Think of it like:**  
You're now walking **backwards** and picking up coins. The number at each step tells you how much you’d collect if you started walking from there to the end.

📌 **Example:**
```
Original:     [2, 4, -1, 3]  
Suffix Sums:  [8, 6, 2, 3]   <- (2+4-1+3), (4-1+3), (-1+3), (3)
```

---

### 🔸 Max Suffix Sum
The **largest number** in the suffix sum array.

🧠 **Why it matters:**  
It shows the best you can do if you start collecting coins from **any point to the end**.

📌 **In our example:**
```
Max Suffix Sum = 8
```

---

```

Let me know if you'd like to add visuals, emoji-free version, or keep going with other terms!