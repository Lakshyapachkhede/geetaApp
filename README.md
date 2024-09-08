# Geeta App

**Geeta App** is an Android application that allows users to explore and read the Bhagavad Gita in Hindi. The app is designed with a modern, intuitive interface that mimics the experience of Instagram reels for a smooth and enjoyable reading experience.

## Features

- **Chapter List View**: Upon opening the app, users are presented with a list of all the chapters of the Bhagavad Gita.
- **Shlok List View**: After selecting a chapter, a new screen displays all the Shlokas (verses) in that chapter using a RecyclerView for easy scrolling.
- **Reels-style Shlok View**: Each Shlok can be opened in a reels-style view, allowing users to scroll through the verses of the chapter with smooth, vertical swipe gestures, similar to Instagram reels.
- **Language**: All content is in Hindi, making it easier for native speakers to engage with the Bhagavad Gita.

## Screenshots

**All Adhyay**

![Chapter List View](./screenshots/adhyay.jpg)

**All Shloks**

![Shlok List View](./screenshots/shlok.jpg)

**Shlok Detail**

![Reels-style View](./screenshots/shlokDetail.jpg)

**Reels-style Scrolling**

![Reels-style View](./screenshots/scroll.jpg)


## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Lakshyapachkhede/geetaApp.git
   ```
2. Open the project in Android Studio.
3. Sync the Gradle files and run the app on an Android device or emulator.

## Usage

1. **Chapter List**: When you open the app, you’ll see a list of all the chapters from the Bhagavad Gita.
2. **Shlok List**: Click on any chapter to view all the Shlokas within it. The Shlokas are displayed in a list format.
3. **Reels-style View**: Select a Shlok to open it in a reels-style view. Swipe up or down to move between Shlokas of the same chapter.

## API

The app uses the following API to fetch chapter and shlok data:

- `/adhyay/` - List of all chapters with their names, meanings, and summaries.
- `/adhyay/{id}` - Fetch details of a specific chapter.
- `/shlok/{chapter_id}` - Fetch all Shlokas of a specific chapter.
- `/shlok/{chapter_id}/{shlok_id}` - Fetch a specific Shlok along with its meaning.
