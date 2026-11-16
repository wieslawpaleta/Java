# 🎰 Ultra Hot Deluxe - Java Swing Edition

A classic retro-style slot machine desktop simulator inspired by *Ultra Hot Deluxe*, built entirely in **Java** using **Swing** and **Object-Oriented Programming (OOP)** principles.

## ✨ Features

* **3x3 Slot Grid & 5 Paylines:** Evaluates horizontal and diagonal winning combinations dynamically.
* **Smooth Reel Animation:** Powered by `javax.swing.Timer` for non-blocking UI updates during spins.
* **Gamble Feature ("Double or Nothing"):** Modal `JDialog` mini-game allowing players to risk their winnings by guessing Red or Black.
* **Dynamic Betting System:** Adjustable bet multiplier affecting both risk and potential payouts.
* **Visual & Audio Feedback:** Winning paylines highlight in a fiery orange-red glow, accompanied by native `.wav` sound effects via `javax.sound.sampled`.
* **Clean Architecture:** Separation of concerns dividing game logic (`GameModel`), data representation (`Symbol` enum), audio (`SoundPlayer`), and UI (`MainFrame`, `GambleDialog`).

## 🛠️ Technologies Used

* **Java (JDK 17+)**
* **Java Swing & AWT** (GUI components, custom layouts, event listeners)
* **Java Sound API** (`Clip`, `AudioSystem`)

## 🚀 How to Run

1. Clone the repository:
   ```bash
   git clone [https://github.com/your-username/ultra-hot-java.git](https://github.com/your-username/ultra-hot-java.git)