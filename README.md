#HyperLaunch
The hypertext markup Android launcher

##Current features
- Make a toast - `Launcher.toast()`
- Get list of launchable & installed apps - `Launcher.apps()`


##Important
Currently, all returned values from the Launcher class are strings and integers. This is due to technical issues that make it difficult to associate Java objects with Javascript objects. If an item returns a string and you were expecting an object or an array, it's likely that you simply have to run `JSON.parse()` on the text you received.
