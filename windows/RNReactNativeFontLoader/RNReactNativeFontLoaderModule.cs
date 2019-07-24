using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace React.Native.Font.Loader.RNReactNativeFontLoader
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNReactNativeFontLoaderModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNReactNativeFontLoaderModule"/>.
        /// </summary>
        internal RNReactNativeFontLoaderModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNReactNativeFontLoader";
            }
        }
    }
}
