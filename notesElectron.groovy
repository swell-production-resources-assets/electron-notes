 Electron Overview-
--------------------------------------------------------------------------------------------------------------------------------

---Electron takes a main file defined in your package.json file and executes it. This main file (usually named main.js) then creates application windows which contain rendered web pages with the added power of interacting with the native GUI (graphical user interface) of your operating system.

--- Purely starting the main process doesn’t give the users of your application any application windows. Those are created by the main process in the main file by using something called a BrowserWindow module. Each browser window is considered a new renderer process. This renderer process takes a web page (an HTML file which references the usual CSS files, JavaScript files, images, etc.) and renders it in the window. Your web pages are rendered with Chromium


----------------------------------------------------------------------------------
A basic example of a single window in electron (this goes in main.js)
----------------------------------------------------------------------------------

	const app = require('app');  // The app module controls your application lifecycle (for example — reacting to the ready state of your application).
	const BrowserWindow = require('browser-window'); // The BrowserWindow module allows window creation.


	let mainWindow = null; // the mainWindow object is going to be your main application window and is declared as null because the window would otherwise be closed once JavaScripts garbage collection kicks in.

	app.on('ready', function() { // Once app gets the ready event, we create a new 800 pixels wide and 600 pixels high window using BrowserWindow.
	    mainWindow = new BrowserWindow({
	        height: 600,
	        width: 800
	    });

	    mainWindow.loadUrl('file://' + __dirname + '/app/index.html'); // This window’s renderer process is going to render our index.html file.

	});


