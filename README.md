
# react-native-react-native-font-loader

## Getting started

`$ npm install react-native-react-native-font-loader --save`

### Mostly automatic installation

`$ react-native link react-native-react-native-font-loader`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-react-native-font-loader` and add `RNReactNativeFontLoader.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNReactNativeFontLoader.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNReactNativeFontLoaderPackage;` to the imports at the top of the file
  - Add `new RNReactNativeFontLoaderPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-react-native-font-loader'
  	project(':react-native-react-native-font-loader').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-react-native-font-loader/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-react-native-font-loader')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNReactNativeFontLoader.sln` in `node_modules/react-native-react-native-font-loader/windows/RNReactNativeFontLoader.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using React.Native.Font.Loader.RNReactNativeFontLoader;` to the usings at the top of the file
  - Add `new RNReactNativeFontLoaderPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNReactNativeFontLoader from 'react-native-react-native-font-loader';

// TODO: What to do with the module?
RNReactNativeFontLoader;
```
  