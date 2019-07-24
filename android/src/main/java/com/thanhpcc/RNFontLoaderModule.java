
package com.thanhpcc;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import java.io.File;

public class RNFontLoaderModule extends ReactContextBaseJavaModule {
  private final ReactApplicationContext reactContext;
  private static final String ASSET_SCHEME = "asset://";

  public RNFontLoaderModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @ReactMethod
    public void loadFontAsync(final String fontFamilyName, final String localUri, final Promise promise) {
       try{
         Typeface typeFace;
         //load font from asset folder
         if(localUri.startsWith(ASSET_SCHEME)){
           typeface = Typeface.createFromAsset(
            getContext().getAssets(),
            // Also remove the leading slash.
            localUri.substring(ASSET_SCHEME.length() + 1));
         } else {
          typeface = Typeface.createFromFile(new File(Uri.parse(localUri).getPath()));
         }
       } catch(Exception e){

       }
    }

  @Override
  public String getName() {
    return "RNFontLoader";
  }
}