--------------------------------------------------------------------------------------------------------------------------------
Here's a list of the different ways to customize your BrowserWindows
--------------------------------------------------------------------------------------------------------------------------------
	1) resizable: false, // removes the users ability to resize this window
	2) frame: false, // removes outer frame for the window
	3) width ://Controls Window's width in pixels. Default is 800.
	4) height : //Controls Window's height in pixels. Default is 600.
	5) x :// (required if y is used) Window's left offset from screen. Default is to center the window.
	6) y : // - (required if x is used) Window's top offset from screen. Default is to center the window.
	7) useContentSize Boolean :// The width and height would be used as web page's size, which means the actual window's size will include window frame's size and be slightly larger. Default is false.
	8) center Boolean :// THis will show window in the center of the screen.
	9) minWidth Integer: // Window's minimum width. Default is 0.
	10) minHeight Integer: // Window's minimum height. Default is 0.
	11) maxWidth Integer: // Window's maximum width. Default is no limit.
	12) maxHeight Integer: // Window's maximum height. Default is no limit.
	13) resizable Boolean: // Controls Whether window is resizable. Default is true.
	14) movable Boolean: // Controls Whether window is movable. This is not implemented on Linux. Default is true.
	15) minimizable Boolean: // Controls Whether window is minimizable. This is not implemented on Linux. Default is true.
	16) maximizable Boolean: // Controls Whether window is maximizable. This is not implemented on Linux. Default is true.
	17) closable Boolean: // Controls Whether window is closable. This is not implemented on Linux. Default is true.
	18) focusable Boolean: // Controls Whether the window can be focused. Default is true. On Windows setting focusable: false also implies setting skipTaskbar: true. On Linux setting focusable: false makes the window stop interacting with wm, so the window will always stay on top in all workspaces.
	19) alwaysOnTop Boolean: // Controls Whether the window should always stay on top of other windows. Default is false.
	20) fullscreen Boolean: // Controls Whether the window should show in fullscreen. When explicitly set to false the fullscreen button will be hidden or disabled on macOS. Default is false.
	21) fullscreenable Boolean:// Controls Whether the window can be put into fullscreen mode. On macOS, also whether the maximize/zoom button should toggle full screen mode or maximize window. Default is true.
	22) simpleFullscreen Boolean:// Use pre-Lion fullscreen on macOS. Default is false.
	23) skipTaskbar Boolean:// Controls Whether to show the window in taskbar. Default is false.
	24) kiosk Boolean:// The kiosk mode. Default is false.(not sure what this is)
	25) title String:// Sets default window title. Default is "Electron". If the HTML tag <title> is defined in the HTML file loaded by loadURL(), this property will be ignored.
	26) icon (NativeImage | String):// The window icon. On Windows it is recommended to use ICO icons to get best visual effects, you can also leave it undefined so the executable's icon will be used.
	27) show Boolean:// Whether window should be shown when created. Default is true.
	28) frame Boolean:// Specify false to create a Frameless Window. Default is true.
	29) parent BrowserWindow:// Specify parent window. Default is null.
	30) modal Boolean:// Whether this is a modal window. This only works when the window is a child window. Default is false.
	31) acceptFirstMouse Boolean:// Whether the web view accepts a single mouse-down event that simultaneously activates the window. Default is false.
	32) disableAutoHideCursor Boolean:// Whether to hide cursor when typing. Default is false.
	33) autoHideMenuBar Boolean:// Auto hide the menu bar unless the Alt key is pressed. Default is false.
	34) enableLargerThanScreen Boolean:// Enable the window to be resized larger than screen. Only relevant for macOS, as other OSes allow larger-than-screen windows by default. Default is false.
	35) backgroundColor String:// Window's background color as a hexadecimal value, like #66CD00 or #FFF or #80FFFFFF (alpha in #AARRGGBB format is supported if transparent is set to true). Default is #FFF (white).
	36) hasShadow Boolean:// Whether window should have a shadow. This is only implemented on macOS. Default is true.
	37) opacity Number: // Set the initial opacity of the window, between 0.0 (fully transparent) and 1.0 (fully opaque). This is only implemented on Windows and macOS.
	38) darkTheme Boolean: // Forces using dark theme for the window, only works on some GTK+3 desktop environments. Default is false.
	39) transparent Boolean: // Makes the window transparent. Default is false.
	40) type String: // The type of window, default is normal window. See more about this below.
	41) titleBarStyle String: // The style of window title bar. Default is default. Possible values are:
		//default - Results in the standard gray opaque Mac title bar.
		// hidden - Results in a hidden title bar and a full size content window, yet the title bar still has the standard window controls ("traffic lights") in the top left.
		// hiddenInset - Results in a hidden title bar with an alternative look where the traffic light buttons are slightly more inset from the window edge.
	44) customButtonsOnHover Boolean: // Makes the  custom, close, and minimize buttons on macOS frameless windows. These buttons will not display unless hovered over in the top left of the window. These custom buttons prevent issues with mouse events that occur with the standard window toolbar buttons. Note: This option is currently experimental.
	45) fullscreenWindowTitle Boolean: // Shows the title in the title bar in full screen mode on macOS for all titleBarStyle options. Default is false.
	46) thickFrame Boolean:// Use WS_THICKFRAME style for frameless windows on Windows, which adds standard window frame. Setting it to false will remove window shadow and window animations. Default is true.
	47) vibrancy String: // Add a type of vibrancy effect to the window, only on macOS. Can be appearance-based, light, dark, titlebar, selection, menu, popover, sidebar, medium-light, ultra-dark, header, sheet, window, hud, fullscreen-ui, tooltip, content, under-window, or under-page. Please note that using frame: false in combination with a vibrancy value requires that you use a non-default titleBarStyle as well. Also note that appearance-based, light, dark, medium-light, and ultra-dark have been deprecated and will be removed in an upcoming version of macOS.
	48) zoomToPageWidth Boolean :// Controls the behavior on macOS when option-clicking the green stoplight button on the toolbar or by clicking the Window > Zoom menu item. If true, the window will grow to the preferred width of the web page when zoomed, false will cause it to zoom to the width of the screen. This will also affect the behavior when calling maximize() directly. Default is false.
	49) tabbingIdentifier String: // Tab group name, allows opening the window as a native tab on macOS 10.12+. Windows with the same tabbing identifier will be grouped together. This also adds a native new tab button to your window's tab bar and allows your app and window to receive the new-window-for-tab event.
	50) webPreferences Object: // Settings of web page's features.
	51) devTools Boolean :// Controls Whether or not to enable DevTools. If it is set to false, can not use BrowserWindow.webContents.openDevTools() to open DevTools. Default is true.
	52) nodeIntegration Boolean: // Controls Whether or not node integration is enabled. Default is false.
	53) nodeIntegrationInWorker Boolean: // Controls Whether or not node integration is enabled in web workers. Default is false. More about this can be found in Multithreading.
	54) nodeIntegrationInSubFrames Boolean: // Experimental option for enabling Node.js support in sub-frames such as iframes and child windows. All your preloads will load for every iframe, you can use process.isMainFrame to determine if you are in the main frame or not.
	55) preload String: // Specifies a script that will be loaded before other scripts run in the page. This script will always have access to node APIs no matter whether node integration is turned on or off. The value should be the absolute file path to the script. When node integration is turned off, the preload script can reintroduce Node global symbols back to the global scope. See example here.
	56) sandbox Boolean:// If set, this will sandbox the renderer associated with the window, making it compatible with the Chromium OS-level sandbox and disabling the Node.js engine. This is not the same as the nodeIntegration option and the APIs available to the preload script are more limited. Read more about the option here. Note: This option is currently experimental and may change or be removed in future Electron releases.
	57) enableRemoteModule Boolean (optional) - Whether to enable the remote module. Default is true.
	58) session Session:// Sets the session used by the page. Instead of passing the Session object directly, you can also choose to use the partition option instead, which accepts a partition string. When both session and partition are provided, session will be preferred. Default is the default session.
	59) partition String:// Sets the session used by the page according to the session's partition string. If partition starts with persist:, the page will use a persistent session available to all pages in the app with the same partition. If there is no persist: prefix, the page will use an in-memory session. By assigning the same partition, multiple pages can share the same session. Default is the default session.
	60) affinity String:// When specified, web pages with the same affinity will run in the same renderer process. Note that due to reusing the renderer process, certain webPreferences options will also be shared between the web pages even when you specified different values for them, including but not limited to preload, sandbox and nodeIntegration. So it is suggested to use exact same webPreferences for web pages with the same affinity. This property is experimental
	61) zoomFactor Number:// The default zoom factor of the page, 3.0 represents 300%. Default is 1.0.
	62) javascript Boolean:// Enables JavaScript support. Default is true.
	63) webSecurity Boolean:// When false, it will disable the same-origin policy (usually using testing websites by people), and set allowRunningInsecureContent to true if this options has not been set by user. Default is true.
	64) allowRunningInsecureContent Boolean:// Allow an HTTPS page to run JavaScript, CSS or plugins from http URLs. Default is false.
	65) images Boolean:// Enables image support. Default is true.
	66) textAreasAreResizable Boolean:// Make TextArea elements resizable. Default is true.
	67) webgl Boolean:// Enables WebGL support. Default is true.
	68) plugins Boolean:// Whether plugins should be enabled. Default is false.
	69) experimentalFeatures Boolean:// Enables Chromium's experimental features. Default is false.
	70) scrollBounce Boolean:// Enables scroll bounce (rubber banding) effect on macOS. Default is false.
	71) enableBlinkFeatures String:// A list of feature strings separated by ,, like CSSVariables,KeyboardEventKey to enable. The full list of supported feature strings can be found in the RuntimeEnabledFeatures.json5 file.
	72) disableBlinkFeatures String:// A list of feature strings separated by ,, like CSSVariables,KeyboardEventKey to disable. The full list of supported feature strings can be found in the RuntimeEnabledFeatures.json5 file.
	73) defaultFontFamily Object:// Sets the default font for the font-family.
	74) standard String:// Defaults to Times New Roman.
	75) serif String:// Defaults to Times New Roman.
	76) sansSerif String:// Defaults to Arial.
	77) monospace String:// Defaults to Courier New.
	78) cursive String:// Defaults to Script.
	79) fantasy String:// Defaults to Impact.
	80) defaultFontSize Integer:// Defaults to 16.
	81) defaultMonospaceFontSize Integer:// Defaults to 13.
	82) minimumFontSize Integer:// Defaults to 0.
	83) defaultEncoding String:// Defaults to ISO-8859-1.
	84) backgroundThrottling Boolean:// Whether to throttle animations and timers when the page becomes background. This also affects the Page Visibility API. Defaults to true.
	85) offscreen Boolean:// Whether to enable offscreen rendering for the browser window. Defaults to false. See the offscreen rendering tutorial for more details.
	86) contextIsolation Boolean:// Whether to run Electron APIs and the specified preload script in a separate JavaScript context. Defaults to false. The context that the preload script runs in will still have full access to the document and window globals but it will use its own set of JavaScript builtins (Array, Object, JSON, etc.) and will be isolated from any changes made to the global environment by the loaded page. The Electron API will only be available in the preload script and not the loaded page. This option should be used when loading potentially untrusted remote content to ensure the loaded content cannot tamper with the preload script and any Electron APIs being used. This option uses the same technique used by Chrome Content Scripts. You can access this context in the dev tools by selecting the 'Electron Isolated Context' entry in the combo box at the top of the Console tab.
	87) nativeWindowOpen Boolean:// Whether to use native window.open(). Defaults to false. Child windows will always have node integration disabled unless nodeIntegrationInSubFrames is true. Note: This option is currently experimental.
	88) webviewTag Boolean:// Whether to enable the <webview> tag. Defaults to false. Note: The preload script configured for the <webview> will have node integration enabled when it is executed so you should ensure remote/untrusted content is not able to create a <webview> tag with a possibly malicious preload script. You can use the will-attach-webview event on webContents to strip away the preload script and to validate or alter the <webview>'s initial settings.
	89) additionalArguments String[]:// A list of strings that will be appended to process.argv in the renderer process of this app. Useful for passing small bits of data down to renderer process preload scripts.
	90) safeDialogs Boolean:// Whether to enable browser style consecutive dialog protection. Default is false.
	91) safeDialogsMessage String:// The message to display when consecutive dialog protection is triggered. If not defined the default message would be used, note that currently the default message is in English and not localized.
	92) navigateOnDragDrop Boolean:// Whether dragging and dropping a file or link onto the page causes a navigation. Default is false.
	93) autoplayPolicy String:// Autoplay policy to apply to content in the window, can be no-user-gesture-required, user-gesture-required, document-user-activation-required. Defaults to no-user-gesture-required.
	94) disableHtmlFullscreenWindowResize Boolean : //Whether to prevent the window from resizing when entering HTML Fullscreen. Default is false.



