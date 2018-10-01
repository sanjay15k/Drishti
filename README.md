# Drishti - A Companion App For Blind People

## Inspiration
The project is an endeavour to provide the visually impaired with a friend, more dependable and dedicated than most humans can ever be. 
There are lots of services for the blind to find the objects (at several times crucial for their work), but none of them manage to give an avid description of the same. What if the wallet it detects isn't yours? or what if you get in the wrong car?
having to learn how to navigate urban environments safely is a big pressure on an already impaired person. We present a unique way of being able to navigate with assistant from the only AI a blind person will ever need.

## What it does and How I built it
Object Detection
Using sophisticated object detection algorithms, implemented from scratch on a tensorflow library on a native android device by incorporating a trained classifier, we detect the object a user wants to find within an environment. We further built a cloud API through which the app fetches further information about the object as caught in the picture. 

Path Prediction

A reinforcement learning based AI model is to be incorporated to make the predictions better with time while training. We plan to incorporate a AAA game where the character is being navigated in first person and the model learns how to navigate itself from the directions being chosen by the player.

We use this Neural Network based classifier which helps to choose the right direction to take at every frame as recorded from the back camera of an android device 

## ScreenShots

<img src="https://user-images.githubusercontent.com/35829879/46232671-8ab93a00-c38d-11e8-9070-1184c6042e86.jpeg" width="290"> <img src="https://user-images.githubusercontent.com/35829879/46232691-99075600-c38d-11e8-834b-1003ec615b77.jpeg" width="290"> <img src="https://user-images.githubusercontent.com/35829879/46232704-9f95cd80-c38d-11e8-968b-9d975e120318.jpeg" width="290"> 

## Accomplishments that I'm proud of
80% accuracy in path prediction
Simple clean and user-friendly UI for the blind

## What's next for Drishti - A virtual AI assistant for the blind
A smarter android integration, with an activity that spans not just an app. A full-fledged Siri style assistant.

## Contributors
1. <a href="https://github.com/sanjay-kd">Sanjay Kumar </a> (Android App Dev.)
2. <a href="">Yash Aggarwal </a> (Android App Dev.)
3. <a href="https://github.com/devanshbatra04">Devansh Batra </a> (AI + Cloud)
4. <a href="https://github.com/avinsit123">Avinash </a> (Machine Learning)
