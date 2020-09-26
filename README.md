# Native Android app automation with Espresso

## Overview
Before choosing the actual framework I tried to remember the interview and the discussion and assumptions around it. I stated, that I would choose a framework, which would be a part of the app's repo (that's what is happening here), share the same code language (Kotlin in this instance) and possible future healthy collaboration and contribution into the code coverage by both Test Automation Engineers and Developers.

I went with Espresso. It's intuitive, it's native and it's fast.

I had an option of choosing a library (https://github.com/KasperskyLab/Kaspresso) which is widely appreciated amongst test automation engineers, but I sticked to the regular approach and went with espresso (I didn't try it in depth before and it was really challenging to google everything :D). I had an option with going into the Appium (which is black-box testing and is generally slower), but as I said, I want to have a healthy conversation with developers, rather than choosing a framework, which is more QA-oriented.

As a result, we are living in the same infrastructure, in the same code base and writing the tests on the same language. In the future we can:
- run these test suites as a part of PRs
- being able to mock the data and backend, adjust necessary views, discuss the implementation of necessary IDs with developers. work together

and so on.

Some cons around Espresso:
- General overly verbose syntax
- Needs a good wrapper/framework around main Espresso library (written by team or open-sourced solution)


## Installation
- Checkout the project in Android studio
- Turn off the Window animation scale, Transition animation scale and Animator duration scale on target emulator via Developer Settings menu.
- Tap on green "Run" button on SignInTests class in LoginTests.kt file.

## Frameworks/Tools/Patterns used
- I've used a popular Page Object pattern, since it's easier to maintain, than basic Espresso Tests and it's intuitive to understand (for devs it makes sense, since it's OOP). I hide all the logic of the tests behind the scenes, with HomePage, LoginPage and WelcomePage and tests only contain readable functions. I have an Utils file, which contain "implicit-wait" implementation (it was tricky to deal with the image on the second view after login and not using the thread.sleep() :) and it doesn't use complicated IdlingResources approach for waits.