----------------------------------------------------------------------------------
Tip for frameless windows
----------------------------------------------------------------------------------

---The problem with using a frameless window (when you set frame to false)is that you dont have a place to drag your window. That can be fixed with this css:
		
		body {
		    ...
		    -webkit-app-region: drag; 
		    ...
		}

---webkit-app-region: drag; allows the whole html to be a draggable object. 
---But the new problem is that you can’t click buttons on a draggable object. The -webkit-app-region: no-drag; allows you to define undraggable (and thus clickable elements)
		
		button{
    		...
    		-webkit-app-region: no-drag;
		}

-----------------------------------------------------------------------------------------------------------------------------------
The Main process can Subscribe to a channel that listens for things from the renderer processes 
-----------------------------------------------------------------------------------------------------------------------------------

--- The *ipc* (inter-process communication) module lets processes communicate with each other
--- After requiring the module, subscribing to a channel involves using the on() method with the channel name and a callback function.

like this :
---(this would go into the main.js)// listening for a response from a renderer process... communication is happening on a channel called close-main-window

	var ipc = require('ipc');

	ipc.on('close-main-window', function () {
	    app.quit();
	});

----------------------------------------------------------------------------------
---(this would go into the index.js or whatever js file your renderer process uses )

	const ipc = require('ipc');

	const closebutton = document.querySelector('.close'); // when i click this button ...
	closebutton.addEventListener('click', function () { 
	    ipc.send('close-main-window'); // ... take me to the main process's close-main-window channel and run its function
	});


