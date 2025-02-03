### WearOS-RideTracker

## Overview

This proof of concept (POC) WearOS app was made with the intention of simply wrapping a bus tracker website in a webview. As I began creating the app, I noticed there are no publicly avaliable APIs for webview from Google (Android only, no WearOS support yet). So I instead opted for GeckoView from Mozilla. The main hurdles I ran into were in regards to cropping, as this site was not made with circular displays in mind. For that reason I had to scale and add bottom margins to the view, to ensure all the toggles of the site were reachable. Cropping the top was not an issue, as the map could be panned in any direction needed.

This was also an exercise in leveraging the Gemini AI feature of Android Studio Ladybug, helping me debug and resolve any issues I encountered. This was my first Android WearOS app.