--- IN other words I Subscribed the main process (main.js) to the “close-main-window” channel and sent a message to that channel from the renderer process (index.js) so that when someone clicks the close button  app.quit() runs .

--- when sending messages via ipc from the main process to a renderer process (aka doing what I did above backwards)you have to use the reference to that window (something like “createdWindow.webContents.send(‘channel’))


--------------------------------------------------------------------------------------------------------------------------------
Doing things via Keyboard shortcuts
--------------------------------------------------------------------------------------------------------------------------------


--- Electron has a *global shortcut* module which allows you to listen to custom keyboard combinations. 
--- The keyboard combinations are known as "Accelerators" and are string representations of a combination of keypresses (for example “Ctrl+Shift+1”).

in main,js:

	const globalShortcut = require('global-shortcut');

	app.on('ready', function() {
	    ... // existing code from earlier

	    globalShortcut.register('ctrl+shift+1', function () {
	            mainWindow.webContents.send('global-shortcut', 0);
	    });
	    globalShortcut.register('ctrl+shift+2', function () {
	        mainWindow.webContents.send('global-shortcut', 1);
	    });
	});


--- First, we require the global-shortcut module. 
--- Then, once our application is ready, we register two shortcuts — one that will respond to pressing Ctrl, Shift and 1 together and the other that will respond to pressing Ctrl, Shift and 2 together. 
--- Each of those will send a message to the “global-shortcut” channel with an argument which is a number in this case

----------------------------------------------------------------------------------
in index.js :

	ipc.on('global-shortcut', function (arg) {// arg is whatever was passed in above(0 or 1)
	    var event = new MouseEvent('click');
	 	buttons[arg].dispatchEvent(event);// give the button at this index a click event 
	});




--------------------------------------------------------------------------------------------------------------------------------
Packaging 
--------------------------------------------------------------------------------------------------------------------------------


--- Use the electron-packager to package an app for all platform(mac, windows, linux).
--- In a nutshell, electron-packager abstracts away all work going into wrapping your app and generates all platforms for which you’re going to publish.

----------------------------------------------------------------------------------


the general form when packaging an application is:(type this into command line)


	electron-packager <location of project> <name of project> <platform> <architecture> <electron version> <optional options>


	1)location of project: points to the folder where your project is,
	2)name of project: defines the name of your project,
	3)platform: decides for which platforms to build (all to build for Windows, Mac and Linux),
	4)architecture: decides for which architectures to build (x86 or x64, all for both) and
	5)electron version: lets you choose which Electron version to use.

----------------------------------------------------------------------------------

--- electron-builder is another separate thing that takes the packages produced by electron-packager and creates automated installers. aka auto update feature

--------------------------------------------------------------------------------------------------------------------------------
Need to look up
--------------------------------------------------------------------------------------------------------------------------------
 	"chart.js": "^2.7.3",
    "classnames": "^2.2.6",
    "date-fns": "^1.29.0",
    "dexie": "^2.0.4", // allows user to have a unique and personal local database on their instance of chromium( kinda like local storage)
    "electron-devtools-installer": "^2.2.4",
    "electron-log": "^2.2.17",
    "electron-updater": "^4.0.5",
    "node-sass": "^4.10.0",
    "path": "^0.12.7",
    "pretty": "^2.0.0",
    "prop-types": "^15.6.2",
    "react": "^16.6.3",
    "react-dom": "^16.6.3",
    "react-highlight": "^0.12.0",
    "react-json-view": "^1.19.1",
    "react-redux": "^5.0.6",
    "react-syntax-highlighter": "^10.1.1",
    "redux": "^3.7.2",
    "rpmbuild": "0.0.22",
    "status-indicator": "^1.0.9",
    "uuid": "^3.3.2",
    "ws"

 	"devtron": "^1.4.0", // devtron is an new developer tool that gets added to your chrome dev tools that lets you see things in you electron app(Lets you see require statements and eventlisteners)
    "electron": "^3.0.6",
    "electron-builder": "^20.38.2",// implements auto updates
    "electron-packager": "^12.2.0",// package your files for windows, mac linux
    "file-loader": "^2.0.0",
    "html-webpack-plugin": "^3.2.0",
    "jest": "^24.1.0",
    "mini-css-extract-plugin": "^0.4.4",
    "postcss-cssnext": "^3.1.0", // post css mostly takes your existing css code and will go through and add prefixes to it. Post css doesnt do much on its own but has a ton of plugins (grids and linters)that you can use. postcss next is one of them and it lets you use future css syntax  https://cssnext.github.io/
    "postcss-import": "^12.0.1",
    "postcss-loader": "^3.0.0",
    "postcss-nested": "^4.1.0",
    "postcss-pxtorem": "^4.0.1",
